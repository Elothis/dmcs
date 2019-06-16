package mapping.attribute_mapping;

public class MappedDesignmodelAttribute extends MappedDesignmodelElement {

	public MappedDesignmodelAttribute(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public String toString() {
		return "The '" + this.getTargetValue() + "' of an attribute in the designmodel is " + this.getMappedCodeElement();
	}
}
