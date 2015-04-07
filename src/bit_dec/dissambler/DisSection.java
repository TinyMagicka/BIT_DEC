package bit_dec.dissambler;

import java.util.ArrayList;

public class DisSection {
	public final static int ELF_SECTION_TEXT = 0;
	public final static int ELF_SECTION_DATA = 1;
	public final static int ELF_SECTION_BSS  = 1;
	
	private String name = "";
	private int type;
	private ArrayList<DisFunction> funcList;
	private long start;
	private long end;
	
	/**
	 * Instruct
	 */
	public DisSection(){
		funcList = new ArrayList<DisFunction>();
	}
	
	/**
	 * Set
	 * @param temp
	 */
	public void setName(String temp) {
		name = temp;
	}
	public void setType(int temp){
		type = temp;
	}
	public void addFunctionList(DisFunction functionname){
		funcList.add(functionname);
	}
	public void setStart(long temp){
		start = temp;
	}
	public void setEnd(long temp){
		end = temp;
	}
	
	/**
	 * Get
	 * @return
	 */
	public String getNmae(){
		return name;
	}
	public int getType(){
		return type;
	}
	public ArrayList<DisFunction> getFunctionList(){
		return funcList;
	}
	public long getStart(){
		return start;
	}
	public long getEnd(){
		return end;
	}
	
}
