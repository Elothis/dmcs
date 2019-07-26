package mappingdeclaration;

/**
 * Holds the information the user declared in the instantiation-file (.mapping file per default).<br>
 * If the Integration Mechanism getting instantiated here is part of a holding parent element, e.g. a reference of a class like State.transition,
 * the parent model element gets saved in here as well. For other IMs without such parent elements, it just holds the model element itself and the parent element is null.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingInstantiation {
	private String instantiatedModelElement;
	private String instantiatedParentModelElement;
	private IntegrationMechanismDeclaration imd;
	
	public MappingInstantiation(String instantiatedModelElement, String instantiatedParentModelElement,
			IntegrationMechanismDeclaration imd) {
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
	public IntegrationMechanismDeclaration getImd() {
		return imd;
	}
	public void setImd(IntegrationMechanismDeclaration imd) {
		this.imd = imd;
	}
}
