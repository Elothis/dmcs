package mapping;

/**
 * Class holding all data declared in one mapping file that declares an integration mechanism.
 * 
 * @author Fabian Glittenberg
 *
 */
public class IntegrationMechanismMappingDeclaration {
	private String name;
	private Codestructure codestructure;
	private Modelelement modelelement;
	private Condition condition;
	private AttributeMapping attributeMapping;
	
	public IntegrationMechanismMappingDeclaration(String name) {
		this.name = name;
	}

	public Codestructure getCodestructure() {
		return codestructure;
	}

	public void setCodestructure(Codestructure codestructure) {
		this.codestructure = codestructure;
	}

	public Modelelement getModelelement() {
		return modelelement;
	}

	public void setModelelement(Modelelement modelelement) {
		this.modelelement = modelelement;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public AttributeMapping getAttributeMapping() {
		return attributeMapping;
	}

	public void setAttributeMapping(AttributeMapping attributeMapping) {
		this.attributeMapping = attributeMapping;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(this.name);
		if(this.getCodestructure() != null)
			sb.append("\nCodestructure: ").append(getCodestructure().toString());
		if(this.getModelelement() != null)
			sb.append("\nModelelement: ").append(getModelelement().toString());
		if(this.getCondition() != null)
			sb.append("\nCondition: ").append(getCondition().toString());
		if(this.getAttributeMapping() != null)
			sb.append("\nMapping: ").append(getAttributeMapping().toString());
		sb.append("\n---------------------------------------------------");
		return sb.toString();
	}
	
}
