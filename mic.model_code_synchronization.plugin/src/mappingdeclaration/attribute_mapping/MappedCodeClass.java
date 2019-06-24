package mappingdeclaration.attribute_mapping;

/**
 * Represents the mapping to a value of a class in the code.
 * TODO The concrete implementing classes should operate on their respective types in the spoon-metamodel,
 * e.g. MappedCodeAnnotation should work on a CtAnnotation and return the values that get mapped in the attribute-mapping part of the mapping file.<br>
 * E.g. for 'codestructure.parameter.type' for 'codestructure: annotation' the MappedCodeAnnotation should be able to return the parameter-type for a concrete mapped annotation.
 *
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeClass extends MappedCodeElement {

	public MappedCodeClass(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of a class in the code.";
	}

}
