package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

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

	@Override
	public boolean deleteCodestructure(CtNamedElement codestructure) {
		//since this codestructure is an entire typdefinition in form of a class-file, the whole file gets deleted
		codestructure.delete();
		System.out.println("The class '" + codestructure.getSimpleName() + "' was deleted");
		return codestructure.getPosition().getCompilationUnit().getFile().delete();
	}

}
