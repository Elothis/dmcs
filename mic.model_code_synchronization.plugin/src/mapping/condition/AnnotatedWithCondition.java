package mapping.condition;

/**
 * Condition representing an "annotated with" relationship for the codestructure mapped to.
 * E.g. "condition: annotatedWith MyComponent;"
 * 
 * @author Fabian Glittenberg
 *
 */
public class AnnotatedWithCondition extends AbstractCondition {

	public AnnotatedWithCondition(String targetElement) {
		super(targetElement);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = AnnotatedWithCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}
}
