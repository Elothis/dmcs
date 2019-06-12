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
	//TODO implement mapping from imDeclaration to concrete model structures
	
	public MappingDatabase(List<IntegrationMechanismMappingDeclaration> imDeclarations) {
		this.imDeclarations = imDeclarations;
	}

	public MappingDatabase() {
		this.imDeclarations = new ArrayList<>();
	}
	
	public List<IntegrationMechanismMappingDeclaration> getIntegrationMechanismDeclarations() {
		return this.imDeclarations;
	}

	public boolean addIntegrationMechanismDeclaration(IntegrationMechanismMappingDeclaration imDeclaration) {
		return this.imDeclarations.add(imDeclaration);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		this.imDeclarations.forEach(i -> {
			sb.append(i.toString());
		});
		return sb.toString();
	}

	
}
