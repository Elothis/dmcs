package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import mappingdeclaration.MappingDeclarationParser;

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
		
		TransformationManager mappingGenerator = new TransformationManager("C:/Daten/MIC_Sync_Tool_Repo/TestProject", parser);
		mappingGenerator.buildDesignModel(DESIGNMODEL_TARGET_PATH);
		
//		TransformationManager tm = mappingGenerator.getTransformationManager();
//		tm.updateCode(Utility.loadExistingModel(DESIGNMODEL_TARGET_PATH));
	}
}
