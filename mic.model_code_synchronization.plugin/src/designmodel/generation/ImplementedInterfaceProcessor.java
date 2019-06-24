package designmodel.generation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.attribute_mapping.MappingException;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;


public class ImplementedInterfaceProcessor extends GenerationProcessor<CtClass> {
	public String markerInterface;

	public ImplementedInterfaceProcessor(String markerInterface, List<MappedDesignmodelElement> attributeMappings, CodestructureType codestructureType, EPackage metapackage) {
		super(attributeMappings, codestructureType, metapackage);
		this.markerInterface = markerInterface;
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
		//TODO save mapping from spoon-element to created designmodelelement
		//-> how to save? which attribute of model gets mapped to what value of codestructure?
		EObject generatedDesignmodelElement;
		MappingEntry mappingEntry;
		try {
			generatedDesignmodelElement = this.getAttributeMappings().get(0).createDesignmodelElement(getMetapackage(), markerInterface, element);
			mappingEntry = this.getAttributeMappings().get(0).createMappingEntry(generatedDesignmodelElement, element);
			this.getMappingEntries().add(mappingEntry);
			
			//TODO add mapping entry for multiple mapped values
			if(this.getAttributeMappings().size() > 1) {
				for(int i = 1; i < this.getAttributeMappings().size(); i++) {
					this.getAttributeMappings().get(i).addMappedAttribute(getMetapackage(), generatedDesignmodelElement, markerInterface, element);
				}
			}
			this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		System.out.println(element.getSimpleName() + " implements " + markerInterface + " and thus got processed with ImplementedInterfaceProcessor");
		
		/*
		Factory factory = element.getFactory();
		CtAnnotationType newAnnotationType = (CtAnnotationType) factory.Type().get(Generated.class);
		CtAnnotation newAnnotation = factory.createAnnotation(newAnnotationType.getReference());
		element.addAnnotation(newAnnotation);
		*/
		
	}
	

}
