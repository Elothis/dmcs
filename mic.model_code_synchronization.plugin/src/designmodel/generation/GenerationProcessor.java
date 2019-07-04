package designmodel.generation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;

public abstract class GenerationProcessor<T extends CtElement> extends AbstractProcessor<T> {
	private List<MappedDesignmodelElement> attributeMappings;
	private EPackage metapackage;
	private List<EObject> generatedDesignmodelElements;
	private CodestructureType codestructureType;
	private List<MappingEntry> mappingEntries;

	public GenerationProcessor(List<MappedDesignmodelElement> attributeMappings, CodestructureType codestructureType, EPackage metapackage) {
		super();
		this.attributeMappings = attributeMappings;
		this.metapackage = metapackage;
		this.generatedDesignmodelElements = new ArrayList<>();
		this.codestructureType = codestructureType;
		this.mappingEntries = new ArrayList<>();
	}

	public List<MappingEntry> getMappingEntries() {
		return mappingEntries;
	}

	public void setMappingEntries(List<MappingEntry> mappingEntries) {
		this.mappingEntries = mappingEntries;
	}

	public EPackage getMetapackage() {
		return metapackage;
	}

	public void setMetapackage(EPackage metapackage) {
		this.metapackage = metapackage;
	}

	public CodestructureType getCodestructureType() {
		return codestructureType;
	}

	public void setCodestructureType(CodestructureType codestructureType) {
		this.codestructureType = codestructureType;
	}

	public List<EObject> getGeneratedDesignmodelElements() {
		return generatedDesignmodelElements;
	}
	
	/**
	 * Adds an EObject to the list of generated design model elements the processor created during its process-method.
	 * @param generatedDesignmodelElement
	 * @return
	 */
	public boolean addGeneratedDesignmodelElement(EObject generatedDesignmodelElement) {
		return this.generatedDesignmodelElements.add(generatedDesignmodelElement);
	}

	public void setGeneratedDesignmodelElements(List<EObject> generatedDesignmodelElement) {
		this.generatedDesignmodelElements = generatedDesignmodelElement;
	}

	public List<MappedDesignmodelElement> getAttributeMappings() {
		return attributeMappings;
	}

	public void setAttributeMappings(List<MappedDesignmodelElement> attributeMappings) {
		this.attributeMappings = attributeMappings;
	}
}
