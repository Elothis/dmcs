package designmodel.generation;

import java.io.File;

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
		//how to create processors at runtime that identify the codestructures and create mapping that are parsed in at runtime through mapping file?
		//xtend-classes to write processors at runtime and then instantiate here? (via dependency injection)
		//create additional processors with xtend for transformations if model gets changed at runtime?
		
		//create processor for each keyword -> probably in abstract method implementation in concrete keyword class to return abstract processor that does the things
		//identifyMarkerInterfaceMechanisms("State");
		this.mappingDeclarationDatabase.getMappingInstantiations().forEach((modelElementName, imDeclaration) -> {
			//creates a processor that acts upon the specific condition target and runs it
			imDeclaration.getCondition().createProcessor(modelElementName);
			this.astModel.processWith(imDeclaration.getCondition().getProcessor());
		});
	}
	
	private void identifyMarkerInterfaceMechanisms(String interfaceName) {
		this.astModel.processWith(new ImplementedInterfaceProcessor("State"));
		//this.launcher.run();
		this.launcher.prettyprint();
	}
}
