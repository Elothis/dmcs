package parsing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import mappingdeclaration.CodestructureType;
import mappingdeclaration.IntegrationMechanismMappingDeclaration;
import mappingdeclaration.MappingDeclarationDatabase;
import mappingdeclaration.MappingInstantiation;
import mappingdeclaration.ModelelementType;
import mappingdeclaration.ParserException;
import mappingdeclaration.attribute_mapping.MappedCodeElement;
import mappingdeclaration.attribute_mapping.MappedCodeElementFactory;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElement;
import mappingdeclaration.attribute_mapping.MappedDesignmodelElementFactory;
import mappingdeclaration.condition.Condition;
import mappingdeclaration.condition.ConditionFactory;
import mappingdeclaration.condition.ConditionKeyword;
import util.Utility;

/**
 * Main parsing class that handles the parsing of the mapping files in a specified mapping directory.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingDeclarationParserImpl implements IMappingDeclarationParser {
	
	/**
	 * File extension of the files containing the mapping description of an integration mechanism
	 */
	public static final String INTEGRATION_MECHANISM_MAPPING_DECLARATION_FILE_EXTENSION = "im";
	/**
	 * File extension of the file containing the instantiation of the integration mechanisms to concrete model elements
	 */
	public static final String MAPPING_INSTANTIATION_FILE_EXTENSION = "inst";
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

	private MappingDeclarationDatabase mappingDeclarationDatabase;
	
	/**
	 * Constructor instantiating a MappingParser object operating on the specified path as the directory containing the required mapping files.
	 * @param path to the directory containing mapping files
	 */
	public MappingDeclarationParserImpl() {
		this.mappingDeclarationDatabase = new MappingDeclarationDatabase();
	}
	
	@Override
	public MappingDeclarationDatabase parseMappingDirectory(String directoryPath) {
		try {
			//parse in the files defining integration mechanisms
			Utility.getAllFilesByExtension(directoryPath, INTEGRATION_MECHANISM_MAPPING_DECLARATION_FILE_EXTENSION).forEach(f -> {
				try {
					IntegrationMechanismMappingDeclaration imDeclaration = this.parseIMFile(f);
					this.mappingDeclarationDatabase.addIntegrationMechanismDeclaration(imDeclaration);
				} catch (ParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			//parse in the mapping instantiation file that applies the IMs to concrete model elements
			List<File> l = Utility.getAllFilesByExtension(directoryPath, MAPPING_INSTANTIATION_FILE_EXTENSION);
			if(l.size() != 1) {
				throw new ParserException("Please provide exactly one mapping instantiation file!");
			}
			List<MappingInstantiation> mappingInstantiations = this.parseMappingInstantiationFile(l.get(0));
			this.mappingDeclarationDatabase.setMappingInstantiations(mappingInstantiations);		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return this.mappingDeclarationDatabase;
	}
	
	/**
	 * Parses an integration mechanism file into a respective data object containing all information defined in the .im-file with the following outline:<br>
	 * codestructure: class;<br>
	 * modelelement: class;<br>
	 * condition: implements modelelement.name;<br>
	 * mapping: modelelement.attribute(name) = codestructure.name;
	 * @param f file containing definition of one integration mechanism
	 * @return IntegrationMechanismMappingDeclaration containing all data
	 * @throws IOException
	 * @throws ParserException
	 */
	private IntegrationMechanismMappingDeclaration parseIMFile(File f) throws IOException, ParserException {
		String integrationMechanismName = f.getName().split("\\.")[0];
		IntegrationMechanismMappingDeclaration imMappingDeclaration = new IntegrationMechanismMappingDeclaration(integrationMechanismName);
		String content = new String(Files.readAllBytes(f.toPath()));
		
		//split by ';' delimiter to receive all the fields of the mapping (first-level keywords)
		String[] fields = content.split(";");
		if(fields.length < 3) throw new ParserException("Mapping file does not contain all necessary fields!");
		
		//set flags to false
		this.attributeMappingParsed = false;
		this.codestructureParsed = false;
		this.modelelementParsed = false;
		this.conditionParsed = false;
		
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
				if(lineElements.length < 2 ) {
					throw new ParserException("Please provide a codestructure");
				}
				String codestructureName = lineElements[1].trim();
				if(codestructureName.contentEquals("")) {
					throw new ParserException("Please provide a codestructure");
				}
				imMappingDeclaration.setCodestructure(CodestructureType.getCodeStructureTypeFor(codestructureName));
				this.codestructureParsed = true;
				break;
			case MODELELEMENT:
				if(modelelementParsed) {
					throw new ParserException("Modelelement already parsed! Cannot parse modelelement twice in same mapping file");
				}
				//dispatch the type of modelelement being declared in the mapping file
				if(lineElements.length < 2 ) {
					throw new ParserException("Please provide a modelelement");
				}
				String modelelementName = lineElements[1].trim();
				if(modelelementName.contentEquals("")) {
					throw new ParserException("Please provide a modelelement");
				}
				imMappingDeclaration.setModelelementType(ModelelementType.getModelelementTypeFor(modelelementName));
				this.modelelementParsed = true;
				break;
			case CONDITION:
				if(conditionParsed) {
					throw new ParserException("Condition already parsed! Cannot parse condition twice in same mapping file");
				}
				if(lineElements.length < 2 ) {
					throw new ParserException("Please provide a condition");
				}
				String[] conditionDefinition = lineElements[1].trim().split(" ");
				if(conditionDefinition.length < 2) {
					throw new ParserException("Please provide a target-element the condition shall get evaluated against in addition to the keyword");
				}

				Condition condition = ConditionFactory.createCondition(ConditionKeyword.getConditionKeywordFor(conditionDefinition[0]), conditionDefinition[1], imMappingDeclaration.getCodestructureType());
				imMappingDeclaration.setCondition(condition);
				
				this.conditionParsed = true;
				break;
			case ATTRIBUTE_MAPPING:
				if(attributeMappingParsed) {
					throw new ParserException("Attribute mapping already parsed! Cannot parse mapping twice in same mapping file");
				}
				if(!codestructureParsed || !modelelementParsed) {
					throw new ParserException("Please provide the codestructure and modelelement the mapping refers to first");
				}
				
				if(lineElements.length < 2 ) {
					throw new ParserException("Please provide an attribute mapping");
				}
				
				//split for eventual multiple mapping definitions, split by '&'
				String[] attributeMappingDefinitions = lineElements[1].trim().split("&");
				for(String amd: attributeMappingDefinitions) {
					amd = amd.trim();
					//split assignments left (modelelement side) and right (codestructure side)
					String[] assignmentValues = amd.split("=");
					//first create MappedCodeElement by parsing the right hand side of the assignment, since it is held in the following MappedDesignmodelElement
					MappedCodeElement mce = MappedCodeElementFactory.createMappedCodeElement(assignmentValues[1].trim(), imMappingDeclaration.getCodestructureType());
					//create MappedDesignmodelElement, by parsing the left hand side of the assignment and providing it with previously parsed MappedCodeElement
					MappedDesignmodelElement mde = MappedDesignmodelElementFactory.createMappedDesignmodelElement(assignmentValues[0].trim(), imMappingDeclaration.getModelelementType(), mce);
					imMappingDeclaration.getAttributeMappings().add(mde);
				}
				if(attributeMappingDefinitions.length > 1) {
					throw new NotImplementedException("Currently, there are only transformations for the first attribute-mapping implemented. Additional ones will get ignored.");
				}
				
				this.attributeMappingParsed = true;
	
				break;
				default:
					throw new ParserException("Unknown keyword/element in mapping file");
			}
		}
		
		//throw exception if one element is missing
		if(!codestructureParsed || !modelelementParsed || !conditionParsed || !attributeMappingParsed) {
			throw new ParserException("Uncompletely mapping file! Some necessary fields are missing!");
		}
		
		return imMappingDeclaration;
	}
	
	/**
	 * Parses the mapping instantiation file that maps concrete model elements to integration mechanisms they shall get translated with.
	 * File getting parsed looks like this:<br>
	 * TypeAnnotation {<br>
	 * 		ComponentType<br>
	 * 	};<br>
	 * 
	 * MarkerInterface {<br>
	 * 		State<br>
	 * };<br>
	 *
	 * StaticInterface {<br>
	 * 		Interface<br>
	 * };<br>
	 * @param f mapping instantiation file to parse
	 * @return list of mapping instantiations
	 * @throws IOException
	 * @throws ParserException 
	 */
	private List<MappingInstantiation> parseMappingInstantiationFile(File f) throws IOException, ParserException {
		
		List<MappingInstantiation> mappingInstantiations = new ArrayList<>();
		String content = new String(Files.readAllBytes(f.toPath()));
		if(content.trim().isEmpty()) {
			throw new ParserException("Mapping instantiation file cannot be empty");
		}
		
		//different instantiations from IMs to specific Model elements are split by ';'
		String[] imInstantiations = content.trim().split(";");
		
		//iterate over all IM-instantiations
		for(String imInstantiation: imInstantiations) {
			//get integration mechanism
			String integrationMechanismName = imInstantiation.split("\\{")[0].trim();
			IntegrationMechanismMappingDeclaration imd = this.mappingDeclarationDatabase.getIntegrationMechanismByName(integrationMechanismName);
			if(imd == null) {
				throw new ParserException("The integration mechanism applied to certain model elements in the .mapping-file does not exist");
			}
			
			//get all names between {} separated by commas
			String[] appliedModelelements = StringUtils.substringBetween(imInstantiation, "{", "}").trim().split(",");
			
			for(String instantiationDeclaration: appliedModelelements) {
				String[] split = instantiationDeclaration.split("\\.");
				String modelElementName = (split.length > 1) ? split[1] : split[0];
				String parentModelElementName = (split.length > 1) ? split[0] : null;
				for(MappingInstantiation mi: mappingInstantiations) {
					if(mi.getInstantiatedModelElement().contentEquals(modelElementName))
						throw new ParserException("Cannot map one design model element multiple times!");
				}
				MappingInstantiation mi = new MappingInstantiation(modelElementName, parentModelElementName, imd);

				mappingInstantiations.add(mi);
			}
		}
		if(mappingInstantiations.isEmpty()) {
			throw new ParserException("The mapping instantiation file is empty! Please provide an instantiation from the declared integration mechanisms to model elements");
		}
		return mappingInstantiations;
	}

	@Override
	public EPackage parseConfigFileToMetaPackage(String path) {
		try {
			String content = new String(Files.readAllBytes(new File(path).toPath())).trim();
			
			//get meta model and create metapackage from it
			ResourceSet rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
			Resource res = rs.createResource(URI.createFileURI(content));
			res.load(null);
			EPackage metapackage = (EPackage) res.getContents().get(0);
			
			return metapackage;
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		return null;
	}	
}
