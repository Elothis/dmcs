package mappingdeclaration.condition;

import java.util.List;

import org.apache.maven.shared.utils.StringUtils;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

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
			targetAnnotation = annotationList.isEmpty() ? null : annotationList.get(0); //simply get the first element, implicitly assuming there is only one interface of that name
			//if annotation does not exist in entire project either, ask user if he wants to create it or specify fully qualified name if existent in dependency (e.g. javax.ejb.Stateless)
			if(targetAnnotation == null) {
				
				MessageDialog createOrSpecifiyDialog = new MessageDialog(Display.getDefault().getActiveShell(),
						"Create Annotation?",
						null,
					    "There is no annotation of that name in your project. Do you want to specifiy its fully qualified name because it is part of an external dependency or create a new one?",
					    MessageDialog.QUESTION,
					    new String[] { "Create new annotation", "Specify its fully qualified name"},
					    0);
					int result = createOrSpecifiyDialog.open();
				if(result == 0) { //create new annotation
					targetAnnotation = launcher.getFactory().Annotation().create(targetNameInstance);
					targetAnnotation.setVisibility(ModifierKind.PUBLIC);
				}
				else { //ask user for fully qualified name
					String fullyQualifiedAnnotation = "";
					InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell(),
							"Annotation selection", "Please enter the fully qualified name of the annotation here",
							"org.example.SampleAnnotation", null);
					if(dialog.open() == Window.OK) {
						fullyQualifiedAnnotation = dialog.getValue();
						targetAnnotation = launcher.getFactory().Annotation().create(fullyQualifiedAnnotation);
						targetAnnotation.setVisibility(ModifierKind.PUBLIC);

						//current workaround because when the user e.g. specifies "javax.ejb.Stateless" as annotation, spoon creates a Stateless-AnnotationType in a package javax.ejb
						//this is because the spoon meta model currently does not involve dependencies so it cannot find the actual javax.ejb annotation
						//so a new annotation type in the package gets initially created and then deleted directly again, so the actual/original javax.ejb annotation is used
						launcher.getFactory().Package().get(fullyQualifiedAnnotation.split("\\.")[0]).delete();
					}
				}
			}
		}

		CtAnnotation<?> newAnnotation = launcher.getFactory().createAnnotation(targetAnnotation.getReference());
		newCodestructure.addAnnotation(newAnnotation);
		return newCodestructure;
	}
}
