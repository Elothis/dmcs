package mappingdeclaration;

import java.util.ArrayList;
import java.util.List;

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
	private List<IntegrationMechanismDeclaration> imDeclarations;
	/**
	 * Holds information of which model element (saved as String) gets translated with which IM (including a possible parent element for cases like references)
	 */
	private List<MappingInstantiation> mappingInstantiations;
	
	public MappingDeclarationDatabase(List<IntegrationMechanismDeclaration> imDeclarations) {
		this.imDeclarations = imDeclarations;
		this.mappingInstantiations = new ArrayList<>();
	}

	public MappingDeclarationDatabase() {
		this.imDeclarations = new ArrayList<>();
	}
	
	public List<IntegrationMechanismDeclaration> getIntegrationMechanismDeclarations() {
		return this.imDeclarations;
	}
	
	/**
	 * Gets an IntegrationMechanismMappingDeclaration based on the specified name of the IM.
	 * @param name
	 * @return IntegrationMechanismDeclaration if found, NULL if no such IM exists
	 */
	public IntegrationMechanismDeclaration getIntegrationMechanismByName(String name) {
		for(IntegrationMechanismDeclaration imd: this.imDeclarations) {
			if(imd.getName().contentEquals(name)) return imd;
		}
		return null;
	}
	
	/**
	 * Gets an IntegrationMechanismMappingDeclaration based on the specified name of a model element it is applied to.
	 * @param elementName
	 * @return IntegrationMechanismDeclaration if found, NULL if no IM is applied to that model element
	 */
	public IntegrationMechanismDeclaration getIntegrationMechanismByElementAppliedTo(String elementName) {
		for (MappingInstantiation mi: this.mappingInstantiations) {
		    if(mi.getInstantiatedModelElement().equalsIgnoreCase(elementName)) {
		    	return mi.getImd();
		    }
//		    if(mi.getInstantiatedParentModelElement() != null && mi.getInstantiatedParentModelElement().equalsIgnoreCase(elementName)) {
//		    	return mi.getImd();
//		    }
		    
		}
		
		return null;
	}
	
	public boolean addIntegrationMechanismDeclaration(IntegrationMechanismDeclaration imDeclaration) {
		for (IntegrationMechanismDeclaration imd: this.imDeclarations) {
			if(imd.getName().contentEquals(imDeclaration.getName())) return false;
		}
			
		//check whether its a reference type IM that has to be applied later after all other IMs have been translated (since it needs existing model elements)
		if(imDeclaration.getModelelementType() == ModelelementType.CONTAINMENT) {
			return this.imDeclarations.add(imDeclaration);
		}
		this.imDeclarations.add(0, imDeclaration);
		return true;
	}
	
	public void setMappingInstantiations(List<MappingInstantiation> mappingInstantiations) {
		this.mappingInstantiations = mappingInstantiations;
	}

	/**
	 * Gets the information of which design model element (saved as String) gets translated with which integration mechanism.
	 * @return map of design model element-name (key) to IM (value)
	 */
	public List<MappingInstantiation> getMappingInstantiations() {
		return mappingInstantiations;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IM-Declarations:\n");
		this.imDeclarations.forEach(i -> {
			sb.append(i.toString());
		});
		sb.append("\n\nMapping instantiations:\n");
		this.mappingInstantiations.forEach(e -> {
			sb.append(e.getInstantiatedModelElement() + " -> ").append(e.getImd().getName()).append("\n");
		});
		return sb.toString();
	}
}
