package mapping.attribute_mapping;

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
	public String toString() {
		if(target != null) {
			return "The '" + this.getTargetValue() + "' of the target-class of a reference in the designmodel is " + this.getMappedCodeElement();
		}
		return "The '" + this.getTargetValue() + "' of the reference in the designmodel is " + this.getMappedCodeElement();
	}
}
