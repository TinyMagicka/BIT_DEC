package bit_dec.actions;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import bit_dec.views.ConsoleFactory;
import bit_dec.views.myNavigatorView;
import androidCallGragh.CallGragh;

public class CallGraphAction extends Action implements IWorkbenchAction{
	
	private  IWorkbenchWindow workbenchWindow;
	public CallGraphAction(IWorkbenchWindow window) {
		// TODO Auto-generated constructor stub
		if  (window  ==   null ){
			  throw   new  IllegalArgumentException();
		   } 
		this.setText("Generate Call Graph");
		   this.workbenchWindow = window; 
		   setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
 "BIT_DEC", "icons/graph.jpg"));
		   this.setToolTipText("Generate Call Graph");
	}
	
	
	@Override
	public void run(){
		/*
		 * 传递项目的路径
		 */
		IWorkbenchPage page = workbenchWindow.getActivePage();
		myNavigatorView viewPart = (myNavigatorView)page.findView("BIT_DEC.myNavigator");
		
		ISelectionService service = viewPart.getNavigatorActionGroup().getNavigator().getSite().getWorkbenchWindow()
				.getSelectionService();
		IStructuredSelection selection1 = (IStructuredSelection) service
				.getSelection("BIT_DEC.myNavigator");
		IProject iproject = (IProject) selection1.getFirstElement();
		String file2dec = iproject.getLocation().toString();
		
		MessageConsoleStream  printer =ConsoleFactory.getConsole().newMessageStream();
		int k;
		int i;
		int flag = 0;
		int flag2 = 0;
		boolean flag3 = true;
		String armfilepathString = "";
		
		File projectFile = new File(file2dec);
		File[] files  = projectFile.listFiles();
		for(i=0;i<files.length;i++){
			if(files[i].getName().equals("so2asm")){
				flag2 = 1;
				armfilepathString = files[i].getAbsolutePath();
				break;
			}
		}
		File apkfile = files[1];
		File[] apkfiles = apkfile.listFiles();
		
		for(k=0;k<apkfiles.length;k++){
			if(apkfiles[k].getName().equals("smali1")){
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			printer.println("还没有进行Genearate Java Code操作");
			MessageDialog.openInformation(workbenchWindow.getShell(), "提示", "请先进行Genearate Java Code操作"); 
		}
		if(flag2 == 0){
			if(MessageDialog.openConfirm(workbenchWindow.getShell(), "选择","有so文件?")){
				MessageDialog.openInformation(workbenchWindow.getShell(), "提示", "请先进行Disassembler操作"); 
			}
			else{
				flag2 = 1;
				flag3 = false;
			}
		}
		if(flag == 1 && flag2 == 1){
			printer.println(apkfiles[k].getAbsolutePath());
			CallGragh callgraph = new CallGragh(apkfiles[k].getAbsolutePath(),flag3,armfilepathString);
		}
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
