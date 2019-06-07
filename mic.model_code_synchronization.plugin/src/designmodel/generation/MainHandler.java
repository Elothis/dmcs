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

import mapping.IMappingParser;
import mapping.MappingParser;



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
	            
	            IMappingParser parser = new MappingParser("C:/Daten/UNI/Masterarbeit_Tool/mappingDirectory");
				parser.parseMappingDirectory();
				
	           // MappingGenerator mappingGenerator = new MappingGenerator(projectPath);
				//mappingGenerator.createMapping("dummy");
	        }
		
				
				
			
		}
		return null;
	}

}
