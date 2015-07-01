package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;






import bit_dec.dissambler.DisBlock;
import bit_dec.dissambler.DisFunction;
import bit_dec.dissambler.DisInst;
import bit_dec.dissambler.DisSection;
public class ObjDumpParser extends BinaryPaser {

	public static ArrayList<DisSection> sectiton_Stack = new ArrayList<DisSection>();
	static ArrayList<DisFunction> function_Stack = new ArrayList<DisFunction>();
	static ArrayList<DisInst> instruction_Stack = new ArrayList<DisInst>();
	/**
	 * generate assembler data
	 * @param pathnamehghg
	 */
	public void generateAssembler(String pathname) {
		
		
		
		sectiton_Stack.clear();
		function_Stack.clear();
		instruction_Stack.clear();
		
		String encodeing = "GBK";
		long index = 0;
		File file = new File(pathname);
		String lineTxtString = "";

		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encodeing);
			BufferedReader bufferedReader = new BufferedReader(read);
			int flag = 0;
			while ((lineTxtString = bufferedReader.readLine()) != null) {
				// Disassembler of section
				index++;
				if (lineTxtString.contains("Disassembly of section")) {
					flag = 0;
					DisSection section__temp = new DisSection();
					String nameString = lineTxtString.substring(
							lineTxtString.indexOf("."),
							lineTxtString.indexOf(":"));
					section__temp.setName(nameString);
					section__temp.setStart(index);
					int size1;
					if ((size1 = sectiton_Stack.size()) != 0) {
						sectiton_Stack.get(size1 - 1).setEnd(index);
					}
					if ((size1 = function_Stack.size()) != 0) {
						function_Stack.get(size1 - 1).setEnd(index - 1);
					}

					if (instruction_Stack.size() != 0) {
						for (int i = 0; i < instruction_Stack.size(); i++) {
							function_Stack.get(function_Stack.size() - 1)
									.addInstruction(instruction_Stack.get(i));
						}
						instruction_Stack.clear();
					}
					if (sectiton_Stack.size() != 0) {
						int function_Stack_size = function_Stack.size();
						DisSection top_section = sectiton_Stack
								.get(sectiton_Stack.size() - 1);
						for (int i = 0; i < function_Stack_size; i++) {
							top_section.addFunctionList(function_Stack.get(i));
						}
						function_Stack.clear();
					}
					sectiton_Stack.add(section__temp);
				} else if (lineTxtString.endsWith(">:")) {
					flag = 0;
					DisFunction function_temp = new DisFunction();
					String nameString = lineTxtString.substring(
							lineTxtString.indexOf("<") + 1,
							lineTxtString.indexOf(">:"));
					String addrString = lineTxtString.split(" ")[0];
					function_temp.setFunctionName(nameString);
					function_temp.setFunctionAddr(addrString);
					function_temp.setStart(index);
					int size1 = function_Stack.size();
					if (size1 != 0) {
						function_Stack.get(size1 - 1).setEnd(index - 1);
					}

					if (function_Stack.size() != 0) {
						int instruction_Stack_size = instruction_Stack.size();
						DisFunction top_function = function_Stack
								.get(function_Stack.size() - 1);
						for (int i = 0; i < instruction_Stack_size; i++) {
							top_function.addInstruction(instruction_Stack
									.get(i));
						}
						instruction_Stack.clear();
					}
					function_Stack.add(function_temp);
				} else if ((!lineTxtString.contains("..."))
						&& (!lineTxtString.contains("file format"))
						&& (!lineTxtString.equals(""))) {
					if(flag == 1){
						continue;
					}
					DisInst instruction_temp = new DisInst();
					instruction_temp.setInstructionLine(lineTxtString);
					instruction_temp.setIndex(index);
					// ========================================================
					//指令特征提取
					
					if(lineTxtString.contains(";")){
						int pos = lineTxtString.indexOf(";");
						lineTxtString = lineTxtString.substring(0, pos);
					}
					lineTxtString = lineTxtString.trim();
					int pos = lineTxtString.indexOf(":");
					
					String addr = lineTxtString.substring(0, pos);
					instruction_temp.setAddr(addr);
					lineTxtString = lineTxtString.substring(pos+1).trim();
					try{
						pos = lineTxtString.indexOf("\t");
						String bin_code = lineTxtString.substring(0,pos);
						instruction_temp.setBinCode(bin_code);
						lineTxtString = lineTxtString.substring(pos+1).trim();
						if(lineTxtString.indexOf("\t")>0)
							pos = lineTxtString.indexOf("\t");
						else {
							pos = lineTxtString.indexOf(" ");
						}
						
						String ass_code = lineTxtString.substring(0,pos);
						instruction_temp.setAssCode(ass_code);
						lineTxtString = lineTxtString.substring(pos+1).trim();
						String arg[] = lineTxtString.split(",");
						if(arg[0].contains("<")&&arg[0].contains(">")){
							String arg1[] = lineTxtString.split(" ");
							instruction_temp.addArgs(arg1[0].trim());
						}
						else{
							instruction_temp.addArgs(arg[0].trim());
						}
						for(int n=1;n<arg.length;n++){
							instruction_temp.addArgs(arg[n].trim());
						}
						//删除pop后面的函数数据段
						if(ass_code.equals("pop")){
							flag = 1;
						}
					}catch(Exception e){}
					// ==========================================================
					instruction_Stack.add(instruction_temp);
				}
			}
			if (instruction_Stack.size() != 0) {
				for (int i = 0; i < instruction_Stack.size(); i++) {
					function_Stack.get(function_Stack.size() - 1)
							.addInstruction(instruction_Stack.get(i));
				}
				instruction_Stack.clear();
			}
			if (function_Stack.size() != 0) {
				for (int i = 0; i < function_Stack.size(); i++) {
					sectiton_Stack.get(sectiton_Stack.size() - 1)
							.addFunctionList(function_Stack.get(i));
				}
				function_Stack.clear();
			}

