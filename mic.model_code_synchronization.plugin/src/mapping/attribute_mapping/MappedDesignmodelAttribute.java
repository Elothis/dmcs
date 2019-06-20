package mapping.attribute_mapping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class MappedDesignmodelAttribute extends MappedDesignmodelElement {

	public MappedDesignmodelAttribute(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public EObject createDesignmodelElement(EPackage metapackage, String metamodelElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "The '" + this.getTargetValue() + "' of an attribute in the designmodel is " + this.getMappedCodeElement();
	}
}
