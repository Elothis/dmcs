package designmodel.generation;

import java.util.ArrayList;
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
	private List<EObject> generatedDesignmodelElements;

	public GenerationProcessor(List<MappedDesignmodelElement> attributeMappings, EPackage metapackage) {
		super();
		this.attributeMappings = attributeMappings;
		this.metapackage = metapackage;
		this.generatedDesignmodelElements = new ArrayList<>();
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

	public List<EObject> getGeneratedDesignmodelElements() {
		return generatedDesignmodelElements;
	}
	
	/**
	 * Adds an EObject to the list of generated design model elements the processor created during its process-method.
	 * @param generatedDesignmodelElement
	 * @return
	 */
	public boolean addGeneratedDesignmodelElement(EObject generatedDesignmodelElement) {
		return this.generatedDesignmodelElements.add(generatedDesignmodelElement);
	}

	public void setGeneratedDesignmodelElements(List<EObject> generatedDesignmodelElement) {
		this.generatedDesignmodelElements = generatedDesignmodelElement;
	}

	public List<MappedDesignmodelElement> getAttributeMappings() {
		return attributeMappings;
	}

	public void setAttributeMappings(List<MappedDesignmodelElement> attributeMappings) {
		this.attributeMappings = attributeMappings;
	}
}
