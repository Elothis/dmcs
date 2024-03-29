package designmodel.generation;

import java.lang.annotation.Annotation;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import concrete_mapping.MappingEntry;
import mappingdeclaration.CodestructureType;
import mappingdeclaration.MappingInstantiation;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.attribute_mapping.MappingException;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtNamedElement;

public class AnnotatedWithProcessor extends ConditionProcessor<CtNamedElement> {
	private String annotationName;
	private boolean parentObjectExistent = false;
	private MappingInstantiation mappingInstantiation;
	
	public AnnotatedWithProcessor(MappingInstantiation mappingInstantiation, List<MappedDesignmodelElement> attributeMappings,
			CodestructureType codestructureType, EPackage metapackage, List<MappingEntry> mappings) {
		super(attributeMappings, codestructureType, metapackage, mappings);
		
		if(mappingInstantiation.getInstantiatedParentModelElement() != null) {
			String holdingClassName = mappingInstantiation.getInstantiatedParentModelElement();
			String referenceName =  mappingInstantiation.getInstantiatedModelElement();
			
			EClass holdingMetaClass = (EClass) metapackage.getEClassifier(holdingClassName);
			EReference classReference = (EReference) holdingMetaClass.getEStructuralFeature(referenceName);
			if(classReference == null) {
	        	classReference = (EReference) holdingMetaClass.getEStructuralFeature(StringUtils.uncapitalize(referenceName));
	        }
	        if(classReference == null) {
	        	throw new IllegalArgumentException(referenceName + " is no reference in the meta model!");
	        }
	        this.annotationName = classReference.getName();
		}
		else {
			this.annotationName = mappingInstantiation.getInstantiatedModelElement();
		}
		
		this.mappingInstantiation = mappingInstantiation;
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
		case METHOD:
			if(!(candidate instanceof CtMethod)) {				
				return false;
			}
			parentObjectExistent = true;
			break;
		default:
			break;
		
		}

		for(CtAnnotation<? extends Annotation> a: candidate.getAnnotations()) {
			if(a.toString().split("@")[1].split("\\(")[0].equalsIgnoreCase(annotationName)) {
				return true;
			}
			String[] split = annotationName.split("\\.");
			if(split.length > 1 && a.toString().split("@")[1].split("\\(")[0].equalsIgnoreCase(split[1])) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public void process(CtNamedElement element) {
		EObject generatedDesignmodelElement;
		MappingEntry mappingEntry;
		try {
			EObject parentObject = null;
			if(parentObjectExistent) {
				String parentClassName = ((CtMethod<?>) element).getDeclaringType().getSimpleName();
				for(MappingEntry e: this.getExistentMappings()) {
					//if there is a mapping entry containing the parent class of this codestructure, set it to later hand it into the createDesignmodelElement-call
					if(e.getCodeElement().getSimpleName().contentEquals(parentClassName)) {
						parentObject = e.getDesignmodelElementEObject();
					}
				}
			}
			
			generatedDesignmodelElement = this.getAttributeMappings().get(0).createDesignmodelElement(getMetapackage(), mappingInstantiation, element, parentObject);
			//add mapping entry from the created designmodel element to the code element
			mappingEntry = this.getAttributeMappings().get(0).createMappingEntry(generatedDesignmodelElement, element);
			this.getMappingEntries().add(mappingEntry);
			
			if(this.getAttributeMappings().size() > 1) {
				for(int i = 1; i < this.getAttributeMappings().size(); i++) {
					this.getAttributeMappings().get(i).addMappedAttribute(getMetapackage(), generatedDesignmodelElement, annotationName, element);
				}
			}
			this.addGeneratedDesignmodelElement(generatedDesignmodelElement);
		} catch (MappingException e) {
			e.printStackTrace();
		}		
		
		//System.out.println(element.getSimpleName() + " is annotated with " + annotationName + " and thus got processed with annotatedWithProcessor");
	}
}
