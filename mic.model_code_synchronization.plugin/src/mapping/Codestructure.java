package mapping;

/**
 * Supported keywords defined here to describe the codestructure being mapped to in the mapping files. 
 *
 * @author Fabian Glittenberg
 *
 */
public enum Codestructure {
	CLASS("class"),
	INTERFACE("interface"),
	METHOD("method"),
	ANNOTATION("annotation");
	
	private String textRepresentation;
	
	private Codestructure(String textRepresentation) {
		this.textRepresentation = textRepresentation;
	}

	public static Codestructure getCodeStructureFor(String desired) throws ParserException {
	    for (Codestructure codestructure : values()) {
	      if (desired.contentEquals(codestructure.textRepresentation)) {
	        return codestructure;
	      }
	    }
	    throw new ParserException("Unknown codestructure type defined");
	}

	@Override
	public String toString() {
		return this.textRepresentation;
	}
}
