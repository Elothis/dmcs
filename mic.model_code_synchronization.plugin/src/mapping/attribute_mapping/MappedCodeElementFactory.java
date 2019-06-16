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
		//TODO parse right hand side of mapping attribute assignment here
		// e.g. mapping: modelelement.attribute(name) = |||||codestructure.name|||||;
		//trim off the initial "codestructure."
		if(mappedCodeElementTargetValue.startsWith("codestructure.")) {
			mappedCodeElementTargetValue = mappedCodeElementTargetValue.split("codestructure.")[1];
		}
		if (mappedCodeElementTargetValue.contentEquals("")) {
			throw new ParserException("Right hand side of an attribute-mapping cannot be empty");
		}
		switch (codestructureType) {
		case ANNOTATION:
			return new MappedCodeAnnotation(mappedCodeElementTargetValue);
		case CLASS:
			return new MappedCodeClass(mappedCodeElementTargetValue);
		case INTERFACE:
			return new MappedCodeInterface(mappedCodeElementTargetValue);
		case METHOD:
			//if the target is an annotation attached to a method,
			//add a MappedCodeAnnotation to the MappedCodeMethod and attach targetValue to it
			if(mappedCodeElementTargetValue.startsWith("annotation.")) {
				mappedCodeElementTargetValue = mappedCodeElementTargetValue.split("annotation.")[1];
				MappedCodeMethod mcm = new MappedCodeMethod(mappedCodeElementTargetValue);
				mcm.setAnnotation(new MappedCodeAnnotation(mappedCodeElementTargetValue));
				return mcm;
			}
			//if the target is the method directly (not an annotation attached to it or anything else),
			//return it with the targetValue attached to it directly			
			return new MappedCodeMethod(mappedCodeElementTargetValue);
		default:
			throw new ParserException("Codestructure-Type not supported");		
		}
	}
}
