import javax.swing.JFrame;

public class ServerTest {
	public static void main(String[] args){
		Server ani = new Server();
		ani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ani.startRunning();
	}

}
