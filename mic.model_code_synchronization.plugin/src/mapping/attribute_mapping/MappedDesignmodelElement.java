package mapping.attribute_mapping;

/**
 * Abstract super class representing one attribute-mapping from designmodel element to code element. Holding the mapped code element, thus making this a complete mapping. 
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedDesignmodelElement {
	private MappedCodeElement mappedCodeElement;
	private String targetValue;

	public MappedCodeElement getMappedCodeElement() {
		return mappedCodeElement;
	}

	public void setMappedCodeElement(MappedCodeElement mappedCodeElement) {
		this.mappedCodeElement = mappedCodeElement;
	}

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public MappedDesignmodelElement(String targetValue, MappedCodeElement mappedCodeElement) {
		this.targetValue = targetValue;
		this.mappedCodeElement = mappedCodeElement;
	}
	
}
