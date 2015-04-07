package bit_dec.actions;


import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import parser.ObjDumpParser;
import decompiler.CDecompiler;
import bit_dec.dissambler.DisFunction;
import bit_dec.views.cfgView;
import bit_dec.views.functionsView;

public class DecAction extends Action implements IWorkbenchAction, Runnable {

	private IWorkbenchWindow workbenchWindow;

	public DecAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
		this.setText("Generate C Code");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				 "BIT_DEC", "icons/c.jpg"));
		this.setToolTipText("Generate C Code");
	}

	@Override
	public void run() {
		if (workbenchWindow != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			functionsView viewPart = (functionsView)page.findView("BIT_DEC.functionsView");
			
			Shell shell = workbenchWindow.getShell();
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(
					shell, new LabelProvider());
			
			dialog.setElements(viewPart.getList());
			dialog.setTitle("Which function do you want to dec");
			if (dialog.open() != Window.OK) {
				return;
			}
			Object[] result = dialog.getResult();
			if(result[0]!=null){
				final ObjDumpParser objdump = new  ObjDumpParser();
				ArrayList<DisFunction> funclist = objdump.getTextFunList();
				String funcName = (String)result[0];
				objdump.CfgGen(funcName);
				IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
				cfgView graphView = (cfgView)workbenchPage.findView("BIT_DEC.cfgView");
				graphView.drawCFG(funcName);
				//==============输出高级代码================//
				CDecompiler showHighCode = new CDecompiler(); 
				showHighCode.cfgAna(funcName);
			}
		}
	}


	@Override
	public void dispose() {
		workbenchWindow = null;
	}
}
