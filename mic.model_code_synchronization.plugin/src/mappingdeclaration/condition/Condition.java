package mappingdeclaration.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import designmodel.generation.GenerationProcessor;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.Launcher;
import spoon.reflect.declaration.CtNamedElement;

public abstract class Condition {
	private String targetElement;
	private GenerationProcessor<?> processor;

	
	public String getTargetElement() {
		return targetElement;
	}

	public void setTargetElement(String targetElement) {
		this.targetElement = targetElement;
	}

	public Condition(String targetElement) {
		this.targetElement = targetElement;
	}

	public GenerationProcessor<?> getProcessor() {
		return processor;
	}

	public void setProcessor(GenerationProcessor<?> processor) {
		this.processor = processor;
	}
	
	/**
	 * Creates and sets the processor for the condition based on the specific, instantiated target name of the condition and the attribute mappings of that IM.<br>
	 * E.g. for "condition: implements modelelement.name" it creates a processor that acts on all classes that implement the targetName.
	 * @param targetName
	 * @param attributeMappings
	 */
	public abstract void createProcessor(String targetName, List<MappedDesignmodelElement> attributeMappings, CodestructureType codestructureType, EPackage metapackage);
	
	/**
	 * Applies the concrete condition to a codestructure, after the codestructure got created in the design model by the user and now gets created in the code.
	 * E.g. it annotates the codestructure with a certain annotation for a AnnotatedWithCondition etc.
	 * @param newCodestructure
	 * @return the codestructure after it got treated accordingly
	 */
	public abstract CtNamedElement applyConditionToCreatedCodestructure(CtNamedElement newCodestructure, String targetNameInstance, Launcher launcher);
}
