package mapping.attribute_mapping;


/**
 * Abstract super class representing one attribute-mapping code element.
 * Belongs to one MappedDesignmodelElement and holds the targetValue of the concrete code element that gets assigned to the respective MappedDesignmodelElement.
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedCodeElement {
	/**
	 * Concrete value the modelelement gets assigned from the codestrucuture.
	 * E.g.: "name" from codestructure.name in a mapping statement like "mapping: modelelement.attribute(name) = codestructure.name"
	 */
	private String targetValue;
	
	//TODO maybe add 'private MappedCodeElement subElement' that is either NULL or not, depending on whether the targetValue is from directly this object or a subElement

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public MappedCodeElement(String targetValue) {
		this.targetValue = targetValue;
	}
}
