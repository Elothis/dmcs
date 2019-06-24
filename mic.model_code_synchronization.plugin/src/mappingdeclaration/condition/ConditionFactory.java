package mappingdeclaration.condition;

import mappingdeclaration.CodestructureType;
import mappingdeclaration.ParserException;

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
	 * @throws ParserException 
	 */
	public static Condition createCondition(ConditionKeyword keyword, String targetElement, CodestructureType codestructureType) throws ParserException {
		Condition condition;
		
		switch (keyword) {
		case IMPLEMENTS:
			if(codestructureType == CodestructureType.CLASS) {
				condition = new ImplementedInterfaceCondition(targetElement);
			}
			else {
				throw new ParserException("implements-condition cannot be applied to any other codestructure-type than a class");
			}
			break;
		case ANNOTATED_WITH:
			condition = new AnnotatedWithCondition(targetElement);
			break;
			default:
				throw new ParserException("The specified condition-keyword is not yet implemented.");
		}
		
		return condition;
	}
}
