package mappingdeclaration.condition;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import designmodel.generation.ImplementedInterfaceProcessor;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.ModifierKind;

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
	public void createProcessor(String targetName, List<MappedDesignmodelElement> attributeMappings, CodestructureType codestructureType, EPackage metapackage) {
		this.setProcessor(new ImplementedInterfaceProcessor(targetName, attributeMappings, codestructureType, metapackage));
	}

	@Override
	public CtNamedElement applyConditionToCreatedCodestructure(CtNamedElement newCodestructure, String targetNameInstance, Launcher launcher) {
		//first try and get the existing interface
		CtInterface<?> targetInterface = launcher.getFactory().Interface().get(targetNameInstance);
		//if the interface type does not exist yet, create it
		if(targetInterface == null) {
			targetInterface = launcher.getFactory().Interface().create(targetNameInstance);
			targetInterface.setVisibility(ModifierKind.PUBLIC);
		}
		((CtClass<?>) newCodestructure).addSuperInterface(targetInterface.getReference());
		return newCodestructure;
	}
}
