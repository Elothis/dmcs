package mappingdeclaration;

import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;

public interface IMappingDeclarationParser {
	public MappingDeclarationDatabase parseMappingDirectory();
	public EPackage parseEcorePathToMetapackage() throws IOException;
}
