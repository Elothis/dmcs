package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import parsing.MappingDeclarationParserImpl;

class ExtractModel {

	public static final String MAPPING_DIRECTORY_PATH = "C:/Users/Fabian/mappingDirectory";
	public static final String PROJECT_PATH = "C:/Daten/UNI/jack3/";
	//public static final String PROJECT_PATH = "C:/Daten/MIC_Sync_Tool_Repo/TestProject";
	//public static final String PROJECT_PATH = "F:/code_generation";

	@Test
	void extractModel() throws IOException {
		long pre = System.currentTimeMillis();
		MappingDeclarationParserImpl parser = new MappingDeclarationParserImpl();
		
		TransformationManager tm = new TransformationManager(MAPPING_DIRECTORY_PATH, PROJECT_PATH, parser);
		tm.buildDesignModel();
		System.out.println("overall time : " + (System.currentTimeMillis() - pre));
	}
}
