package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import designmodel.generation.MappingGenerator;
import mapping.TransformationManager;
import mappingdeclaration.MappingDeclarationParser;
import util.Utility;

public class IntegrationTesting {
	
	public static final String DESIGNMODEL_TARGET_PATH = "C:/Users/Fabian/mappingDirectory/designmodel.xmi";

	@Test
	void testMenuEntryClick() throws IOException {
		StringBuilder sb = new StringBuilder();
        String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParser parser = new MappingDeclarationParser(mappingDirectoryPath);
		
		MappingGenerator mappingGenerator = new MappingGenerator("C:/Daten/MIC_Sync_Tool_Repo/TestProject", parser);
		mappingGenerator.buildDesignModel(DESIGNMODEL_TARGET_PATH);
		
//		TransformationManager tm = mappingGenerator.getTransformationManager();
//		tm.updateCode(Utility.loadExistingModel(DESIGNMODEL_TARGET_PATH));
	}
}
