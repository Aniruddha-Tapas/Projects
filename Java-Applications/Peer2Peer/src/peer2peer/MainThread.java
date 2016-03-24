package peer2peer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


import java.util.Scanner;

class MainThread extends Thread {

    Socket sc;

    MainThread(Socket s) {
        sc = s;
        start();
    }

    @Override
    public void run() {
        try {
            Scanner si = new Scanner(System.in);
            try (DataInputStream dis = new DataInputStream(sc.getInputStream())) {
                String str = dis.readUTF();
                System.out.println("message : " + str);
                
                System.out.println("Enter data");
                str = si.next();
                
                DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                dos.writeUTF(str);
            }
        }
        catch (Exception e) {

        }
    }
}

