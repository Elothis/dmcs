package test;

import org.junit.jupiter.api.Test;

import mapping.MappingParser;

class ParseTest {

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
