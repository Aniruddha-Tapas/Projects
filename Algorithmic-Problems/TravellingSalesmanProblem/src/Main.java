package TSP;

public class Main {

	/**
	 * 
	 * Basically, the smaller the change in energy (the quality of the
	 * solution), and the higher the temperature, the more likely it is for the
	 * algorithm to accept the solution.
	 * 
	 * - First we need set the initial temperature and create a random initial
	 * solution - From here we select a neighbour by making a small change to
	 * our current solution - We then decide whether to move to that neighbour
	 * solution - Finally, we decrease the temperature and continue looping
	 * 
	 */

	public static void main(String[] args) {

		City city = new City("Berlin" , 60, 200);
		SingleTravelManager.addCity(city);
		City city2 = new City("London",180, 200);
		SingleTravelManager.addCity(city2);
		City city3 = new City("Budapest",80, 180);
		SingleTravelManager.addCity(city3);

		Simulation simulation = new Simulation();
		simulation.simulateTravellingProblem();
		

	}
}
