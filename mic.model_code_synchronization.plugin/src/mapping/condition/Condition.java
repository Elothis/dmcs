package mapping.condition;

public abstract class Condition {
	//TODO until now only as string, has to be dispatched to actual element
	private String targetElement;
	
	public String getTargetElement() {
		return targetElement;
	}

	public void setTargetElement(String targetElement) {
		this.targetElement = targetElement;
	}

	public Condition(String targetElement) {
		this.targetElement = targetElement;
	}
}
