package mapping.condition;

import java.util.List;

import designmodel.generation.AnnotationHasNameOfProcessor;
import mapping.attribute_mapping.MappedDesignmodelElement;

public class AnnotationHasNameOfCondition extends Condition {

	public AnnotationHasNameOfCondition(String targetElement) {
		super(targetElement);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = HasNameOfCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}

	@Override
	public void createProcessor(String targetName, List<MappedDesignmodelElement> attributeMappings) {
		this.setProcessor(new AnnotationHasNameOfProcessor(targetName, attributeMappings));
		
	}
}
