package knighttour;

class KnightTour {

	private int[][] solutionMatrix;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public KnightTour() {
		this.solutionMatrix = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < Constants.BOARD_SIZE; ++i)
			for (int y = 0; y < Constants.BOARD_SIZE; ++y)
				this.solutionMatrix[i][y] = Integer.MIN_VALUE;
	}

	public void solveKnightTourProblem() {

		this.solutionMatrix[0][0] = 0;

		if ( !solveProblem(1, 0, 0) ) {
			System.out.println("No feasible solution found...");
			return;
		}
		 
		showSolution();	
	}

	public boolean solveProblem(int stepCount, int x, int y) {

		if (stepCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE) {
			return true;
		}

		for (int i = 0; i < Constants.BOARD_SIZE; ++i) {

			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			if ( isValidMove(nextX, nextY) ) {

				this.solutionMatrix[nextX][nextY] = stepCount;

				if ( solveProblem(stepCount + 1, nextX, nextY) ) {
					return true; // good solution, keep going
				}

				this.solutionMatrix[nextX][nextY] = Integer.MIN_VALUE; // remove from solutions --> backtracking
			}
		}

		return false;
	}

	public boolean isValidMove(int x, int y) {

		if (x < 0 || x >= Constants.BOARD_SIZE) return false;
		if (y < 0 || y >= Constants.BOARD_SIZE) return false;
		if (this.solutionMatrix[x][y] != Integer.MIN_VALUE) return false;

		return true;
	}

	public void showSolution() {
		for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
			for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
				System.out.print(this.solutionMatrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}
