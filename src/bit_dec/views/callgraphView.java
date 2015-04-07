package bit_dec.views;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import androidCallGragh.CallGragh;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxEdgeLabelLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class callgraphView extends ViewPart {

	private Composite composite;
	private Frame frame;
	private ArrayList<String> NodeListText;
	private ArrayList<mxCell> NodeList;
	private String temp;
	private mxCell node1;
	private mxCell node2;
	private int width = 150;
	private int height = 40;
	private String shap = null;
	private String temp8;

	protected static mxGraphComponent graghComponent = new mxGraphComponent(
			new mxGraph());

	public callgraphView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		composite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void drawCallGraph() {
		frame = SWT_AWT.new_Frame(composite);

		NodeListText = new ArrayList<String>();
		NodeList = new ArrayList<mxCell>();

		mxGraph graph = new mxGraph();
		graghComponent.setConnectable(false);
		graph.setAllowDanglingEdges(false);
		graph.setCloneInvalidEdges(false);
		graph.setCellsEditable(false);
		graph.setCellsResizable(false);
		graph.setAutoSizeCells(true);
		Object parent = graph.getDefaultParent();

		
		
		
		
		graph.getModel().beginUpdate();
		try {
			for (int i = 0; i < CallGragh.allJavaCallGragh.size(); i++) {
				temp = CallGragh.allJavaCallGragh.get(i).getFuncSelf()
						.getClassName()
						+ "."
						+ CallGragh.allJavaCallGragh.get(i).getFuncSelf()
								.getFunName();
				if (temp == null) {
					temp = "";
				}
				if (NodeListText.contains(temp)) {
					for (int k = 0; k < NodeList.size(); k++) {
						if (NodeList.get(k).getValue().toString().equals(temp)) {
							node1 = NodeList.get(k);
							break;
						}
					}
				} else {
					if (CallGragh.allJavaCallGragh.get(i)
							.getFuncInnerFuncsNum() != 0) {
						node1 = (mxCell) graph.insertVertex(parent, null, temp,
								20, 20, width, height, shap);

						NodeListText.add(temp);// ?????????????????没有考虑类不同
						graph.updateCellSize(node1);
						NodeList.add(node1);
						for (int j = 0; j < CallGragh.allJavaCallGragh.get(i)
								.getFuncInnerFuncsNum(); j++) {
							temp = CallGragh.allJavaCallGragh.get(i)
									.getFunInnerFuncs().get(j).getClassName()
									+ "."
									+ CallGragh.allJavaCallGragh.get(i)
											.getFunInnerFuncs().get(j)
											.getFunName();
							if (temp == null) {
								temp = "";
							}
							if (NodeListText.contains(temp)) {
								for (int k = 0; k < NodeList.size(); k++) {
									if (NodeList.get(k).getValue().toString()
											.equals(temp)) {
										node2 = NodeList.get(k);
										break;
									}
								}
							} else {
								node2 = (mxCell) graph
										.insertVertex(parent, null, temp, 20,
												20, width, height, shap);

								graph.updateCellSize(node2);
								NodeListText.add(temp);// ?????????????????没有考虑类不同
								NodeList.add(node2);
							}
							if (graph.getEdgesBetween(node1, node2).length == 0) {
								graph.insertEdge(parent, null, null, node1,
										node2);

							}

						}
					}
				}
			}
			// 扫描c
			if (CallGragh.include) {
				for (int i = 0; i < CallGragh.allCCallGragh.size(); i++) {
					temp = CallGragh.allCCallGragh.get(i).getFuncSelf()
							.getFunName();
					if (temp == null) {
						temp = "";
					}
					if (NodeListText.contains(temp)) {
						for (int k = 0; k < NodeList.size(); k++) {
							if (NodeList.get(k).getValue().toString()
									.equals(temp)) {
								node1 = NodeList.get(k);
								break;
							}
						}
					} else {
						if (CallGragh.allCCallGragh.get(i)
								.getCFuncInnerFuncsNum() != 0) {
							node1 = (mxCell) graph.insertVertex(parent, null,
									temp, 20, 20, width, height, shap);
							temp8 = temp;
							graph.updateCellSize(node1);
							NodeListText.add(temp);// ?????????????????没有考虑类不同
							NodeList.add(node1);
							for (int j = 0; j < CallGragh.allCCallGragh.get(i)
									.getCFuncInnerFuncsNum(); j++) {
								temp = CallGragh.allCCallGragh.get(i)
										.getCfuncInnerFuncs().get(j);
								if (temp == null) {
									temp = "";
								}
								if (NodeListText.contains(temp)) {
									for (int k = 0; k < NodeList.size(); k++) {
										if (NodeList.get(k).getValue()
												.toString().equals(temp)) {
											node2 = NodeList.get(k);
											break;
										}
									}
								} else {
									node2 = (mxCell) graph.insertVertex(parent,
											null, temp, 20, 20, width, height,
											shap);

									graph.updateCellSize(node2);
									NodeListText.add(temp);// ?????????????????没有考虑类不同
									NodeList.add(node2);
								}
								if (graph.getEdgesBetween(node1, node2).length == 0) {
									graph.insertEdge(parent, null, null, node1,
											node2);

								}
							}
							if (temp8 != null && temp8.contains("Java_")) {
								temp8 = temp8
										.substring(temp8.lastIndexOf('_') + 1);
								for (int m = 0; m < NodeList.size(); m++) {

									if (NodeList
											.get(m)
											.getValue()
											.toString()
											.substring(
													NodeList.get(m).getValue()
															.toString()
															.lastIndexOf('.') + 1)
											.equals(temp8)) {
										node2 = NodeList.get(m);
										if (graph.getEdgesBetween(node1, node2).length == 0) {
											graph.insertEdge(parent, null,
													null, node2, node1);

										}
									}
								}
							}
						}
					}
				}
			}
			mxIGraphLayout layout = new mxHierarchicalLayout(graph);
			layout = new mxHierarchicalLayout(graph, SwingConstants.WEST);
			layout.execute(graph.getDefaultParent());
			layout = new mxCompactTreeLayout(graph, false);
			layout = new mxCompactTreeLayout(graph, true);
			layout = new mxParallelEdgeLayout(graph);
			layout = new mxEdgeLabelLayout(graph);
			layout = new mxOrganicLayout(graph);
		} finally {
			graph.getModel().endUpdate();
		}
		final mxGraphComponent graphComponent = new mxGraphComponent(graph);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.add(graphComponent);
			}
		});
	}

}
