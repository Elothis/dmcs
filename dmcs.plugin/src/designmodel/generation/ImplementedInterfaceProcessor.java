package designmodel.generation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import concrete_mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.MappingInstantiation;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.attribute_mapping.MappingException;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;


public class ImplementedInterfaceProcessor extends ConditionProcessor<CtClass> {
	private String markerInterface;
	private MappingInstantiation mappingInstantiation;

	public ImplementedInterfaceProcessor(MappingInstantiation mappingInstantiation, List<MappedDesignmodelElement> attributeMappings,
			CodestructureType codestructureType, EPackage metapackage, List<MappingEntry> mappings) {
		super(attributeMappings, codestructureType, metapackage, mappings);
		this.markerInterface = mappingInstantiation.getInstantiatedModelElement();
		this.mappingInstantiation = mappingInstantiation;
	}

	@Override
	public boolean isToBeProcessed(CtClass candidate) {
		Set<CtTypeReference<?>> implementedInterfaces = candidate.getSuperInterfaces();
		for (CtTypeReference<?> i : implementedInterfaces) {
			if (i.getSimpleName().contentEquals(this.markerInterface)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void process(CtClass element) {
		EObject generatedDesignmodelElement;
		MappingEntry mappingEntry;
		try {
			//create design model element
			generatedDesignmodelElement = this.getAttributeMappings().get(0).createDesignmodelElement(getMetapackage(), mappingInstantiation, element, null);
			//add mapping entry from the created designmodel element to the code element
			mappingEntry = this.getAttributeMappings().get(0).createMappingEntry(generatedDesignmodelElement, element);
			this.getMappingEntries().add(mappingEntry);
			
			//TODO add mapping entries for multiple mapped values
			if(this.getAttributeMappings().size() > 1) {
				for(int i = 1; i < this.getAttributeMappings().size(); i++) {
					this.getAttributeMappings().get(i).addMappedAttribute(getMetapackage(), generatedDesignmodelElement, markerInterface, element);
				}
			}
			this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		//System.out.println(element.getSimpleName() + " implements " + markerInterface + " and thus got processed with ImplementedInterfaceProcessor");		
	}
	

}
