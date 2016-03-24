package iddfs;

import java.util.Stack;

/**
 *
 * @author ANIRUDDHA
 */

// Iterative Deepning DFS algorithm
public class IDDFS {
    
    private Node targetNode;
    private boolean isTargetFound;
    
    public IDDFS(Node targetNode){
        this.targetNode = targetNode;
    }

    
    // Running the Search
    public void runDeepningSearch(Node startNode){
        
        int depth = 0;
        
        while(!isTargetFound){
            System.out.println();
            dfs(startNode,depth);
            depth++;
        }
    }

    // DFS using stack
    private void dfs(Node startNode, int depth) {
        
        Stack<Node> stack = new Stack<>();
        startNode.setDepthLevel(0);
        stack.push(startNode);
        
        while(!stack.isEmpty()){
            
            //Pop the actual vertices for display
            Node actualNode = stack.pop();
            System.out.print(actualNode+" ");
            
            // Check if we found the target node
            if(actualNode.getName().equals(this.targetNode.getName())){
                System.out.println("\nNode is found... ");
                this.isTargetFound = true; // break the while loop
                return;
            }
            
            // Contine if the target node is deeper than the current set depth
            if(actualNode.getDepthLevel() >= depth){
                continue;
            }
            
            for(Node node: actualNode.getAdjacenciesList()){
                node.setDepthLevel(actualNode.getDepthLevel()+1); // Incrementing the DepthLevel;
                stack.push(node);
            }
            
        }
    }

}
