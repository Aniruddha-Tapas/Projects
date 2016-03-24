package TowersOfHanoi;

public class Algorithm {

	public void solveHanoiProblem(int n, char rodFrom, char middleRod, char rodTo){
		
		if( n == 1 ){
			System.out.println("Plate 1 from " + rodFrom + " to " + rodTo);
			return;
		}
		
		solveHanoiProblem(n-1, rodFrom, rodTo, middleRod);
		System.out.println("Plate " + n + " from " + rodFrom + " to " + rodTo);
		solveHanoiProblem(n-1, middleRod, rodFrom, rodTo);
	}
}
