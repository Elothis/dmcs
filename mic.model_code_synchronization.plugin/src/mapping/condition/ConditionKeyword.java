package mapping.condition;

import mapping.ParserException;

/**
 * Supported keywords defined here to describe the condition element in the mapping files.
 * 
 * @author Fabian Glittenberg
 *
 */
public enum ConditionKeyword {
	NONE(""),
	IMPLEMENTS("implements"),
	ANNOTATED_WITH("annotatedWith"),
	HAS_NAME_OF("hasNameOf");
	
	private String textRepresentation;
	
	private ConditionKeyword(String textRepresentation) {
		this.textRepresentation = textRepresentation;
	}
	
	public static ConditionKeyword getConditionKeywordFor(String desired) throws ParserException {
	    for (ConditionKeyword element : values()) {
	      if (desired.contentEquals(element.textRepresentation)) {
	        return element;
	      }
	    }
	    throw new ParserException("Unknown condition-keyword defined");
	}
	
	@Override
	public String toString() {
		return this.textRepresentation;
	}
}
