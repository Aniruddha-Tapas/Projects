package KnapsackProblem;

public class Knapsack {
	
	private int numOfItems;
	private int capacityOfKnapsack;
	private int[] weightOfItems;
	private int[] profitOfItems;
	private int totalBenefit;
	private int[][] itemsTaken;
	
	public Knapsack(int numOfItems, int capacityOfKnapsack,int[] weightOfItems, int[] profitOfItems) {
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.weightOfItems = weightOfItems;
		this.profitOfItems = profitOfItems;
	}

	public void solveKnapsackProblem() {
		
		int[][] knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
		itemsTaken = new int[numOfItems+1][capacityOfKnapsack+1];
		
		for(int i=1;i<=this.numOfItems;i++){
			for(int w=1;w<=this.capacityOfKnapsack;w++){
				
				int notTakeItem = knapsackTable[i-1][w]; // not taking item i
				
				int takeItem = 0;
				if (weightOfItems[i] <= w){
					takeItem = profitOfItems[i] + knapsackTable[i-1][w-weightOfItems[i]];  // taking item i
				}			
				
				knapsackTable[i][w] = Math.max( notTakeItem, takeItem );
				
				if( takeItem > notTakeItem ){
					itemsTaken[i][w] = 1; // track what items we take
				}else{
					itemsTaken[i][w] = 0;
				}	
			}	
		}
		
		totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
	}

	public void showResult() {
		
		System.out.println("Total benefit: "+totalBenefit+"\n");
		
		 for (int n = this.numOfItems, w = this.capacityOfKnapsack; n > 0; n--) {
	            if (this.itemsTaken[n][w] == 1 ) {
	            	System.out.println("We take item #"+n);
	            	w = w - this.weightOfItems[n];
	            }                    
	        }
	}

}
