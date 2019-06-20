package designmodel.generation;

import java.util.List;
import java.util.Set;

import mapping.attribute_mapping.MappedDesignmodelElement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;


public class ImplementedInterfaceProcessor extends GenerationProcessor<CtClass> {
	public String markerInterface;

	public ImplementedInterfaceProcessor(String markerInterface, List<MappedDesignmodelElement> attributeMappings) {
		super(attributeMappings);
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
		//TODO create Ecore-Model here and save mapping from this CtClass to the created Ecore element
		this.setMyData("BLUBBERINO");
		
		System.out.println(element.getSimpleName() + " implements " + markerInterface + " and thus got processed with ImplementedInterfaceProcessor");
//		if (initialName.equals("AnotherOne")) {
//			element.setSimpleName("ChangedClassName");
//			System.out.println("Changed name: " + element.getSimpleName());
//		}
		//DesignmodelFactory.eINSTANCE.createState();
		
		/*
		Factory factory = element.getFactory();
		CtAnnotationType newAnnotationType = (CtAnnotationType) factory.Type().get(Generated.class);
		CtAnnotation newAnnotation = factory.createAnnotation(newAnnotationType.getReference());
		element.addAnnotation(newAnnotation);
		*/
		
	}
	

}
