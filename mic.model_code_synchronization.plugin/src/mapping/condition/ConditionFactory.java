package mapping.condition;

/**
 * Factory for creating concrete Conditions based on the ConditionKeyword parsed from the mapping file and the targetElement followed.
 * 
 * @author Fabian Glittenberg
 *
 */
public class ConditionFactory {
	/**
	 * Creates a concrete condition based on the ConditionKeyword parsed from the mapping file and the targetElement following the keyword.
	 * @param keyword
	 * @param targetElement
	 * @return concrete condition object respective to the specified type of condition by the ConditionKeyword
	 */
	public static Condition createCondition(ConditionKeyword keyword, String targetElement) {
		Condition condition;
		
		switch (keyword) {
		case IMPLEMENTS:
			condition = new ImplementedInterfaceCondition(targetElement);
			break;
		case ANNOTATED_WITH:
			condition = new AnnotatedWithCondition(targetElement);
			break;
		case HAS_NAME_OF:
			condition = new HasNameOfCondition(targetElement);
			break;
			default:
				throw new IllegalArgumentException("Unknown ConditionKeyword provided for factory class");
		}
		
		return condition;
	}
}