package astarsearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANIRUDDHA
 */

// Class Node for the A* Search
public class Node implements Comparable<Node>{ //Comparable : To compare the fScores between two nodes so as to make a decision

    private String value;
    private double gScore; // Calculates the actual distance from the start node to the current node
    private double hScore; // Calculates the heuristic distance from the goal node to the current node
    private double fScore;
    private double x;
    private double y;
    private List<Edge> adjacenciesList; //List of all adjacent neighbours
    private Node parentNode; //PPredecessor Node
    
    public Node(String value){
        this.value = value;
        this.adjacenciesList = new ArrayList<Edge>();
    }
    
    public void addNeighbour(Edge edge){
        this.adjacenciesList.add(edge);
    }
    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getgScore() {
        return gScore;
    }

    public void setgScore(double gScore) {
        this.gScore = gScore;
    }

    public double gethScore() {
        return hScore;
    }

    public void sethScore(double hScore) {
        this.hScore = hScore;
    }

    public double getfScore() {
        return fScore;
    }

    public void setfScore(double fScore) {
        this.fScore = fScore;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
 
        
    public String toString(){
        return this.value;
    }

    // Comparing the fscores of two nodes to make a decision for the path
    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(this.fScore, otherNode.getfScore());
    }


}
