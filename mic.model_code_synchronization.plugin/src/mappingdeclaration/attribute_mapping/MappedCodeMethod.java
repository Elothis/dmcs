package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

public class MappedCodeMethod extends MappedCodeElement {

	public MappedCodeMethod(String targetValue, CodestructureType codestructureType) {
		super(targetValue, codestructureType);
	}
	
	@Override
	public boolean deleteCodestructure(CtNamedElement codestructure) {
		codestructure.delete();
		return true;
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of a method in the code.";
	}
}
