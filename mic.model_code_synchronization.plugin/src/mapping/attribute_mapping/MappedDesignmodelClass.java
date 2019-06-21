package mapping.attribute_mapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

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
			throw new MappingException(this.getMappedCodeElement().getTargetValue() + " as the target value of a MappedCodeElement is currently not yet implemented.");
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
	    	throw new MappingException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
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
	    	throw new MappingException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
	    }
	}
	
}
