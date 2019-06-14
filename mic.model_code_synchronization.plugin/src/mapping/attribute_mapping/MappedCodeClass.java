package mapping.attribute_mapping;

public class MappedCodeClass extends MappedCodeElement {

	public MappedCodeClass(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Mapped to a class in the code with name '" + this.getName() + "'";
	}

}
