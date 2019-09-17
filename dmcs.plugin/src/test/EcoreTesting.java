package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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
		
		EClass sourceClass = (EClass) metapackage.getEClassifier("State");
		EAttribute nameAttr = (EAttribute) sourceClass.getEStructuralFeature("name");
		
		EFactory metafactory = metapackage.getEFactoryInstance();
		EObject sourceInstance = metafactory.create(sourceClass);
		sourceInstance.eSet(nameAttr, "Ready");
		
		EClass targetClass = (EClass) metapackage.getEClassifier("Transition");
		EAttribute targetClassNameAttr = (EAttribute) targetClass.getEStructuralFeature("name");
		
		EObject targetClassInstance = metafactory.create(targetClass);
		targetClassInstance.eSet(targetClassNameAttr, "scanItem");
		
		EObject targetClassInstance2 = metafactory.create(targetClass);
		targetClassInstance2.eSet(targetClassNameAttr, "deleteItem");
		
		EReference reference = (EReference) sourceClass.getEStructuralFeature("transition");
		List<EObject> refs = new ArrayList<>(sourceInstance.eCrossReferences());
		refs.add(targetClassInstance);
		refs.add(targetClassInstance2);
		sourceInstance.eSet(reference, refs);
		
		System.out.println(sourceInstance.eContents());
		
		sourceInstance.eCrossReferences().forEach(e -> {
			System.out.println(e.eGet(targetClassNameAttr));
		});
		
		System.out.println("eContainer() = " + targetClassInstance.eContainer().eClass().getName());
		
		savingRes.getContents().add(sourceInstance);
		//savingRes.getContents().add(targetClassInstance);
		//savingRes.getContents().add(targetClassInstance2);
		savingRes.setID(sourceInstance, UUID.randomUUID().toString());
		savingRes.setID(targetClassInstance, UUID.randomUUID().toString());
		savingRes.setID(targetClassInstance2, UUID.randomUUID().toString());
		try {
			savingRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
