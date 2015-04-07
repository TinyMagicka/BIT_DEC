package androidCallGragh;

import java.awt.print.Printable;
import java.util.ArrayList;

public class funcSelfBean {

	private String pack;
	private String className;
	private String func_name;
	private String func_return;
	private int func_arg_num;
	private ArrayList<String> func_arg_type;
	
	
	public funcSelfBean() {
		// TODO Auto-generated constructor stub
		func_arg_type = new  ArrayList<String>();
	}
	
	public funcSelfBean(String temp1,String temp2) {
		// TODO Auto-generated constructor stub
		func_name = temp1;
		func_return = temp2;
		func_arg_num = 0;
		func_arg_type = new  ArrayList<String>();
	}
	
	
	public funcSelfBean(String temp1,String temp2,ArrayList<String> temp3) {
		// TODO Auto-generated constructor stub
		func_name = temp1;
		func_return = temp2;
		func_arg_type = new  ArrayList<String>();
		func_arg_type = temp3;
		func_arg_num = func_arg_type.size();
	}
	
	public funcSelfBean(String temp1,String temp2,ArrayList<String> temp3,String temp4) {
		// TODO Auto-generated constructor stub
		func_name = temp1;
		func_return = temp2;
		func_arg_type = new  ArrayList<String>();
		func_arg_type = temp3;
		//func_arg_num = func_arg_type.size();
		className = temp4;
	}
	
	
	
	// set private
	public void setFuncName(String temp){
		func_name = temp;
	}
	
	public void setFuncReturn(String temp){
		func_return = temp;
	}
	
	public void setFuncArgNum(int temp){
		func_arg_num = temp;
	}
	public void setPack(String temp){
		pack = temp;
	}
	public void setClassName(String temp){
		className = temp;
	}
	
	//add arg type
	public void addArgType(String temp){
		func_arg_type.add(temp);
		func_arg_num++;
	}
	
	
	
	//get private
	
	public String getFunName(){
		return func_name;
	}
	
	public String getFuncReturn(){
		return func_return;
	}
	public int getFuncArgNum(){
		return func_arg_num;
	}
	public String getPack(){
		return pack;
	}
	public String getClassName(){
		return className;
	}
	public ArrayList<String> getFuncArgType(){
		return func_arg_type;
	}
	
	
	public void Print(){
		System.out.println("=======================================");
		System.out.println(" Package: " + this.pack);
		System.out.println("   Class: " + this.className);
		System.out.println("Function: " + this.func_name);
		System.out.println("  Return: " + this.func_return);
		System.out.println("    Args: " + this.func_arg_type);
	}

}
