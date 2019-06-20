package test;

import org.junit.jupiter.api.Test;

import designmodel.generation.MappingGenerator;
import mapping.MappingParser;

public class IntegrationTesting {

	@Test
	void testMenuEntryClick() {
		StringBuilder sb = new StringBuilder();
        String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingParser parser = new MappingParser(mappingDirectoryPath);
		
		MappingGenerator mappingGenerator = new MappingGenerator("C:/Daten/MIC_Sync_Tool_Repo/TestProject", parser);
		mappingGenerator.buildDesignModel();
	}
}
