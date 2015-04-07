package bit_dec.views;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import parser.ObjDumpParser;
import bit_dec.dissambler.DisBlock;
import bit_dec.dissambler.DisFunction;
import bit_dec.dissambler.DisInst;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class cfgView extends ViewPart {

	private Composite composite;
	private mxCell node1;
	private mxCell node2;
	private int width = 150;
	private int height = 40;
	private String shap = null;
	private ArrayList<mxCell> NodeList;
	private ArrayList<String> NodeListText;
	protected static mxGraphComponent graghComponent = new mxGraphComponent(
			new mxGraph());
	private Frame frame;
	DisFunction func;
	
	public cfgView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		composite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void drawCFG(String funcName) {
		frame = SWT_AWT.new_Frame(composite);
		
		NodeListText = new ArrayList<String>();
		NodeList = new ArrayList<mxCell>();

		final mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();

		graghComponent.setConnectable(false);
		graph.setAllowDanglingEdges(false);
		graph.setCloneInvalidEdges(false);
		graph.setCellsEditable(false);
		graph.setCellsResizable(false);
		graph.setAutoSizeCells(true);

		
		ObjDumpParser objDumpParser = new ObjDumpParser();
		func = objDumpParser.getFuncByName(funcName);
		if (func == null)
			return;
		ArrayList<DisBlock> block_list = func.getBlocklist();
		int block_list_size = block_list.size();
		try {
			for (int i = 0; i < block_list_size; i++) {
				DisBlock block = block_list.get(i);
				String temp = Integer.toString(i);
				if (NodeListText.contains(temp)) {
					int index = NodeListText.indexOf(temp);
					node1 = NodeList.get(index);
				} else {
					node1 = (mxCell) graph.insertVertex(parent, null, temp, 20,
							20, width, height, shap);
					NodeListText.add(temp);
					NodeList.add(node1);
				}
				graph.updateCellSize(node1);
				ArrayList<Integer> subBlockSet = block.getSubBlockSet();
				int subSetSize = subBlockSet.size();
				for (int j = 0; j < subSetSize; j++) {
					String temp2 = Integer.toString(subBlockSet.get(j));
					if (NodeListText.contains(temp2)) {
						int index = NodeListText.indexOf(temp2);
						node2 = NodeList.get(index);
					} else {
						node2 = (mxCell) graph.insertVertex(parent, null,
								temp2, 20, 20, width, height, shap);
						NodeListText.add(temp2);
						NodeList.add(node2);
					}
					graph.updateCellSize(node2);
					graph.insertEdge(parent, null, null, node1, node2);
				}
			}
			mxIGraphLayout layout = new mxHierarchicalLayout(graph);
			layout = new mxHierarchicalLayout(graph, SwingConstants.NORTH);
			layout.execute(graph.getDefaultParent());
			// layout = new mxCompactTreeLayout(graph, false);
			// layout = new mxCompactTreeLayout(graph, true);
			// layout = new mxParallelEdgeLayout(graph);
			// layout = new mxEdgeLabelLayout(graph);
			// layout = new mxOrganicLayout(graph);
		}

		finally {
			graph.getModel().endUpdate();
		}
		final mxGraphComponent graphComponent = new mxGraphComponent(graph);
		SwingUtilities.invokeLater(new Runnable() {
			 @Override
			public void run() {
				 frame.add(graphComponent);
			 }
		});
		/*
		 * 点击控制流图结点
		 */
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
		{
		
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Object cell = graphComponent.getCellAt(e.getX(), e.getY());
				
				if (cell != null)
				{
					String blocknum = graph.getLabel(cell);
					System.out.println(blocknum);
					showBlock(blocknum);
				}
			}
		});
	}

	/*
	 * 通过基本块号高亮汇编代码
	 */
	public void showBlock(String blocknum){
		int num =Integer.parseInt(blocknum);
		ArrayList<DisInst> instlist = func.getInstructionList();
		DisBlock block = func.getBlocklist().get(num);
		int start = block.getStart();
		int end = block.getEnd();
		for(int i=start;i<=end;i++){
			System.out.println(instlist.get(i).getInstructionLine());
		}
	}
}
