package bit_dec.dissambler;

import java.util.ArrayList;

public class DisFunction {

	private String funcAddr = "";
	private String funcName = "";
	private ArrayList<DisInst> instList;
	private long start;
	private long end;
	private ArrayList<DisBlock> blockList;
	
	/**
	 * Instruct
	 */
	public DisFunction(){
		instList = new ArrayList<DisInst>();
		blockList = new ArrayList<DisBlock>();
	}
	
	/**
	 * set
	 * @param temp
	 */
	public void setFunctionAddr(String temp){
		funcAddr = temp;
	}
	public void setFunctionName(String temp){
		funcName = temp;
	}
	public void addInstruction(DisInst temp){
		instList.add(temp);
	}
	public void setStart(long temp){
		start = temp;
	}
	public void setEnd(long temp){
		end = temp;
	}
	public void addBlock(DisBlock temp){
		blockList.add(temp);
	}
	public void equBlocklist(ArrayList<DisBlock> temp){
		blockList = temp;
	}
	
	/**
	 * get
	 * @return
	 */
	public String getFunctionAddr(){
		return funcAddr;
	}
	
	public String getFunctionName(){
		return funcName;
	}
	
	public ArrayList<DisInst> getInstructionList(){
		return instList;
	}
	public long getStart(){
		return start;
	}
	public long getEnd(){
		return end;
	}
	public ArrayList<DisBlock> getBlocklist(){
		return blockList;
	}
}

