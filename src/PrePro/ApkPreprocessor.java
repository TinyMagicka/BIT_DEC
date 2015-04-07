package PrePro;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.MessageConsoleStream;

import utils.ZipUtils;

import bit_dec.actions.AndroidCodeDecAction;
import bit_dec.dissambler.Sodump;
import bit_dec.views.ConsoleFactory;

public class ApkPreprocessor implements Runnable{
	
	private IWorkbenchWindow workbenchWindow;
	private String projectPath = "";
	private String filePath = "";
	
	public  ApkPreprocessor(String projectPath,String filePath,IWorkbenchWindow workbenchWindow){
		this.workbenchWindow = workbenchWindow;
		this.projectPath = projectPath;
		this.filePath = filePath;
	}
	
	public void decompressionApk() throws Exception{
		MessageConsoleStream  printer =ConsoleFactory.getConsole().newMessageStream();
		printer.println(this.filePath+" is being under decompression...");
		this.filePath.replace(".apk", ".zip");
		ZipUtils.decompress(this.filePath, this.projectPath);
		printer.println(this.filePath+" decompressed completly.");
	}
	
	@Override
	public void run() {
		try {
			this.decompressionApk();
			AndroidCodeDecAction androidCodeDecAction = new AndroidCodeDecAction(workbenchWindow);
			androidCodeDecAction.run();
			Sodump sodump = new Sodump(projectPath);
			sodump.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
