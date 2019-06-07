package mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Holding all necessary information regarding mappings as defined from user.
 * Generation of design model and transformations can be generated based on the information stored in here.
 * 
 * @author Fabian Glittenberg
 *
 */
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
