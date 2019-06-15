package mapping.attribute_mapping;

public class MappedDesignmodelClass extends MappedDesignmodelElement {
	
	public MappedDesignmodelClass(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public String toString() {
		return "Modelelement of type class with the target value '" + this.getTargetValue() + "' " + this.getMappedCodeElement();
	}
}
