package ex03;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> aL = new ArrayList<>();
	ArrayList<Edge> edgeList = new ArrayList<Edge>();

	int counter = 1;
	boolean elementExists;
	boolean emptyGraph = true;
	Edge firstEdge;
	int nodeCounter = 0;

	/**
	 * Adds node to graph if node with same name does not already exist
	 * 
	 * @param node node to add
	 * @return true if node added, else otherwise (i.e., node with same name already
	 *         existed)
	 */
	public boolean addNode(Node node) {

		if (!exists(node)) {
			aL.add(node);
			node.count = counter;
			counter++;
		}
		return false;
	}

	/**
	 * Adds an edge to the graph if its nodes already exist in the graph, the edge
	 * connects two different nodes, the nodes are not yet connected, and the weight
	 * is positive.
	 * 
	 * @param edge edge to add
	 * @return true if edge added, else otherwise (i.e., violating the above
	 *         mentioned rules)
	 */
	public boolean addEdge(Edge edge) {
		if (emptyGraph) {
			firstEdge = edge;
			emptyGraph = false;
		}
		edgeList.add(edge);
		edge.nodesOfEdge.add(edge.firstNode);
		edge.nodesOfEdge.add(edge.secondNode);

		return false;
	}

	/**
	 * Removes the given node.
	 * 
	 * @param node node to remove
	 * @return true if removed, false if it was not inside the graph
	 */
	public boolean removeNode(Node node) {
		aL.remove(node);
		for (int i = 0; i < edgeList.size(); i++) {
			if (edgeList.get(i).firstNode.name.equals(node.name) || edgeList.get(i).secondNode.name.equals(node.name)) {
				edgeList.remove(i);
				edgeList.get(i).nodesOfEdge.clear();
			}
		}
		return true;
	}

	/**
	 * Removes the given edge.
	 * 
	 * @param edge edge to remove
	 * @return true if removed, false if it was not inside the graph
	 */
	public boolean removeEdge(Edge edge) {
		for (int i = 0; i < edgeList.size(); i++) {
			if (edgeList.get(i) == edge) {
				edgeList.remove(edge);
			}

		}
		return false;
	}

	/**
	 * Returns the node with the given name if it exists in the graph. Null
	 * otherwise.
	 * 
	 * @param name Name of the node to be returned
	 * @return null if no node with that name exists in the graph.
	 */
	public Node getNode(String name) {
		Node result = null;
		for (int i = 0; i < aL.size(); i++) {
			if (aL.get(i).name.equals(name)) {
				result = aL.get(i);
			}
		}
		return result;
	}

	/**
	 * Checks whether the graph is connected or not. This means that a path exists
	 * from any node to any other node.
	 * 
	 * @return true if the graph is connected and false otherwise
	 */

	public boolean checkConnectivity() {
		boolean allChecked = true;
		for (int i = 0; i < edgeList.size(); i++) {
			for (int k = 0; k < edgeList.size(); k++) {

				if (firstEdge.firstNode.name.equals(edgeList.get(k).firstNode.name)
						&& (!firstEdge.secondNode.name.equals(edgeList.get(k).secondNode.name))) {

					if (edgeList.get(k).firstNode.checked == false) {
						edgeList.get(k).firstNode.checked = true;
						for (int j = 0; j < aL.size(); j++) {
							if (edgeList.get(k).firstNode.name.equals(aL.get(j).name)) {
								aL.get(j).checked = true;
							}
						}
					}
				}
				if (firstEdge.firstNode.name.equals(edgeList.get(k).secondNode.name)
						&& (!firstEdge.secondNode.name.equals(edgeList.get(k).firstNode.name))) {
					if (edgeList.get(k).secondNode.checked == false) {
						edgeList.get(k).secondNode.checked = true;
						for (int j = 0; j < aL.size(); j++) {
							if (edgeList.get(k).secondNode.name.equals(aL.get(j).name)) {
								aL.get(j).checked = true;
							}
						}
					}
				}
				if (firstEdge.secondNode.name.equals(edgeList.get(k).firstNode.name)
						&& (!firstEdge.firstNode.name.equals(edgeList.get(k).secondNode.name))) {

					if (edgeList.get(k).firstNode.checked == false) {
						edgeList.get(k).firstNode.checked = true;
						for (int j = 0; j < aL.size(); j++) {
							if (edgeList.get(k).firstNode.name.equals(aL.get(j).name)) {
								aL.get(j).checked = true;
							}
						}
					}
				}
				if (firstEdge.secondNode.name.equals(edgeList.get(k).secondNode.name)
						&& (!firstEdge.firstNode.name.equals(edgeList.get(k).firstNode.name))) {
					if (edgeList.get(k).secondNode.checked == false) {
						edgeList.get(k).secondNode.checked = true;
						for (int j = 0; j < aL.size(); j++) {
							if (edgeList.get(k).secondNode.name.equals(aL.get(j).name)) {
								aL.get(j).checked = true;
							}
						}
					}
				}
			}
		}
		nodeCounter++;
		if (nodeCounter < edgeList.size()) {
			firstEdge = edgeList.get(nodeCounter);
			checkConnectivity();
		}
		for (int j = 0; j < aL.size(); j++) {
			if (aL.get(j).checked == false) {
				allChecked = false;
			}
		}
		return allChecked;

	}

	/**
	 * @param firstNode the node where to start
	 * @return every node mapped to the edge to reach it
	 */
	int path = 0;
	Node tempNode;
	int kekw = 0;
	int counter1 = 0;
	int closestNeighbour;
	Edge tempEdge;
	Edge tempEdge1;
	Edge tempEdge2;

	/**
	 * 
	 * Not completely implemented
	 */
	public Object calculateShortestPaths(Node firstNode) {
		for (int i = edgeList.size() - 1; i >= 0; i--) {
			if (firstNode.name.equals(edgeList.get(i).firstNode.name)) {
				edgeList.get(i).secondNode.shortestPath.add(edgeList.get(i));
				if ((closestNeighbour == 0) || edgeList.get(i).weight < closestNeighbour) {
					closestNeighbour = edgeList.get(i).weight;
					tempNode = edgeList.get(i).secondNode;
					for (int j = 0; j < aL.size(); j++) {
						if (edgeList.get(i).secondNode.name.equals(aL.get(j).name)) {
							aL.get(j).pathTable += " " + firstNode.name + " -> " + aL.get(j).name;
							aL.get(j).path += " " + firstNode.name + " -> " + aL.get(j).name;
						}
					}
					if (tempEdge == null) {
						tempEdge = edgeList.get(i);
					} else {
						if (edgeList.get(i).weight < tempEdge.weight) {
							tempEdge = edgeList.get(i);
						}
					}
				}
				for (int j = 0; j < aL.size(); j++) {
					if (edgeList.get(i).secondNode.name.equals(aL.get(j).name)) {
						aL.get(j).shortestWeight = edgeList.get(i).weight;
					}
				}
			}
			if (firstNode.name.equals(edgeList.get(i).secondNode.name)) {
				edgeList.get(i).firstNode.shortestPath.add(edgeList.get(i));
				if ((closestNeighbour == 0) || edgeList.get(i).weight < closestNeighbour) {
					closestNeighbour = edgeList.get(i).weight;
					tempNode = edgeList.get(i).firstNode;
					if (tempEdge == null) {
						tempEdge = edgeList.get(i);
					} else {
						if (edgeList.get(i).weight < tempEdge.weight) {
							tempEdge = edgeList.get(i);
						}
					}
				}
				for (int j = 0; j < aL.size(); j++) {
					if (edgeList.get(i).firstNode.name.equals(aL.get(j).name)) {
						aL.get(j).shortestWeight = edgeList.get(i).weight;
					}
				}
			}

		}
		edgeList.remove(tempEdge);
		firstNode = tempNode;

		while (edgeList.size() > 4) {
			for (int i = edgeList.size() - 1; i >= 0; i--) {
				if (firstNode.name.equals(edgeList.get(i).firstNode.name)
						|| firstNode.name.equals(edgeList.get(i).secondNode.name)) {
					if (firstNode.name.equals(edgeList.get(i).firstNode.name)) {
						for (int k = 0; k < aL.size(); k++) {
							if (edgeList.get(i).firstNode.name.equals(aL.get(k).name)) {
								for (int j = 0; j < aL.size(); j++) {
									if (edgeList.get(i).secondNode.name.equals(aL.get(j).name)) {
										if ((aL.get(j).shortestWeight == 0) || edgeList.get(i).weight
												+ aL.get(k).shortestWeight < aL.get(j).shortestWeight) {
											aL.get(j).shortestWeight = edgeList.get(i).weight
													+ aL.get(k).shortestWeight;
											for (int z = 0; z < aL.size(); z++) {
												if (edgeList.get(i).secondNode.name.equals(aL.get(z).name)) {
													aL.get(z).pathTable += firstNode.path + " -> " + aL.get(z).name;
													aL.get(z).path += firstNode.path + " -> " + aL.get(z).name;
												}
											}
											firstNode = edgeList.get(i).secondNode;
											tempEdge1 = edgeList.get(i);

										}
									}
								}
							}

						}

					}
					if (firstNode.name.equals(edgeList.get(i).secondNode.name)) {
						for (int k = 0; k < aL.size(); k++) {
							if (edgeList.get(i).secondNode.name.equals(aL.get(k).name)) {
								for (int j = 0; j < aL.size(); j++) {
									if (edgeList.get(i).firstNode.name.equals(aL.get(j).name)) {
										if ((aL.get(k).shortestWeight == 0) || edgeList.get(i).weight
												+ aL.get(j).shortestWeight < aL.get(k).shortestWeight) {
											aL.get(k).shortestWeight = edgeList.get(i).weight
													+ aL.get(j).shortestWeight;
											for (int z = 0; z < aL.size(); z++) {
												if (edgeList.get(i).firstNode.name.equals(aL.get(z).name)) {
													aL.get(z).pathTable += firstNode.path + " -> " + aL.get(z).name;
													aL.get(z).path += firstNode.path + " -> " + aL.get(z).name;
										

												}
											}
											firstNode = edgeList.get(i).firstNode;
											tempEdge2 = edgeList.get(i);
										
										}
									}
								}
								break;
							}

						}
					}
					if ((tempEdge1 == null) || (tempEdge2 == null)) {
						if (tempEdge1 == null) {
							edgeList.remove(tempEdge2);
						} else {
							edgeList.remove(tempEdge1);
						}
					} else {
						if (tempEdge1.weight < tempEdge2.weight) {
							edgeList.remove(tempEdge1);
						} else {
							edgeList.remove(tempEdge2);
						}
					}

				}

			}
			for (int i = 0; i < aL.size(); i++) {
				System.out.println(aL.get(i).pathTable);
			}
		}
		return firstNode;
	}

	boolean exists(Node node) {
		boolean elementExists = false;
		for (int i = 0; i < aL.size(); i++) {
			if (node.name.equals(aL.get(i).name)) {
				elementExists = true;
			}
		}
		return elementExists;
	}

	public void checkedClear() {
		for (int i = 0; i < edgeList.size(); i++) {
			edgeList.get(i).firstNode.checked = false;
			edgeList.get(i).secondNode.checked = false;
		}
	}
}
