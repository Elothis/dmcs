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
			
			//getting respective model element in existing designmodel
			EObject existentModelElement = existentDesignmodel.getEObject(updatedModel.getID(updatedModelElement));
			
			if(existentModelElement == null) {
			//no existend model element there yet, meaning it got added by the user through modifications at the design model
				System.out.println(updatedModelElement + " was newly created");
				return;
			}
			
			//getting the mapping entry of this model element to check what is mapped to what, to then determine whether it got changed by the user
			MappingEntry entry = getMappingEntryByModelelement(existentModelElement);
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
}
