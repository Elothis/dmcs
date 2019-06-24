package mapping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.xmi.XMIResource;

import spoon.Launcher;

public class TransformationManager {
	private List<MappingEntry> mappings;
	private XMIResource existentDesignmodel;
	private Launcher launcher;
	
	public TransformationManager(Launcher launcher) {
		this.mappings = new ArrayList<>();
		this.launcher = launcher;
	}

	public List<MappingEntry> getMappings() {
		return mappings;
	}

	public void setMappings(List<MappingEntry> mappings) {
		this.mappings = mappings;
	}

	public XMIResource getExistentDesignmodel() {
		return existentDesignmodel;
	}

	public void setExistentDesignmodel(XMIResource existentDesignmodel) {
		this.existentDesignmodel = existentDesignmodel;
	}

	/**
	 * Updates the code to reflect the contents of a changed design model.
	 * @param updatedModel
	 */
	public void updateCode(XMIResource updatedModel) {
		updatedModel.getContents().forEach(e -> {
			System.out.println("updatedModel eClass: " + e.eClass());		
			System.out.println("getName() = " + e.eClass().getName());
			System.out.println("getEStructuralFeature('name') = " + e.eGet(e.eClass().getEStructuralFeature("name")));
		});
		
		this.existentDesignmodel.getContents().forEach(e -> {
			System.out.println("existendModel eClass: " + e.eClass());
			System.out.println("getName() = " + e.eClass().getName());
			System.out.println("getEStructuralFeature('name') = " + e.eGet(e.eClass().getEStructuralFeature("name")));
		});
		
		//testing actually changing the spoon element and then printing it into code
		//--> WORKS! but old class-file has to be removed (only adds new one with new name)
		getMappingEntryByCodeElementName("Waiting").getCodeElement().setSimpleName("NotWaitingAnymore");
		this.launcher.prettyprint();
		
		//TODO implement updateCode
		/*
		 * - check differences between updatedModel and existentDesignmodel
		 * - find mapped codestructures in this.mappings from modelelements that got changed
		 * - update codestructures respective to changes to modelelements
		 * - print results and remove old files with old names (manually, no refactoring a la eclipse)
		 * - set newly updatedModel to existendDesignmodel
		 * 
		 * OR
		 * 
		 * - go through this.mappings and check for each entry if smth has changed in updatedModel
		 */
	}
	
	private MappingEntry getMappingEntryByCodeElementName(String codeElementName) {
		for(MappingEntry e: this.mappings) {
			if(e.getCodeElement().getSimpleName().contentEquals(codeElementName))
				return e;
		}
		return null;
	}
}
