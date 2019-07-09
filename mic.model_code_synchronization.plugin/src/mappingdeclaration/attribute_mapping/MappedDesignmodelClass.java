package mappingdeclaration.attribute_mapping;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

/**
 * Representing the mapping to a value of a class in the design model.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedDesignmodelClass extends MappedDesignmodelElement {
	
	public MappedDesignmodelClass(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public String toString() {
		return "The '" + this.getTargetValue() + "' of a class in the designmodel is " + this.getMappedCodeElement();
	}

	@Override
	public EObject createDesignmodelElement(EPackage metapackage, String metamodelElement, CtNamedElement mappedCodeElement) throws MappingException {
		//first look up what from the codestructure shall get mapped to some value of the metamodel element
		//currently only 'codestructure.name' supported, rest is TODO
		if(!this.getMappedCodeElement().getTargetValue().contentEquals("name")) {
			throw new NotImplementedException(this.getMappedCodeElement().getTargetValue() + " as the target value of a MappedCodeElement is currently not yet implemented.");
		}
		
		this.getMappedCodeElement().getTargetValue();
		
		EClass metaClass = (EClass) metapackage.getEClassifier(metamodelElement);
		
		//test whether targetValue is of format 'attribute(xyz)'
		String re1="(attribute)";
	    String re2="(\\(.*\\))";

	    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(this.getTargetValue());
	    if (m.find()) {
	        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");

			EAttribute classAttribute = (EAttribute) metaClass.getEStructuralFeature(attributeName);
			if(classAttribute == null) {
				throw new MappingException(attributeName + " is no attribute of the meta model class!");
			}
			
			EFactory metafactory = metapackage.getEFactoryInstance();
			EObject stateInstance = metafactory.create(metaClass);
			stateInstance.eSet(classAttribute, mappedCodeElement.getSimpleName());
			
			return stateInstance;
	    }
	    else {
	    	throw new NotImplementedException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
	    }

	}

	@Override
	public EObject addMappedAttribute(EPackage metapackage, EObject obj, String metamodelElement, CtNamedElement mappedCodeElement) throws MappingException {
		//first look up what from the codestructure shall get mapped to some value of the metamodel element
		//currently only 'codestructure.name' supported, rest is TODO
		if(!this.getMappedCodeElement().getTargetValue().contentEquals("name")) {
			throw new MappingException(this.getMappedCodeElement().getTargetValue() + " as the target value of a MappedCodeElement is currently not yet implemented.");
		}
		
		EClass metaClass = (EClass) metapackage.getEClassifier(metamodelElement);

		//test whether targetValue is of format 'attribute(xyz)'
		String re1="(attribute)";
	    String re2="(\\(.*\\))";

	    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(this.getTargetValue());
	    if (m.find()) {
	        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
	        
	        EAttribute classAttribute = (EAttribute) metaClass.getEStructuralFeature(attributeName);
			if(classAttribute == null) {
				throw new MappingException(attributeName + " is no attribute of the meta model class!");
			}

			obj.eSet(classAttribute, mappedCodeElement.getSimpleName());
			
			return obj;
	    }
	    else {
	    	throw new NotImplementedException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
	    }
	}

	@Override
	public MappingEntry updateMappingEntry(MappingEntry entry, EObject updatedModelElement) {
		if(entry.getCodeElement() == null) {
			return null;
		}
		//dispatch here what is mapped to what (currently only the name of the codestructure mapped to attributes of the design model element is implemented)
		if(entry.getMappedCodeElementValue().contentEquals("name") &&
				(entry.getCodestructureType() != CodestructureType.CLASS || entry.getCodestructureType() != CodestructureType.INTERFACE) &&
				entry.getMappedDesignmodelElementValue().startsWith("attribute(")) {
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
				entry.setDesignmodelElementEObject(updatedModelElement);
				//remove the old codestructure
				//-> currently just implemented as deleting it (TODO is full refactoring through renaming it instead of deleting it)
				entry.getCodeElement().getPosition().getCompilationUnit().getFile().delete();
				//setting the path to the .java-file of the possibly renamed code element
				String pathWithoutJavaExtension = entry.getCodeElement().getPosition().getCompilationUnit().getFile().toString().split("\\.java")[0];
				String[] a = pathWithoutJavaExtension.split(Pattern.quote(System.getProperty("file.separator")));
				String newFileName = pathWithoutJavaExtension.split(a[a.length-1])[0] + entry.getCodeElement().getSimpleName() + ".java";
				entry.getCodeElement().getPosition().getCompilationUnit().setFile(new File(newFileName));
		    }
		    else {
		    	throw new NotImplementedException(entry.getMappedDesignmodelElementValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
		    }
		}
		else {
			throw new NotImplementedException("Currently there are only mappings from attributes from a design model class to names of classes and interfaces as code strucutres implemented");
		}
		return entry;
	}

	@Override
	public boolean deleteCodestructure(MappingEntry entry, EObject deletedMappedModelElement) {
		if(entry.getMappedDesignmodelElementValue().startsWith("attribute(")) {
			//call the delete-function of the mapped code element
			return entry.getMappedDesignmodelElement().getMappedCodeElement().deleteCodestructure(entry.getCodeElement());
		}
		else {
			throw new NotImplementedException("Currently there are only mappings from attributes from a design model class to codestructures implemented");
		}
		
	}

	@Override
	public MappingEntry createMappingEntry(EObject designmodelElement, CtNamedElement mappedCodeElement) {
		MappingEntry mappingEntry = new MappingEntry();
		mappingEntry.setDesignmodelElementEObject(designmodelElement);
		mappingEntry.setCodeElement(mappedCodeElement);
		mappingEntry.setCodestructureType(this.getMappedCodeElement().getCodestructureType());
		mappingEntry.setMappedDesignmodelElementValue(this.getTargetValue());
		mappingEntry.setMappedCodeElementValue(this.getMappedCodeElement().getTargetValue());
		mappingEntry.setMappedDesignmodelElement(this);
		
		return mappingEntry;
	}
	
}
