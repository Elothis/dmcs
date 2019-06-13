package mapping.attribute_mapping;

/**
 * Abstract super class representing one attribute-mapping from designmodel element to code element. Holding the mapped code element, thus making this a complete mapping. 
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedDesignmodelElement {
	private MappedCodeElement mappedCodeElement;

	public MappedCodeElement getMappedCodeElement() {
		return mappedCodeElement;
	}

	public void setMappedCodeElement(MappedCodeElement mappedCodeElement) {
		this.mappedCodeElement = mappedCodeElement;
	}

	public MappedDesignmodelElement(MappedCodeElement mappedCodeElement) {
		this.mappedCodeElement = mappedCodeElement;
	}
	
}
