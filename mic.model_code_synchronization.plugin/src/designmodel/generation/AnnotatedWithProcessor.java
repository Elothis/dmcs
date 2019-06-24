package designmodel.generation;

import java.lang.annotation.Annotation;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import mappingdeclaration.CodestructureType;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.attribute_mapping.MappingException;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtNamedElement;

public class AnnotatedWithProcessor extends GenerationProcessor<CtNamedElement> {
	private String annotationName;
	
	public AnnotatedWithProcessor(String annotationName, List<MappedDesignmodelElement> attributeMappings, CodestructureType codestructureType, EPackage metapackage) {
		super(attributeMappings, codestructureType, metapackage);
		this.annotationName = annotationName;
	}

	@Override
	public boolean isToBeProcessed(CtNamedElement candidate) {
		//first check whether the candidate getting visited here is of the type defined in the mapping-file
		switch(this.getCodestructureType()) {
		case CLASS:
			if(!(candidate instanceof CtClass)) {
				return false;
			}
			break;
		case INTERFACE:
			if(!(candidate instanceof CtInterface)) {
				return false;
			}
			break;
		default:
			break;
		
		}

		for(CtAnnotation<? extends Annotation> a: candidate.getAnnotations()) {
			if(a.toString().split("@")[1].split("\\(")[0].contentEquals(annotationName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void process(CtNamedElement element) {
		EObject generatedDesignmodelElement;
		try {
			generatedDesignmodelElement = this.getAttributeMappings().get(0).createDesignmodelElement(getMetapackage(), annotationName, element);
			
			if(this.getAttributeMappings().size() > 1) {
				for(int i = 1; i < this.getAttributeMappings().size(); i++) {
					this.getAttributeMappings().get(i).addMappedAttribute(getMetapackage(), generatedDesignmodelElement, annotationName, element);
				}
			}
			this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
		} catch (MappingException e) {
			e.printStackTrace();
		}		
		
		
		/*this.getAttributeMappings().forEach(am -> {
			EObject generatedDesignmodelElement;
			try {
				generatedDesignmodelElement = am.createDesignmodelElement(getMetapackage(), annotationName, element.getSimpleName());
				this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
			} catch (MappingException e) {
				e.printStackTrace();
			}			
			//TODO also save a mapping from this generated ecore element to the spoon-element (probably also in a field in GenerationProcessor)
			//then collect these mapping infos from ecore to spoon elements and build a mappingDatabase in MappingGenerator
		});*/
		System.out.println(element.getSimpleName() + " is annotated with " + annotationName + " and thus got processed with annotatedWithProcessor");
	}
}
