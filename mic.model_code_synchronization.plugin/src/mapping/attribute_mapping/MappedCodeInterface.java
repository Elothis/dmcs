package mapping.attribute_mapping;

/**
 * Representing the mapping to the value of an inteface in the code.
 *
 * TODO The concrete implementing classes should operate on their respective types in the spoon-metamodel,
 * e.g. MappedCodeAnnotation should work on a CtAnnotation and return the values that get mapped in the attribute-mapping part of the mapping file.<br>
 * E.g. for 'codestructure.parameter.type' for 'codestructure: annotation' the MappedCodeAnnotation should be able to return the parameter-type for a concrete mapped annotation.
 *
 * @author Fabian Glittenberg
 *
 */
public class MappedCodeInterface extends MappedCodeElement {

	public MappedCodeInterface(String targetValue) {
		super(targetValue);
	}

	@Override
	public String toString() {
		return "Mapped to the '" + this.getTargetValue() + "' of an interface in the code.";
	}
}
