package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;

/**
 * Represents the mapping to a value of a class in the code.
 *
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeClass extends MappedCodeElement {

	public MappedCodeClass(String targetValue, CodestructureType codestructureType) {
		super(targetValue, codestructureType);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of a class in the code.";
	}

}
