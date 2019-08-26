package mappingdeclaration.attribute_mapping;

import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;
import util.Utility;

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
	public CtNamedElement updateCodestructure(CtNamedElement codestructure, String newMappedModelElementValue, IJavaProject project) {
		if(this.getTargetValue().contentEquals("name") ) {
			
			//refactoring rename-operation
			codestructure.getPosition().getCompilationUnit().getMainType().getQualifiedName();
			try {
				System.out.println(codestructure.getPosition().getCompilationUnit().getMainType().getQualifiedName());
				IType javaType = project.findType(codestructure.getPosition().getCompilationUnit().getMainType().getQualifiedName());
				Utility.renameType(javaType, newMappedModelElementValue);
				codestructure = codestructure.getFactory().Class().get(javaType.getFullyQualifiedName());
			} catch (JavaModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			codestructure.setSimpleName(newMappedModelElementValue);
			return codestructure;
		}
		else {
			throw new NotImplementedException("Currently there are only mappings to names of codestructures implemented");
		}
	}

	@Override
	public boolean deleteCodestructure(CtNamedElement codestructure) {
		//since this codestructure is an entire typdefinition in form of a class-file, the whole file gets deleted
		codestructure.delete();
		//System.out.println("The class '" + codestructure.getSimpleName() + "' was deleted");
		return codestructure.getPosition().getCompilationUnit().getFile().delete();
	}

}
