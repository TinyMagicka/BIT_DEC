package androidCallGragh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import bit_dec.views.callgraphView;


public class CallGragh {

	private ClearComment clearcomment;
	
	private funcInnerBean OnefuncInnerBean;
	private funcSelfBean Single_func_self;
	
	public static ArrayList<funcSelfBean> allJavaFuncsInfo;
	public static ArrayList<funcInnerBean> allJavaCallGragh;
	
	public static ArrayList<funcSelfBean> allCFuncsInfo;
	public static ArrayList<funcInnerBean> allCCallGragh;
	
	public static ArrayList<String> myClassesNames;
	
	
	private String classs_name;
	public static boolean include = false;
	
	public CallGragh(){
		
	}
	
	public CallGragh(String path1,boolean ff,String ARMfilepath){
		allJavaFuncsInfo = new ArrayList<funcSelfBean>();
		allJavaCallGragh = new ArrayList<funcInnerBean>();
		allCFuncsInfo = new ArrayList<funcSelfBean>();
		allCCallGragh = new ArrayList<funcInnerBean>();
		myClassesNames = new ArrayList<String>();
		include = ff;
		File file  = new File(path1);
		/*
		 * 构建Java函数表（以及构建C函数表和调用表）
		 */
		System.out.println("path1:"+path1);
		System.out.println("ARMfilepath:"+ARMfilepath);
		listJavaFile(file);
		
		if(!ARMfilepath.equals("")){
			File ARMfile = new File(ARMfilepath);
			listARMFile(ARMfile);
		}
		/*
		 * 构建Java调用表
		 */
		JavaGraghInfo(file);
		/*
		 * 画出调用图
		 */
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart viewPart;
		try {
			viewPart = page.showView("BIT_DEC.callgraphView");
			callgraphView callgarphView = (callgraphView)viewPart;
			callgarphView.drawCallGraph();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	
	public void listARMFile(File file) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if(files[i].getName().endsWith(".txt")){
					getCFuncInfoAddCallGragh(files[i]);
				}
			} else {
				listARMFile(files[i]);
			}
		}
	}
	
	
	public void listJavaFile(File file) {
		
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if (files[i].getName().endsWith(".java")) {
					getJavaFuncsInfo(files[i]);
				} 
			} else {
				if(files[i].getName().equals("com")){
					System.out.println("111111");
				}
				listJavaFile(files[i]);
			}
		}

	}
	
	public void getCFuncInfoAddCallGragh(File file){
		BufferedReader reader;
		int startIndex = 0;
		String temp5;
		int GoalFuncIndex = 0;
		OnefuncInnerBean = new funcInnerBean();
		try {
			String line = null;
			InputStream is;
			
			is = new FileInputStream(file.getAbsolutePath());
			reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			while ((line = reader.readLine())!= null){
				
				if(line.contains("Disassembly of section")){
					if(line.contains(".text:")){
						startIndex = 1;
						continue;
					}
					else{
						startIndex  = 0;
						continue;
					}
				}
				if(startIndex == 1){
					if(line.equals("")){
						allCCallGragh.add(OnefuncInnerBean);
					}
					if(line.contains(">:")){
						//提取函数名
						temp5 = line.substring(line.indexOf('<')+1, line.indexOf('>'));
						if((!temp5.startsWith("_")) && (!temp5.startsWith("__"))){
							GoalFuncIndex = 1;
							Single_func_self = new funcSelfBean();
							OnefuncInnerBean = new funcInnerBean();
							Single_func_self.setFuncName(temp5);
							OnefuncInnerBean.setFuncSelf(Single_func_self);
							allCFuncsInfo.add(Single_func_self);
						}
						else{
							GoalFuncIndex = 0;
						}
						
					}
					//提取调用函数
					if(GoalFuncIndex == 1){
						String[] words;
						String callFunc;
						words = line.split("\\s+");
						
						for(int i=0;i<words.length;i++){
							if(words[i].equals("pop")){
								GoalFuncIndex = 0;
								break;
							}
							if((words[i].equals("bl")) || (words[i].equals("blx"))){
								if(line.contains("<") && line.contains(">")){
									callFunc = line.substring(line.indexOf('<')+1, line.indexOf('>'));
									if((!callFunc.startsWith("_")) && (!callFunc.startsWith("__"))){//????????
										if(callFunc.contains("+")){
											callFunc = callFunc.substring(0, callFunc.lastIndexOf('+'));
										}
										else if(callFunc.contains("-")){
											callFunc = callFunc.substring(0, callFunc.lastIndexOf('-'));
										}
										OnefuncInnerBean.addCfuncInnerFuncs(callFunc);
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	} 
	
	public void getJavaFuncsInfo(File file){

		
		 //得到副本
		 Copy(file.getPath(),file.getPath()+".copy.noblank");
		 //去除副本注释 
		 clearcomment = new ClearComment(); 
		 try {
		 clearcomment.clearComment(file.getPath()+".copy.noblank"); }
		 catch (FileNotFoundException e) { e.printStackTrace(); }
		 catch (UnsupportedEncodingException e) {
		 e.printStackTrace(); }
		 //处理java得到函数信息表
	}
	
	public void JavaGraghInfo(File file){
		
		File[] files = file.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if(files[i].getName().equals("android")){
				continue;
			}
			else if (files[i].isFile()) {
				if (files[i].getName().endsWith(".java.copy.noblank")) {
					getJavaGragh(files[i]);
				} 
			} 
			else{
				JavaGraghInfo(files[i]);
			}   
		}
		
	}
	
	public void getJavaGragh(File file){
		BufferedReader reader;
		String long_string="";
		String[] head_str;
		int left_kuohao = 0;
		int right_kuohao = 0;
		try {
			String line = null;
			InputStream is;
			is = new FileInputStream(file.getAbsolutePath());
			reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			String setclassStr = "";
			
			while ((line = reader.readLine())!= null && (!line.contains("}"))){
				if(line.contains("class")){
					head_str = line.split("\\s+");
					for(int i=0; i<head_str.length ;i++){
						if(head_str[i].equals("class")){
							classs_name = head_str[i+1];
							break;
						}
					}
				}
			}
			
			while((line = reader.readLine())!= null){
				//提取基函数并创建OnefuncInnerBean
				if(!line.equals("")){
				left_kuohao = 0;
				right_kuohao = 0;
				long_string = "";
				OnefuncInnerBean = new funcInnerBean();
				Single_func_self = new funcSelfBean();
				splitFunStr1(line);
				OnefuncInnerBean.setFuncSelf(Single_func_self);
				//单个提取??????????????????????????????????????同时还要找出该函数的类型
				while((line = reader.readLine())!= null){
					if(line.contains("{")){
						left_kuohao++;
						if(left_kuohao == right_kuohao)
							break;
					}
					else if(line.contains("}")){
						right_kuohao++;
						if(left_kuohao == right_kuohao)
							break;
					}
					else{
						long_string = long_string + line;
					}
				}
				//??????????????????寻找activity然后跳转,而且还有setClass 等
				if(long_string.contains("setClass")){
					
					funcSelfBean ff = new funcSelfBean();
					funcInnerBean ffi = new funcInnerBean();
					
					setclassStr = long_string.substring(long_string.indexOf("setClass"));
					setclassStr = setclassStr.substring(setclassStr.indexOf(',')+1, setclassStr.indexOf(')'));
					ff.setFuncName("startActivity");
					ffi.setFuncSelf(ff);
					ffi.addFuncInnerFunc(new funcSelfBean("onCreate","void",null,setclassStr));
					allJavaCallGragh.add(ffi);
				}
				else if(long_string.contains("startActivity")){
					
					funcSelfBean ff = new funcSelfBean();
					funcInnerBean ffi = new funcInnerBean();
					
					setclassStr = long_string.substring(long_string.indexOf("startActivity"));
					for(int q = 0; q < myClassesNames.size(); q++){
						if(setclassStr.contains(","+myClassesNames.get(q))){
							ff.setFuncName("startActivity");
							ffi.setFuncSelf(ff);
							ffi.addFuncInnerFunc(new funcSelfBean("onCreate","void",null,myClassesNames.get(q)));
							allJavaCallGragh.add(ffi);
							break;
						}
					}
					
				}
				//寻找调用函数并分离出参数（特别是为了c语言的参数推断）
				SeekFuncs(long_string);
				allJavaCallGragh.add(OnefuncInnerBean);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void SeekFuncs(String temp_str){
//		扫面java调用的java
		
		
		for(int i=0;i<allJavaFuncsInfo.size();i++){
//			???????????1.不同类相同的函数 2.相同函数不同参数
			if(temp_str.contains(allJavaFuncsInfo.get(i).getFunName())){
				OnefuncInnerBean.addFuncInnerFunc(allJavaFuncsInfo.get(i));
			}
		}
//		扫描java调用的c
		int CfuncIndex;
		int CfuncKuohaoStartIndex;
		int CfuncKuohaoEndIndex;
		String rest;
		String kuoInner;
		String[] args;
		String[] argsType;
		for(int i=0;i<allCFuncsInfo.size();i++){
			if(allCFuncsInfo.get(i).getFunName().startsWith("Java_")){
				if(temp_str.contains(allCFuncsInfo.get(i).getFunName())){
//					提取C函数的参数
					CfuncIndex = temp_str.indexOf(allCFuncsInfo.get(i).getFunName());
					rest = temp_str.substring(CfuncIndex);
					CfuncKuohaoStartIndex = rest.indexOf('(');
					CfuncKuohaoEndIndex = rest.indexOf(')');
					kuoInner = rest.substring(CfuncKuohaoStartIndex+1, CfuncKuohaoEndIndex);
					if(kuoInner.equals("")){
					}
					else{
						args = kuoInner.split(",");
						for(int j=0;j< args.length;j++){
							args[j].trim();
							argsType = args[j].split(" ");
							allCFuncsInfo.get(i).addArgType(argsType[argsType.length-2]);
						}
					}
					OnefuncInnerBean.addFuncInnerFunc(allJavaFuncsInfo.get(i));
				}
			}
			
		}
	}
	
	public void splitFunStr1(String funcString){
		int args_num = 0;
		String[] listt = funcString.split("[\\(\\)]");
		String[] list1 = listt[0].split("\\s+");
		Single_func_self.setClassName(classs_name);
//		System.out.println(funcString);
		if(listt.length == 1){
			Single_func_self.setFuncArgNum(0);
			Single_func_self.addArgType("_null");
//			System.out.println("父函数参数个数:0");
//			System.out.println("父函数参数类型:_null");
		}
		else{
			String[] list2 = listt[1].split(",");
			String[] list22;
			int args_count = 0;
			args_num= list2.length;
			Single_func_self.setFuncArgNum(args_num);
//			System.out.println("父函数参数个数:"+args_num);
			for(int i=0;i<list2.length;i++){
				if(list2[i]==""){
//					System.out.println("父函数类型参数:null");
					Single_func_self.addArgType("_null");
				}
				else {
					list2[i] = list2[i].trim();
					list22 = list2[i].split("\\s+");
					args_count = i+1;
					if(list22.length>=2){
//						System.out.println("参数"+args_count+":"+list22[list22.length-2]);
						Single_func_self.addArgType(list22[list22.length-2]);
					}
					else{
						Single_func_self.addArgType(list22[0]);
					}
				}
			}
		}
		
		
		
		Single_func_self.setFuncName(list1[list1.length-1]);
//		System.out.println("父函数名:"+list1[list1.length-1]);
		if(list1.length == 1){
			Single_func_self.setFuncReturn("_null");
//			System.out.println("父返回类型:_null");
		}
		else if( (list1[list1.length-2].equals("public") )  ||
				(list1[list1.length-2].equals("private") )  ||
				(list1[list1.length-2].equals("protected") )  ||
				(list1[list1.length-2].equals("abstract") )  ||
				(list1[list1.length-2].equals("interface") )  ||
				(list1[list1.length-2].equals("static") )  ||
				(list1[list1.length-2] == "final") )
			
		{
//			System.out.println("父返回类型: null");
			Single_func_self.setFuncReturn("_null");
		}
		else{
//			System.out.println("父返回类型:"+list1[list1.length-2]);
			Single_func_self.setFuncReturn(list1[list1.length-2]);
		}
		
			
	}

	public void PrintCGragh(){
		for(int i=1;i<allCCallGragh.size();i++){
			//System.out.println(allCCallGragh.get(i).getFuncSelf().getFunName());
			for(int j=0;j<allCCallGragh.get(i).getCFuncInnerFuncsNum();j++){
				//System.out.println("   +++"+allCCallGragh.get(i).getCfuncInnerFuncs().get(j));
			}
		}
	}
	
	public void PrintJavaGragh(){
		for(int i=0;i<allJavaCallGragh.size();i++){
			//System.out.println("----------------------------------------------------");
			//System.out.println(allJavaCallGragh.get(i).getFuncSelf().getFunName());
			for(int j=0;j<allJavaCallGragh.get(i).getFuncInnerFuncsNum();j++){
			//	System.out.println("  +++"+allJavaCallGragh.get(i).getFunInnerFuncs().get(j).getFunName());
			}
		}
	}
	
	public void PrintFuncInfoList(){
		for(int i=0;i<allJavaFuncsInfo.size();i++){
		//	System.out.println(allJavaFuncsInfo.get(i).getFunName());
		}
	}
	
	public void Copy(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
	}
	public void printJavaFuncInfo(){
		for(int i=0;i<allJavaFuncsInfo.size();i++){
//			System.out.println("++++++++++++++++");
//			System.out.println("类名："+allJavaFuncsInfo.get(i).getClassName());
//			System.out.println("函数名："+allJavaFuncsInfo.get(i).getFunName());
		}
	}

}
