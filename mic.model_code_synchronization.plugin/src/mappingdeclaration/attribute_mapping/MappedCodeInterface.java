package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;

/**
 * Representing the mapping to the value of an inteface in the code.
 *
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeInterface extends MappedCodeElement {

	public MappedCodeInterface(String targetValue, CodestructureType codestructureType) {
		super(targetValue, codestructureType);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of an interface in the code.";
	}
}