			read.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * output assembler data
	 */
	public void PrintAssembler() {

		int section_stack_size = sectiton_Stack.size();
		try {

			for (int i = 0; i < section_stack_size; i++) {

				DisSection section_temp = sectiton_Stack.get(i);
				ArrayList<DisFunction> function_list = section_temp
						.getFunctionList();
				int function_stack_size = function_list.size();
				System.out
						.println("================================================================================");
				System.out.println(section_temp.getStart() + ":"
						+ section_temp.getNmae());
				System.out.println(section_temp.getEnd() + ":"
						+ section_temp.getNmae());
				System.out
						.println("================================================================================");

				for (int j = 0; j < function_stack_size; j++) {

					DisFunction function_temp = function_list.get(j);
					ArrayList<DisInst> instruction_list = function_temp
							.getInstructionList();
					int instruction_stack_size = instruction_list.size();


					System.out.println("++++++++++++++++++++++++++++++++++++");
					System.out.println(function_temp.getStart() + ":"
							+ function_temp.getFunctionName());
					System.out.println(function_temp.getEnd() + ":"
							+ function_temp.getFunctionName());
					System.out.println("++++++++++++++++++++++++++++++++++++");
					for (int k = 0; k < instruction_stack_size; k++) {
						if(instruction_list.get(k).getAssCode().contains("b")){
							System.out.println(instruction_list.get(k).getIndex()
								+ ":"
								+ instruction_list.get(k).getInstructionLine());
						}
						
					}
				}
			}

		} catch (Exception e) {
		}
		AllBblockGen();
		//PrintBlock();
	}
	
	
	/**
	 * Basic Block Generate
	 */
	public void AllBblockGen(){
		
		ArrayList<DisFunction> func_list = getTextFunList();
		int func_list_size = func_list.size();
		for(int i=0;i<func_list_size;i++){
			MarkBhead(func_list.get(i));
		}
		for(int i=0;i<func_list_size;i++){
			BblockGen(func_list.get(i),i);
		}
	}
	
