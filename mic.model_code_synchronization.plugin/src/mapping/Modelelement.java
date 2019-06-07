package mapping;

public enum Modelelement {
	CLASS("class"),
	ATTRIBUTE("attribute"),
	REFERENCE("reference");
	
	private String textRepresentation;
	
	private Modelelement(String textRepresentation) {
		this.textRepresentation = textRepresentation;
	}
	
	public static Modelelement getModelelementFor(String desired) throws ParserException {
	    for (Modelelement element : values()) {
	      if (desired.contentEquals(element.textRepresentation)) {
	        return element;
	      }
	    }
	    throw new ParserException("Unknown modelelement type defined");
	}
	
	@Override
	public String toString() {
		return this.textRepresentation;
	}
}
