package designmodel.generation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import mapping.IMappingParser;
import mapping.MappingDeclarationDatabase;
import spoon.Launcher;
import spoon.compiler.Environment;
import spoon.reflect.CtModel;
import util.Utility;


/**
 * Main mapping generator responsible for triggering the initial model generation. Getting created and called directly from clicking the context
 * menu entry.
 * 
 * @author Fabian Glittenberg
 *
 */
public class MappingGenerator {
	
	//TODO parse these from .mapping file or so
	public static final String ECORE_PATH = "C:/Daten/MIC_Sync_Tool_Repo/mic.model_code_synchronization.designmodel/model/designmodel.ecore";
	public static final String DESIGNMODEL_TARGET_PATH = "C:/Users/Fabian/mappingDirectory/designmodel.xmi";
	
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
	 * @throws IOException 
	 */
	public void buildDesignModel() throws IOException {
		this.mappingDeclarationDatabase = this.mappingParser.parseMappingDirectory();
		//get meta model and create metapackage from it
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		Resource res = rs.createResource(URI.createFileURI(ECORE_PATH));
		res.load(null);
		EPackage metapackage = (EPackage) res.getContents().get(0);
		
		//initialize resource for saving the design model as xmi
		XMIResource savingRes = initializePersistingResource(DESIGNMODEL_TARGET_PATH);
		
		this.mappingDeclarationDatabase.getMappingInstantiations().forEach((modelElementName, imDeclaration) -> {
			//creates a processor that acts upon the specific condition target and runs it
			if(!imDeclaration.getCondition().getTargetElement().contentEquals("modelelement.name")) {
				throw new NotImplementedException("Currently cannot apply conditions to other elements than 'modelelement.name'");
			}
			//creates the respective processor, handing over the modelelement.name,
			//the attribute mappings of the IM and the metapackage of the meta model that the design model gets instantiated with
			imDeclaration.getCondition().createProcessor(modelElementName, imDeclaration.getAttributeMappings(), metapackage);
			GenerationProcessor<?> processor = imDeclaration.getCondition().getProcessor();
			this.astModel.processWith(processor);
			//add all the generated design model elements from the processor to the resourceSet of the design model xmi
			processor.getGeneratedDesignmodelElements().forEach(e -> {
				savingRes.getContents().add(e);
			});
		});
		//save model as xmi
		try {
			savingRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private XMIResource initializePersistingResource(String output) {
		ResourceSet savingResSet = new ResourceSetImpl();
		savingResSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		XMIResource savingRes = (XMIResource) savingResSet.createResource(URI.createFileURI(DESIGNMODEL_TARGET_PATH), null);
		savingRes.getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		
		return savingRes;
	}

}
