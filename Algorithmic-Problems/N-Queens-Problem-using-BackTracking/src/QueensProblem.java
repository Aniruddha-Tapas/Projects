package BackTracking;

public class QueensProblem {

	private int[] queensArray;
	private int numOfQueens;

	public QueensProblem(int numberOfQueens) {
		queensArray = new int[numberOfQueens];
		this.numOfQueens = this.queensArray.length;
	}

	public void solveQueensProblem() {
		arrangeqQueens(0);
	}

	public void arrangeqQueens(int rowIndex) {
		for (int i = 0; i < numOfQueens; i++) {

			if ( isPlaceValid(rowIndex, i) ) {

				queensArray[rowIndex] = i;

				if (rowIndex == numOfQueens - 1) {
					printQueens(queensArray);
				} else {
					arrangeqQueens(rowIndex + 1);
				}
			}
		}
	}

	public boolean isPlaceValid(int rowIndex, int columnIndex) {
		for (int i = 0; i < rowIndex; i++) {
			if (queensArray[i] == columnIndex) return false; // same column
			if ((i - rowIndex) == (queensArray[i] - columnIndex)) return false; // for ascending .. tehat bal fentrol megy jobb le
			if ((i - rowIndex) == (columnIndex - queensArray[i])) return false;   // for descending...tehat jobb fentrol megy bal le
		}
		
		return true;
	}

	public void printQueens(int[] queensArray) {

		int numOfQueens = queensArray.length;

		for (int i = 0; i < numOfQueens; i++) {
			for (int j = 0; j < numOfQueens; j++) {

				if (queensArray[i] == j) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}

			}
			System.out.println();
		}
		System.out.println();
	}
}
