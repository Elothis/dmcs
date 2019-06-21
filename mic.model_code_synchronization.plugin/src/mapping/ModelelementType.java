package mapping;

/**
 * Supported keywords defined here to describe the modelelment being mapped to in the mapping files.
 * 
 * @author Fabian Glittenberg
 *
 */
public enum ModelelementType {
	CLASS("class"),
	ATTRIBUTE("attribute"),
	REFERENCE("reference");
	
	private String textRepresentation;
	
	private ModelelementType(String textRepresentation) {
		this.textRepresentation = textRepresentation;
	}
	
	public static ModelelementType getModelelementTypeFor(String desired) throws ParserException {
	    for (ModelelementType element : values()) {
	      if (desired.contentEquals(element.textRepresentation)) {
	        return element;
	      }
	    }
	    throw new ParserException("The specified modelelement-type is not yet implemented");
	}
	
	@Override
	public String toString() {
		return this.textRepresentation;
	}
}
