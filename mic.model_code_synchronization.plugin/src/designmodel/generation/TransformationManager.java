package designmodel.generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import mapping.MappingEntry;
import mappingdeclaration.IMappingDeclarationParser;
import mappingdeclaration.MappingDeclarationDatabase;
import spoon.Launcher;
import spoon.compiler.Environment;
import spoon.reflect.CtModel;


/**
 * Main transformation manager responsible for triggering the initial model generation and all following transformations.
 * Getting created and called directly from clicking the context menu entry.
 * 
 * @author Fabian Glittenberg
 *
 */
public class TransformationManager {
	
	private Launcher launcher;
	private String projectPath;
	private CtModel astModel;
	private IMappingDeclarationParser mappingDeclarationParser;
	private MappingDeclarationDatabase mappingDeclarationDatabase;
	
	private List<MappingEntry> mappings;
	private XMIResource existentDesignmodel;

	public String getDirectoryPath() {
		return projectPath;
	}

	/**
	 * Constructor, taking the project path of the target Java program as parameter.
	 * @param projectPath
	 */
	public TransformationManager(String projectPath, IMappingDeclarationParser mappingParser) {
		this.projectPath = projectPath;
		this.launcher = new Launcher();
		this.launcher.addInputResource(projectPath);
		Environment env = this.launcher.getEnvironment();
		
		env.setSourceOutputDirectory(new File(projectPath + "/src"));
		env.setCopyResources(false);
		env.setNoClasspath(true);
		env.setCommentEnabled(true);
		env.setAutoImports(true);
		
		this.astModel = this.launcher.buildModel();
		
		this.mappingDeclarationParser = mappingParser;
		this.mappings = new ArrayList<>();
	}
	
