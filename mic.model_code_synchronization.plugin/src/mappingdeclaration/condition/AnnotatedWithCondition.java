package mappingdeclaration.condition;

import java.util.List;

import org.apache.maven.shared.utils.StringUtils;
import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import designmodel.generation.AnnotatedWithProcessor;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.MappingInstantiation;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.Launcher;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtAnnotationType;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.filter.NamedElementFilter;

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
	public void createProcessor(MappingInstantiation mappingInstantiation, List<MappedDesignmodelElement>attributeMappings, CodestructureType codestructureType, EPackage metapackage,
			List<MappingEntry> mappings) {
		this.setProcessor(new AnnotatedWithProcessor(mappingInstantiation, attributeMappings, codestructureType, metapackage, mappings));
	}

	@Override
	public CtNamedElement applyConditionToCreatedCodestructure(CtNamedElement newCodestructure, String targetNameInstance, Launcher launcher) {
		targetNameInstance = StringUtils.capitalise(targetNameInstance);
		//first try and get the existing annotation in the same package
		CtAnnotationType<?> targetAnnotation = (CtAnnotationType<?>) launcher.getFactory().Annotation().get(targetNameInstance);
		//if the annotation type does not exist here, search in entire project
		if(targetAnnotation == null) {
			List<CtAnnotationType> annotationList = launcher.getModel().filterChildren(new NamedElementFilter<CtAnnotationType>(CtAnnotationType.class, targetNameInstance)).list();
			targetAnnotation = annotationList.get(0); //simply get the first element, implicitly assuming there is only one interface of that name
			//if annotation does not exist in entire project either, create it
			if(targetAnnotation == null) {
				targetAnnotation = launcher.getFactory().Annotation().create(targetNameInstance);
				targetAnnotation.setVisibility(ModifierKind.PUBLIC);
			}		
		}

		CtAnnotation<?> newAnnotation = launcher.getFactory().createAnnotation(targetAnnotation.getReference());
		newCodestructure.addAnnotation(newAnnotation);
		return newCodestructure;
	}
}
