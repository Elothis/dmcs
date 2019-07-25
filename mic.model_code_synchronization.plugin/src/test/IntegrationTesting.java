package test;

import java.io.IOException;
import java.util.Scanner;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import parsing.MappingDeclarationParser;
import util.Utility;

public class IntegrationTesting {
	
	public static final String DESIGNMODEL_TARGET_PATH = "C:/Users/Fabian/mappingDirectory/designmodel.xmi";
	public static final String PROJECT_PATH = "C:/Daten/MIC_Sync_Tool_Repo/TestProject";

	@Test
	void testMenuEntryClick() throws IOException {
		StringBuilder sb = new StringBuilder();
        String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParser parser = new MappingDeclarationParser(mappingDirectoryPath);
		
		TransformationManager tm = new TransformationManager(PROJECT_PATH, parser);
		tm.buildDesignModel(DESIGNMODEL_TARGET_PATH);
		
		XMIResource loadedModel = Utility.loadExistingModel(DESIGNMODEL_TARGET_PATH);
		System.out.println(loadedModel);

		Scanner s = new Scanner(System.in);
		System.out.println("Type smth to propagate changes from the model back to the code");
		s.next();
		tm.updateCode(DESIGNMODEL_TARGET_PATH);
		s.close();
	}
}
