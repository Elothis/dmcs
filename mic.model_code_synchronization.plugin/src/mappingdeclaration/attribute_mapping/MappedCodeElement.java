package mappingdeclaration.attribute_mapping;

import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

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
	/**
	 * Updates the codestructure.
	 * @param codestructure
	 * @param project 
	 * @return true on success
	 */
	public CtNamedElement updateCodestructure(CtNamedElement codestructure, String newMappedModelElementValue, IJavaProject project) {
		if(this.targetValue.contentEquals("name") ) {
			codestructure.setSimpleName(newMappedModelElementValue);
			return codestructure;
		}
		else {
			throw new NotImplementedException("Currently there are only mappings to names of codestructures implemented");
		}
	}
	
	/**
	 * Deletes the codestructure.
	 * @param codestructure
	 * @return true on success
	 */
	public abstract boolean deleteCodestructure(CtNamedElement codestructure);
}
