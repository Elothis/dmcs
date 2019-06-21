package designmodel.generation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import mapping.attribute_mapping.MappedDesignmodelElement;
import mapping.attribute_mapping.MappingException;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;


public class ImplementedInterfaceProcessor extends GenerationProcessor<CtClass> {
	public String markerInterface;

	public ImplementedInterfaceProcessor(String markerInterface, List<MappedDesignmodelElement> attributeMappings, EPackage metapackage) {
		super(attributeMappings, metapackage);
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
		this.getAttributeMappings().forEach(am -> {
			EObject generatedDesignmodelElement;
			try {
				generatedDesignmodelElement = am.createDesignmodelElement(getMetapackage(), markerInterface, element.getSimpleName());
				this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
			} catch (MappingException e) {
				e.printStackTrace();
			}			
			//TODO also save a mapping from this generated ecore element to the spoon-element (probably also in a field in GenerationProcessor)
			//then collect these mapping infos from ecore to spoon elements and build a mappingDatabase in MappingGenerator
		});
		
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
