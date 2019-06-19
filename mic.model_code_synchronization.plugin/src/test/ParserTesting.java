package test;

import org.junit.jupiter.api.Test;

import designmodel.generation.MappingGenerator;
import mapping.MappingParser;

class ParserTesting {

	@Test
	void testParseMappingDirectory() {
		
		 StringBuilder sb = new StringBuilder();
         String mappingDirectoryPath;
			sb.append(System.getProperty("user.home").replace('\\', '/'))
			.append('/').append("mappingDirectory");
		mappingDirectoryPath = sb.toString();
		
		MappingParser parser = new MappingParser(mappingDirectoryPath);
		System.out.println(parser.parseMappingDirectory());
	}
}
