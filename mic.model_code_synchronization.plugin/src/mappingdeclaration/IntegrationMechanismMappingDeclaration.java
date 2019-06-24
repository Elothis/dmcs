package mappingdeclaration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.condition.Condition;

/**
 * Class holding all data declared in one mapping file that declares an integration mechanism.
 * 
 * @author Fabian Glittenberg
 *
 */
public class IntegrationMechanismMappingDeclaration {
	private String name;
	private CodestructureType codestructureType;
	private ModelelementType modelelementType;
	private Condition condition;
	private List<MappedDesignmodelElement> attributeMappings;
	
	public IntegrationMechanismMappingDeclaration(String name) {
		this.name = name;
		this.attributeMappings = new ArrayList<>();
	}

	public CodestructureType getCodestructureType() {
		return codestructureType;
	}

	public void setCodestructure(CodestructureType codestructureType) {
		this.codestructureType = codestructureType;
	}

	public ModelelementType getModelelementType() {
		return modelelementType;
	}

	public void setModelelementType(ModelelementType modelelementType) {
		this.modelelementType = modelelementType;
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
		if(this.getCodestructureType() != null)
			sb.append("\nCodestructure: ").append(getCodestructureType().toString());
		if(this.getModelelementType() != null)
			sb.append("\nModelelement: ").append(getModelelementType().toString());
		if(this.getCondition() != null)
			sb.append("\nCondition: ").append(getCondition().toString());
		if(this.getAttributeMappings() != null) {
			sb.append("\nMapping: ");
			Iterator<MappedDesignmodelElement> it = getAttributeMappings().iterator();
			while(it.hasNext()) {
				sb.append(it.next());
				if(it.hasNext()) sb.append(" &\n\t");
			}
		}	
		sb.append("\n---------------------------------------------------\n");
		return sb.toString();
	}
	
}
