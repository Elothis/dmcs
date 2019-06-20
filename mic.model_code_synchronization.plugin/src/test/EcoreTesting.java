package test;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;

import util.Utility;

class EcoreTesting {
	
	//platform:/resource/mic.model_code_synchronization.designmodel/model/designmodel.ecore
	public static final String ECORE_PATH = "C:/Daten/MIC_Sync_Tool_Repo/mic.model_code_synchronization.designmodel/model/designmodel.ecore";

	@Test
	void test() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		
		Resource res = rs.createResource(URI.createFileURI(ECORE_PATH));
		res.load(null);
		
		EPackage metapackage = (EPackage) res.getContents().get(0);
		System.out.println(metapackage.getName());
		
		EClass stateClass = (EClass) metapackage.getEClassifier("State");
		EAttribute nameAttr = (EAttribute) stateClass.getEStructuralFeature("name");
		
		EFactory metafactory = metapackage.getEFactoryInstance();
		EObject stateInstance = metafactory.create(stateClass);
		stateInstance.eSet(nameAttr, "Ready");
		
		Utility.storeAsXMI(stateInstance, "C:/Users/Fabian/mappingDirectory/designmodel.xmi");
	}

}
