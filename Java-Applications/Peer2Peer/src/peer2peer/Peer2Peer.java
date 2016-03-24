package peer2peer;

import java.io.IOException;
import java.util.Scanner;

public class Peer2Peer {

    public static void main(String[] args) throws IOException, Exception {
        int a[] = new int[50];
        for (int k = 0; k < 50; k++) {
            a[k] = 1;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Node 3 sending packets to either of the two nodes");
        System.out.println("Send to Node 1 / 2");
        int d = sc.nextInt();
        
        int q;
        NodeN3 a4;
        while (true) {
            a4 = new NodeN3(d, a);
            System.out.println("Continue sending? Click 1 for Exit and 2 to Continue");
            q = sc.nextInt();
            if (q == 1) {
                break;       

            }
        }
        System.out.println("Node 2 sending packets to either of the two nodes");
        System.out.println("Send to Node 1 / 3");
        int k = sc.nextInt();
        int i;
        NodeN2 a0;
        while (true) {
            a0 = new NodeN2(k, a);
            System.out.println("Continue sending? Click 1 for Exit and 2 to Continue");
            q = sc.nextInt();
            if (q == 1) {
                break;
                
            }
        }
        System.out.println("Node 1 sending packets to either of the two nodes");
        System.out.println("Send to Node 2 / 3");
        int t = sc.nextInt();
    
        int y;
        NodeN1 a11;
        while (true) {
            a11 = new NodeN1(t, a);
            System.out.println("Continue sending? Click 1 for Exit and 2 to Continue");
            q = sc.nextInt();
            if (q == 1) {
                break;       
            }
        }
    }
}

class NodeN1 {

    int a[];

    int priority = 3;
    String IP_address = "192.168.1.153";

    NodeN1() {

    }

    NodeN1(int x, int a[]) throws IOException, Exception {
        this.a = a;
        NodeN2 a1 = new NodeN2();
        NodeN3 a2 = new NodeN3();

        a1.display();
        a2.display();
        if (x == 2) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

        if (x == 3) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

    }

    void display() {
        System.out.println("address   " + IP_address);
    }

    void getdata(int a) {
        System.out.println("data is..." + a);

    }

    int getack() {
        return 0;
    }
}

class NodeN2 {

    int x;
    int a[];
    int priority = 2;
    String IP_address = "192.168.1.1532";

    NodeN2() {

    }

    NodeN2(int x, int a[]) throws IOException, Exception {
        this.a = a;
        this.x = x;
        NodeN1 a1 = new NodeN1();
        NodeN3 a2 = new NodeN3();

        a1.display();
        a2.display();
        if (x == 1) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

        if (x == 3) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

    }

    void display() {
        System.out.println("address    " + IP_address);
    }

    void getdata(int a) {
        System.out.println("data is..." + a);

    }

    int getack() {
        return 0;
    }
}

class NodeN3 {

    int k;
    int a[];
    int priority = 1;
    String IP_address = "192.168.1.151";

    NodeN3() {

    }

    NodeN3(int x, int a[]) throws IOException, Exception {
        this.a = a;
        NodeN1 a1 = new NodeN1();
        NodeN2 a2 = new NodeN2();

        a1.display();
        a2.display();
        if (x == 1) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

        if (x == 2) {
            System.out.println("Run the Client");
            server a1111 = new server();
        }

    }

    void display() {
        System.out.println("ip address " + IP_address);
    }

    void getdata(int a) {
        System.out.println("data  " + a);

    }

    int getack() {
        return 0;
    }
}


