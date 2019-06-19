package mapping.condition;

import designmodel.generation.AnnotationHasNameOfProcessor;

public class AnnotationHasNameOfCondition extends Condition {

	public AnnotationHasNameOfCondition(String targetElement) {
		super(targetElement);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = HasNameOfCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}

	@Override
	public void createProcessor(String targetName) {
		this.setProcessor(new AnnotationHasNameOfProcessor(targetName));
		
	}
}
