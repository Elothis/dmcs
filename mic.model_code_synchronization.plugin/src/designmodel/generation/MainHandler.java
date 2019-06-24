package designmodel.generation;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import mappingdeclaration.IMappingParser;
import mappingdeclaration.MappingDeclarationParser;



/**
 * Handler getting called by clicking the added menu entry on a Java project to start the model generation and synchronization from here on.
 * 
 * @author Fabian Glittenberg
 * 
 */
public class MainHandler extends AbstractHandler {

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
	            
	            IMappingParser mappingParser = new MappingDeclarationParser(mappingDirectoryPath);
				
	            MappingGenerator mappingGenerator = new MappingGenerator(projectPath, mappingParser);
				try {
					mappingGenerator.buildDesignModel();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		
				
				
			
		}
		return null;
	}

}
