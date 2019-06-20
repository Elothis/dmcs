package mapping.condition;

import java.util.List;

import designmodel.generation.ImplementedInterfaceProcessor;
import mapping.attribute_mapping.MappedDesignmodelElement;

/**
 * Condition reprenseting an "implements" relationship of codestructure mapped to.
 * E.g. "condition: implements InterfaceXYZ;"
 * 
 * @author Fabian Glittenberg
 *
 */
public class ImplementedInterfaceCondition extends Condition {

	public ImplementedInterfaceCondition(String targetElement) {
		super(targetElement);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = ImplementedInterfaceCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}

	@Override
	public void createProcessor(String targetName, List<MappedDesignmodelElement> attributeMappings) {
		this.setProcessor(new ImplementedInterfaceProcessor(targetName, attributeMappings));
	}
}
