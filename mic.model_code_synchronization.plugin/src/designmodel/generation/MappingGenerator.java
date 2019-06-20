package designmodel.generation;

import java.io.File;

import org.apache.commons.lang3.NotImplementedException;

import mapping.IMappingParser;
import mapping.MappingDeclarationDatabase;
import spoon.Launcher;
import spoon.compiler.Environment;
import spoon.reflect.CtModel;


/**
 * Main mapping generator responsible for triggering the initial model generation. Getting created and called directly from clicking the context
 * menu entry.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingGenerator {
	
	private Launcher launcher;
	private String projectPath;
	private CtModel astModel;
	private IMappingParser mappingParser;
	private MappingDeclarationDatabase mappingDeclarationDatabase;
	
	public String getDirectoryPath() {
		return projectPath;
	}

	/**
	 * Constructor, taking the project path of the target Java program as parameter.
	 * @param projectPath
	 */
	public MappingGenerator(String projectPath, IMappingParser mappingParser) {
		this.projectPath = projectPath;
		this.launcher = new Launcher();
		this.launcher.addInputResource(projectPath);
		Environment env = this.launcher.getEnvironment();
		
		env.setSourceOutputDirectory(new File(projectPath + "/src"));
		env.setCopyResources(false);
		env.setNoClasspath(true);
		env.setCommentEnabled(true);
		env.setAutoImports(true);
		
		this.astModel = this.launcher.buildModel();
		
		this.mappingParser = mappingParser;
		
		
	}
	
	/**
	 * Called when clicking context menu entry on Java Project.
	 * Parses in the mapping file and starts the process of creating the design model on the basis of the mapping file and the Java source code
	 * of the underlying project.
	 * @param mappingFileHere
	 */
	public void buildDesignModel() {
		this.mappingDeclarationDatabase = this.mappingParser.parseMappingDirectory();
		//TODO		
		//create processor for each keyword -> probably in abstract method implementation in concrete keyword class to return abstract processor that does the things
		//identifyMarkerInterfaceMechanisms("State");
		this.mappingDeclarationDatabase.getMappingInstantiations().forEach((modelElementName, imDeclaration) -> {
			//creates a processor that acts upon the specific condition target and runs it
			if(!imDeclaration.getCondition().getTargetElement().contentEquals("modelelement.name")) {
				throw new NotImplementedException("Currently cannot apply conditions to other elements than 'modelelement.name'");
			}
			imDeclaration.getCondition().createProcessor(modelElementName, imDeclaration.getAttributeMappings());
			GenerationProcessor<?> processor = imDeclaration.getCondition().getProcessor();
			this.astModel.processWith(processor);
			System.out.println(processor.getMyData());
		});
	}

}
