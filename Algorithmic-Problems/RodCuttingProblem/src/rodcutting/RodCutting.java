package rodcutting;

public class RodCutting {

	public void dynamicProgrammingApproach(int lengthOfRod, int[] prices) {
	
		prices = transformPrices(prices);
		
		int[][] dpTable = new int[prices.length+1][lengthOfRod+1];
		
//		for(int i=0;i<prices.length+1;++i){
//			dpTable[i][0] = 0;
//		}
//		
//		for(int j=0;j<lengthOfRod+1;++j){
//			dpTable[0][j] = 0;
//		}
		
		for (int i = 1; i < prices.length; ++i) {
			for (int j = 1; j <= lengthOfRod; ++j) {
				
				if( i <= j ){
					dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i]+dpTable[i][j-i]);
				}else{
					dpTable[i][j] = dpTable[i-1][j];
				}
				
				System.out.print(dpTable[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println( "Optimal profit: $" + dpTable[prices.length-1][lengthOfRod] );
	}

	private int[] transformPrices(int[] prices) {
		
		int[] newPrices = new int[prices.length+1];
		
		newPrices[0] = 0;
		
		for(int i=0;i<prices.length;i++){
			newPrices[i+1]=prices[i];
		}
		
		return newPrices;
	}
}
