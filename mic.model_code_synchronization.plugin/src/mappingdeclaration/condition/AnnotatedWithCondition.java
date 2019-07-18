package mappingdeclaration.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import designmodel.generation.AnnotatedWithProcessor;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.Launcher;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtAnnotationType;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.ModifierKind;

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
	public void createProcessor(String targetName, List<MappedDesignmodelElement>attributeMappings, CodestructureType codestructureType, EPackage metapackage,
			List<MappingEntry> mappings) {
		this.setProcessor(new AnnotatedWithProcessor(targetName, attributeMappings, codestructureType, metapackage, mappings));
	}

	@Override
	public CtNamedElement applyConditionToCreatedCodestructure(CtNamedElement newCodestructure, String targetNameInstance, Launcher launcher) {
		//first try and get an existing annotation
		CtAnnotationType<?> targetAnnotation = (CtAnnotationType<?>) launcher.getFactory().Annotation().get(targetNameInstance);
		//if the annotation type does not exist yet, create it
		if(targetAnnotation == null) {
			targetAnnotation = launcher.getFactory().Annotation().create(targetNameInstance);
			targetAnnotation.setVisibility(ModifierKind.PUBLIC);
		}

		CtAnnotation<?> newAnnotation = launcher.getFactory().createAnnotation(targetAnnotation.getReference());
		newCodestructure.addAnnotation(newAnnotation);
		return newCodestructure;
	}
}