	/**
	 * Called when clicking context menu entry on Java Project.
	 * Parses in the mapping file and starts the process of creating the design model on the basis of the mapping file and the Java source code
	 * of the underlying project.
	 * @param designmodelTargetPath 
	 * @throws IOException 
	 */
	public void buildDesignModel(String designmodelTargetPath) throws IOException {
		this.mappingDeclarationDatabase = this.mappingDeclarationParser.parseMappingDirectory();

		EPackage metapackage = this.mappingDeclarationParser.parseConfigFileToMetaPackage();
		
		//initialize resource for saving the design model as xmi
		XMIResource savingRes = initializePersistationResource(designmodelTargetPath);

		this.mappingDeclarationDatabase.getMappingInstantiations().forEach((modelElementName, imDeclaration) -> {
			//creates a processor that acts upon the specific condition target and runs it
			if(!imDeclaration.getCondition().getTargetElement().contentEquals("modelelement.name")) {
				throw new NotImplementedException("Currently cannot apply conditions to other elements than 'modelelement.name'");
			}
			//creates the respective processor, handing over the modelelement.name,
			//the attribute mappings of the IM and the metapackage of the meta model that the design model gets instantiated with
			imDeclaration.getCondition().createProcessor(modelElementName, imDeclaration.getAttributeMappings(), imDeclaration.getCodestructureType(), metapackage);
			GenerationProcessor<?> processor = imDeclaration.getCondition().getProcessor();
			this.astModel.processWith(processor);
			//add all the generated design model elements from the processor to the resourceSet of the design model xmi
			processor.getGeneratedDesignmodelElements().forEach(e -> {
				if(e != null) {
					savingRes.setID(e, UUID.randomUUID().toString());
					savingRes.getContents().add(e);
				}
			});
			//add all the generated mapping entries from the processor to the transformation manager
			processor.getMappingEntries().forEach(e -> {
				this.mappings.add(e);
			});
		});
		//set existent design model in the transformation manager
		this.existentDesignmodel = savingRes;
		
		//save model as xmi
		try {
			savingRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private XMIResource initializePersistationResource(String outputPath) {
		ResourceSet savingResSet = new ResourceSetImpl();
		savingResSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		XMIResource savingRes = (XMIResource) savingResSet.createResource(URI.createFileURI(outputPath), null);
		//savingRes.getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		
		return savingRes;
	}

	/**
	 * Updates the code to reflect the contents of a changed design model.
	 * @param updatedModel
	 */
	public void updateCode(XMIResource updatedModel) {
		updatedModel.getContents().forEach(updatedModelElement -> {
			
			//getting respective model element in existing designmodel
			String id = updatedModel.getID(updatedModelElement);
			EObject existentModelElement = existentDesignmodel.getEObject(id);
			
			if(existentModelElement == null) {
			//no existend model element there yet, meaning it got added by the user through modifications at the design model
				System.out.println(updatedModelElement + " was newly created");
				return;
			}
			
			//getting the mapping entry of this model element to check what is mapped to what, to then determine whether it got changed by the user
			MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
			if(entry == null) {
				entry = getMappingEntryByID(updatedModel.getID(updatedModelElement));
			}
			entry = updateMappingEntry(entry, updatedModelElement);
		});
		
		this.launcher.prettyprint();
		
		this.existentDesignmodel = updatedModel;
	}

	/**
	 * Updates the mapping entry with the information from the updatedModelElement.<br>
	 * Changes the code element itself contained in the mapping entry and thus propagates the model changes back to the actual code
	 * (launcher.prettyprint() has to get called afterwards though to create source changes)
	 * @param entry
	 * @param updatedModelElement
	 * @return the mapping entry containing all updated elements
	 */
	private MappingEntry updateMappingEntry(MappingEntry entry, EObject updatedModelElement) {
		//when a codestrcuture does not exist yet, this means a new model element got created and the codestructure has to be created freshly
		if(entry.getCodeElement() == null) {
			return createNewCodestructure(entry, updatedModelElement);
		}
		//dispatch here what is mapped to what (currently only the name of the codestructure mapped to attributes of the design model element is implemented)
		if(entry.getMappedCodeElementValue().contentEquals("name") && entry.getMappedDesignmodelElementValue().startsWith("attribute(")) {
			String re1="(attribute)";
		    String re2="(\\(.*\\))";

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(entry.getMappedDesignmodelElementValue());
		    if (m.find()) {
		        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
		        //get the new attribute value that is mapped to the name of the codestructure
				String newAttributeValue = updatedModelElement.eGet(updatedModelElement.eClass().getEStructuralFeature(attributeName)).toString();
				//check if the design model got changed
				//-> if it did not change, simply return original entry without modifications
				if(newAttributeValue.contentEquals(entry.getCodeElement().getSimpleName())) {
					System.out.println(entry.getCodeElement().getSimpleName() + " did not get changed");
					return entry;
				}
				System.out.println(entry.getCodeElement().getSimpleName() + " got changed to " + newAttributeValue);
				//change the codestructure respectively
				entry.getCodeElement().setSimpleName(newAttributeValue);
				//change the model element to new one
				entry.setDesignmodelElement(updatedModelElement);
				//remove the old codestructure
				//-> currently just implemented as deleting it (TODO is full refactoring through renaming it instead of deleting it)
				entry.getCodeElement().getPosition().getCompilationUnit().getFile().delete();
				//setting the path to the .java-file of the possibly renamed code element
				String pathWithoutJavaExtension = entry.getCodeElement().getPosition().getCompilationUnit().getFile().toString().split("\\.java")[0];
				String[] a = pathWithoutJavaExtension.split("\\\\");
				String newFileName = pathWithoutJavaExtension.split(a[a.length-1])[0] + entry.getCodeElement().getSimpleName() + ".java";
				entry.getCodeElement().getPosition().getCompilationUnit().setFile(new File(newFileName));
				
//				CompilationUnit newCu = entry.getCodeElement().getFactory().Core().createCompilationUnit();
//				newCu.setFile(new File(newFileName));
//				JDTTreeBuilder jdtTreeBuilder = new JDTTreeBuilder(this.launcher.createFactory());
//				entry.getCodeElement().getFactory().Core().createBodyHolderSourcePosition(newCu,
//						entry.getCodeElement().getPosition().getSourceStart(),
//						entry.getCodeElement().getPosition().getSourceEnd(),
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						entry.getCodeElement().getPosition().getSourceStart()+1,
//						jdtTreeBuilder.getContextBuilder().getCompilationUnitLineSeparatorPositions());
		    }
		    else {
		    	throw new NotImplementedException(entry.getMappedDesignmodelElementValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
		    }
		}
		else {
			throw new NotImplementedException("Currently there are only mappings from attributes from a design model class to names of codestructures implemented");
		}
		
		return entry;
	}
	
	/**
	 * Responsible for creating a new codestructure based on a new design model element added by the user.
	 * @param entry
	 * @param addedDesignmodelelement
	 * @return MappingEntry containing the mapping to the newly created codestructure
	 */
	private MappingEntry createNewCodestructure(MappingEntry entry, EObject addedDesignmodelelement) {
		
		return null;
	}

	/**
	 * Gets the respective mapping entry holding the specified code element name.
	 * @param codeElementName
	 * @return
	 */
	private MappingEntry getMappingEntryByCodeElementName(String codeElementName) {
		for(MappingEntry e: this.mappings) {
			if(e.getCodeElement().getSimpleName().contentEquals(codeElementName))
				return e;
		}
		return null;
	}
	
	/**
	 * Gets the respective mapping entry holding the specified model element.
	 * @param modelelement
	 * @return
	 */
	private MappingEntry getMappingEntryByModelelement(EObject modelelement) {
		for(MappingEntry e: this.mappings) {
			if(e.getDesignmodelElement().equals(modelelement))
				return e;
		}
		return null;
	}
	
	private MappingEntry getMappingEntryByID(String id) {
		for(MappingEntry e: this.mappings) {
			EObject o = e.getDesignmodelElement();
			String existentID = this.existentDesignmodel.getID(o);
			if(existentID.contentEquals(id))
				return e;
		}
		return null;
	}
	
}