	public void MarkBhead(DisFunction curFunc){
		
		ArrayList<DisInst>ins_list = curFunc.getInstructionList();
		long ins_list_size = ins_list.size();
		//？？[ 'i' may be out of bounds ]？？
		//(0)====
		String first_addr = ins_list.get(0).getAddr();
		setBlockStart(first_addr,getInsParent(first_addr));
		for(int i=0;i<ins_list_size;i++){
			DisInst ins = ins_list.get(i);
			String op = ins.getAssCode();
			if( op.startsWith("blx")||
				op.startsWith("bl") ||
				op.startsWith("bx") ||
				op.startsWith("b")){
				//(2)=====
				if(i<(ins_list_size-1)){
					String sec_addr = ins_list.get(i+1).getAddr();
					setBlockStart(sec_addr,getInsParent(sec_addr));
				}
				ArrayList<String> arg = ins.getArgsList();
				//(3)=====
				if((arg.size()>0)&&(!arg.get(0).contains("r"))){
					String thir_addr = arg.get(0);
					//跳转地址在text section 中时
					insParent insp;
					if((insp = getInsParent(thir_addr))!=null){
						setBlockStart(thir_addr,insp);
					}
				}
			}
		}
	}
	
	class BlockSeqAddr{
		public String addrString;
		public int seqIndexl;
	}
	
	public void BblockGen(DisFunction curFunc,int func_index){
		ArrayList<BlockSeqAddr> block_squen_Stack = new ArrayList<BlockSeqAddr>();
		ArrayList<DisInst> ins_list = curFunc.getInstructionList();
		int ins_list_size = ins_list.size();
		for(int i=0;i<ins_list_size;i++){
			DisInst ins = ins_list.get(i);
			if(ins.isHead()){
				BlockSeqAddr bsa = new BlockSeqAddr();
				bsa.seqIndexl = i;
				bsa.addrString = ins.getAddr();
				block_squen_Stack.add(bsa);
			}
		}
		int block_squen_Stack_size = block_squen_Stack.size();
		
		for(int i=0;i<block_squen_Stack_size;i++){
			DisBlock block_temp = new DisBlock();
			block_temp.setStart(block_squen_Stack.get(i).seqIndexl);
			block_temp.setStartAddr(block_squen_Stack.get(i).addrString);
			if((i+1)==block_squen_Stack_size){
				block_temp.setEnd(ins_list_size-1);
			}
			else
				block_temp.setEnd(block_squen_Stack.get(i+1).seqIndexl-1);
			addBlock(func_index,block_temp);
		}
	
	}
	
	public void PrintBlock() throws IOException{
		
		FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\2.txt");
        BufferedWriter bw = new BufferedWriter(fw);
       
       
		ArrayList<DisFunction> func_list = getTextFunList();
		int func_list_size = func_list.size();
		for(int i=0;i<func_list_size;i++){
			bw.write("===========================================");
	        bw.newLine();
	        bw.flush();
	        DisFunction func = func_list.get(i);
	        bw.write(func.getFunctionName());
	        bw.newLine();
	        bw.flush();
	        bw.write("===========================================");
	        bw.newLine();
	        bw.flush();
			ArrayList<DisInst> ins_list = func.getInstructionList();
			ArrayList<DisBlock> block_list = func.getBlocklist();
			int block_num = block_list.size();
			for(int j=0;j<block_num;j++){
				bw.write("*****************:"+j);
		        bw.newLine();
		        bw.flush();
				int start = block_list.get(j).getStart();
				int end = block_list.get(j).getEnd();
				for(int k=start;k<=end;k++){
					bw.write(ins_list.get(k).getInstructionLine());
			        bw.newLine();
			        bw.flush();
				}
			}
		}
		 bw.close();
		 fw.close();
	}
  
	/**
	 * Control fluid Graph Generate
	 */
	public void CfgGen(String funcName){
		
		String[] CondIns = {"beq","bne","bhs","bcs","blo","bcc",
							"bmi","bpl","bvs","bvc","bhi","bls",
							"bge","blt","bgt","ble","blx"};
		
		DisFunction func;
		func = getFuncByName(funcName);
		if(func ==null)
			return;
		ArrayList<DisBlock> block_list = func.getBlocklist();
		ArrayList<DisInst> ins_list = func.getInstructionList();
		int block_list_size = block_list.size();
		
		for(int i=0;i<block_list_size;i++){
			DisBlock block = block_list.get(i);
			int block_end = block.getEnd();
			DisInst last_ins = ins_list.get(block_end);
			String last_ass_code = last_ins.getAssCode();
			
			if(last_ass_code.startsWith("b")){
				for(int k=0;k<block_list_size;k++){
					DisBlock jumped_block = block_list.get(k);
					if(jumped_block.getStartAddr().equals(last_ins.getArgsList().get(0))){
						block_list.get(i).addSubBlockIndex(k);
						block_list.get(k).addPreBlockIndex(i);
						break;
					}
				}
				if((i+1)<block_list_size){
					int CondInsNum = CondIns.length;
					for(int ii=0;ii<CondInsNum;ii++){
						if(last_ass_code.startsWith(CondIns[ii])){
							block_list.get(i).addSubBlockIndex(i+1);
							block_list.get(i+1).addPreBlockIndex(i);
							break;
						}
					}
				}
			}
			else{
				if((i+1)<block_list_size){
					block_list.get(i).addSubBlockIndex(i+1);
					block_list.get(i+1).addPreBlockIndex(i);
				}
			}
		}
		updateBlockList(func,block_list);
	}
	

