package decompiler;

public abstract class Decompiler {
	abstract public void machineAnalysis();
	abstract public void typeAnalysis();
	abstract public void convertToIntermediateCode();
	//-----------------------------------------------------
	public void structAnalysis(){
		
	}
	public void callGraphAnalysis(){
		
	}
	public void optimize(){
		
	}
	//------------------------------------------------------
	abstract public void codeGen();
}
