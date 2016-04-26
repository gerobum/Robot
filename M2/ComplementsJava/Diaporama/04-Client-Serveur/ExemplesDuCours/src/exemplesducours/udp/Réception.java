package exemplesducours.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author yvan
 */
public class Réception {

    public static void main(String[] args) throws SocketException, IOException, InterruptedException {
        try (DatagramSocket ds = new DatagramSocket(1414)) {
            byte[] tampon = new byte[256];
            DatagramPacket dp = new DatagramPacket(tampon,
                    tampon.length);
            ds.receive(dp);
            System.out.print(new String(tampon).trim());
            for (int i = 0; i < 100; i++) {
                //Thread.sleep(333);
                ds.receive(dp);
                System.out.print(", " + new String(tampon).trim());
            }
        }
        System.out.println("\nFin de la réception");
    }
}
