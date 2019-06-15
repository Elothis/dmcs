package mapping.attribute_mapping;

import mapping.ModelelementType;
import mapping.ParserException;

/**
 * Factory for creating concrete MappedDesignmodelElements.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappedDesignmodelElementFactory {

	/**
	 * Factory method for creating concrete instances of MappedDesignmodelelement-objects.
	 * Takes the left-hand-side String of the attribute-mapping assignment from the "mapping:" element in the mapping-file, the CodestructureType
	 * it refers to and the already formerly parsed MappedCodeElement that gets assigned as parameters.
	 * 
	 * @param mappedDesignmodelElementTargetValue Left-hand-side String of the attribute-mapping assignment from the "mapping:"-element in the .im-file
	 * @param modelelementType ModelelementType it refers to
	 * @param mappedCodeElement The already parsed MappedCodeElement that gets assigned to the designmodel element
	 * @return concrete instance of the respective MappedDesignmodelElement
	 * @throws ParserException 
	 */
	public static MappedDesignmodelElement createMappedDesignmodelElement(String mappedDesignmodelElementTargetValue, ModelelementType modelelementType, MappedCodeElement mappedCodeElement) throws ParserException {
		//TODO parse left hand side of mapping attribute assignment here
		// e.g. mapping: |||||modelelement.attribute(name)||||| = codestructure.name;
		
		if(mappedDesignmodelElementTargetValue.startsWith("modelelement.")) {
			mappedDesignmodelElementTargetValue = mappedDesignmodelElementTargetValue.split("modelelement.")[1];
		}
		if (mappedDesignmodelElementTargetValue.contentEquals("")) {
			throw new ParserException("Left hand side of an attribute-mapping cannot be empty");
		}
		
		switch (modelelementType) {
		case ATTRIBUTE:
			break;
		case CLASS:
			return new MappedDesignmodelClass(mappedDesignmodelElementTargetValue, mappedCodeElement);
			
		case REFERENCE:
			break;
		default:
			break;
		
		}
		
		MappedDesignmodelClass mdc = new MappedDesignmodelClass(mappedDesignmodelElementTargetValue, mappedCodeElement);

		return mdc;
	}
}
