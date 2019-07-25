package mappingdeclaration;

import org.eclipse.emf.ecore.EPackage;

public interface IMappingDeclarationParser {
	/**
	 * Parses the mapping directory associated with this MappingParser and stores the defined Integration Mechanisms
	 * and the instantiation of these Integration Mechanisms applied to concrete model elements in a MappingDeclarationDatabase.
	 * @return MappingDatabase containing all parsed information
	 */
	public MappingDeclarationDatabase parseMappingDirectory();
	
	/**
	 * Parses the config file containing the path to the underlying Ecore meta model and returns its EPackage.
	 * @return EPackage of the Ecore meta model
	 */
	public EPackage parseConfigFileToMetaPackage();
}
