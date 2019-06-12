package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mapping.MappingParser;

class ParseTest {

	@Test
	void testParseMappingDirectory() {
		MappingParser parser = new MappingParser("C:/Daten/UNI/Masterarbeit_Tool/mappingDirectory");
		System.out.println(parser.parseMappingDirectory());
	}

}
