package astarsearch;

import java.util.List;

/**
 *
 * @author ANIRUDDHA
 */
public class Main {

    public static void main(String[] args) {
     
        // Create nodes
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        
        //Add neighbours to nodes
        node1.addNeighbour(new Edge(node2, 10)); 
        //node1.addNeighbour(new Edge(node4, 10)); // This gives path [A,D] as the route is very cheap. 
        node1.addNeighbour(new Edge(node4, 100)); // Whereas this gives [A,B,C,D] due to the added cost.
        node2.addNeighbour(new Edge(node3, 10));
        node3.addNeighbour(new Edge(node4, 10));
        
        AStarSearch as = new AStarSearch();
        as.aStarSearchAlgo(node1, node4);
        
        // Print out the path
        List<Node> path = as.printPath(node4);
        System.out.println(path);
        
    }
}
