package mapping.attribute_mapping;

/**
 * Abstract super class representing one attribute-mapping from designmodel element to code element.
 * Holding the mapped code element and the designmodel-element's targetValue the code element is mapped to, thus making this a complete mapping. 
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedDesignmodelElement {
	private MappedCodeElement mappedCodeElement;
	private String targetValue;

	//TODO maybe add 'private MappedDesignModelelement subElement' that is either NULL or not, depending on whether the targetValue is from directly this object or a subElement
	
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
