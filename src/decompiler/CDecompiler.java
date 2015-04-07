package decompiler;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import androidCallGragh.CallGragh;
import androidCallGragh.funcSelfBean;
import bit_dec.dissambler.DisBlock;
import bit_dec.dissambler.DisFunction;
import bit_dec.dissambler.DisInst;
import bit_dec.views.AdvancedCodeView;
import parser.ObjDumpParser;

public class CDecompiler extends Decompiler {

	ObjDumpParser objdump = new ObjDumpParser();
	private ArrayList<Integer> vertices;
	private ArrayList<ArrayList<Integer>> adjacentTable;
	private CDecompiler copyedG;
	private ArrayList<nodeinfo> treeList;
	private ArrayList<VarNode> V1;
	static ArrayList<VarNode> P;
	private AdvancedCodeView myView;
	private DisFunction func;
	private ArrayList<DisBlock> block_list;

	public void cfgAna(String funcName) {

		vertices = new ArrayList<Integer>();
		adjacentTable = new ArrayList<ArrayList<Integer>>();
		treeList = new ArrayList<nodeinfo>();

		objdump.CfgGen(funcName);
		func = objdump.getFuncByName(funcName);
		if (func == null)
			return;

		block_list = func.getBlocklist();
		int block_list_size = block_list.size();
		for (int i = 0; i < block_list_size; i++) {
			addVertex(i);
			DisBlock block = block_list.get(i);
			ArrayList<Integer> subBlockSet = block.getSubBlockSet();
			int subBlockNum = subBlockSet.size();
			for (int j = 0; j < subBlockNum; j++) {
				addEdge(i, subBlockSet.get(j));
			}
		}
		copyedG = makeACopy();
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IViewPart viewPart = page.findView("BIT_DEC.advanced_code");
		myView = (AdvancedCodeView) viewPart;
		myView.init();
		// ================变量类型分析======================
		if (funcName.contains("Java_")) {
			funcName = funcName.substring(funcName.lastIndexOf("_") + 1);
			System.out.println("JNI函数：" + funcName);
		}
		String argliststr = "";
		String headstr = "";
		try {
			int javafuncs_size = CallGragh.allJavaFuncsInfo.size();
			for (int i = 0; i < javafuncs_size; i++) {
				funcSelfBean funcSelfBean = CallGragh.allJavaFuncsInfo.get(i);
				String callfuncName = funcSelfBean.getFunName();
				if (callfuncName.equals(funcName)) {
					String returnString = funcSelfBean.getFuncReturn();
					ArrayList<String> arglist = funcSelfBean.getFuncArgType();
					int arglist_size = arglist.size();
					headstr = returnString + " " + funcName + " (";
					for (int k = 0; k < arglist_size; k++) {
						int k1 = k + 2;
						argliststr = argliststr + arglist.get(k) + " r" + k1
								+ " ";
						if (k == (arglist_size - 1)) {
							headstr = headstr + arglist.get(k) + " r" + k1
									+ "){";
						} else {
							headstr = headstr + arglist.get(k) + " r" + k1
									+ ", ";
						}
					}
					System.out.println(headstr);
					System.out.println(argliststr);
					break;
				}
			}
			myView.showConten(headstr + "\n\r\n\r", 0);
			typeAnalysis1(argliststr);
			// ================打印变量 =========================
			printVars();
			// ================规约形成树 ======================
			reduce(this);
		} catch (NullPointerException e) {
			MessageDialog.openInformation(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "提示",
					"请先进行callGraph操作");
			return;
		}
	}

	/*
	 * 判断是否进行了call graph操作
	 */
	public boolean judgeCallGraphed() {

		return true;
	}

