package mapping.condition;

import designmodel.generation.ImplementedInterfaceProcessor;

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
		this.setProcessor(new ImplementedInterfaceProcessor("State"));
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = ImplementedInterfaceCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}
	
	
}
