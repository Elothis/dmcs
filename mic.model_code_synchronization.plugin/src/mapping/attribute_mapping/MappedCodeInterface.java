package mapping.attribute_mapping;

public class MappedCodeInterface extends MappedCodeElement {

	public MappedCodeInterface(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of an interface in the code.";
	}
}
