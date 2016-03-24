package binpackingproblem;

/**
 *
 * @author ANIRUDDHA
 */
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> items = Arrays.asList(5,5,5);
		int binCapacity = 5;
		
		FirstFitDecreasingAlgorithm algorithm = new FirstFitDecreasingAlgorithm(items, binCapacity);
		algorithm.solveBinPackingProblem();
		algorithm.showResults();

	}
}
