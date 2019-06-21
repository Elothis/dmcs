package mapping.attribute_mapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import mapping.ParserException;

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
	public EObject createDesignmodelElement(EPackage metapackage, String metamodelElement, String instanceValue) throws MappingException {
		//TODO add parameters for structuralFeatures of the metamodelElement that shall get set as well
		//probably 3-tupels of structuralFeatureName (e.g. "name" here),
		//structuralFeatureType to know what to cast to (here "EAttribute") and
		//structuralFeatureInstanceValue to know what to set it to (here "Ready")
		
		//and what about this.getMappedCodeElement()? what do I do with that data?
		EClass stateClass = (EClass) metapackage.getEClassifier(metamodelElement);
		
		//test whether targetValue is of format 'attribute(xyz)'
		String re1="(attribute)";
	    String re2="(\\(.*\\))";

	    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(this.getTargetValue());
	    if (m.find()) {
	        String attributeName = StringUtils.substringBetween(m.group(2), "(", ")");

			EAttribute classAttribute = (EAttribute) stateClass.getEStructuralFeature(attributeName);
			if(classAttribute == null) {
				throw new MappingException(attributeName + " is no attribute of the meta model class!");
			}
			
			EFactory metafactory = metapackage.getEFactoryInstance();
			EObject stateInstance = metafactory.create(stateClass);
			stateInstance.eSet(classAttribute, instanceValue);
			
			return stateInstance;
	    }
	    else {
	    	throw new MappingException(this.getTargetValue() + " as the target value of a MappedDesignmodelClass is currently not yet implemented.");
	    }

	}
	
}