	/*
	 * 归约形成树
	 */
	public void reduce(CDecompiler g) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> vlist = new ArrayList<Integer>();
		int currPos = 0;
		boolean changed = true;
		while (this.vertices.size() > 1) {
			if (changed) {
				visited.clear();
				vlist.clear();
				getPostOrder(g, 0, vlist, visited);
				currPos = 0;
				changed = false;
			} else if (currPos >= vlist.size() && !changed) {
				break;
			}
			int v = vlist.get(currPos);
			ArrayList<Integer> toList = g.getToList(v);
			// test if it is a sequential path
			if (toList.size() == 1) {
				ArrayList<Integer> fromList = g.getFromList(toList.get(0));
				if (fromList.size() == 1) {
					ArrayList<Integer> toList2 = g.getToList(toList.get(0));
					for (int node : toList2) {
						g.addEdge(v, node);
						g.removeEdge(toList.get(0), node);
					}
					g.removeEdge(v, toList.get(0));
					g.removeVertex(toList.get(0));
					// =================
					nodeinfo node1 = new nodeinfo();
					node1.type = "seq";
					node1.childlist.add(v);
					node1.childlist.add(toList.get(0));
					treeList.add(node1);
					// =================
					changed = true;
				}
			}
			// test if it is an "if"
			else if (toList.size() == 2) {
				// if-else ?
				ArrayList<Integer> fromList0 = g.getFromList(toList.get(0));
				ArrayList<Integer> fromList1 = g.getFromList(toList.get(1));
				if (fromList0.size() == 1 && fromList1.size() == 1) {
					ArrayList<Integer> toList0 = g.getToList(toList.get(0));
					ArrayList<Integer> toList1 = g.getToList(toList.get(1));
					if (toList0.size() == 1 && toList1.size() == 1) {
						if (toList0.get(0) == toList1.get(0)) {
							g.removeEdge(v, toList.get(0));
							g.removeEdge(v, toList.get(1));
							g.removeEdge(toList.get(0), toList0.get(0));
							g.removeEdge(toList.get(1), toList1.get(0));
							g.addEdge(v, toList0.get(0));
							g.removeVertex(toList.get(0));
							g.removeVertex(toList.get(1));
							g.removeVertex(toList1.get(0));
							changed = true;
							// ==================
							nodeinfo node = new nodeinfo();
							node.type = "if";
							node.childlist.add(v);
							node.childlist.add(toList.get(0));
							node.childlist.add(toList.get(1));
							treeList.add(node);

							nodeinfo node1 = new nodeinfo();
							node1.type = "seq";
							node1.childlist.add(v);
							node1.childlist.add(toList0.get(0));
							treeList.add(node1);
							// ==================
						}
					} else if (toList0.size() == 0 && toList1.size() == 0) {
						g.removeEdge(v, toList.get(0));
						g.removeEdge(v, toList.get(1));
						g.removeVertex(toList.get(0));
						g.removeVertex(toList.get(1));
						changed = true;
						// ==============
						nodeinfo node = new nodeinfo();
						node.type = "if";
						node.childlist.add(v);
						node.childlist.add(toList.get(0));
						node.childlist.add(toList.get(1));
						treeList.add(node);
						// ==============
					}
				} else if (fromList0.size() == 1) {
					ArrayList<Integer> toList0 = g.getToList(toList.get(0));
					if (toList0.size() == 1 && toList0.get(0) == toList.get(1)) {
						g.removeEdge(v, toList.get(0));
						g.removeEdge(toList.get(0), toList.get(1));
						g.removeVertex(toList.get(0));
						changed = true;
						// ==============
						nodeinfo node = new nodeinfo();
						node.type = "seq";
						node.childlist.add(v);
						node.childlist.add(toList.get(0));
						treeList.add(node);

						nodeinfo node1 = new nodeinfo();
						node1.type = "seq";
						node1.childlist.add(v);
						node1.childlist.add(toList.get(1));
						treeList.add(node1);
						// ==============
					}
				} else if (fromList1.size() == 1) {
					ArrayList<Integer> toList1 = g.getToList(toList.get(1));
					if (toList1.size() == 1 && toList1.get(0) == toList.get(0)) {
						g.removeEdge(v, toList.get(1));
						g.removeEdge(toList.get(1), toList.get(0));
						g.removeVertex(toList.get(1));
						changed = true;
						// ==============
						nodeinfo node = new nodeinfo();
						node.type = "seq";
						node.childlist.add(v);
						node.childlist.add(toList.get(1));
						treeList.add(node);

						nodeinfo node1 = new nodeinfo();
						node1.type = "seq";
						node1.childlist.add(v);
						node1.childlist.add(toList.get(0));
						treeList.add(node1);
						// ==============
					}
				}
			}
			ArrayList<Integer> fromList = g.getFromList(v);
			// test if it is a "loop"
			if (fromList.size() == 1) {
				if (g.hasEdge(fromList.get(0), v)
						&& g.hasEdge(v, fromList.get(0))) {
					if (g.outDegree(fromList.get(0)) == 2
							&& g.outDegree(v) == 1) {
						g.removeEdge(v, fromList.get(0));
						g.removeEdge(fromList.get(0), v);
						g.removeVertex(v);
						changed = true;
						// ==============
						nodeinfo node = new nodeinfo();
						node.type = "while";
						node.childlist.add(fromList.get(0));
						node.childlist.add(v);
						treeList.add(node);
						// ==============
					} else if (g.outDegree(v) == 2
							&& g.outDegree(fromList.get(0)) == 1) {
						g.removeEdge(v, fromList.get(0));
						changed = true;
						// ==============
						nodeinfo node = new nodeinfo();
						node.type = "while";
						node.childlist.add(v);
						node.childlist.add(fromList.get(0));
						treeList.add(node);
						// ==============
					}
				}
			}
			currPos += 1;
		}
		codeGen1(0, 0);
		myView.showConten("}", 0);
	}

	/*
	 * 高级代码生成
	 */
	public boolean codeGen1(int index, int step) {
		nodeinfo root = getBranchNode(index);

		if (root == null) {
			return true;
		} else {
			switch (root.type) {
			case "seq": {
				// 当是叶子节点时
				if (codeGen1(root.childlist.get(0), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(0));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten(highCodeList.get(i).highstring
								+ ";\n\r", step);
					}
					System.out.println(root.childlist.get(0) + ";");
				}
				if (codeGen1(root.childlist.get(1), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(1));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten(highCodeList.get(i).highstring
								+ ";\n\r", step);
					}
					System.out.println(root.childlist.get(1) + ";");
				}
				break;
			}
			case "if": {
				if (codeGen1(root.childlist.get(0), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(0));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						if (highCodeList.get(i).hightype.equals("cmp")) {
							myView.showConten(
									"if(" + highCodeList.get(i).highstring
											+ "){\n\r", step);
						} else {
							myView.showConten(highCodeList.get(i).highstring
									+ ";\n\r", step);
						}

					}
					System.out.println("if(" + root.childlist.get(0) + "){");
				}
				if (codeGen1(root.childlist.get(1), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(1));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten(highCodeList.get(i).highstring
								+ ";\n\r", step);
					}

					System.out.println(root.childlist.get(1) + ";");
				}
				myView.showConten("}\n\r", step);
				System.out.println("}");
				myView.showConten("else{\n\r", step);
				System.out.println("else{");
				if (codeGen1(root.childlist.get(2), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(2));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten(highCodeList.get(i).highstring
								+ ";\n\r", step);
					}
					System.out.println(root.childlist.get(2) + ";");
				}
				myView.showConten("}\n\r", step);
				System.out.println("}");
				break;
			}
			case "while": {
				if (codeGen1(root.childlist.get(0), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(0));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten("while("
								+ highCodeList.get(i).highstring + "){\n\r",
								step);
					}
					System.out.println("while(" + root.childlist.get(0) + "){");
				}
				if (codeGen1(root.childlist.get(1), ++step) == true) {
					ArrayList<highcode> highCodeList = block2code(root.childlist
							.get(1));
					int listsize = highCodeList.size();
					for (int i = 0; i < listsize; i++) {
						myView.showConten(highCodeList.get(i).highstring
								+ ";\n\r", step);
					}
					System.out.println(root.childlist.get(1) + ";");
				}
				myView.showConten("}\n\r", step);
				System.out.println("}");
				break;
			}
			}
			return false;
		}
	}

	/*
	 * 只针对基本块中的语句转为高级代码
	 */
	public ArrayList<highcode> block2code(int blockIndex) {
		ArrayList<highcode> highCodeList = new ArrayList<highcode>();

		ArrayList<DisInst> Inslist = func.getInstructionList();
		DisBlock block = block_list.get(blockIndex);
		int start = block.getStart();
		int end = block.getEnd();
		for (int i = start; i <= end; i++) {
			DisInst inst = Inslist.get(i);
			String opString = inst.getAssCode();
			switch (opString) {
			case "cmp": {
				DisInst inst_next = Inslist.get(i + 1);
				String op_nextString = inst_next.getAssCode();
				ArrayList<String> argsList = inst.getArgsList();
				highcode high = new highcode();
				if (op_nextString.startsWith("bne")) {
					String arg0 = argsList.get(0);
					String arg1 = argsList.get(1);
					high.highstring = arg0 + "!=" + arg1;
					high.hightype = "cmp";
					highCodeList.add(high);
				} else if (op_nextString.startsWith("blt")) {
					String arg0 = argsList.get(0);
					String arg1 = argsList.get(1);
					high.highstring = arg0 + "<" + arg1;
					high.hightype = "cmp";
					highCodeList.add(high);
				}

				break;
			}
			case "adds": {
				ArrayList<String> argsList = inst.getArgsList();
				highcode high = new highcode();
				if (argsList.size() == 3) {
					String arg0 = argsList.get(0);
					String arg1 = argsList.get(1);
					String arg2 = argsList.get(2);
					high.highstring = arg0 + "=" + arg1 + "+" + arg2;
					high.hightype = "adds";
					highCodeList.add(high);
				} else {
					String arg0 = argsList.get(0);
					String arg1 = argsList.get(1);
					high.highstring = arg0 + "=" + arg0 + "+" + arg1;
					high.hightype = "adds";
					highCodeList.add(high);
				}
				break;
			}
			default:
				break;
			}
		}
		return highCodeList;
	}

	/*
	 * 变量类型分析
	 */
	public void typeAnalysis1(String argString) {
		ArrayList<Node> L = new ArrayList<Node>();

		ArrayList<DisInst> instList = new ArrayList<DisInst>();
		instList = func.getInstructionList();
		int instListSize = instList.size();
		for (int i = 0; i < instListSize; i++) {
			Node node = new Node();
			DisInst inst = instList.get(i);
			node.opString = inst.getAssCode();
			ArrayList<String> arglist = inst.getArgsList();
			int arglistsize = arglist.size();
			for (int j = 0; j < arglistsize; j++) {
				node.argsList.add(arglist.get(j));
			}
			L.add(node);
		}

		V1 = new ArrayList<VarNode>();
		P = new ArrayList<VarNode>();
		String temp[] = argString.split(" ");
		for (int i = 0; i < temp.length; i++) {
			VarNode var = new VarNode();
			var.T.add(temp[i++]);
			var.name = temp[i];
			P.add(var);
		}
		// ============参数收集=============
		V1 = P;
		int index;
		int Lsize = L.size();
		for (int i = 0; i < Lsize; i++) {
			Node I = L.get(i);
			if (I.opString.startsWith("mov") || I.opString.startsWith("cmp")) {

				String vname = I.argsList.get(0);
				String wname = I.argsList.get(1);
				ArrayList<String> wset = new ArrayList<String>();
				wset.add(wname);
				ArrayList<String> vset = new ArrayList<String>();
				vset.add(vname);

				int mark0 = -1, mark1 = -1;

				index = SearchVar(vname);
				VarNode vVar = new VarNode();
				if (index > -1) {
					vVar = V1.get(index);
					mark0 = index;
				} else {
					vVar.name = vname;
				}

				index = SearchVar(wname);
				VarNode wVar = new VarNode();
				if (index > -1) {
					wVar = V1.get(index);
					mark1 = index;
				} else {
					wVar.name = wname;
				}

				if (mark0 == -1 && mark1 == -1) {
					vVar.S = union(vVar.S, wset);
					wVar.S = union(wVar.S, vset);
					V1.add(vVar);
					V1.add(wVar);
				} else if (mark0 == -1 && mark1 != -1) {
					vVar.S = union(vVar.S, wset);
					V1.get(mark1).S = union(V1.get(mark1).S, vset);
					V1.add(vVar);
				} else if (mark0 != -1 && mark1 == -1) {
					V1.get(mark0).S = union(V1.get(mark0).S, wset);
					wVar.S = union(wVar.S, vset);
					V1.add(wVar);
				} else if (mark0 != -1 && mark1 != -1) {
					V1.get(mark0).S = union(V1.get(mark0).S, wset);
					V1.get(mark1).S = union(V1.get(mark1).S, vset);
				}

			} else if (I.opString.startsWith("add")) {
				String src1name = "";
				String src2name = "";
				String destname = "";
				if (I.argsList.size() == 2) {
					src1name = I.argsList.get(0);
					src2name = I.argsList.get(1);
					destname = "1";
				} else if (I.argsList.size() == 3) {
					src1name = I.argsList.get(0);
					src2name = I.argsList.get(1);
					destname = I.argsList.get(2);
				}
				ArrayList<String> src1set = new ArrayList<String>();
				src1set.add(src1name);
				ArrayList<String> src2set = new ArrayList<String>();
				src2set.add(src2name);
				ArrayList<String> destset = new ArrayList<String>();
				destset.add(destname);

				int flag0 = -1, flag1 = -1, flag2 = -1;

				index = SearchVar(src1name);
				VarNode src1Var = new VarNode();
				if (index > -1) {
					src1Var = V1.get(index);
					flag0 = index;
				} else {
					src1Var.name = src1name;
				}

				index = SearchVar(src2name);
				VarNode src2Var = new VarNode();
				if (index > -1) {
					src2Var = V1.get(index);
					flag1 = index;
				} else {
					src2Var.name = src2name;
				}

				index = SearchVar(destname);
				VarNode destVar = new VarNode();
				if (index > -1) {
					destVar = V1.get(index);
					flag2 = index;
				} else {
					destVar.name = destname;
				}

				ArrayList<String> set1 = new ArrayList<String>();
				set1.add(src2name);
				set1.add(destname);
				ArrayList<String> set2 = new ArrayList<String>();
				set2.add(src1name);
				set2.add(destname);
				ArrayList<String> set3 = new ArrayList<String>();
				set3.add(src1name);
				set3.add(src2name);
				if (flag0 == -1 && flag1 == -1 && flag2 == -1) {
					src1Var.S = union(src1Var.S, set1);
					src2Var.S = union(src2Var.S, set2);
					destVar.S = union(destVar.S, set3);
					V1.add(src1Var);
					V1.add(src2Var);
					V1.add(destVar);
				} else if (flag0 == -1 && flag1 == -1 && flag2 != -1) {
					src1Var.S = union(src1Var.S, set1);
					src2Var.S = union(src2Var.S, set2);
					V1.get(flag2).S = union(V1.get(flag2).S, set3);
					V1.add(src1Var);
					V1.add(src2Var);
				} else if (flag0 == -1 && flag1 != -1 && flag2 == -1) {
					src1Var.S = union(src1Var.S, set1);
					V1.get(flag1).S = union(V1.get(flag1).S, set2);
					destVar.S = union(destVar.S, set3);
					V1.add(src1Var);
					V1.add(destVar);
				} else if (flag0 == -1 && flag1 != -1 && flag2 != -1) {
					src1Var.S = union(src1Var.S, set1);
					V1.get(flag1).S = union(V1.get(flag1).S, set2);
					V1.get(flag2).S = union(V1.get(flag2).S, set3);
					V1.add(src1Var);
				} else if (flag0 != -1 && flag1 == -1 && flag2 == -1) {
					V1.get(flag0).S = union(V1.get(flag0).S, set1);
					src2Var.S = union(src2Var.S, set2);
					destVar.S = union(destVar.S, set3);
					V1.add(src2Var);
					V1.add(destVar);
				} else if (flag0 != -1 && flag1 == -1 && flag2 != -1) {
					V1.get(flag0).S = union(V1.get(flag0).S, set1);
					src2Var.S = union(src2Var.S, set2);
					V1.get(flag2).S = union(V1.get(flag2).S, set3);
					V1.add(src2Var);
				} else if (flag0 != -1 && flag1 != -1 && flag2 == -1) {
					src1Var.S = union(src1Var.S, set1);
					src2Var.S = union(src2Var.S, set2);
					V1.get(flag2).S = union(V1.get(flag2).S, set3);
					V1.add(src1Var);
					V1.add(src2Var);
				} else if (flag0 != -1 && flag1 != -1 && flag2 != -1) {
					V1.get(flag0).S = union(V1.get(flag0).S, set1);
					V1.get(flag1).S = union(V1.get(flag1).S, set2);
					V1.get(flag2).S = union(V1.get(flag2).S, set3);
				}

			}
			// .....
		}
		// ============类型传递=============
		boolean flag = false;

		int lun = 0;

		while (!flag) {
			flag = true;
			lun++;
			System.out.println("==============" + "  第" + lun + "轮  "
					+ "===============");
			int Vsize = V1.size();
			for (int i = 0; i < Vsize; i++) {
				VarNode v = (VarNode) V1.get(i).clone();
				// =============================================
				String string = "";
				for (int ii = 0; ii < v.T.size(); ii++) {
					string = string + "  " + v.T.get(ii);
				}
				System.out.println(v.name + ":" + string);
				// =============================================
				int vSsize = v.S.size();
				for (int k = 0; k < vSsize; k++) {
					String w = v.S.get(k);
					VarNode wNode;
					for (int j = 0; j < Vsize; j++) {
						VarNode temp1 = (VarNode) V1.get(j).clone();
						if (temp1.name.equals(w)) {
							wNode = temp1;
							// =============================================
							String string1 = "";
							for (int ii = 0; ii < wNode.T.size(); ii++) {
								string1 = string1 + "  " + wNode.T.get(ii);
							}
							System.out.println("   +" + wNode.name + ":"
									+ string1);
							// =============================================
							Collections.sort(v.T);
							Collections.sort(wNode.T);
							if (!v.T.equals(wNode.T)) {
								flag = false;
								V1.get(i).T = union(V1.get(i).T, wNode.T);
								V1.get(j).T = union(V1.get(j).T, v.T);
							}
							break;
						}
					}

				}
			}
		}
		System.out.println("a");
	}

	/*
	 * 打印变量
	 */
	public void printVars() {
		int V1_size = V1.size();
		for (int i = 0; i < V1_size; i++) {
			VarNode var = V1.get(i);
			if (var.name.contains("r")) {
				myView.showConten(var.T.get(0) + "  " + var.name + ";\n\r", 1);
			}
		}
		myView.showConten("\n\r", 0);
	}

	/*
	 * 得到变量类型
	 */
	public String getType(String r) {
		int V1_size = V1.size();
		for (int i = 0; i < V1_size; i++) {
			if (V1.get(i).name.equals(r)) {
				return V1.get(i).T.get(0);
			}
		}
		return "";
	}

	/*
	 * 函数基本块定值点形成
	 */
	public void EPGen(DisFunction func) {

	}

	// ====================================
	// 变量类型分析用到的结构和方法
	// ====================================
	class Node {
		String opString;
		ArrayList<String> argsList;

		public Node() {
			argsList = new ArrayList<String>();
		}
	}

	class VarNode implements Cloneable {
		public String name;
		public ArrayList<String> S;
		public ArrayList<String> T;

		public VarNode() {
			S = new ArrayList<String>();
			T = new ArrayList<String>();
		}

		@Override
		public Object clone() {
			Object o = null;
			try {
				o = super.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println(e.toString());
			}
			return o;
		}
	}

	public ArrayList<String> union(ArrayList<String> ls, ArrayList<String> ls2) {
		ArrayList<String> list = new ArrayList<String>();
		for (String string : ls) {
			if (list.contains(string))
				continue;
			else {
				list.add(string);
			}
		}
		for (String string : ls2) {
			if (list.contains(string))
				continue;
			else {
				list.add(string);
			}
		}
		return list;
	}

	public int SearchVar(String temp) {
		int Vsize = V1.size();
		for (int i = 0; i < Vsize; i++) {
			if (V1.get(i).name.equals(temp)) {
				return i;
			}
		}
		return -1;
	}

	// ====================================
	// 生成结构树的工具函数
	// ====================================
	class nodeinfo {
		String type = null;
		ArrayList<Integer> childlist;

		public nodeinfo() {
			childlist = new ArrayList<Integer>();
		}
	}

	public void addVertex(int v) {
		if (vertices.indexOf(v) < 0) {
			vertices.add(v);
			adjacentTable.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int f, int t) {
		int index = vertices.indexOf(f);
		if (index < 0) {
			System.out.println("addEdge: cant find the source vertex!");
			System.exit(1);
		}

		ArrayList<Integer> targets = adjacentTable.get(index);
		if (targets.indexOf(t) < 0) {
			targets.add(t);
		}
	}

	public void getPostOrder(CDecompiler g, int root, ArrayList<Integer> vlist,
			ArrayList<Integer> visited) {
		visited.add(root);
		int index = vertices.indexOf(root);
		if (index >= 0) {
			ArrayList<Integer> adjacentList = adjacentTable.get(index);
			for (int i = 0; i < adjacentList.size(); i++) {
				if (visited.indexOf(adjacentList.get(i)) < 0) {
					getPostOrder(g, adjacentList.get(i), vlist, visited);
				}
			}
		}
		vlist.add(root);
	}

	public ArrayList<Integer> getToList(int v) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = vertices.indexOf(v);
		if (index >= 0) {
			list.addAll(adjacentTable.get(index));
		}
		return list;
	}

	public ArrayList<Integer> getFromList(int v) {
		ArrayList<Integer> froms = new ArrayList<Integer>();
		for (int i = 0; i < adjacentTable.size(); i++) {
			ArrayList<Integer> l = adjacentTable.get(i);
			int index = l.indexOf(v);
			if (index >= 0) {
				froms.add(vertices.get(i));
			}
		}
		return froms;
	}

	public void removeEdge(int from, int to) {
		int index = vertices.indexOf(from);
		if (index >= 0) {
			ArrayList<Integer> list = adjacentTable.get(index);
			index = list.indexOf(to);
			list.remove(index);
		}
	}

	public void removeVertex(int v) {
		int index = vertices.indexOf(v);
		if (index >= 0) {
			vertices.remove(index);
			adjacentTable.remove(index);
		}
	}

	public boolean hasEdge(int from, int to) {
		int index = vertices.indexOf(from);
		if (index >= 0) {
			if (adjacentTable.get(index).contains(to)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int outDegree(int v) {
		int index = vertices.indexOf(v);
		if (index >= 0) {
			return adjacentTable.get(index).size();
		}

		return 0;
	}

	public CDecompiler makeACopy() {
		CDecompiler c = new CDecompiler(this);
		return c;
	}

	public CDecompiler(CDecompiler graph) {
		this.vertices = new ArrayList<Integer>();
		this.adjacentTable = new ArrayList<ArrayList<Integer>>();
		this.vertices.addAll(graph.getVertices());
		for (int i = 0; i < this.vertices.size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(graph.getTable().get(i));
			this.adjacentTable.add(list);
		}
	}

	public CDecompiler() {
	}

	public ArrayList<Integer> getVertices() {
		return this.vertices;
	}

	public ArrayList<ArrayList<Integer>> getTable() {
		return this.adjacentTable;
	}

	// ====================================
	// 基本块转高级代码用到的结构和函数
	// ====================================
	public nodeinfo getBranchNode(int node) {
		int NodeTreeNum = treeList.size();
		for (int i = NodeTreeNum - 1; i >= 0; i--) {
			if (treeList.get(i).childlist.get(0) == node) {
				nodeinfo node2 = treeList.get(i);
				treeList.remove(i);
				return node2;
			}
		}
		return null;
	}

	class highcode {
		public String highstring = "";
		public String hightype = "";
	}

	@Override
	public void codeGen() {

	}

	@Override
	public void machineAnalysis() {
		// TODO Auto-generated method stub

	}

	@Override
	public void typeAnalysis() {

	}

	@Override
	public void convertToIntermediateCode() {
		// TODO Auto-generated method stub

	}

}
