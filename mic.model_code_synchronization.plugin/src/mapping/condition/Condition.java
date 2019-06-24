package mapping.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import designmodel.generation.GenerationProcessor;
import mapping.CodestructureType;
import mapping.attribute_mapping.MappedDesignmodelElement;

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
}
