package androidCallGragh;

import java.util.ArrayList;

public class funcInnerBean {
	
	private funcSelfBean func_self;
	private int func_inner_funcs_num = 0;
	private ArrayList<funcSelfBean> func_inner_funcs;
	
	private int C_func_inner_funcs_num = 0; 
	private ArrayList<String> C_func_inner_funcs;
	
	public funcInnerBean(){
		func_inner_funcs = new ArrayList<funcSelfBean>();
		C_func_inner_funcs = new ArrayList<String>();
		func_self = new funcSelfBean();
	}
	
	
	
	
	public void setFuncSelf(funcSelfBean temp){
		func_self = temp;
	}
	public void addFuncInnerFunc(funcSelfBean temp){
		func_inner_funcs.add(temp);
		func_inner_funcs_num++;
	}
	public void addCfuncInnerFuncs(String temp){
		C_func_inner_funcs.add(temp);
		C_func_inner_funcs_num++;
	}
	public funcSelfBean getFuncSelf(){
		return func_self;
	}
	
	public int getFuncInnerFuncsNum(){
		return func_inner_funcs_num;
	}
	
	public int getCFuncInnerFuncsNum(){
		return C_func_inner_funcs_num;
	}
	
	public ArrayList<funcSelfBean> getFunInnerFuncs(){
		return func_inner_funcs;
	}
	
	public ArrayList<String> getCfuncInnerFuncs(){
		return C_func_inner_funcs;
	}
	
	



}
