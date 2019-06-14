package mapping.attribute_mapping;

import mapping.CodestructureType;

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
	 * @param mappedCodeElement Right-hand-side String of the attribute-mapping-assignment from "mapping:"-element in the .im-file
	 * @param codestructureType CodestructureType it refers to
	 * @return concrete instance of MappedCodeElement
	 */
	public static MappedCodeElement createMappedCodeElement(String mappedCodeElement, CodestructureType codestructureType) {
		//TODO parse right hand side of mapping attribute assignment here
		// e.g. mapping: modelelement.attribute(name) = |||||codestructure.name|||||;
		
		return new MappedCodeClass(mappedCodeElement.split("\\.")[0]);
	}
}
