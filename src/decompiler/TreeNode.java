package decompiler;

import java.util.ArrayList;

public class TreeNode {
	public static final int NODE_TYPE_IF = 0;
	public static final int NODE_TYPE_IF_ELSE = 0;
	public static final int NODE_TYPE_LOOP_FOR = 1;
	public static final int NODE_TYPE_LOOP_WHILE = 2;
	public static final int NODE_TYPE_FUNC_DEF = 1;
	public static final int NODE_TYPE_FUNC_DECL = 1;
	public static final int NODE_TYPE_CLASS_DEF = 1;
	public static final int NODE_TYPE_PARAS = 1;
	public static final int NODE_TYPE_PARA = 1;
	public static final int NODE_TYPE_STATEMENT_LIST = 1;
	public static final int NODE_TYPE_VAR_DECL = 2;
	public static final int NODE_TYPE_EXPR = 3;
	private ArrayList<TreeNode> children;
}
