package bit_dec.actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import utils.SelectedFilePath;
import utils.ZipUtils;
import bit_dec.Activator;
import bit_dec.views.ConsoleFactory;
import bit_dec.views.myNavigatorView;

public class AndroidCodeDecAction extends Action implements IWorkbenchAction{

	public String projectPath = "";
	public String toolsFileUrl="";
	public String dexFilePath="";
	private IWorkbenchWindow workbenchWindow;
	MessageConsoleStream  printer =ConsoleFactory.getConsole().newMessageStream();
	
	public AndroidCodeDecAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
		this.setText("Generate Java Code");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				 "BIT_DEC", "icons/sample.gif"));
		this.setToolTipText("Generate Java Code");
	}
	
	public void run() {
		SelectedFilePath selectedFilePath = new SelectedFilePath(workbenchWindow);
		this.projectPath = selectedFilePath.SelectedProjectPath;
		try {
			URL url = Activator.getDefault().getBundle().getResource("tools");
			this.toolsFileUrl = FileLocator.toFileURL(url).toString().substring(6);
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
		if  (this.workbenchWindow  !=   null )  {
			this.printer.println("parsing the classes.dex...");
			this.dexFilePath = projectPath+"/classes.dex";
			try {
				Process p = null;
				p = Runtime.getRuntime().exec(toolsFileUrl+"/dex2jar-0.0.9.15/d2j-dex2jar.bat" +
												" -f "+this.dexFilePath+
												" -o "+this.projectPath+"/classes-dex2jar.jar");
				System.out.println(toolsFileUrl+"/dex2jar-0.0.9.15/d2j-dex2jar.bat" +
									" -f "+this.dexFilePath+
									" -o "+this.projectPath+"/classes-dex2jar.jar");
				StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "Error");            
	            StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "Output");
	            errorGobbler.start();
	            outputGobbler.start();
	            p.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
				printer.println("parse classes.dex error.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String dex2jarPath = this.projectPath+"/classes-dex2jar.jar";
			printer.println("parse classes.dex to "+dex2jarPath+" successfully");
			
			//��ѹclasses-dex2jar.jar
			printer.println("extracting " +dex2jarPath+"...");
			dex2jarPath.replace(".jar", ".zip");
			File directory = new File(this.projectPath+"/classes");
			directory.mkdir();
			try {
				ZipUtils.decompress(dex2jarPath, directory.getAbsolutePath());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			printer.println(dex2jarPath+" extracte has completed.");
			
			//������classes
			printer.println("decompiling *.class...");
			File jadBat = new File(toolsFileUrl+"//jad//jad.bat");
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jadBat)));
				bw.write(toolsFileUrl+"//jad//jad.exe -r -ff -d "+projectPath+"//src -s java "+projectPath+"//classes/**/*.class");
				System.out.println(toolsFileUrl+"//jad//jad.exe -r -ff -d "+projectPath+"//src -s java "+projectPath+"//classes/**/*.class");
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Process p = null;
				p = Runtime.getRuntime().exec(toolsFileUrl+"//jad//jad.bat");
				StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "Error");            
	            StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "Output");
	            errorGobbler.start();
	            outputGobbler.start();
	            p.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
				printer.println("decompile .class error����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				File jadFile = new File(toolsFileUrl+"//jad//jad.bat");
				jadFile.delete();
			}
			printer.println(".class has decompiled completed����");
		}
	}
	
	@Override
	public void dispose() {
		workbenchWindow  =   null ;
	}
}


//��֤exec�ɹ������
class StreamGobbler extends Thread {
	 InputStream is;
	 String type;
	 StreamGobbler(InputStream is, String type) {
	  this.is = is;
	  this.type = type;
	 }

	 public void run() {
	  try {
	   InputStreamReader isr = new InputStreamReader(is);
	   BufferedReader br = new BufferedReader(isr);
	   String line = null;
	   while ((line = br.readLine()) != null) {
	   }
	  } catch (IOException ioe) {
	   ioe.printStackTrace();
	  }
	 }
	}

