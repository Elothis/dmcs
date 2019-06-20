package mapping.attribute_mapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

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
	public EObject createDesignmodelElement(EPackage metapackage, String metamodelElement) {
		//TODO add parameters for structuralFeatures of the metamodelElement that shall get set as well
		//probably 3-tupels of structuralFeatureName (e.g. "name" here),
		//structuralFeatureType to know what to cast to (here "EAttribute") and
		//structuralFeatureInstanceValue to know what to set it to (here "Ready")
		EClass stateClass = (EClass) metapackage.getEClassifier(metamodelElement);
		EAttribute nameAttr = (EAttribute) stateClass.getEStructuralFeature("name");
		
		EFactory metafactory = metapackage.getEFactoryInstance();
		EObject stateInstance = metafactory.create(stateClass);
		stateInstance.eSet(nameAttr, "Ready");
		
		return stateInstance;
	}
	
}
