package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;

/**
 * Abstract super class representing one attribute-mapping code element.
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
	private CodestructureType codestructureType;

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public CodestructureType getCodestructureType() {
		return codestructureType;
	}

	public void setCodestructureType(CodestructureType codestructureType) {
		this.codestructureType = codestructureType;
	}

	public MappedCodeElement(String targetValue, CodestructureType codestructureType) {
		this.targetValue = targetValue;
		this.codestructureType = codestructureType;
	}
}
