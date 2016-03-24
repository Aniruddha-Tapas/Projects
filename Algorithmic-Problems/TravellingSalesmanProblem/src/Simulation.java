package TSP;

public class Simulation {

	public void simulateTravellingProblem() {

		double temperature = 100000;
		double coolingRate = 0.00003;

		SingleTravel currentSolution = new SingleTravel();
		currentSolution.generateIndividual();

		System.out.println("Initial solution: " + currentSolution.getDistance());

		SingleTravel bestTravel = new SingleTravel(currentSolution.getTourList());

		while (temperature > 1) {
			
			SingleTravel newSolution = new SingleTravel(currentSolution.getTourList());

			int travelPosition1 = (int) (newSolution.getTourList().size() * Math.random());
			int travelPosition2 = (int) (newSolution.getTourList().size() * Math.random());

			City firstCityToSwap = newSolution.getCity(travelPosition1);
			City secondCityToSwap = newSolution.getCity(travelPosition2);

			newSolution.setCity(travelPosition2, firstCityToSwap);
			newSolution.setCity(travelPosition1, secondCityToSwap);

			int currentEnergy = currentSolution.getDistance();
			int neighbourEnergy = newSolution.getDistance();

			if (acceptanceProbability(currentEnergy, neighbourEnergy, temperature) > Math.random()) {
				currentSolution = new SingleTravel(newSolution.getTourList());
			}

			if (currentSolution.getDistance() < bestTravel.getDistance()) {
				bestTravel = new SingleTravel(currentSolution.getTourList());
			}

			temperature *= (1 - coolingRate);
		}

		System.out.println("Final solution distance: " + bestTravel.getDistance());
		System.out.println("Tour: " + bestTravel);
	}

	public double acceptanceProbability(int energy, int newEnergy, double temperature) {
	
		if (newEnergy < energy) {
			return 1.0;
		}
		
		return Math.exp((energy - newEnergy) / temperature);
	}
}
