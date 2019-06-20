package designmodel.generation;

import java.util.List;

import mapping.attribute_mapping.MappedDesignmodelElement;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;

public abstract class GenerationProcessor<E extends CtElement> extends AbstractProcessor<E> {
	private List<MappedDesignmodelElement> attributeMappings;
	private String myData;

	public GenerationProcessor(List<MappedDesignmodelElement> attributeMappings) {
		super();
		this.attributeMappings = attributeMappings;
	}

	public String getMyData() {
		return myData;
	}

	public void setMyData(String myData) {
		this.myData = myData;
	}

	public List<MappedDesignmodelElement> getAttributeMappings() {
		return attributeMappings;
	}

	public void setAttributeMappings(List<MappedDesignmodelElement> attributeMappings) {
		this.attributeMappings = attributeMappings;
	}
}
