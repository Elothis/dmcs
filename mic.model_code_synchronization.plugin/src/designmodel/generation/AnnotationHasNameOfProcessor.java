package designmodel.generation;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;


//TODO generics type named element best fit here?
public class AnnotationHasNameOfProcessor extends AbstractProcessor<CtAnnotation> {
	
	private String nameToMatch;
	
	public AnnotationHasNameOfProcessor(String nameToMatch) {
		super();
		this.nameToMatch = nameToMatch;
	}

	@Override
	public boolean isToBeProcessed(CtAnnotation candidate) {
		return candidate.toString().split("@")[1].split("\\(")[0].contentEquals(nameToMatch);
	}

	@Override
	public void process(CtAnnotation arg0) {
		System.out.println(nameToMatch + " processed as attribute annotation");
	}

}
