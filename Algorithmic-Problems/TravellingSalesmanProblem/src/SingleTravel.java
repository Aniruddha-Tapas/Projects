package TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTravel {
	
	// N cities -> N! permutations

	private List<City> tourList;
	private int distance;
	
	public SingleTravel(){
		this.tourList = new ArrayList<>();
		
		for (int i = 0; i < SingleTravelManager.numOfCities; i++) {
            tourList.add(null);
        }
	}
	
	public SingleTravel(List<City> tourList){
		this.tourList = tourList;	
	}

	public List<City> getTourList() {
		return tourList;
	}

	public void setTourList(List<City> tourList) {
		this.tourList = tourList;
	}
	
	// random tour: at start this is the solution...in the algorithm we keep enhancing
	// this initial solution
	public void generateIndividual(){
		for(int i = 0;i<SingleTravelManager.numOfCities;i++){
			setCity(i,SingleTravelManager.getCity(i));
		}
		
		// generate a random tour
		Collections.shuffle(this.tourList);
	}
	
	public City getCity(int index){
		return this.tourList.get(index);
	}

	public void setCity(int cityIndex, City city) {
		this.tourList.set(cityIndex, city);
		this.distance = 0;
	}

	public int getDistance(){
		if( this.distance == 0 ){
			
			int tourDistance = 0;
           
			int size = this.tourList.size();
            for (int  i=0;  i < size;  i++) {
           
                City fromCity = getCity(i);
                City destinationCity;
              
                if( i+1 < this.tourList.size()){
                    destinationCity = getCity( i+1);
                }else{
                    destinationCity = getCity(0);
                }
             
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            
            this.distance = tourDistance;
		}
		
		return this.distance;
	}
	
	@Override
    public String toString() {     
		String s = "";	
		
		int size = this.tourList.size();
        for (int i = 0; i < size; i++) {
            s += getCity(i)+" - ";
        }
        return s;
    }
}