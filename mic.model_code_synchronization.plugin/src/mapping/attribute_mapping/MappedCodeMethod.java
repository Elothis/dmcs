package mapping.attribute_mapping;

public class MappedCodeMethod extends MappedCodeElement {
	
	private MappedCodeAnnotation annotation;

	public MappedCodeMethod(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to a method in the code with the target value '" + this.getTargetValue() + "'";
	}
}
