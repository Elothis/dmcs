package mapping.attribute_mapping;

public abstract class MappedCodeElement {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MappedCodeElement(String name) {
		super();
		this.name = name;
	}
}
