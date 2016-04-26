package exemplesducours.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Envoi {

    public static void main(String[] args) throws
            SocketException, IOException {

        ServerSocket serveur = new ServerSocket(1414);
        System.out.println("Attente de connexion");
        try (Socket s = serveur.accept()) {
            System.out.println("Connecté");
            PrintStream pw = new PrintStream(s.getOutputStream());
            for (int i = 0; i < 100; i++) {
                pw.println(i);
            }
        }
    }
}
