package designmodel.generation;

import java.io.File;

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
	
	public String getDirectoryPath() {
		return projectPath;
	}

	/**
	 * Constructor, taking the project path of the target Java program as parameter.
	 * @param projectPath
	 */
	public MappingGenerator(String projectPath) {
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
	}
	
	/**
	 * Called when clicking context menu entry on Java Project.
	 * Parses in the mapping file and starts the process of creating the design model on the basis of the mapping file and the Java source code
	 * of the underlying project.
	 * @param mappingFileHere
	 */
	public void createMapping(String mappingFileHere) {
		//TODO
		System.out.println("Parse in mapping file and create mapping");
		
		identifyMarkerInterfaceMechanisms("State");
	}
	
	private void identifyMarkerInterfaceMechanisms(String interfaceName) {
		this.astModel.processWith(new MarkerInterfaceProcessor(interfaceName));;
		//this.launcher.run();
		this.launcher.prettyprint();
	}
}
