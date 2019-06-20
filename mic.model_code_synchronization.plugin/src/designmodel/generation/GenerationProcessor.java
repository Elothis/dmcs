package designmodel.generation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import mapping.attribute_mapping.MappedDesignmodelElement;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;

public abstract class GenerationProcessor<E extends CtElement> extends AbstractProcessor<E> {
	private List<MappedDesignmodelElement> attributeMappings;
	private EPackage metapackage;
	private String myData;
	private EObject generatedDesignmodelElement;

	public GenerationProcessor(List<MappedDesignmodelElement> attributeMappings, EPackage metapackage) {
		super();
		this.attributeMappings = attributeMappings;
		this.metapackage = metapackage;
	}

	public EPackage getMetapackage() {
		return metapackage;
	}

	public void setMetapackage(EPackage metapackage) {
		this.metapackage = metapackage;
	}

	public String getMyData() {
		return myData;
	}

	public void setMyData(String myData) {
		this.myData = myData;
	}

	public EObject getGeneratedDesignmodelElement() {
		return generatedDesignmodelElement;
	}

	public void setGeneratedDesignmodelElement(EObject generatedDesignmodelElement) {
		this.generatedDesignmodelElement = generatedDesignmodelElement;
	}

	public List<MappedDesignmodelElement> getAttributeMappings() {
		return attributeMappings;
	}

	public void setAttributeMappings(List<MappedDesignmodelElement> attributeMappings) {
		this.attributeMappings = attributeMappings;
	}
}
