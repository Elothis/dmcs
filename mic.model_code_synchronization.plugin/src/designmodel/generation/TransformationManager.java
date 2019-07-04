package designmodel.generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.NotImplementedException;
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
import util.Utility;


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
	private List<String> existentElementIDs;
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
		this.existentElementIDs = new ArrayList<>();
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
					this.existentElementIDs.add(savingRes.getID(e));
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
	public void updateCode(String existingModelPath) {
		XMIResource updatedModel = Utility.loadExistingModel(existingModelPath);
		
		List<MappingEntry> updatedMappings = new ArrayList<>();
		List<String> newElementIDs = new ArrayList<>();
		updatedModel.getContents().forEach(updatedModelElement -> {
			String updatedModelElementID = updatedModel.getID(updatedModelElement);
			newElementIDs.add(updatedModelElementID);
			if(this.existentElementIDs.contains(updatedModelElementID)) {
				//exists in both lists -> UPDATE
				System.out.println(updatedModelElement + " was updated/not changed at all");
				//get MappingEntry for the respective model element
				EObject existentModelElement = existentDesignmodel.getEObject(updatedModelElementID);
				MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
				//update it according to changes applied to the updatedModelElement
				MappingEntry updatedEntry = entry.getMappedDesignmodelElement().updateMappingEntry(entry, updatedModelElement);
				updatedMappings.add(updatedEntry);
			}
			else {
				//exists only in updated model -> CREATE
				System.out.println(updatedModelElement + " was added by the user");
			}
		});
		this.existentElementIDs.forEach(existentModelElementID -> {
			if(!newElementIDs.contains(existentModelElementID)) {
				//only existent in old model version -> DELETE
				System.out.println(this.existentDesignmodel.getEObject(existentModelElementID) + " was deleted");
				EObject existentModelElement = existentDesignmodel.getEObject(existentModelElementID);
				MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
				entry.getMappedDesignmodelElement().deleteCodestructure(entry, existentModelElement);
				this.mappings.remove(entry);
			}
		});
		
		this.launcher.prettyprint();
		
		this.mappings = updatedMappings;
		try {
			//rebuild model instance afterwards to reset and reconfigure all data in this TransformationManager instance
			this.buildDesignModel(existingModelPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the respective mapping entry holding the specified model element.
	 * @param modelelement
	 * @return
	 */
	private MappingEntry getMappingEntryByModelelement(EObject modelelement) {
		for(MappingEntry e: this.mappings) {
			if(e.getDesignmodelElementEObject().equals(modelelement))
				return e;
		}
		return null;
	}
}
