package mapping.condition;

public class HasNameOfCondition extends Condition {

	public HasNameOfCondition(String targetElement) {
		super(targetElement);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = HasNameOfCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}
}
