package mapping.attribute_mapping;

import org.apache.commons.lang3.StringUtils;

import mapping.ModelelementType;

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
	 * @param mappedDesignmodelElement Left-hand-side String of the attribute-mapping assignment from the "mapping:"-element in the .im-file
	 * @param modelelementType ModelelementType it refers to
	 * @param mappedCodeElement The already parsed MappedCodeElement that gets assigned to the designmodel element
	 * @return concrete instance of the respective MappedDesignmodelElement
	 */
	public static MappedDesignmodelElement createMappedDesignmodelElement(String mappedDesignmodelElement, ModelelementType modelelementType, MappedCodeElement mappedCodeElement) {
		//TODO parse left hand side of mapping attribute assignment here
		// e.g. mapping: |||||modelelement.attribute(name)||||| = codestructure.name;
		MappedDesignmodelClassAttribute mdca = new MappedDesignmodelClassAttribute(mappedCodeElement);
		mdca.setAttributeName(StringUtils.substringBetween(mappedDesignmodelElement, "(", ")"));
		return mdca;
	}
}
