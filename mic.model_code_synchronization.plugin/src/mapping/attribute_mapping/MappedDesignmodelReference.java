package mapping.attribute_mapping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import spoon.reflect.declaration.CtNamedElement;

/**
 * Representing the mapping to a value of a reference in the design model
 * OR
 * the mapping to a value of the target class of a reference in the design model, if this.target != NULL
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedDesignmodelReference extends MappedDesignmodelElement {
	
	/**
	 * NULL if the targetValue is directly the MappedDesignmodelReference
	 * if != NULL, the targetValue of the assignment is actually within the MappedDesignmodelClass (target of the reference) and not in here!
	 */
	private MappedDesignmodelClass target;

	public MappedDesignmodelReference(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	public MappedDesignmodelClass getTarget() {
		return target;
	}

	public void setTarget(MappedDesignmodelClass target) {
		this.target = target;
	}

	@Override
	public EObject createDesignmodelElement(EPackage metapackage, String metamodelElement, CtNamedElement mappedCodeElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		if(target != null) {
			return "The '" + this.getTargetValue() + "' of the target-class of a reference in the designmodel is " + this.getMappedCodeElement();
		}
		return "The '" + this.getTargetValue() + "' of the reference in the designmodel is " + this.getMappedCodeElement();
	}
}
