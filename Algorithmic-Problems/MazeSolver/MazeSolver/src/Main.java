package MazeSolver;

public class Main {

	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader("C:\\Users\\Comp\\Desktop\\map.txt", 5, 5);
                fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(),fileReader.getStartPositionRow(),fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
		
	}
}
