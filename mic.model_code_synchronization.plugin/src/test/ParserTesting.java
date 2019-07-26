package test;

import org.junit.jupiter.api.Test;

import parsing.MappingDeclarationParser;

class ParserTesting {

	@Test
	void testParseMappingDirectory() {
		
		 StringBuilder sb = new StringBuilder();
         String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParser parser = new MappingDeclarationParser();
		System.out.println(parser.parseMappingDirectory(mappingDirectoryPath));
	}
}
