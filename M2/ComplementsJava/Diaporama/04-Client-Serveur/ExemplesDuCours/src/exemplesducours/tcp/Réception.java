package exemplesducours.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author yvan
 */
public class Réception {

    public static void main(String[] args) throws
            SocketException, IOException {
        try (Socket s = new Socket("192.168.1.32", 1414);
                Scanner scan = new Scanner(s.getInputStream())) {
            System.out.println("Connecté");
            while (scan.hasNext()) {
                System.out.println(scan.nextInt());
            }
            System.out.println("Fini");
        }
    }
}
