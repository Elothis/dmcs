package mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holding all necessary information regarding mappings as defined from user.
 * Generation of design model and transformations can be generated based on the information stored in here.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingDeclarationDatabase {
	
	private List<IntegrationMechanismMappingDeclaration> imDeclarations;
	private Map<String, IntegrationMechanismMappingDeclaration> mappingInstantiations;
	
	public MappingDeclarationDatabase(List<IntegrationMechanismMappingDeclaration> imDeclarations) {
		this.imDeclarations = imDeclarations;
	}

	public MappingDeclarationDatabase() {
		this.imDeclarations = new ArrayList<>();
	}
	
	public List<IntegrationMechanismMappingDeclaration> getIntegrationMechanismDeclarations() {
		return this.imDeclarations;
	}
	
	/**
	 * Gets an IntegrationMechanismMappingDeclaration based on the specified name of the IM.
	 * @param name
	 * @return IntegrationMechanismDeclaration if found, NULL if no such IM exists
	 */
	public IntegrationMechanismMappingDeclaration getIntegrationMechanismByName(String name) {
		for(IntegrationMechanismMappingDeclaration imd: this.imDeclarations) {
			if(imd.getName().contentEquals(name)) return imd;
		}
		return null;
	}

	public boolean addIntegrationMechanismDeclaration(IntegrationMechanismMappingDeclaration imDeclaration) {
		for (IntegrationMechanismMappingDeclaration imd: this.imDeclarations) {
			if(imd.getName().contentEquals(imDeclaration.getName())) return false;
		}
			
		return this.imDeclarations.add(imDeclaration);
	}
	
	public void setMappingInstantiations(Map<String, IntegrationMechanismMappingDeclaration> mappingInstantiations) {
		this.mappingInstantiations = mappingInstantiations;
	}

	public Map<String, IntegrationMechanismMappingDeclaration> getMappingInstantiations() {
		return mappingInstantiations;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IM-Declarations:\n");
		this.imDeclarations.forEach(i -> {
			sb.append(i.toString());
		});
		sb.append("\n\nMapping instantiations:\n");
		this.mappingInstantiations.forEach((modelElementName, imDeclaration) -> {
			sb.append(modelElementName + " -> ").append(imDeclaration.getName()).append("\n");
		});
		return sb.toString();
	}
}
