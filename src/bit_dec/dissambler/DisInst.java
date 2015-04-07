package bit_dec.dissambler;

import java.util.ArrayList;

public class DisInst {
	private String addr = "";
	private String binary = "";
	private String op = "";
	private ArrayList<String> argList;
	private String instLine ="";
	private long index;
	private boolean head = false;
	private boolean tail = false;
	
	
	/**
	 * Instruct
	 */
	public DisInst(){
		argList = new ArrayList<String>();
	}
	
	/**
	 * Set
	 * @param temp
	 */
	public void setAddr(String temp){
		addr = temp;
	}
	public void setBinCode(String temp){
		binary = temp;
	}
	public void setAssCode(String temp){
		op = temp;
	}
	public void addArgs(String temp){
		argList.add(temp);
	}
	public void  setInstructionLine(String temp) {
		instLine = temp;
	}
	public void  setIndex(long temp) {
		index = temp;
	}
	public void setHead(){
		head = true;
	}
	public void setTail(){
		tail = true;
	}
	/**
	 * Get
	 * @return
	 */
	public String getAddr(){
		return addr;
	}
	public String getBinCode(){
		return binary;
	}
	public String getAssCode(){
		return op;
	}
	public ArrayList<String> getArgsList(){
		return argList;
	}
	public String getInstructionLine(){
		return instLine;
	}
	public long getIndex(){
		return index;
	}
	public boolean isHead(){
		return head;
	}
	public boolean isTail(){
		return tail;
	}
	
}
