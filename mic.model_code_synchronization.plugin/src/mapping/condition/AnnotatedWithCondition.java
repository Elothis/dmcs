package mapping.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import designmodel.generation.AnnotatedWithProcessor;
import mapping.attribute_mapping.MappedDesignmodelElement;

/**
 * Condition representing an "annotated with" relationship for the codestructure mapped to.
 * E.g. "condition: annotatedWith MyComponent;"
 * 
 * @author Fabian Glittenberg
 *
 */
public class AnnotatedWithCondition extends Condition {

	public AnnotatedWithCondition(String targetElement) {
		super(targetElement);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type = AnnotatedWithCondition | targetElement = ")
			.append(this.getTargetElement());
		return sb.toString();
	}

	@Override
	public void createProcessor(String targetName, List<MappedDesignmodelElement>attributeMappings, EPackage metapackage) {
		this.setProcessor(new AnnotatedWithProcessor(targetName, attributeMappings, metapackage));
	}
}
