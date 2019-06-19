package designmodel.generation;

import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;


public class ImplementedInterfaceProcessor extends AbstractProcessor<CtClass> {
	private String markerInterface;

	public ImplementedInterfaceProcessor(String markerInterface) {
		super();
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
		String initialName = element.getSimpleName();
		//System.out.println("Initial name: " + initialName);
		//TODO create Ecore-Model here and save mapping from this CtClass to the created Ecore element
		
		System.out.println(element.getSimpleName() + " processed as marker interface");
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
