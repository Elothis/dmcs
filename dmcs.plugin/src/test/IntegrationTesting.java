package test;

import java.io.IOException;
import java.util.Scanner;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import parsing.MappingDeclarationParserImpl;
import util.Utility;

public class IntegrationTesting {
	
	public static final String MAPPING_DIRECTORY_PATH = "C:/Users/Fabian/mappingDirectory";
	public static final String PROJECT_PATH = "C:/Daten/MIC_Sync_Tool_Repo/TestProject";
	//public static final String PROJECT_PATH = "C:/Daten/UNI/jack3";

	@Test
	void testMenuEntryClick() throws IOException {		
		MappingDeclarationParserImpl parser = new MappingDeclarationParserImpl();
		
		TransformationManager tm = new TransformationManager(MAPPING_DIRECTORY_PATH, PROJECT_PATH, parser);
		tm.buildDesignModel();
		
		XMIResource loadedModel = Utility.loadExistingModel(MAPPING_DIRECTORY_PATH + "/designmodel.xmi");
		System.out.println(loadedModel);

		Scanner s = new Scanner(System.in);
		System.out.println("Type smth to propagate changes from the model back to the code");
		s.next();
		tm.updateCode();
		s.close();
	}
}
