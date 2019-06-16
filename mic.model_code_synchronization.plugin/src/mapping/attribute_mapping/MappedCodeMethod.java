package mapping.attribute_mapping;

/**
 * Representing the mapping to the value of a method in the code
 * OR
 * the mapping to the value of an annotation attached to a method in the code if this.annotation is != NULL
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeMethod extends MappedCodeElement {
	
	
	/**
	 * NULL if the target is directly the MappedCodeMethod
	 * if != NULL, the target of the assignment is actually within the MappedCodeAnnotation and not in here!
	 */
	private MappedCodeAnnotation annotation;

	public MappedCodeMethod(String targetValue) {
		super(targetValue);
	}

	public MappedCodeAnnotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(MappedCodeAnnotation annotation) {
		this.annotation = annotation;
	}

	@Override
	public String toString() {
		if(annotation != null) {
			return "Mapped to the '" + this.getTargetValue() + "' of an annotation attached to a method in the code.";
		}
		return "Mapped to the '" + this.getTargetValue() + "' of a method in the code.";
	}
}
