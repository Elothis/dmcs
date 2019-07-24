package mappingdeclaration.attribute_mapping;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import concrete_mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.MappingInstantiation;
import spoon.reflect.declaration.CtNamedElement;

/**
 * Representing the mapping to a containment reference value in the design model.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedDesignmodelContainmentReference extends MappedDesignmodelElement {

	public MappedDesignmodelContainmentReference(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public EObject createDesignmodelElement(EPackage metapackage, MappingInstantiation mappingInstantiation,
			CtNamedElement mappedCodeElement, EObject parentObject) throws MappingException {
		if(parentObject == null) {
			throw new IllegalArgumentException("parentObject cannot be null for MappedDesignmodelContainmentReferences");
		}
		//first look up what from the codestructure shall get mapped to some value of the metamodel element
		//currently only 'codestructure.name' supported, rest is TODO
		if(!this.getMappedCodeElement().getTargetValue().contentEquals("name")) {
			throw new NotImplementedException(this.getMappedCodeElement().getTargetValue() + " as the target value of a MappedCodeElement is currently not yet implemented.");
		}
		
		String holdingClassName = mappingInstantiation.getInstantiatedParentModelElement();
		String referenceName =  mappingInstantiation.getInstantiatedModelElement();
		
		EClass holdingMetaClass = (EClass) metapackage.getEClassifier(holdingClassName);
		
		//test whether targetValue is of format 'target.attribute(xyz)'
		String re1="(target\\.attribute)";
	    String re2="(\\(.*\\))";

	    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(this.getTargetValue());
	    if (m.find()) {
	        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");
	        //get target-class
	        EReference classReference = (EReference) holdingMetaClass.getEStructuralFeature(referenceName);
	        if(classReference == null) {
	        	classReference = (EReference) holdingMetaClass.getEStructuralFeature(StringUtils.uncapitalize(referenceName));
	        }
	        if(classReference == null) {
	        	throw new IllegalArgumentException(referenceName + " is no reference in the meta model!");
	        }

	        EClass targetMetaClass = classReference.getEReferenceType();
	        
	        //set attribute
			EAttribute classAttribute = (EAttribute) targetMetaClass.getEStructuralFeature(attributeName);
			if(classAttribute == null) {
				throw new MappingException(attributeName + " is no attribute of the meta model class!");
			}
			//create contained model element object
			EFactory metafactory = metapackage.getEFactoryInstance();
			EObject targetModelelement = metafactory.create(targetMetaClass);
			targetModelelement.eSet(classAttribute, mappedCodeElement.getSimpleName());
			
			List<EObject> refs = (List<EObject>) parentObject.eGet(classReference);
			
			refs.add(targetModelelement);
			//parentObject.eSet(classReference, refs);
			
			return targetModelelement;
	    }
	    else {
	    	throw new NotImplementedException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
	    }
	}

	@Override
	public EObject addMappedAttribute(EPackage metapackage, EObject eClass, String metamodelElement,
			CtNamedElement mappedCodeElement) throws MappingException {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public MappingEntry updateTransformation(MappingEntry entry, EObject updatedModelElement) {
		if(entry.getCodeElement() == null) {
			return null;
		}
		//dispatch here what is mapped to what (currently only the name of the codestructure mapped to attributes of the reference target in the design model element is implemented)
		if(entry.getMappedCodeElementValue().contentEquals("name") &&
				entry.getCodestructureType() == CodestructureType.METHOD &&
				entry.getMappedDesignmodelElementValue().startsWith("target.attribute(")) {
			String re1="(target\\.attribute)";
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
					//System.out.println(entry.getCodeElement().getSimpleName() + " did not get changed");
					return entry;
				}
				//System.out.println(entry.getCodeElement().getSimpleName() + " got changed to " + newAttributeValue);
				//change the codestructure respectively
				entry.getCodeElement().setSimpleName(newAttributeValue);
				//change the model element to new one
				entry.setDesignmodelElementEObject(updatedModelElement);
		    }
		    else {
		    	throw new NotImplementedException(entry.getMappedDesignmodelElementValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
		    }
		}
		else {
			throw new NotImplementedException("Currently there are only mappings from referenced attributes from a design model class to names of methods as code structures implemented");
		}
		return entry;
	}

	@Override
	public boolean deleteTransformation(MappingEntry entry, EObject deletedMappedModelElement) {
		if(entry.getMappedDesignmodelElementValue().startsWith("attribute(") ||
				entry.getMappedDesignmodelElementValue().startsWith("target.attribute(")) {
			//call the delete-function of the mapped code element
			return entry.getMappedDesignmodelElement().getMappedCodeElement().deleteCodestructure(entry.getCodeElement());
		}
		else {
			throw new NotImplementedException("Currently there are only mappings from attributes from a design model class to codestructures implemented");
		}		
	}

	@Override
	public String toString() {
		return "The reference-value '" + this.getTargetValue() + "' in the designmodel is " + this.getMappedCodeElement();
	}
}
