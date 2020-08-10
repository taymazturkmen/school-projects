package ex03;

import java.util.ArrayList;

public class Node {
    String name;
    int count;
    boolean checked = false;
    ArrayList<Edge> shortestPath;
    int shortestWeight;
    String pathTable;
    String path;

    public Node(String name) {
        this.name = name;
        this.count = count;
        this.checked = checked;
        shortestPath = new ArrayList<>();
        this.shortestWeight = shortestWeight;
        shortestWeight = 0;
        pathTable = "Path to " + name + ":";
        path = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Node node = (Node) o;
        return name.equals(node.name);
    }

}
