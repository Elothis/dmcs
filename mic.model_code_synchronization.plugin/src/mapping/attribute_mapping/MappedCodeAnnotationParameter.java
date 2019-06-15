package mapping.attribute_mapping;

public class MappedCodeAnnotationParameter extends MappedCodeElement {
	//hold these not as Strings but as individual types?
	private String type;
	private String value;

	public MappedCodeAnnotationParameter() {
		super();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Type: " + type + ", value: " + value;
	}
}
