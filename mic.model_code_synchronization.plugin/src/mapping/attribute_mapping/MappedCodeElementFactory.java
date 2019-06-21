package mapping.attribute_mapping;

import mapping.CodestructureType;
import mapping.ParserException;

/**
 * Factory for creating concrete instances of MappedCodeElements
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeElementFactory {
	
	/**
	 * Factory method for creating concrete instances of MappedCodeElement-objects.
	 * Takes the right-hand-side String of the attribute-mapping assignment from the "mapping:" element in the mapping-file and the CodestructureType
	 * it refers to as parameters.
	 * 
	 * @param mappedCodeElementTargetValue Right-hand-side String of the attribute-mapping-assignment from "mapping:"-element in the .im-file
	 * @param codestructureType CodestructureType it refers to
	 * @return concrete instance of MappedCodeElement
	 * @throws ParserException 
	 */
	public static MappedCodeElement createMappedCodeElement(String mappedCodeElementTargetValue, CodestructureType codestructureType) throws ParserException {

		//trim off the initial "codestructure."
		if(mappedCodeElementTargetValue.startsWith("codestructure.")) {
			mappedCodeElementTargetValue = mappedCodeElementTargetValue.split("codestructure.")[1];
		}
		if (mappedCodeElementTargetValue.contentEquals("")) {
			throw new ParserException("Right hand side of an attribute-mapping cannot be empty");
		}
		switch (codestructureType) {
		case CLASS:
			return new MappedCodeClass(mappedCodeElementTargetValue);
		case INTERFACE:
			return new MappedCodeInterface(mappedCodeElementTargetValue);
		default:
			throw new ParserException("Codestructure-Type not supported");		
		}
	}
}
