package mapping;

import org.eclipse.emf.ecore.EObject;

import mappingdeclaration.CodestructureType;
import spoon.reflect.declaration.CtNamedElement;

/**
 * Represents the mapping of a concrete codestructure to a design model element.
 * Contains the CtNamedElement representing the codestructure, an EObject representing the mapped designmodel element
 * and their exact values about what exactly got mapped to what (e.g. the 'name' of the codestructure got mapped to 'attribute(name)' of the model)
 * @author Fabian Glittenberg
 *
 */
public class MappingEntry {
	
	private CtNamedElement codeElement;
	private CodestructureType codestructureType;
	private EObject designmodelElement;
	private String mappedCodeElementValue;
	private String mappedDesignmodelElementValue;
	
	public MappingEntry(CtNamedElement codeElement, CodestructureType codestructureType, EObject designmodelElement, String mappedCodeElementValue,
			String mappedDesignmodelElementValue) {
		super();
		this.codeElement = codeElement;
		this.codestructureType = codestructureType;
		this.designmodelElement = designmodelElement;
		this.mappedCodeElementValue = mappedCodeElementValue;
		this.mappedDesignmodelElementValue = mappedDesignmodelElementValue;
	}
	public MappingEntry() {
		
	}
	public CtNamedElement getCodeElement() {
		return codeElement;
	}
	public void setCodeElement(CtNamedElement codeElement) {
		this.codeElement = codeElement;
	}
	public CodestructureType getCodestructureType() {
		return codestructureType;
	}
	public void setCodestructureType(CodestructureType codestructureType) {
		this.codestructureType = codestructureType;
	}
	public EObject getDesignmodelElement() {
		return designmodelElement;
	}
	public void setDesignmodelElement(EObject designmodelElement) {
		this.designmodelElement = designmodelElement;
	}
	public String getMappedCodeElementValue() {
		return mappedCodeElementValue;
	}
	public void setMappedCodeElementValue(String mappedCodeElementValue) {
		this.mappedCodeElementValue = mappedCodeElementValue;
	}
	public String getMappedDesignmodelElementValue() {
		return mappedDesignmodelElementValue;
	}
	public void setMappedDesignmodelElementValue(String mappedDesignmodelElementValue) {
		this.mappedDesignmodelElementValue = mappedDesignmodelElementValue;
	}
	@Override
	public String toString() {
		return codeElement.getSimpleName() + " - " + designmodelElement.eClass().getName() + " - " +
				mappedCodeElementValue + " - " + mappedDesignmodelElementValue;
	}

}
