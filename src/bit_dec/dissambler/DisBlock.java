package bit_dec.dissambler;

import java.util.ArrayList;

public class DisBlock {
	private int start = 0;
	private int end = 0;
	private ArrayList<Integer> preBlockSet= new ArrayList<Integer>();
	private ArrayList<Integer> subBlockSet= new ArrayList<Integer>();
	private String startAddr;
	
	public DisBlock(){
	}
	
	public void setStart(int temp){
		start = temp;
	}
	public void setEnd(int temp){
		end = temp;
	}
	public void addPreBlockIndex(Integer temp){
		preBlockSet.add(temp);
	}
	public void addSubBlockIndex(Integer temp){
		subBlockSet.add(temp);
	}
	public void setStartAddr(String temp){
		startAddr = temp;
	}
	
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
	public ArrayList<Integer> getPreBlockSet(){
		return preBlockSet;
	}
	public ArrayList<Integer> getSubBlockSet(){
		return subBlockSet;
	}
	public String getStartAddr(){
		return startAddr;
	}
}
