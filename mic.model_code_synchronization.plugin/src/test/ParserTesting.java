package test;

import org.junit.jupiter.api.Test;

import parsing.MappingDeclarationParserImpl;

class ParserTesting {

	@Test
	void testParseMappingDirectory() {
		
		 StringBuilder sb = new StringBuilder();
         String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingDeclarationParserImpl parser = new MappingDeclarationParserImpl();
		System.out.println(parser.parseMappingDirectory(mappingDirectoryPath));
	}
}
