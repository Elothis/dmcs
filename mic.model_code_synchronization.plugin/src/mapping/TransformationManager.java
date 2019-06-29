package mapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;

import spoon.Launcher;

public class TransformationManager {
	private List<MappingEntry> mappings;
	private XMIResource existentDesignmodel;
	private Launcher launcher;
	
	public TransformationManager(Launcher launcher) {
		this.mappings = new ArrayList<>();
		this.launcher = launcher;
	}

	public List<MappingEntry> getMappings() {
		return mappings;
	}

	public void setMappings(List<MappingEntry> mappings) {
		this.mappings = mappings;
	}

	public XMIResource getExistentDesignmodel() {
		return existentDesignmodel;
	}

	public void setExistentDesignmodel(XMIResource existentDesignmodel) {
		this.existentDesignmodel = existentDesignmodel;
	}

	/**
	 * Updates the code to reflect the contents of a changed design model.
	 * @param updatedModel
	 */
	public void updateCode(XMIResource updatedModel) {
		updatedModel.getContents().forEach(updatedModelElement -> {	
			System.out.println("getName() = " + updatedModelElement.eClass().getName());
			System.out.println("getEStructuralFeature('name') = " + updatedModelElement.eGet(updatedModelElement.eClass().getEStructuralFeature("name")));
			System.out.println("updatedModel-UUID = " + updatedModel.getID(updatedModelElement));
			
			//getting respective model element in existing designmodel
			EObject existentModelElement = existentDesignmodel.getEObject(updatedModel.getID(updatedModelElement));
			System.out.println("existendModel-UUID = " + existentDesignmodel.getID(existentModelElement));
			//getting the mapping entry of this model element to check what is mapped to what, to then determine whether it got changed by the user
			MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
			System.out.println(entry);
			System.out.println("-----------------------------");
			entry = updateMappingEntry(entry, updatedModelElement);
		});
		
		//testing actually changing the spoon element and then printing it into code
		//--> WORKS! but old class-file has to be removed (only adds new one with new name)
		//getMappingEntryByCodeElementName("Waiting").getCodeElement().setSimpleName("NotWaitingAnymore");
		this.launcher.prettyprint();
		
		this.existentDesignmodel = updatedModel;
		
		//TODO implement updateCode
		/*
		 * - check differences between updatedModel and existentDesignmodel
		 * - find mapped codestructures in this.mappings from modelelements that got changed
		 * 		-> how to do that? how to know what the old model element was or if its not a newly created one?
		 * 			-> UUIDs are the answer?
		 * - update codestructures respective to changes to modelelements
		 * 		-> can this be done in the codestructures via some overridden method?
		 * 			-> like codestructure.propagateChangedModelelementToCode(changedMappedModelElement)
		 * 		-> coding the transformations here is ugly, isnt it?
		 * - update the EObject in this.mappings (get the respective MappingEntry and set the designmodel element to changed one)
		 * 		
		 * - print results and remove old files with old names (manually, no refactoring a la eclipse)
		 * - set newly updatedModel to existendDesignmodel
		 * 
		 * OR
		 * 
		 * - go through this.mappings and check for each entry if smth has changed in updatedModel
		 */
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
		//check the mapped code element value (currently only mapping to the codestructure-name is supported)
		if(entry.getMappedCodeElementValue().contentEquals("name") && entry.getMappedDesignmodelElementValue().startsWith("attribute(")) {
			String re1="(attribute)";
		    String re2="(\\(.*\\))";

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(entry.getMappedDesignmodelElementValue());
		    if (m.find()) {
		        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
		        //get the new attribute value that is mapped to the name of the codestructure
				String newAttributeValue = updatedModelElement.eGet(updatedModelElement.eClass().getEStructuralFeature(attributeName)).toString();
				System.out.println("newAttributeValue = " + newAttributeValue);
				//change the codestructure respectively
				entry.getCodeElement().setSimpleName(newAttributeValue);
				//change the model element to new one
				entry.setDesignmodelElement(updatedModelElement);
				//remove the old codestructure
				//-> currently just implemented as deleting it (TODO is full refactoring through renaming it instead of deleting it)
				System.out.println("deleting at " + entry.getCodeElement().getPosition().getCompilationUnit().getFile());
				entry.getCodeElement().getPosition().getCompilationUnit().getFile().delete();
				//setting the path to the .java-file of the possibly renamed code element
				String pathWithoutJavaExtension = entry.getCodeElement().getPosition().getCompilationUnit().getFile().toString().split("\\.java")[0];
				String[] a = pathWithoutJavaExtension.split("\\\\");
				String newFileName = pathWithoutJavaExtension.split(a[a.length-1])[0] + entry.getCodeElement().getSimpleName() + ".java";
				entry.getCodeElement().getPosition().getCompilationUnit().setFile(new File(newFileName));
				//entry.getCodeElement().getPosition().getFile().delete();
				
				//TODO changes in the code do get lost when renaming the files and creating new ones
				
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
}
