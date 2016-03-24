package binpackingproblem;

/**
 *
 * @author ANIRUDDHA
 */

import java.util.ArrayList;
import java.util.List;

public class Bin {

	private int id;
    private int capacity;
    private int currentSize;
    private List<Integer> items;

    public Bin(int capacity, int id) {
        this.capacity = capacity;
        this.id = id;
        this.items = new ArrayList<Integer>();
    }

    public boolean put(Integer item) {
    	
    	if( this.currentSize + item > this.capacity ) return false;
    	
        this.items.add(item);
        this.currentSize += item;
            
        return true;
    }
    
    @Override
    public String toString() {
     
    	String contentOfBin = "Items in bin #"+this.id+": ";
    	
    	for(Integer item : this.items){
    		contentOfBin += item+" ";
    	}
    	
    	return contentOfBin;
    }
}
