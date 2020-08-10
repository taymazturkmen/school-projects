package ex03;

import java.util.ArrayList;

public class Edge {
	Node firstNode;
	Node secondNode;
	int weight;
	ArrayList<Node> nodesOfEdge;
	public Edge(Node firstNode, Node secondNode, int weight) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.weight = weight;
		this.nodesOfEdge = nodesOfEdge;
		nodesOfEdge = new ArrayList<Node>();

	}

	public Node getFirstNode() {
		return this.firstNode;
	}

	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}

	public Node getSecondNode() {
		return this.secondNode;
	}

	public void setSecondNode(Node secondNode) {
		this.secondNode = secondNode;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	
}
