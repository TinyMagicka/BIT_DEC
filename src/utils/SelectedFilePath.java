package utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

import bit_dec.views.myNavigatorView;

public class SelectedFilePath {
	
	public String SelectedProjectPath = "";
	public String SelectedFilePath = "";
	
	public SelectedFilePath(IWorkbenchWindow window){
		IWorkbenchPage page = window.getActivePage();
		myNavigatorView viewPart = (myNavigatorView)page.findView("BIT_DEC.myNavigator");
		ISelectionService service = viewPart.getNavigatorActionGroup().getNavigator().getSite().getWorkbenchWindow()
				.getSelectionService();
		IStructuredSelection selection = (IStructuredSelection) service
				.getSelection("BIT_DEC.myNavigator");
		try{
			IProject iproject = (IProject) selection.getFirstElement();
			this.SelectedProjectPath = iproject.getLocation().toString();
		}catch (NullPointerException e) {
			MessageDialog.openInformation(window.getShell(), "警告", "请先点击需要操作的项目工程"); 
		}
		if(selection.getFirstElement() instanceof IFile) {
		  IFile file = (IFile) selection.getFirstElement();
		  this.SelectedFilePath = file.getLocation().toString();
		}
	}
}
