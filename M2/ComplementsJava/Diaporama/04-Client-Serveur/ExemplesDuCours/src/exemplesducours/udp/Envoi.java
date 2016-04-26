package exemplesducours.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;

public class Envoi {
    public static void main(String[] args) throws SocketException, IOException, InterruptedException {
        try (DatagramSocket ds = new DatagramSocket()) {
            DatagramPacket dp;
            for (int i = 0; i < 100; i++) {
                dp = new DatagramPacket((i + "").getBytes(),
                        (i + "").length(), Inet4Address.getLocalHost(),
                        1414);
                Thread.sleep(333);
                ds.send(dp);
            }
        }
        System.out.println("Fin de l'envoi");
    }
}
