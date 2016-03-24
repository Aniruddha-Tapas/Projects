package TSP;

public class City {

	private String cityName;
	private int coordinateX;
	private int coordinateY;

	public City(String cityName, int coordinateX, int coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	
	// Eucledian distance 
	public double distanceTo(City city){
		
		int xDistance = Math.abs(this.coordinateX-city.getCoordinateX());
		int yDistance = Math.abs(this.coordinateY-city.getCoordinateY());
		
		double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
		
		return distance;
	}

	@Override
	public String toString() {
		return this.cityName;
	}
}
