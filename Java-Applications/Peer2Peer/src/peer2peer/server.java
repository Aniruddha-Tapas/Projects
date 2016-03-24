package peer2peer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    server() throws Exception {
        Scanner scc = new Scanner(System.in);
        System.out.println("Server starts");
        ServerSocket ss = new ServerSocket(8888);
        int i = 0;
        int x = 1;
        int y = 0;
        System.out.println("Enter the total number of messages: ");
        y = scc.nextInt();

        while (i < y) {

            Socket sc = ss.accept();
            MainThread s;
            s = new MainThread(sc);
            i++;

        }
    }

}