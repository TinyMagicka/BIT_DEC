package bit_dec;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import bit_dec.actions.*;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction NewAction;
	private IWorkbenchAction iExitAction;
	private IWorkbenchAction iSaveAction;
	private IWorkbenchAction iSaveasAction;
	private IWorkbenchAction iCloseAction;
	private IWorkbenchAction iCutAction;
	private IWorkbenchAction iCopyAction;
	private IWorkbenchAction iPasteAction;
	private IWorkbenchAction PREFERENCES;
	private IWorkbenchAction iRefresh;
	private IWorkbenchAction iResetPers;
	private IWorkbenchAction iShowViewMenu;
	private IWorkbenchAction iOpenPersDiag;
	private IWorkbenchAction iHELP_CONTENTS;
	private IWorkbenchAction iHELP_SEARCH;
	private IWorkbenchAction iImport;
	private IWorkbenchAction iExport;
	
	private OpenAction OpenAction;
	private CallGraphAction callGraphAction;
	private DecAction decAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    @Override
	protected void makeActions(IWorkbenchWindow window) {
    	//file Menu
    	NewAction = ActionFactory.NEW.create(window);
    	NewAction.setText("New Project...");
    	register(NewAction);
    	OpenAction = new OpenAction(window);
    	iExitAction = ActionFactory.QUIT.create(window);
		register(iExitAction);
		iSaveAction = ActionFactory.SAVE.create(window);
		register(iSaveAction);
		iSaveasAction = ActionFactory.SAVE_AS.create(window);
		register(iSaveasAction);
		iCloseAction = ActionFactory.CLOSE.create(window);
		
		register(iCloseAction);
		iImport = ActionFactory.IMPORT.create(window);
		iImport.setText("Import Project...");
		register(iImport);
		iExport = ActionFactory.EXPORT.create(window);
		iExport.setText("Export Project...");
		register(iExport);
		
		//Edit Menu
		iCutAction = ActionFactory.CUT.create(window);
		register(iCutAction);
		iCopyAction = ActionFactory.COPY.create(window);
		register(iCopyAction);
		iPasteAction = ActionFactory.PASTE.create(window);
		register(iPasteAction);
		
		//decompiling Menu
		callGraphAction = new CallGraphAction(window);
		decAction = new DecAction(window);
		
		//others
		PREFERENCES = ActionFactory.PREFERENCES.create(window);
		register(PREFERENCES);
		iRefresh = ActionFactory.REFRESH.create(window);
		register(iRefresh);
		iResetPers = ActionFactory.RESET_PERSPECTIVE.create(window);
		register(iResetPers);
		iShowViewMenu = ActionFactory.SHOW_VIEW_MENU.create(window);
		register(iShowViewMenu);
		iOpenPersDiag = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
		register(iOpenPersDiag);
		
		//help
		iHELP_CONTENTS = ActionFactory.HELP_CONTENTS.create(window);
		register(iHELP_CONTENTS);
		iHELP_SEARCH = ActionFactory.HELP_SEARCH.create(window);
		register(iHELP_SEARCH);
    }

    @Override
	protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager fileMenu = new MenuManager("&File","");
    	MenuManager editMenu = new MenuManager("&Edit","");
    	MenuManager OperateMenu = new MenuManager("&Decompile","");
    	MenuManager OthersMenu = new MenuManager("&View","");
    	MenuManager HelpMenu = new MenuManager("&Help","");
    	menuBar.add(fileMenu);
    	menuBar.add(editMenu);
    	menuBar.add(OperateMenu);
    	menuBar.add(OthersMenu);
    	menuBar.add(HelpMenu);
    	
    	//file Menu
    	fileMenu.add(NewAction);
    	fileMenu.add(OpenAction);
    	fileMenu.add(iSaveAction);
    	fileMenu.add(iSaveasAction);
    	fileMenu.add(new Separator());
    	fileMenu.add(iImport);
    	fileMenu.add(iExport);
    	fileMenu.add(new Separator());
    	fileMenu.add(iCloseAction);
    	fileMenu.add(iExitAction);
    	
    	//Edit Menu
    	editMenu.add(iCutAction);
    	editMenu.add(iCopyAction);
    	editMenu.add(iPasteAction);
    	
    	//Operate Menu
    	OperateMenu.add(new Separator());
    	OperateMenu.add(new Separator());
    	OperateMenu.add(callGraphAction);
    	OperateMenu.add(decAction);
    	
    	//Others Menu
    	OthersMenu.add(PREFERENCES);
    	OthersMenu.add(iResetPers);
    	OthersMenu.add(iShowViewMenu);
    	OthersMenu.add(iOpenPersDiag);
    	
    	//Help Menu
    	HelpMenu.add(iHELP_CONTENTS);
    	HelpMenu.add(iHELP_SEARCH);
    }
    
    @Override
	protected void fillCoolBar(ICoolBarManager coolBar){
		// This will add a new toolbar to the application
		IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
		coolBar.add(new ToolBarContributionItem(toolbar, "main"));
		toolbar.add(callGraphAction);
		toolbar.add(decAction);
		toolbar.add(iRefresh);
    }

    
}
