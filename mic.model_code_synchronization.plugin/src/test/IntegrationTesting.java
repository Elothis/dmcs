package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import designmodel.generation.MappingGenerator;
import mappingdeclaration.MappingDeclarationParser;

public class IntegrationTesting {

	@Test
	void testMenuEntryClick() throws IOException {
		StringBuilder sb = new StringBuilder();
        String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParser parser = new MappingDeclarationParser(mappingDirectoryPath);
		
		MappingGenerator mappingGenerator = new MappingGenerator("C:/Daten/MIC_Sync_Tool_Repo/TestProject", parser);
		mappingGenerator.buildDesignModel();
	}
}
