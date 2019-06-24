package mappingdeclaration;

/**
 * Supported keywords defined here to describe the codestructure being mapped to in the mapping files. 
 *
 * @author Fabian Glittenberg
 *
 */
public enum CodestructureType {
	CLASS("class"),
	INTERFACE("interface");
	
	private String textRepresentation;
	
	private CodestructureType(String textRepresentation) {
		this.textRepresentation = textRepresentation;
	}

	public static CodestructureType getCodeStructureTypeFor(String desired) throws ParserException {
	    for (CodestructureType codestructure : values()) {
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
