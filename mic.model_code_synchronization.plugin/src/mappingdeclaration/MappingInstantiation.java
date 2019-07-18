package mappingdeclaration;

public class MappingInstantiation {
	private String instantiatedModelElement;
	private String instantiatedParentModelElement;
	private IntegrationMechanismMappingDeclaration imd;
	
	public MappingInstantiation(String instantiatedModelElement, String instantiatedParentModelElement,
			IntegrationMechanismMappingDeclaration imd) {
		super();
		this.instantiatedModelElement = instantiatedModelElement;
		this.instantiatedParentModelElement = instantiatedParentModelElement;
		this.imd = imd;
	}
	public String getInstantiatedModelElement() {
		return instantiatedModelElement;
	}
	public void setInstantiatedModelElement(String instantiatedModelElement) {
		this.instantiatedModelElement = instantiatedModelElement;
	}
	public String getInstantiatedParentModelElement() {
		return instantiatedParentModelElement;
	}
	public void setInstantiatedParentModelElement(String instantiatedParentModelElement) {
		this.instantiatedParentModelElement = instantiatedParentModelElement;
	}
	public IntegrationMechanismMappingDeclaration getImd() {
		return imd;
	}
	public void setImd(IntegrationMechanismMappingDeclaration imd) {
		this.imd = imd;
	}
}
