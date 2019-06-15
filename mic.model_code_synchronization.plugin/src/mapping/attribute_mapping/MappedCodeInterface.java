package mapping.attribute_mapping;

public class MappedCodeInterface extends MappedCodeElement {

	public MappedCodeInterface() {
		super();
	}

	@Override
	public String toString() {
		return "Mapped to an interface in the code with name '" + this.getName() + "'";
	}
}
