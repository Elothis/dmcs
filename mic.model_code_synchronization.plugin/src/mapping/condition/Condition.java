package mapping.condition;

import spoon.processing.AbstractProcessor;

public abstract class Condition {
	//TODO until now only as string, has to be dispatched to actual element?
	private String targetElement;
	private AbstractProcessor<?> processor;
	
	public String getTargetElement() {
		return targetElement;
	}

	public void setTargetElement(String targetElement) {
		this.targetElement = targetElement;
	}

	public Condition(String targetElement) {
		this.targetElement = targetElement;
	}

	public AbstractProcessor<?> getProcessor() {
		return processor;
	}

	public void setProcessor(AbstractProcessor<?> processor) {
		this.processor = processor;
	}
}
