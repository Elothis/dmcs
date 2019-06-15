package mapping.attribute_mapping;

public class MappedDesignmodelReference extends MappedDesignmodelElement {
	
	//TODO maybe add fields for reference target (as MappedDesignmodelClass?)
	//maybe even for reference source?

	public MappedDesignmodelReference(String targetValue, MappedCodeElement mappedCodeElement) {
		super(targetValue, mappedCodeElement);
	}

}
