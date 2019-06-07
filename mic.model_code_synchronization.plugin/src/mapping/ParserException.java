package mapping;

/**
 * Exception getting thrown when something goes wrong while parsing the mappings.
 * 
 * @author Fabian Glittenberg
 *
 */
public class ParserException extends Exception {

	public ParserException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
