package test;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtNamedElement;

public class AnnotatedWithProcessor extends AbstractProcessor<CtNamedElement> {
	public String annotationName;
	

	@Override
	public boolean isToBeProcessed(CtNamedElement candidate) {
		if(candidate instanceof CtMethod) {
			return true;
		}
		return false;
	}

	@Override
	public void process(CtNamedElement element) {
		System.out.println(element.getSimpleName());
		System.out.println("as method in " + ((CtMethod<?>)element).getDeclaringType().getSimpleName());
		System.out.println("of type " + ((CtMethod<?>)element).getType());
	}
}
