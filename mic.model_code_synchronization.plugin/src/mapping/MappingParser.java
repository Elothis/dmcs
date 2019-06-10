package mapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import util.Utility;

/**
 * Main parsing class that handles the parsing of the mapping files in a specified mapping directory.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingParser implements IMappingParser {
	
	/**
	 * File extension of the files containing the mapping description of an integration mechanism
	 */
	public static final String INTEGRATION_MECHANISM_MAPPING_DECLARATION_FILE_EXTENSION = "im";
	/**
	 * File extension of the file containing the instantiation of the integration mechanisms to concrete model elements
	 */
	public static final String MAPPING_INSTANTIATION_FILE_EXTENSION = "mapping";
	/**
	 * Keyword to parse for in the files defining the integration mechanisms that marks the beginning of the codestructure definition being mapped to.
	 */
	public static final String CODESTRUCTURE = "codestructure";
	/**
	 * Keyword to parse for in the files defining the integration mechanisms that marks the beginning of the modelelement definition being mapped to.
	 */
	public static final String MODELELEMENT = "modelelement";
	/**
	 * Keyword to parse for in the files defining the integration mechanisms that marks the beginning of the conditions for the integration mechanism to be applied.
	 */
	public static final String CONDITION = "condition";
	/**
	 * Keyword to parse for in the files defining the integration mechanisms that marks the beginning of the mappings between modelelement and codestructure.
	 */
	public static final String ATTRIBUTE_MAPPING = "mapping";
	
	private boolean codestructureParsed = false,
			modelelementParsed = false,
			conditionParsed = false,
			attributeMappingParsed = false;
	
	private String path;
	private MappingDatabase mappingDatabase;
	
	/**
	 * Constructor instantiating a MappingParser object operating on the specified path as the directory containing the required mapping files.
	 * @param path to the directory containing mapping files
	 */
	public MappingParser(String path) {
		this.path = path;
		this.mappingDatabase = new MappingDatabase();
	}
	
	public MappingDatabase parseMappingDirectory() {
		try {
			Utility.getAllFilesByExtension(this.path, INTEGRATION_MECHANISM_MAPPING_DECLARATION_FILE_EXTENSION).forEach(f -> {
				IntegrationMechanismMappingDeclaration imDeclaration;
				try {
					imDeclaration = parseIMFile(f);
					this.mappingDatabase.addIntegrationMechanismDeclaration(imDeclaration);
					System.out.println(f);
				} catch (ParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			Utility.getAllFilesByExtension(this.path, MAPPING_INSTANTIATION_FILE_EXTENSION).forEach(f -> {
				//TODO
				//create mapping from imMappingDeclaration to concrete model elements and store them in MappingDatabase
				//instantiate spoon-model with java-elements from mapping file
				//build ecore-design model for integration mechanisms and save mapping from spoon-java-elements to ecore-elements
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.mappingDatabase;
	}
	
	private IntegrationMechanismMappingDeclaration parseIMFile(File f) throws IOException, ParserException {
		String integrationMechanismName = f.getName().split("\\.")[0];
		IntegrationMechanismMappingDeclaration imMappingDeclaration = new IntegrationMechanismMappingDeclaration(integrationMechanismName);
		String content = new String(Files.readAllBytes(f.toPath()));
		
		//split by ';' delimiter to receive all the fields of the mapping (first-level keywords)
		String[] fields = content.split(";");
		if(fields.length < 3) throw new ParserException("Mapping file does not contain all necessary fields!");
		
		for(int i = 0; i < fields.length; i++) {
			fields[i] = fields[i].trim();
			String[] lineElements = fields[i].split(":");	//split line with ":" delimiter between keyword and content

			//dispatch they first-level keywords of mapping file
			switch(lineElements[0]) {
			case CODESTRUCTURE:
				if(codestructureParsed) {
					throw new ParserException("Codestructure already parsed! Cannot parse codestructure twice in same mapping file");
				}
				//dispatch the type of codestructure being declared in the mapping file
				String codestructureName = lineElements[1].trim();
				imMappingDeclaration.setCodestructure(Codestructure.getCodeStructureFor(codestructureName));
				this.codestructureParsed = true;
				break;
			case MODELELEMENT:
				if(modelelementParsed) {
					throw new ParserException("Modelelement already parsed! Cannot parse modelelement twice in same mapping file");
				}
				//dispatch the type of modelelement being declared in the mapping file
				String modelelementName = lineElements[1].trim();
				imMappingDeclaration.setModelelement(Modelelement.getModelelementFor(modelelementName));
				this.modelelementParsed = true;
				break;
			case CONDITION:
				if(conditionParsed) {
					throw new ParserException("Condition already parsed! Cannot parse condition twice in same mapping file");
				}
				//TODO
				//implement condition parsing in condition object
				//condition needs to hold keyword (probably via enum) like 'implements', 'annotated with', etc.
				//does it need to hold a keyword to what it applies to (like 'codestructure') or does it always apply to the codestructure? <- probably yes?!
				//target of what the 'implements', 'annotated with' etc. keyword applies to (e.g. Interface XYZ
				this.conditionParsed = true;
				break;
			case ATTRIBUTE_MAPPING:
				if(attributeMappingParsed) {
					throw new ParserException("Attribute mapping already parsed! Cannot parse mapping twice in same mapping file");
				}
				//TODO
				//
				this.attributeMappingParsed = true;
	
				break;
				default:
					throw new ParserException("Unknown keyword/element in mapping file");
			}
		}
		
		//reset flags to false after finishing parsing one .im-file
		this.attributeMappingParsed = false;
		this.codestructureParsed = false;
		this.modelelementParsed = false;
		this.conditionParsed = false;
		
		return imMappingDeclaration;
	}
	
}
