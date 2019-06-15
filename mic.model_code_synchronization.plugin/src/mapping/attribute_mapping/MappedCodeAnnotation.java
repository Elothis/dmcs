package mapping.attribute_mapping;

public class MappedCodeAnnotation extends MappedCodeElement {

	private MappedCodeAnnotationParameter annotationParameter;

	public MappedCodeAnnotation() {
		super();
	}

	@Override
	public String toString() {
		return "CodeAnnotation '" + this.getName() + "' with parameter (" + annotationParameter + ")";
	}
}
