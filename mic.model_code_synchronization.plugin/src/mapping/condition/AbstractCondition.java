package mapping.condition;

public abstract class AbstractCondition {
	//TODO until now only as string, has to be dispatched to actual element
	private String targetElement;
	
	public String getTargetElement() {
		return targetElement;
	}

	public void setTargetElement(String targetElement) {
		this.targetElement = targetElement;
	}

	public AbstractCondition(String targetElement) {
		this.targetElement = targetElement;
	}
}
