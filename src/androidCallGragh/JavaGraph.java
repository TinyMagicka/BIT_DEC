package androidCallGragh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Stack;

public class JavaGraph {

	static ArrayList<funcSelfBean> func_self_beans = new ArrayList<funcSelfBean>();
	private String className = "";
	private String packName = "";

	public JavaGraph() {
		File file = new File("E:\\runtime-BIT_DEC.application\\myAndroid\\src");
		listJavaFile(file);
	}

	public void listJavaFile(File file) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().endsWith(".java")) {
				genFuncBean(files[i]);
			} else if (!files[i].isFile()
					&& !files[i].getName().equals("android")) {
				listJavaFile(files[i]);
			}
		}
	}

	public void genFuncBean(File file) {
		String line = "";
		String line_pre = "";

		InputStream is;
		BufferedReader reader;
		Stack<Character> stack = new Stack<>();

		try {
			is = new FileInputStream(file.getAbsolutePath());
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			line = reader.readLine();
			do {
				if (line.startsWith("package ")) {
					packName = line.substring(8, line.lastIndexOf(";"));
				} else if (line.contains("class") && stack.size() == 0) {
					String[] arrStrings = line.split(" ");
					for (int i = 0; i < arrStrings.length; i++) {
						if (arrStrings[i].trim().equals("class")) {
							className = arrStrings[i + 1];
							break;
						}
					}
				}
				boolean flag = false;
				if (line.contains(" native ")
						|| (flag = (line.contains("{") && stack.size() == 1 && line_pre
								.trim().endsWith(")")))) {
					ArrayList<String> funcInfo = new ArrayList<String>();
					funcSelfBean func_self_bean = new funcSelfBean();
					if (!flag) {
						funcInfo = getFunc(line);
					} else {
						funcInfo = getFunc(line_pre);
					}
					func_self_bean.setFuncName(funcInfo.get(0));
					func_self_bean.setFuncReturn(funcInfo.get(1));
					for (int i = 2; i < funcInfo.size(); i++) {
						func_self_bean.addArgType(funcInfo.get(i));
					}
					func_self_bean.setPack(packName);
					func_self_bean.setClassName(className);
					func_self_beans.add(func_self_bean);
				}
				if (line.contains("{")) {
					stack.push('{');
				}
				if (line.contains("}") && !stack.empty()) {
					stack.pop();
				}
				line_pre = line;
			} while ((line = reader.readLine()) != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getFunc(String line) {
		ArrayList<String> funcInfo = new ArrayList<String>();
		int left = line.indexOf("(");
		int right = line.lastIndexOf(")");
		String[] nameReturn = line.substring(0, left).split(" ");
		funcInfo.add(nameReturn[nameReturn.length - 1]);
		if (!className.equals(nameReturn[nameReturn.length - 1])) {
			funcInfo.add(nameReturn[nameReturn.length - 2]);
		} else {
			funcInfo.add("Construct_Function");
		}
		if (right != (left + 1)) {
			String[] argInfos = line.substring(left + 1, right).split(",");
			for (String string : argInfos) {
				funcInfo.add(string.trim().substring(0,
						string.trim().indexOf(" ")));
			}
		}
		return funcInfo;
	}

	// public static void main(String[] args){
	//
	// JavaGraph gg = new JavaGraph();
	// gg.test();
	// }
	//
	// public void test(){
	// for(int i = 0; i<func_self_beans.size();i++ ){
	// func_self_beans.get(i).Print();
	// }
	// }

	// private String fileName;
	// private String classs_name;
	// private funcSelfBean func_self_bean;
	//
	// public JavaGraph(String path) {
	// fileName = path;
	// readFileByLine(fileName);
	// }
	//
	// public void readFileByLine(String fileName){
	//
	// File file = new File(fileName);
	// String[] head_str;
	//
	// BufferedReader reader;
	// try {
	// StringBuffer buffer = new StringBuffer();
	// String line = null;
	// InputStream is;
	// is = new FileInputStream(file.getAbsolutePath());
	// reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	// line = reader.readLine();
	// while (line != null && (!line.contains("}"))) {
	// buffer.append(line);
	// buffer.append("\r\n");
	// //得到类名
	// // System.out.println(line);
	// if(line.contains("class")){
	// head_str = line.split("\\s+");
	// for(int i=0; i<head_str.length ;i++){
	// if(head_str[i].equals("class")){
	// classs_name = head_str[i+1];
	// break;
	// }
	// }
	// }
	// else if(line.contains("(") && line.contains(")") ){
	// line.trim();
	// // System.out.println("***"+line);
	// func_self_bean = new funcSelfBean();
	// splitFunStr(line);
	// CallGragh.allJavaFuncsInfo.add(func_self_bean);
	// }
	//
	// line = reader.readLine();
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// //函数参数分离
	// public void splitFunStr(String funcString){
	// int args_num = 0;
	// String[] listt = funcString.split("[\\(\\)]");
	// String[] list1 = listt[0].split("\\s+");
	// if(list1[list1.length-1].equals("startActivity")){//????????????????????不止一个startActivity
	// func_self_bean.setClassName("");
	// }
	// else{
	// func_self_bean.setClassName(classs_name);
	// }
	//
	// func_self_bean.setFuncName(list1[list1.length-1]);
	// // System.out.println("函数名:"+list1[list1.length-1]);
	// if(list1.length == 1){
	// func_self_bean.setFuncReturn("_null");
	// }
	// else if( (list1[list1.length-2].equals("public") ) ||
	// (list1[list1.length-2].equals("private") ) ||
	// (list1[list1.length-2].equals("protected") ) ||
	// (list1[list1.length-2].equals("abstract") ) ||
	// (list1[list1.length-2].equals("interface") ) ||
	// (list1[list1.length-2].equals("static") ) ||
	// (list1[list1.length-2] == "final") )
	//
	// {
	// // System.out.println("返回类型: null");
	// func_self_bean.setFuncReturn("_null");
	// }
	// else{
	// // System.out.println("返回类型:"+list1[list1.length-2]);
	// func_self_bean.setFuncReturn(list1[list1.length-2]);
	// }
	//
	//
	// if(listt.length == 1){
	// // System.out.println("参数个数:0");
	// // System.out.println("参数:null");
	// func_self_bean.setFuncArgNum(0);
	// func_self_bean.addArgType("_null");
	// }
	// else if(listt[1].equals("")){
	// args_num = 0;
	// // System.out.println("参数个数:"+args_num);
	// // System.out.println("参数:null");
	// func_self_bean.setFuncArgNum(args_num);
	// func_self_bean.addArgType("_null");
	// }
	// else{
	// String[] list2 = listt[1].split(",");
	// String[] list22;
	// int args_count = 0;
	// args_num= list2.length;
	// // System.out.println("参数个数:"+args_num);
	// func_self_bean.setFuncArgNum(args_num);
	// for(int i=0;i<list2.length;i++){
	// if(list2[i]==""){
	// // System.out.println("参数:null");
	// func_self_bean.addArgType("_null");
	// }
	// else {
	// list2[i] = list2[i].trim();
	// list22 = list2[i].split("\\s+");
	// args_count = i+1;
	// if(list22.length>=2){
	// // System.out.println("参数"+args_count+":"+list22[list22.length-2]);
	// func_self_bean.addArgType(list22[list22.length-2]);
	// }
	// else{
	// func_self_bean.addArgType(list22[0]);
	// }
	// }
	// }
	// }
	// }

}
