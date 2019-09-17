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

import parsing.IMappingDeclarationParser;
import parsing.MappingDeclarationParserImpl;



/**
 * Handler getting called by clicking the added menu entry on a Java project to start the model generation and synchronization from here on.
 * 
 * @author Fabian Glittenberg
 * 
 */
public class MainHandler extends AbstractHandler {
	
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
			
			if (projectObj instanceof IAdaptable && projectObj instanceof IJavaProject) {
	            IProject project = (IProject)((IAdaptable)projectObj).getAdapter(IProject.class);
	            String projectPath = project.getLocation().toString();;
	            
	            StringBuilder sb = new StringBuilder();
	            String mappingDirectoryPath;
				sb.append(System.getProperty("user.home").replace('\\', '/'))
				.append('/').append("mappingDirectory");
				mappingDirectoryPath = sb.toString();
	            
	            IMappingDeclarationParser mappingParser = new MappingDeclarationParserImpl();
				
	            try {
					if(this.transformationManager == null) {
						this.transformationManager = new TransformationManager(mappingDirectoryPath, projectPath, mappingParser);
					}
					
					if(!this.designmodelExistent) {
						transformationManager.buildDesignModel();
						this.designmodelExistent = true;
					}
					else { //model was changed by user and he then clicked the menu entry again to propagate the changes back into the code
						MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(),
								"Transformation direction",
								null,
							    "In which direction do you want to synchronize model and code?",
							    MessageDialog.QUESTION,
							    new String[] { "Code -> Model", "Model -> Code"},
							    0);
							int result = dialog.open();
						if(result == 1) {
							//System.out.println("Propagating changes of the design model back to the code");
					    	transformationManager.updateCode();
						}
						else { //user wants to regenerate the model based on the current state of the code
							//regenerate the design model from scratch
							//System.out.println("Regenerating the design model");
							transformationManager = new TransformationManager(mappingDirectoryPath, projectPath, mappingParser);
							transformationManager.buildDesignModel();
						}	            	
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	            
	        }
		}
		return null;
	}
}
