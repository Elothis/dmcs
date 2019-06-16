package mapping.attribute_mapping;

/**
 * Representing the mapping to the value of an annotation in the code.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeAnnotation extends MappedCodeElement {
	

	public MappedCodeAnnotation(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of an annotation in the code.";
	}
}
