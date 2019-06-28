package mapping;

import org.eclipse.emf.ecore.EObject;

import spoon.reflect.declaration.CtNamedElement;

public class MappingEntry {
	
	private CtNamedElement codeElement;
	private EObject designmodelElement;
	private String mappedCodeElementValue;
	private String mappedDesignmodelElementValue;
	
	public MappingEntry(CtNamedElement codeElement, EObject designmodelElement, String mappedCodeElementValue,
			String mappedDesignmodelElementValue) {
		super();
		this.codeElement = codeElement;
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
