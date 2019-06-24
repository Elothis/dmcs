package mappingdeclaration.attribute_mapping;


/**
 * Abstract super class representing one attribute-mapping code element.
 * Belongs to one MappedDesignmodelElement and holds the targetValue of the concrete code element that gets assigned to the respective MappedDesignmodelElement.<p>
 * TODO The concrete implementing classes should operate on their respective types in the spoon-metamodel,
 * e.g. MappedCodeAnnotation should work on a CtAnnotation and return the values that get mapped in the attribute-mapping part of the mapping file.<br>
 * E.g. for 'codestructure.parameter.type' for 'codestructure: annotation' the MappedCodeAnnotation should be able to return the parameter-type for a concrete mapped annotation.
 * 
 * @author Fabian Glittenberg
 *
 */
public abstract class MappedCodeElement {
	/**
	 * Concrete value the modelelement gets assigned from the codestrucuture.
	 * E.g.: "name" from codestructure.name in a mapping statement like "mapping: modelelement.attribute(name) = codestructure.name"
	 */
	private String targetValue;
	
	//TODO maybe add 'private MappedCodeElement subElement' that is either NULL or not, depending on whether the targetValue is from directly this object or a subElement

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public MappedCodeElement(String targetValue) {
		this.targetValue = targetValue;
	}
}
