package coinchangeproblem;

public class CoinChange {

	// M = total amount, v = coins array !!!
	public int naiveApproach(int M, int[] v, int index) {

		if ( M < 0 ) return 0;
		if ( M == 0 ) return 1;

		if ( index == v.length ) return 0;
		
		return naiveApproach(M - v[index], v, index) + naiveApproach(M, v, index + 1);
	}
	
	// M = total amount, v = coins array !!!
	public void dynamicProgrammingApproach(int[] v, int M) {
		
		int[][] dpTable = new int[v.length + 1][M + 1];

		for (int i = 0; i <= v.length; i++) {
			dpTable[i][0] = 1;
		}
		
		for (int i = 1; i <= M; i++) {
			dpTable[0][i] = 0; // if no coins given, 0 ways to change the amount
		}

		// O(v*M) where v = coins and M = total
		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= M; j++) {
				
				if (v[i - 1] <= j) { // Check if the coin value is less than the amount needed
					dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - v[i - 1]];
				} else {
					dpTable[i][j] = dpTable[i - 1][j]; // copy content from cell above
				}
			}
		}
		
		System.out.println( dpTable[v.length][M] );
	}
}
