package designmodel.generation;

import java.lang.annotation.Annotation;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtNamedElement;

//TODO check spoon type hierarchy: which super interface can be used to get all elements that can be annotated with (methods, classes etc.)
public class AnnotatedWithProcessor extends AbstractProcessor<CtNamedElement> {
	private String annotationName;
	
	public AnnotatedWithProcessor(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean isToBeProcessed(CtNamedElement candidate) {

		for(CtAnnotation<? extends Annotation> a: candidate.getAnnotations()) {
			if(a.getActualAnnotation().toString().split("@")[1].contentEquals(annotationName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void process(CtNamedElement arg0) {
		System.out.println(arg0.getSimpleName() + " is annotated with " + annotationName + " and thus got processed with annotatedWithProcessor");
	}

}
