package bit_dec.views;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.ViewPart;

import decompiler.CDecompiler;
import bit_dec.dissambler.DisFunction;
import parser.ObjDumpParser;

public class functionsView extends ViewPart {

	private List list;
	private ArrayList<String> arrayList;
	
	public functionsView() {
		// TODO Auto-generated constructor stub
	}

	public void showFunctions(){
		
		final ObjDumpParser objdump = new  ObjDumpParser();
		ArrayList<DisFunction> funclist = objdump.getTextFunList();
		int funcNum = funclist.size();
		arrayList = new ArrayList<String>();
		for(int i=0;i<funcNum;i++){
			String tempString;
			tempString = funclist.get(i).getFunctionName();
			list.add(tempString);
			arrayList.add(tempString);
		}
		
		SelectionListener listener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				int index =list.getSelectionIndex();
				if(index == -1)
					return;
				String funcName = list.getItem(index);
				objdump.CfgGen(funcName);
				IWorkbenchPage workbenchPage = getViewSite().getPage();
				IViewPart viewPart = workbenchPage.findView("BIT_DEC.cfgView");
				cfgView graphView = (cfgView)viewPart;
				graphView.drawCFG(funcName);
				//==============输出高级代码================//
				CDecompiler showHighCode = new CDecompiler(); 
				showHighCode.cfgAna(funcName);
			}
		};
		list.addSelectionListener(listener);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		list = new List(parent, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
	}

	public Object[] getList(){;
		return arrayList.toArray();
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
