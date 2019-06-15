package mapping.attribute_mapping;

public class MappedCodeInterface extends MappedCodeElement {

	public MappedCodeInterface(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to an interface in the code with the target value '" + this.getTargetValue() + "'";
	}
}
