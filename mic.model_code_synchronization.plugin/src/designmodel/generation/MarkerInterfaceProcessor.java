package designmodel.generation;

import java.util.Set;

import mic.model_code_synchronization.designmodel.DesignmodelFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtAbstractVisitor;


public class MarkerInterfaceProcessor extends AbstractProcessor<CtClass> {
	private String markerInterface;
	
	public MarkerInterfaceProcessor(String markerInterface) {
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
		System.out.println("Initial name: " + initialName);
		//TODO create Ecore-Model here and save mapping from this CtClass to the created Ecore element
		if (initialName.equals("AnotherOne")) {
			element.setSimpleName("ChangedClassName");
			System.out.println("Changed name: " + element.getSimpleName());
		}
		//DesignmodelFactory.eINSTANCE.createState();
		
		/*
		Factory factory = element.getFactory();
		CtAnnotationType newAnnotationType = (CtAnnotationType) factory.Type().get(Generated.class);
		CtAnnotation newAnnotation = factory.createAnnotation(newAnnotationType.getReference());
		element.addAnnotation(newAnnotation);
		*/
		
	}
	

}
