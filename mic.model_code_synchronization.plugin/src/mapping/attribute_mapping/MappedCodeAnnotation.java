package mapping.attribute_mapping;

public class MappedCodeAnnotation extends MappedCodeElement {

	public MappedCodeAnnotation(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to an annotation in the code with the target value '" + this.getTargetValue() + "'";
	}
}