	//=================================
	//链表函数的相关操作
	//=================================
	
	//得到text section
	public DisSection getTextSection(){
		int sectionlist_size = sectiton_Stack.size();
		for(int i=0;i<sectionlist_size;i++){
			if(sectiton_Stack.get(i).getNmae().equals(".text")){
				return sectiton_Stack.get(i);
			}
		}
		return null;
	}
	//得到text section的位置
	public int getTextSecitonIndex(){
		int sectionlist_size = sectiton_Stack.size();
		for(int i=0;i<sectionlist_size;i++){
			if(sectiton_Stack.get(i).getNmae().equals(".text")){
				return i;
			}
		}
		return 0;
	}
	//得到text section function list
	public ArrayList<DisFunction> getTextFunList(){
		DisSection text_section;
		text_section = getTextSection();
		return text_section.getFunctionList();
	}
	//设置地址为xx的指令为基本块起始位置
	//先要判断在text section中，及得到其parent
	public void setBlockStart(String addr,insParent insp){
		int sectipn_p = insp.section_p;
		int function_p = insp.function_p;
		int ins_p = insp.ins_p;
		sectiton_Stack.get(sectipn_p).getFunctionList().get(function_p)
		.getInstructionList().get(ins_p).setHead();
	}
	class insParent{
		public int section_p;
		public int function_p;
		public int ins_p;
	}
	//得到指定指令xx的parent(text-section_p,function_p,ins_p)
	//返回null则说明不在text section中
	public insParent getInsParent(String addr){
		ArrayList<DisFunction> func_list = getTextFunList();
		int function_list_size = func_list.size();
		for(int i=0;i<function_list_size;i++){
			DisFunction text_function = func_list.get(i);
			ArrayList<DisInst> ins_list = text_function.getInstructionList();
			int ins_list_size = ins_list.size();
			for(int j=0;j<ins_list_size;j++){
				if(ins_list.get(j).getAddr().equals(addr)){
					insParent insp = new insParent();
					insp.section_p = getTextSecitonIndex();
					insp.function_p = i;
					insp.ins_p = j;
					return insp;
				}
			}
		}
		return null;
	}
	//给指定函数添加基本块
	public void addBlock(int func_index,DisBlock block_temp){
		int text_sec_index = getTextSecitonIndex();
		sectiton_Stack.get(text_sec_index).getFunctionList()
		.get(func_index).addBlock(block_temp);
	}
	//根据函数名称得到函数
	public DisFunction getFuncByName(String funcName){
		ArrayList<DisFunction> func_list = getTextFunList();
		int func_list_size = func_list.size();
		for(int i=0;i<func_list_size;i++){
			DisFunction func = func_list.get(i);
			if(func.getFunctionName().equals(funcName)){
				return func;
			}
		}
		return null;
	}
	//更新block_list
	public void updateBlockList(DisFunction func,ArrayList<DisBlock> block_list){
		String funcName = func.getFunctionName();
		int section_text_index = getTextSecitonIndex();
		ArrayList<DisFunction> func_list = getTextFunList();
		int func_list_size = func_list.size();
		int i;
		for(i=0;i<func_list_size;i++){
			DisFunction func_temp = func_list.get(i);
			if(func_temp.getFunctionName().equals(funcName)){
				break;
			}
		}
		sectiton_Stack.get(section_text_index).getFunctionList().get(i).equBlocklist(block_list);
	}
	
	//
}
