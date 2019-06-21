package designmodel.generation;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import mapping.attribute_mapping.MappedDesignmodelElement;
import spoon.reflect.declaration.CtAnnotation;

public class AnnotationHasNameOfProcessor extends GenerationProcessor<CtAnnotation> {
	
	private String nameToMatch;
	
	public AnnotationHasNameOfProcessor(String nameToMatch, List<MappedDesignmodelElement> attributeMappings, EPackage metapackage) {
		super(attributeMappings, metapackage);
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
