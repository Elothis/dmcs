package mapping;

import java.util.ArrayList;
import java.util.List;

import mapping.attribute_mapping.MappedDesignmodelElement;
import mapping.condition.Condition;

/**
 * Class holding all data declared in one mapping file that declares an integration mechanism.
 * 
 * @author Fabian Glittenberg
 *
 */
public class IntegrationMechanismMappingDeclaration {
	private String name;
	private CodestructureType codestructure;
	private ModelelementType modelelementType;
	private Condition condition;
	private List<MappedDesignmodelElement> attributeMappings;
	
	public IntegrationMechanismMappingDeclaration(String name) {
		this.name = name;
		this.attributeMappings = new ArrayList<>();
	}

	public CodestructureType getCodestructure() {
		return codestructure;
	}

	public void setCodestructure(CodestructureType codestructure) {
		this.codestructure = codestructure;
	}

	public ModelelementType getModelelement() {
		return modelelementType;
	}

	public void setModelelement(ModelelementType modelelement) {
		this.modelelementType = modelelement;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<MappedDesignmodelElement> getAttributeMappings() {
		return this.attributeMappings;
	}

	public void setAttributeMappings(List<MappedDesignmodelElement> attributeMappings) {
		this.attributeMappings = attributeMappings;
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
		if(this.getAttributeMappings() != null)
			sb.append("\nMapping: ").append(getAttributeMappings().toString());
		sb.append("\n---------------------------------------------------\n");
		return sb.toString();
	}
	
}
