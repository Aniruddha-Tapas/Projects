package peer2peer;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class client {

    public static void main(String[] args) throws Exception {
        //InetAddress a =null;
        //String addr= a.getHostAddress();
        //Socket ss=new Socket("local host",9999);
        //System.out.println(addr);
        while (true) {
            System.out.println("Client");
            Socket ss = new Socket("localhost", 8888);
            Scanner si = new Scanner(System.in);
            System.out.println("Enter the message to be sent");
            String str = si.next();
            try (DataOutputStream dos = new DataOutputStream(ss.getOutputStream())) {
                dos.writeUTF(str);
                DataInputStream dis = new DataInputStream(ss.getInputStream());
                str = dis.readUTF();
                System.out.println("message : " + str);
                
                dos.close();
            }
        }
    }
}
