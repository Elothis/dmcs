package test;

import org.junit.jupiter.api.Test;

import designmodel.generation.TransformationManager;
import mappingdeclaration.MappingDeclarationParser;

class ParserTesting {

	@Test
	void testParseMappingDirectory() {
		
		 StringBuilder sb = new StringBuilder();
         String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParser parser = new MappingDeclarationParser(mappingDirectoryPath);
		System.out.println(parser.parseMappingDirectory());
	}
}
