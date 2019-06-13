package mapping.attribute_mapping;

public class MappedDesignmodelClassAttribute extends MappedDesignmodelElement {
		
	private String holdingClassName;
	private String attributeName;
	private String mappedValue;
	
	public MappedDesignmodelClassAttribute(MappedCodeElement mappedCodeElement) {
		super(mappedCodeElement);
		// TODO Auto-generated constructor stub
	}
	
	public String getHoldingClassName() {
		return holdingClassName;
	}
	public void setHoldingClassName(String holdingClassName) {
		this.holdingClassName = holdingClassName;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getMappedValue() {
		return mappedValue;
	}
	public void setMappedValue(String mappedValue) {
		this.mappedValue = mappedValue;
	}
	
}
