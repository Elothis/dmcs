package mappingdeclaration.attribute_mapping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import mappingdeclaration.MappingInstantiation;
import spoon.reflect.declaration.CtNamedElement;

/**
 * Abstract super class representing one attribute-mapping from designmodel element to code element.
 * Holding the mapped code element and the designmodel-element's targetValue the code element is mapped to, thus making this a complete mapping. 
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedDesignmodelElement {
	private MappedCodeElement mappedCodeElement;
	private String targetValue;
	
	public MappedCodeElement getMappedCodeElement() {
		return mappedCodeElement;
	}

	public void setMappedCodeElement(MappedCodeElement mappedCodeElement) {
		this.mappedCodeElement = mappedCodeElement;
	}

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public MappedDesignmodelElement(String targetValue, MappedCodeElement mappedCodeElement) {
		this.targetValue = targetValue;
		this.mappedCodeElement = mappedCodeElement;
	}
	
	/**
	 * Creates the design model element as part of the specified EPackage.<br>
	 * This is also where the targetValue of the MappedDesignmodelElement (e.g. 'attribute(name)') gets interpreted.
	 * 
	 * @param metapackage EPackage the model element gets created in (based on the specific meta model, containing factory etc.)
	 * @param mappingInstantiation the meta model element that shall get created (type depends on the specific implementing class)
	 * Note: if depended on other holding EObject (like reference from an EClass), mappingInstantiation contains parent element as well  "class.modelelementName")
	 * @param mappedCodeElement the code element getting mapped to the designmodel element being created
	 * @param parentObject EObject containing the design model element to be created, for example the parent class for a reference element (null if its just a simple element without parent)
	 * @return created EObject
	 * @throws MappingException 
	 */
	public abstract EObject createDesignmodelElement(EPackage metapackage, MappingInstantiation mappingInstantiation, CtNamedElement mappedCodeElement, EObject parentObject) throws MappingException;
	
	/**
	 * Adds an attribute to an already existing EObject. Necessary for when there are multiple attribute-mappings (separated via '&') in an .im-file.
	 * @param metapackage
	 * @param eClass
	 * @param metamodelElement
	 * @param mappedCodeElement
	 * @return
	 * @throws MappingException
	 */
	public abstract EObject addMappedAttribute(EPackage metapackage, EObject eClass, String metamodelElement, CtNamedElement mappedCodeElement) throws MappingException;

	/**
	 * Creates a mapping entry for TransformationManager to work on, holding all the information about what value from what designmodel element
	 * got mapped to what value of what code element.
	 * @param designmodelElement
	 * @param mappedCodeElement
	 * @return
	 */
	public abstract MappingEntry createMappingEntry(EObject designmodelElement, CtNamedElement mappedCodeElement);

	/**
	 * Updates the mapping entry after an existing design model element got changed by the user.
	 * (Also gets called when nothing got changed and then simply recreates the same object without changes.)
	 * @param entry
	 * @param updatedModelElement
	 * @return the updated MappingEntry
	 */
	public abstract MappingEntry updateMappingEntry(MappingEntry entry, EObject updatedModelElement);

	/**
	 * Deletes the codestructure mapped to the model element after the model element got deleted by the user.
	 * @param entry
	 * @param deletedMappedModelElement
	 * @return true on success
	 */
	public abstract boolean deleteCodestructure(MappingEntry entry, EObject deletedMappedModelElement);	
}
