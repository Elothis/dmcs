package mappingdeclaration;

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
	
	/**
	 * List holding all Integration Mechanism Declarations that got parsed from the .im-files
	 */
	private List<IntegrationMechanismMappingDeclaration> imDeclarations;
	/**
	 * Holds information of which model element (saved as String) gets translated with which IM
	 */
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
	
	/**
	 * Gets an IntegrationMechanismMappingDeclaration based on the specified name of a model element it is applied to.
	 * @param elementName
	 * @return IntegrationMechanismDeclaration if found, NULL if no IM is applied to that model element
	 */
	public IntegrationMechanismMappingDeclaration getIntegrationMechanismByElementAppliedTo(String elementName) {
		for (Map.Entry<String, IntegrationMechanismMappingDeclaration> entry : this.mappingInstantiations.entrySet()) {
		    if(entry.getKey().contentEquals(elementName))
		    	return entry.getValue();
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

	/**
	 * Gets the information of which design model element (saved as String) gets translated with which integration mechanism.
	 * @return map of design model element-name (key) to IM (value)
	 */
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
