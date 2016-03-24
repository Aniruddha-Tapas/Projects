/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iddfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANIRUDDHA
 */

//Node in the tree
public class Node {
    
    private String name;
    private int depthLevel = 0;
    private List<Node> adjacenciesList;
    
    public Node(String name){
        this.name = name;
        this.adjacenciesList = new ArrayList<Node>();
    }
    
    public void addNeighbour(Node node){
        this.adjacenciesList.add(node);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(int depthLevel) {
        this.depthLevel = depthLevel;
    }

    public List<Node> getAdjacenciesList() {
        return adjacenciesList;
    }
    
    public String toString(){
        return this.name;
    }
    
}
