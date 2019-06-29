package designmodel.generation;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import mapping.TransformationManager;
import mappingdeclaration.IMappingDeclarationParser;
import mappingdeclaration.MappingDeclarationParser;
import util.Utility;



/**
 * Handler getting called by clicking the added menu entry on a Java project to start the model generation and synchronization from here on.
 * 
 * @author Fabian Glittenberg
 * 
 */
public class MainHandler extends AbstractHandler {
	
	public static final String DESIGNMODEL_TARGET_PATH = "C:/Users/Fabian/mappingDirectory/designmodel.xmi";
	
	private boolean designmodelExistent = false;
	private TransformationManager transformationManager;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		//getting selected item
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		//casting it to IStructuredSelection to retrieve first element
		if(selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object projectObj = strucSelection.getFirstElement();
			
			if (projectObj instanceof IAdaptable && projectObj instanceof IJavaProject)
	        {
	            IProject project = (IProject)((IAdaptable)projectObj).getAdapter(IProject.class);
	            String projectPath = project.getLocation().toString();;
	            
	            StringBuilder sb = new StringBuilder();
	            String mappingDirectoryPath;
				sb.append(System.getProperty("user.home").replace('\\', '/'))
				.append('/').append("mappingDirectory");
				mappingDirectoryPath = sb.toString();
	            
	            IMappingDeclarationParser mappingParser = new MappingDeclarationParser(mappingDirectoryPath);
				
	            MappingGenerator mappingGenerator = new MappingGenerator(projectPath, mappingParser);
	            if(!this.designmodelExistent) {
	            	try {
						mappingGenerator.buildDesignModel(DESIGNMODEL_TARGET_PATH);
						this.transformationManager = mappingGenerator.getTransformationManager();
						this.designmodelExistent = true;
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	            else { //model was changed by user and he then clicked the menu entry again to propagate the changes back into the code
	            	MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(),
	            			"Synchronization direction",
	            			null,
	            		    "Did you change the code base or the design model?",
	            		    MessageDialog.QUESTION,
	            		    new String[] { "I changed some code", "I updated the design model"},
	            		    0);
	            		int result = dialog.open();
	            		System.out.println("dialog result = " + result);
	            	if(result == 1) {
	            		System.out.println("Model updated");
		            	this.transformationManager.updateCode(Utility.loadExistingModel(DESIGNMODEL_TARGET_PATH));
	            	}
	            	else { //user wants to regenerate the model based on the current state of the code
	            		try {
	            			//regenerate the design model from scratch
							mappingGenerator.buildDesignModel(DESIGNMODEL_TARGET_PATH);
							this.transformationManager = mappingGenerator.getTransformationManager();
						} catch (IOException e) {
							e.printStackTrace();
						}
	            	}
	            	
	            }
				
	        }
		}
		return null;
	}

}
