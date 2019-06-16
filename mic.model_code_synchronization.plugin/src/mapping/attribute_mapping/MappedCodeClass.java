package mapping.attribute_mapping;

public class MappedCodeClass extends MappedCodeElement {

	public MappedCodeClass(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of a class in the code.";
	}

}
