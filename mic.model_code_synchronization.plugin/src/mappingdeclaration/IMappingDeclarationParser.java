package mappingdeclaration;

import org.eclipse.emf.ecore.EPackage;

public interface IMappingDeclarationParser {
	public MappingDeclarationDatabase parseMappingDirectory();
	public EPackage parseConfigFileToMetaPackage();
}
