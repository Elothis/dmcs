package mappingdeclaration.attribute_mapping;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

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

	@Override
	public boolean deleteCodestructure(CtNamedElement codestructure) {
		//since this codestructure is an entire typdefinition in form of an interface-file, the whole file gets deleted
		codestructure.delete();
		System.out.println("The interface '" + codestructure.getSimpleName() + "' was deleted");
		return codestructure.getPosition().getCompilationUnit().getFile().delete();
	}
	
}
