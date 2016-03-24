package coinchangeproblem;

public class Main {

	
	
	public static void main(String[] args) {
		
		int[] coins = {1,2,3,4,5};
		int M = 1000;
		
		CoinChange coinChange = new CoinChange();
		System.out.println( coinChange.naiveApproach(M, coins, 0) );
		
	}
}
