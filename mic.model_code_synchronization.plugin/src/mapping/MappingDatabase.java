package mapping;

import java.util.ArrayList;
import java.util.List;

public class MappingDatabase {
	
	private List<IntegrationMechanismMappingDeclaration> imDeclarations;
	
	public MappingDatabase(List<IntegrationMechanismMappingDeclaration> imDeclarations) {
		this.imDeclarations = imDeclarations;
	}

	public MappingDatabase() {
		this.imDeclarations = new ArrayList<>();
	}

	public boolean addIntegrationMechanismDeclaration(IntegrationMechanismMappingDeclaration imDeclaration) {
		return this.imDeclarations.add(imDeclaration);
	}

}
