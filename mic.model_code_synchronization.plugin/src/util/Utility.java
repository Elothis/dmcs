package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Utility {
	
	public static final String ECORE_PATH = "C:/Daten/MIC_Sync_Tool_Repo/mic.model_code_synchronization.designmodel/model/designmodel.ecore";
	
	/**
	 * Gets all files in the specified directory that have the specified file extension.
	 * 
	 * @param directoryPath
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	public static List<File> getAllFilesByExtension(String directoryPath, String extension) throws IOException {
		File directory = new File(directoryPath);
		String[] extensions = new String[] { extension };
		List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);
		return files;
    }
	
	public static XMIResource loadExistingModel(String sourcePath) {
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		XMIResource res = (XMIResource) resSet.getResource(URI.createFileURI(sourcePath), true);
		
		return res;
	}
	
	public static XMIResource initializePersistationResource(String outputPath) {
		ResourceSet savingResSet = new ResourceSetImpl();
		savingResSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		XMIResource savingRes = (XMIResource) savingResSet.createResource(URI.createFileURI(outputPath), null);
		//savingRes.getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		
		return savingRes;
	}
	
	public static void writeToFile(String fileName, String output) {
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Persists an EObject into a "designmodel.xmi" file located at the specified directory path.
	 * 
	 * @param eObject
	 * @param path
	 */
	public static void storeAsXMI(EObject eObject, String path) {
	    ResourceSet resSet = new ResourceSetImpl();
	    resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

	    XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(path + "/designmodel.xmi"), null);
	    resource.getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
	    resource.getContents().add(eObject);

	    try {
	      resource.save(Collections.emptyMap());
	    }
	    catch (IOException exception) {
	      exception.printStackTrace();
	    }
	  }
}
