package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 1. Clone Graph�����ֵ�߽ṹ�ĸ��ƣ������ȵ��ߣ�˳�����һ�㣬����Ҫ��hashmap����ԭ���븴�Ƶ�֮��Ķ�Ӧ��ϵ
 * ͬʱ�����ܿ��ĸ����Ѿ���������ˣ���ֹ�ظ��� ��copy list with random pointer������У�������linkedlist��
 * ���λ���������˶�Ӧ��ϵ��
 * 
 * 2. Topological Sorting:
 * N tasks
 * A -> B		B -> C		C -> D
 * A->B->C->D
 * G = (V, E) //Directed Graph
 * ��һ���������������˳�� -> Topologic Order
 * 0. ���Ƿ������������ ���ǿ���û�л�
 * 1. ������һ����������
 * 
 * ��ȣ� A->B  B�����+1 
 * ���ȣ� A->B  A�ĳ���+1
 * 
 * 0. ��ʼ��hashmap,��ÿһ�������ȣ� ���ֻ����һ�����û�и����е��list������ҪBFS������е��list
 * 1. �ҵ��������Ϊ0�ĵ㣬�ŵ�������
 * 2. �������У��Ӷ������ó�һ���㣬�������� ���������block�õ����ȶ�-1��
 * �������ĳ�������ȱ����0���ͼ������
 * 
 * 3. ���Ǳ任���⣬word�任�������̱任��ÿһ�α任�Ĵ��۶���1�� ��һ����̱任���룬 һ�㶼��BFS
 * 
 */
public class Graph {

	public ArrayList<GraphNode> topologicalSorting(ArrayList<GraphNode> nodes) {
		HashMap<GraphNode, Integer> inCount = new HashMap<GraphNode, Integer>();
		// intialize inCount 
		for (int i = 0; i < nodes.size(); i++) {
		    inCount.put(nodes.get(i), 0);
		}
	
		// construct inCount
		for (int i = 0; i < nodes.size(); i++) {
		    for (int j = 0; j < nodes.get(i).blocks.size(); j++) {
		        GraphNode node = nodes.get(i).blocks.get(j);
		        inCount.put(node, inCount.get(node) + 1);
		    }
		}
	
		// intialize Queue
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		for (int i = 0; i< nodes.size(); i++) {
		    if (inCount.get(nodes.get(i)) == 0) {
		        q.offer(nodes.get(i));
		    }
		}
	
		// BFS
		ArrayList<GraphNode> topoList = new ArrayList<GraphNode> ();
		while (!q.isEmpty()) {
		    GraphNode node = q.poll();
		    topoList.add(node);
		    for (int i = 0; i < node.blocks.size(); i++) {
		        GraphNode blockNode = node.blocks.get(i);
		        inCount.put(blockNode, inCount.get(blockNode) - 1);
		        if (inCount.get(blockNode) == 0) {
		            q.offer(blockNode);
		        }
		    }
		}
	
		if (topoList.size() == nodes.size()) {
		    return topoList;
		} else {
		    return null;
		}
	}
}
class GraphNode {
	int label;
	List<GraphNode> blocks;
	GraphNode(int x) { label = x; blocks = new ArrayList<GraphNode>(); }
}