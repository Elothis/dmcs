package mapping.attribute_mapping;

public class MappedCodeAnnotation extends MappedCodeElement {
	

	public MappedCodeAnnotation(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of an annotation in the code.";
	}
}
