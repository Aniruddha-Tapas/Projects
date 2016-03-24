package iddfs;

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
        
        //Add neighbours to nodes
        node1.addNeighbour(node2);
        node2.addNeighbour(node3);
        
        // Running the IDDFS
        //IDDFS iddfs = new IDDFS(node1);
        IDDFS iddfs = new IDDFS(node3);
        iddfs.runDeepningSearch(node1);
        
    }
    
}
