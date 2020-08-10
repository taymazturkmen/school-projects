package ex03;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        /// read file into graph
        // Je nachdem wo das Programm ausgefuehrt wird, Pfad anpassen
        File file = new File("graph.data");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // iterate every line
            while ((line = reader.readLine()) != null) {
                String[] object = line.split(",");
                if (object.length != 3) {
                    System.err.println("\"" + line + "\" is not an edge!");
                }
                Node firstNode = new Node(object[0]);
                graph.addNode(firstNode);
                Node secondNode = new Node(object[1]);
                graph.addNode(secondNode);
                // add nodes and edges to graph
                
                graph.addEdge(new Edge(firstNode, secondNode, Integer.parseInt(object[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // check whether connected graph is detected
        if(! graph.checkConnectivity()) {
        	System.err.println("Check connectivity returned false, but graph is connected!");
        }

        System.out.println("Expected result:");
        System.out.println("Path to A: A");
        System.out.println("Path to B: A -> B");
        System.out.println("Path to C: A -> C");
        System.out.println("Path to D: A -> B -> D");
        System.out.println("Path to E: A -> B -> D -> E");
        System.out.println("Path to F: A -> B -> D -> F");

        // TODO Hier kann eigener Code eingefuegt werden, um die gefundenen
        // kuerzesten Pfade auszugeben.
        Node firstNode = graph.getNode("A");
       Object paths = graph.calculateShortestPaths(firstNode);
    	
    	
    	
        // Check whether unconnected graph is detected
        Node unconnectedNode = new Node("unconnected");
        graph.addNode(unconnectedNode);
        
        if(graph.checkConnectivity()) {
        	System.err.println("Check connectivity returned true, but graph is not connected!");
        }
    }
}
