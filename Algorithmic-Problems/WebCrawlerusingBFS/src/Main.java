package WebCrawler;

public class Main {

	public static void main(String[] args) {
		
		String root = "http://www.appliedprogramming.net";		
		BFS bfs = new BFS();	
		bfs.discoverWeb(root);
		
	}
}
