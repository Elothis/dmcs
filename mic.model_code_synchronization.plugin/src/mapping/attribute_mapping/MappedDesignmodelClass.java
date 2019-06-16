package mapping.attribute_mapping;

/**
 * Representing the mapping to a value of a class in the design model.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedDesignmodelClass extends MappedDesignmodelElement {
	
	public MappedDesignmodelClass(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

	@Override
	public String toString() {
		return "The '" + this.getTargetValue() + "' of a class in the designmodel is " + this.getMappedCodeElement();
	}
}
