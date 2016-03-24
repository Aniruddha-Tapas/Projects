package ColoringProblem;

public class GraphColoring {
	private int numOfVertices;
	private int numOfColors;
	private int[] colors;
	private int[][] graphMatrix;

	public void graphColor(int[][] graph, int numOfColors) {
		this.numOfVertices = graph.length;
		this.numOfColors = numOfColors;
		this.colors = new int[numOfVertices];
		this.graphMatrix = graph;
	}

	public void solveColoringProblem() {
		try{
			solve(0);
			System.out.println("No solution with the given parameters...");
		}catch(RuntimeException ex){
			showResult();
		}
	}
	
	public void solve(int nodeIndex) {

		if (nodeIndex == numOfVertices) {
			throw new RuntimeException("Solution found...");
		}

		for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
			if (isColorValid(nodeIndex, colorIndex)) {
				colors[nodeIndex] = colorIndex;
				solve(nodeIndex + 1);
			}
		}
	}

	/** function to check if it is valid to allot that color to vertex **/
	public boolean isColorValid(int nodeInex, int colorInedex) {
		for (int i = 0; i < numOfVertices; i++) {
			if (graphMatrix[nodeInex][i] == 1 && colorInedex == colors[i]) {
				return false;
			}
		}

		return true;
	}

	public void showResult() {
		for (int i = 0; i < numOfVertices; i++)
			System.out.println("Node "+(i+1)+" has color index: "+colors[i] + " ");
		System.out.println();

	}
}
