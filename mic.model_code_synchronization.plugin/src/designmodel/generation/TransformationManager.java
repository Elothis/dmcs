package designmodel.generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.XMIResource;

import concrete_mapping.MappingEntry;
import mappingdeclaration.IntegrationMechanismDeclaration;
import mappingdeclaration.MappingDeclarationDatabase;
import mappingdeclaration.ModelelementType;
import mappingdeclaration.ParserException;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElementFactory;
import parsing.IMappingDeclarationParser;
import spoon.Launcher;
import spoon.compiler.Environment;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.filter.TypeFilter;
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
	private String mappingDirectoryPath;
	private CtModel astModel;
	private IMappingDeclarationParser mappingDeclarationParser;
	private MappingDeclarationDatabase mappingDeclarationDatabase;
	
	private List<MappingEntry> mappings;
	private List<String> existentElementIDs;
	private XMIResource existentDesignmodel;
	
	public static final String DESIGNMODEL_FILE_NAME = "/designmodel.xmi";
	public static final String CONFIG_FILE_NAME = "/metamodel-configuration.config";

	public String getDirectoryPath() {
		return projectPath;
	}

	
	/**
	 * Creates a TransformationManager working on the specified mapping directory, java project and mapping parser.
	 * @param mappingDirectoryPath
	 * @param projectPath
	 * @param mappingParser
	 */
	public TransformationManager(String mappingDirectoryPath, String projectPath, IMappingDeclarationParser mappingParser) {
		this.mappingDirectoryPath = mappingDirectoryPath;
		this.projectPath = projectPath;
		this.launcher = new Launcher();
		this.launcher.addInputResource(projectPath);
		Environment env = this.launcher.getEnvironment();
		
		//generated files will be located here
		File outputDir;
		//if the maven-convention of having /src/main/java exists, use it as output directory for generated code artifacts
		File src_main_java_dir = new File(projectPath + "/src/main/java/");
		if(src_main_java_dir.exists()) {
			outputDir = src_main_java_dir;
		}
		else {
			//if it does not exist, use standard /src directory
			outputDir = new File(projectPath + "/src/");
		}
		System.out.println("-----------------" + outputDir + "--------------------");
		
		env.setSourceOutputDirectory(outputDir);
		env.setCopyResources(false);
		env.setNoClasspath(true);
		env.setCommentEnabled(true);
		env.setAutoImports(true);
		
		this.astModel = this.launcher.buildModel();
		
		this.mappingDeclarationParser = mappingParser;
		this.mappings = new ArrayList<>();
		
		this.mappingDeclarationDatabase = this.mappingDeclarationParser.parseMappingDirectory(this.mappingDirectoryPath);
	}
	
	/**
	 * Called when clicking context menu entry on Java Project.
	 * Parses in the mapping file and starts the process of creating the design model on the basis of the mapping file and the Java source code
	 * of the underlying project.
	 * @param designmodelTargetPath 
	 * @throws IOException 
	 */
	public void buildDesignModel() throws IOException {
		this.existentElementIDs = new ArrayList<>();

		EPackage metapackage = this.mappingDeclarationParser.parseConfigFileToMetaPackage(this.mappingDirectoryPath + CONFIG_FILE_NAME);
		
		//initialize resource for saving the design model as xmi
		XMIResource savingRes = Utility.initializePersistationResource(this.mappingDirectoryPath + DESIGNMODEL_FILE_NAME);

		this.mappingDeclarationDatabase.getMappingInstantiations().forEach(mappingInstantiation -> {
			//creates a processor that acts upon the specific condition target and runs it
			if(!mappingInstantiation.getImd().getCondition().getTargetElement().contentEquals("modelelement.name")) {
				throw new NotImplementedException("Currently cannot apply conditions to other elements than 'modelelement.name'");
			}
			//creates the respective processor, handing over the modelelement.name,
			//the attribute mappings of the IM and the metapackage of the meta model that the design model gets instantiated with
			mappingInstantiation.getImd().getCondition().createProcessor(mappingInstantiation, mappingInstantiation.getImd().getAttributeMappings(),
					mappingInstantiation.getImd().getCodestructureType(), metapackage, this.mappings);
			ConditionProcessor<?> processor = mappingInstantiation.getImd().getCondition().getProcessor();
			this.astModel.processWith(processor);
			//add all the generated design model elements from the processor to the resourceSet of the design model xmi
			processor.getGeneratedDesignmodelElements().forEach(e -> {
				if(e != null) {
					//only add it to the resource if its not already contained in another EObject via containment-reference
					if(e.eContainer() == null) {
						savingRes.getContents().add(e);
					}					
					savingRes.setID(e, UUID.randomUUID().toString());
					this.existentElementIDs.add(savingRes.getID(e));
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

	/**
	 * Updates the code to reflect the contents of a changed design model.
	 */
	public void updateCode() {
		XMIResource updatedModel = Utility.loadExistingModel(this.mappingDirectoryPath + DESIGNMODEL_FILE_NAME);
		
		List<MappingEntry> updatedMappings = new ArrayList<>();
		List<String> newElementIDs = new ArrayList<>();
		updatedModel.getContents().forEach(updatedModelElement -> {
			String updatedModelElementID = updatedModel.getID(updatedModelElement);
			newElementIDs.add(updatedModelElementID);
			//check if updatedModelElement needs UPDATE or CREATE transformation
			checkForUpdateOrCreateTransformation(updatedModelElement, updatedModel, updatedMappings, null);
			
			//check the same for possible contained objects
			//get the root object (as specified by the user in the .config-file) to then iterate over all designmodel elements contained by it (which should be all created ones)
			List<EReference> containments = updatedModelElement.eClass().getEAllContainments();
			//iterate over all containment-references of the  model element
			containments.forEach(containment -> {
				List<EObject> refs = (List<EObject>) updatedModelElement.eGet(containment);
				
				refs.forEach(containedElement -> {
					//check here, if this containedObject is newly added or possibly updated
					checkForUpdateOrCreateTransformation(containedElement, updatedModel, updatedMappings, containment);
					//add its UUID to the list of elements contained in the updated model (to then later check for DELETEs)
					String updatedContainedModelElementID = updatedModel.getID(containedElement);
					newElementIDs.add(updatedContainedModelElementID);
				});
			});
			
		});
		
		//check for deleted codestructures
		this.existentElementIDs.forEach(existentModelElementID -> {
			if(!newElementIDs.contains(existentModelElementID)) {
				//only existent in old model version -> DELETE
				//System.out.println(this.existentDesignmodel.getEObject(existentModelElementID) + " was deleted");
				EObject existentModelElement = existentDesignmodel.getEObject(existentModelElementID);
				MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
				entry.getMappedDesignmodelElement().deleteTransformation(entry, existentModelElement);
				this.mappings.remove(entry);
			}
		});
		
		this.launcher.prettyprint();
		
		this.mappings = updatedMappings;
		try {
			//rebuild model instance afterwards to reset and reconfigure all data in this TransformationManager instance
			this.buildDesignModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks for a given possibly updatedModelElement of the deserialized updatedModel whether it was updated or created
	 * and if so, calls the respective transformation to propagate these changes back into the code.
	 * @param updatedModelElement the (potentially) updated modelelement that gets checked against the existing model prior to user modifications
	 * @param updatedModel the newly deserialized model as updated by the user
	 * @param updatedMappings MappingEntry's of the new model version
	 * @param containment possible containment reference of the updatedModelElement (possibly null if not translated as containment reference in the IM)
	 */
	private void checkForUpdateOrCreateTransformation(EObject updatedModelElement, XMIResource updatedModel, List<MappingEntry> updatedMappings, EReference containment) {
		String updatedModelElementID = updatedModel.getID(updatedModelElement);
		
		if(this.existentElementIDs.contains(updatedModelElementID)) {
			//exists in both lists -> UPDATE
			//get MappingEntry for the respective model element
			EObject existentModelElement = existentDesignmodel.getEObject(updatedModelElementID);
			MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
			//update it according to changes applied to the updatedModelElement
			MappingEntry updatedEntry = entry.getMappedDesignmodelElement().updateTransformation(entry, updatedModelElement);
			updatedMappings.add(updatedEntry);
		}
		else {
			//exists only in updated model -> CREATE
			//System.out.println(updatedModelElement + " was added by the user");
			//first find out what Integration Mechanism this newly added object shall get translated with
			String mappedModelElementName = updatedModelElement.eClass().getName();
			//if this updatedModelElement is a contained element (like in containment operation for types - mechanism)
			// -> the integration mechanism is applied to the containment itself and not the actual modelelement!
			if(containment != null) {
				mappedModelElementName = containment.getName();
			}

			IntegrationMechanismDeclaration imd = this.mappingDeclarationDatabase.getIntegrationMechanismByElementAppliedTo(mappedModelElementName);
			//creating a new MappingEntry holding the newly created codestructure				
			MappingEntry newlyCreatedEntry = this.createTransformation(imd, updatedModelElement, updatedModel.getContents());
			updatedMappings.add(newlyCreatedEntry);
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
	
	
	/**
	 * Creates a new codestructure representing the addedDesignmodelElement in the code according to mapping declaration in the imd.
	 * @param imd Integration Mechanism Declaration that describes the mapping between the addedDesignmodelElement and the new codestructure to be created
	 * @param addedDesignmodelElement the modelelement that has to get translated into a new codestructure
	 * @param newModel the entire designmodel as it was updated by the user and deserialized
	 * @return updated MappingEntry now containing the newly created codestructure
	 */
	private MappingEntry createTransformation(IntegrationMechanismDeclaration imd, EObject addedDesignmodelElement, EList<EObject> newModel) {
		CtNamedElement newCodestructure;
		String newCodestructureName;
		if(imd.getAttributeMappings().size() > 1) {
			System.err.println("Attribute-mappings beyond the first one will be ignored when creating a new codestructure based on the mapping provided (as part of the CREATE-transformation)!");
		}
		//currently only codestructure names to attributes of model elements implemented, so only dispatching this here
		if(imd.getAttributeMappings().get(0).getMappedCodeElement().getTargetValue().contentEquals("name") &&
				imd.getAttributeMappings().get(0).getTargetValue().startsWith("attribute(")) {
			String re1="(attribute)";
		    String re2="(\\(.*\\))";

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(imd.getAttributeMappings().get(0).getTargetValue());
		    if (m.find()) {
		    	String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
		    	newCodestructureName = addedDesignmodelElement.eGet(addedDesignmodelElement.eClass().getEStructuralFeature(attributeName)).toString();
		    }
		    else {
		    	throw new NotImplementedException(imd.getAttributeMappings().get(0).getTargetValue() + " as the target value of a mapped design model element is currently not yet implemented.");
		    }
		}
		else if (imd.getAttributeMappings().get(0).getMappedCodeElement().getTargetValue().contentEquals("name") &&
				imd.getAttributeMappings().get(0).getTargetValue().startsWith("target.attribute(")) {
			String re1="(target\\.attribute)";
		    String re2="(\\(.*\\))";

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(imd.getAttributeMappings().get(0).getTargetValue());
		    if (m.find()) {
		    	String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
		    	newCodestructureName = addedDesignmodelElement.eGet(addedDesignmodelElement.eClass().getEStructuralFeature(attributeName)).toString();
		    }
		    else {
		    	throw new NotImplementedException(imd.getAttributeMappings().get(0).getTargetValue() + " as the target value of a mapped designmodel element is currently not yet implemented.");
		    }
		}
		else {
			throw new NotImplementedException("Currently there are only CREATE-transformations for mappings from a codestructure's name to attributes of model elements implemented");
		}
		//creating the codestructure element
		switch(imd.getCodestructureType()) {
		case CLASS:
			CtClass<?> newClass = launcher.getFactory().Class().create(newCodestructureName);
			newClass.setVisibility(ModifierKind.PUBLIC);
			newCodestructure = newClass;
			break;
		case INTERFACE:
			CtInterface<?> newInterface = launcher.getFactory().Interface().create(newCodestructureName);
			newInterface.setVisibility(ModifierKind.PUBLIC);
			newCodestructure = newInterface;
			break;
		case METHOD:
			String holdingClassName = getCodestructureNameOfMappedModelelement(addedDesignmodelElement.eContainer());			
			List<CtClass<?>> parentClass = launcher.getModel().filterChildren(new TypeFilter<CtClass<?>>(CtClass.class)).
				filterChildren(new Filter<CtClass<?>>() {
					@Override
					public boolean matches(CtClass<?> element) {
						if(element.getSimpleName().contentEquals(holdingClassName)) {
							return true;
						}
						return false;
					}					
				}).list();
			if(parentClass.size() == 0) {
				throw new IllegalArgumentException("There is no class to hold the method the added design model element is mapped to");
			}
			Set<ModifierKind> modifierSet = new HashSet<>();
			modifierSet.add(ModifierKind.PUBLIC);
			CtMethod<?> newMethod = launcher.getFactory().Method().create(parentClass.get(0), modifierSet, launcher.getFactory().Type().VOID_PRIMITIVE, newCodestructureName, null, null, launcher.getFactory().createBlock());
			newCodestructure = newMethod;
			break;
		default:
			throw new IllegalArgumentException("Invalid codestructure-type");
		}
		
		//now the newly created codestructure has to be made applicable to the integration mechanism it is translated with
		//i.e. it has to get annotated with a certain annotation if this is specified in the mapping
		return applyIntegrationMechanismToCodestructure(imd, addedDesignmodelElement, newCodestructure);
	}

	/**
	 * Applies the responsible integration mechanism to a newly created codestructure and creates a newly MappingEntry containing the codestructure and respective model element.
	 * @param imd
	 * @param addedDesignmodelElement
	 * @param newCodestructure
	 * @return
	 */
	private MappingEntry applyIntegrationMechanismToCodestructure(IntegrationMechanismDeclaration imd,
			EObject addedDesignmodelElement, CtNamedElement newCodestructure) {
		String targetNameInstance = "";
		if(imd.getCondition().getTargetElement().contentEquals("modelelement.name")) {
			targetNameInstance = addedDesignmodelElement.eClass().getName();
			//if the respective IM acts on containment-modelelements, the targetNameInstance is the containment itself and not the actual addedDesignmodelElement!
			//i.e.: for containment operation for types mechanism, the containment-reference-name and NOT the target-model-element-name is mapped to the annotation-name in the code
			if(imd.getModelelementType() == ModelelementType.CONTAINMENT && addedDesignmodelElement.eContainer() != null) {
				targetNameInstance = addedDesignmodelElement.eContainmentFeature().getName();
			}
			newCodestructure = imd.getCondition().applyConditionToCreatedCodestructure(newCodestructure, targetNameInstance, this.launcher);
		}
		else {
			throw new NotImplementedException("Currently there are only CREATE-transformations for condition target-values of 'modelelement.name' implemented");
		}
		
		MappingEntry entry = new MappingEntry();
		entry.setDesignmodelElementEObject(addedDesignmodelElement);
		entry.setCodeElement(newCodestructure);
		entry.setCodestructureType(imd.getCodestructureType());
		entry.setMappedDesignmodelElementValue(imd.getAttributeMappings().get(0).getTargetValue());
		entry.setMappedCodeElementValue(imd.getAttributeMappings().get(0).getMappedCodeElement().getTargetValue());
		try {
			entry.setMappedDesignmodelElement(MappedDesignmodelElementFactory
					.createMappedDesignmodelElement(entry.getMappedDesignmodelElementValue(), imd.getModelelementType(), null));
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return entry;
	}

	/**
	 * Gets the name of the codestructure the model element is mapped to
	 * @param modelElement
	 * @return codestructure name
	 */
	private String getCodestructureNameOfMappedModelelement(EObject modelElement) {
		String holdingClassName = "";
		IntegrationMechanismDeclaration imd = this.mappingDeclarationDatabase.getIntegrationMechanismByElementAppliedTo(modelElement.eClass().getName());
		if(imd.getAttributeMappings().get(0).getMappedCodeElement().getTargetValue().contentEquals("name") &&
				imd.getAttributeMappings().get(0).getTargetValue().startsWith("attribute(")) {
			String re1="(attribute)";
		    String re2="(\\(.*\\))";

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(imd.getAttributeMappings().get(0).getTargetValue());
		    if (m.find()) {
		    	String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
		    	holdingClassName = modelElement.eGet(modelElement.eClass().getEStructuralFeature(attributeName)).toString();
		    }
		    else {
		    	throw new NotImplementedException(imd.getAttributeMappings().get(0).getTargetValue() + " as the target value of a mapped design model element is currently not yet implemented.");
		    }
		}
		return holdingClassName;
	}

}
