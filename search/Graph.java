package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 1. Clone Graph：这种点边结构的复制，都是先点后边，顺序清楚一点，往往要用hashmap来存原点与复制点之间的对应关系
 * 同时，还能看哪个点已经复制完成了，防止重复。 在copy list with random pointer这道题中，是用了linkedlist的
 * 相对位置来保存了对应关系。
 * 
 * 2. Topological Sorting:
 * N tasks
 * A -> B		B -> C		C -> D
 * A->B->C->D
 * G = (V, E) //Directed Graph
 * 求一个合理的完成任务的顺序 -> Topologic Order
 * 0. 问是否可以拓扑排序： 就是看有没有环
 * 1. 求他的一个拓扑排序
 * 
 * 入度： A->B  B的入度+1 
 * 出度： A->B  A的出度+1
 * 
 * 0. 初始化hashmap,存每一个点得入度， 如果只给了一个点而没有给所有点的list，则需要BFS求出所有点得list
 * 1. 找到所有入度为0的点，放到队列里
 * 2. 遍历队列，从队列里拿出一个点，加入结果， 将这个点所block得点得入度都-1，
 * 如果发现某个点的入度变成了0，就加入队列
 * 
 * 3. 凡是变换问题，word变换或者棋盘变换，每一次变换的代价都是1， 找一个最短变换距离， 一般都是BFS
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