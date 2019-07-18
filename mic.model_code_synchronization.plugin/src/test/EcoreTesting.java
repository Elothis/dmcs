package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
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
		XMIResource savingRes = Utility.initializePersistationResource("C:/Users/Fabian/mappingDirectory/designmodel.xmi");
		
		EPackage metapackage = (EPackage) res.getContents().get(0);
		System.out.println(metapackage.getName());
		
		EClass componentTypeClass = (EClass) metapackage.getEClassifier("ComponentType");
		EAttribute nameAttr = (EAttribute) componentTypeClass.getEStructuralFeature("name");
		
		EFactory metafactory = metapackage.getEFactoryInstance();
		EObject componentTypeInstance = metafactory.create(componentTypeClass);
		componentTypeInstance.eSet(nameAttr, "CashDesk");
		
		EClass interfaceClass = (EClass) metapackage.getEClassifier("Interface");
		EAttribute interfaceNameAttr = (EAttribute) interfaceClass.getEStructuralFeature("interfaceName");
		
		EObject interfaceInstance = metafactory.create(interfaceClass);
		interfaceInstance.eSet(interfaceNameAttr, "IBarcodeScanner");
		
		EReference required = (EReference) componentTypeClass.getEStructuralFeature("required");
		List<EObject> refs = new ArrayList<>(componentTypeInstance.eCrossReferences());
		refs.add(interfaceInstance);
		componentTypeInstance.eSet(required, refs);
		System.out.println("required EType = " + required.getEType().getName());
		
		componentTypeInstance.eCrossReferences().forEach(e -> {
			System.out.println(e.eGet(interfaceNameAttr));
		});
		
		
		savingRes.getContents().add(componentTypeInstance);
		savingRes.getContents().add(interfaceInstance);
		//Utility.storeAsXMI(stateInstance, "C:/Users/Fabian/mappingDirectory/");
		try {
			savingRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
