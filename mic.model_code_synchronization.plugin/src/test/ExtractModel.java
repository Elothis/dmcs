package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import parsing.MappingDeclarationParserImpl;

class ExtractModel {

	public static final String MAPPING_DIRECTORY_PATH = "C:/Users/Fabian/mappingDirectory";
	public static final String PROJECT_PATH = "C:/Daten/UNI/jack3/";

	@Test
	void extractModel() throws IOException {		
		MappingDeclarationParserImpl parser = new MappingDeclarationParserImpl();
		
		TransformationManager tm = new TransformationManager(MAPPING_DIRECTORY_PATH, PROJECT_PATH, parser);
		tm.buildDesignModel();
	}
}
