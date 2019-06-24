package designmodel.generation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import mapping.TransformationManager;
import mappingdeclaration.IMappingDeclarationParser;
import mappingdeclaration.MappingDeclarationDatabase;
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
	private IMappingDeclarationParser mappingDeclarationParser;
	private MappingDeclarationDatabase mappingDeclarationDatabase;
	private TransformationManager transformationManager;
	
	public String getDirectoryPath() {
		return projectPath;
	}

	/**
	 * Constructor, taking the project path of the target Java program as parameter.
	 * @param projectPath
	 */
	public MappingGenerator(String projectPath, IMappingDeclarationParser mappingParser) {
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
		
		this.mappingDeclarationParser = mappingParser;
		
		this.transformationManager = new TransformationManager(this.launcher);
	}
	
	/**
	 * Called when clicking context menu entry on Java Project.
	 * Parses in the mapping file and starts the process of creating the design model on the basis of the mapping file and the Java source code
	 * of the underlying project.
	 * @param designmodelTargetPath 
	 * @throws IOException 
	 */
	public void buildDesignModel(String designmodelTargetPath) throws IOException {
		this.mappingDeclarationDatabase = this.mappingDeclarationParser.parseMappingDirectory();

		EPackage metapackage = this.mappingDeclarationParser.parseConfigFileToMetaPackage();
		
		//initialize resource for saving the design model as xmi
		XMIResource savingRes = initializePersistationResource(designmodelTargetPath);

		this.mappingDeclarationDatabase.getMappingInstantiations().forEach((modelElementName, imDeclaration) -> {
			//creates a processor that acts upon the specific condition target and runs it
			if(!imDeclaration.getCondition().getTargetElement().contentEquals("modelelement.name")) {
				throw new NotImplementedException("Currently cannot apply conditions to other elements than 'modelelement.name'");
			}
			//creates the respective processor, handing over the modelelement.name,
			//the attribute mappings of the IM and the metapackage of the meta model that the design model gets instantiated with
			imDeclaration.getCondition().createProcessor(modelElementName, imDeclaration.getAttributeMappings(), imDeclaration.getCodestructureType(), metapackage);
			GenerationProcessor<?> processor = imDeclaration.getCondition().getProcessor();
			this.astModel.processWith(processor);
			//add all the generated design model elements from the processor to the resourceSet of the design model xmi
			processor.getGeneratedDesignmodelElements().forEach(e -> {
				if(e != null) savingRes.getContents().add(e);
			});
			//add all the generated mapping entries from the processor to the transformation manager
			processor.getMappingEntries().forEach(e -> {
				this.transformationManager.getMappings().add(e);
			});
		});
		//set existent design model in the transformation manager
		this.transformationManager.setExistentDesignmodel(savingRes);
		
		//save model as xmi
		try {
			savingRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private XMIResource initializePersistationResource(String outputPath) {
		ResourceSet savingResSet = new ResourceSetImpl();
		savingResSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		XMIResource savingRes = (XMIResource) savingResSet.createResource(URI.createFileURI(outputPath), null);
		savingRes.getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		
		return savingRes;
	}

	public TransformationManager getTransformationManager() {
		return this.transformationManager;
	}
	
}
