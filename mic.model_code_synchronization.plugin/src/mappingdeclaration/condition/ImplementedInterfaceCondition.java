package mappingdeclaration.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import concrete_mapping.MappingEntry;
import designmodel.generation.ImplementedInterfaceProcessor;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.MappingInstantiation;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.filter.NamedElementFilter;

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
	public CtNamedElement applyConditionToCreatedCodestructure(CtNamedElement newCodestructure, String targetNameInstance, Launcher launcher) {	
		//first try and get the existing interface in the same package
		CtInterface<?> targetInterface = launcher.getFactory().Interface().get(targetNameInstance);
		//if the interface type does not exist there, search for an interface in the entire project
		if(targetInterface == null) {
			List<CtInterface> interfaceList = launcher.getModel().filterChildren(new NamedElementFilter<CtInterface>(CtInterface.class, targetNameInstance)).list();
			targetInterface = interfaceList.isEmpty() ? null : interfaceList.get(0); //simply get the first element, implicitly assuming there is only one interface of that name
			//if interface does not exist in entire project either, create it
			if(targetInterface == null) {
				
				MessageDialog createOrSpecifiyDialog = new MessageDialog(Display.getDefault().getActiveShell(),
						"Create Interface?",
						null,
					    "There is no interface of that name in your project. Do you want to specifiy its fully qualified name because it is part of an external dependency or create a new one?",
					    MessageDialog.QUESTION,
					    new String[] { "Create new interface", "Specify its fully qualified name"},
					    0);
					int result = createOrSpecifiyDialog.open();
				if(result == 0) { //create new annotation
					targetInterface = launcher.getFactory().Interface().create(targetNameInstance);
					targetInterface.setVisibility(ModifierKind.PUBLIC);
				}
				else { //ask user for fully qualified name
					String fullyQualifiedInterfaceName = "";
					InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell(),
							"Interface selection", "Please enter the fully qualified name of the interface here",
							"org.example.ISampleInterface", null);
					if(dialog.open() == Window.OK) {
						fullyQualifiedInterfaceName = dialog.getValue();
						targetInterface = launcher.getFactory().Interface().create(fullyQualifiedInterfaceName);
						targetInterface.setVisibility(ModifierKind.PUBLIC);

						//current workaround because when the user e.g. specifies "java.io.Serializabe" as interface, spoon creates a Serializable interface in a package java.io
						//this is because the spoon meta model currently does not involve dependencies so it cannot find the actual java.io interface
						//so a new interface in the package gets initially created and then deleted directly again, so the actual/original java.io annotation is used
						launcher.getFactory().Package().get(fullyQualifiedInterfaceName.split("\\.")[0]).delete();
					}
				}
			}			
		}
		((CtClass<?>) newCodestructure).addSuperInterface(targetInterface.getReference());
		return newCodestructure;
	}


	@Override
	public void createProcessor(MappingInstantiation mappingInstantiation, List<MappedDesignmodelElement> attributeMappings,
			CodestructureType codestructureType, EPackage metapackage, List<MappingEntry> mappings) {
		this.setProcessor(new ImplementedInterfaceProcessor(mappingInstantiation, attributeMappings, codestructureType, metapackage, mappings));
	}
}
