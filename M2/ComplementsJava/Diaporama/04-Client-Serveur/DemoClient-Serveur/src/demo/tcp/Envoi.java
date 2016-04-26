/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.tcp;

import demo.udp.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author yvan
 */
public class Envoi {
  public static void main(String[] args) throws SocketException, IOException {
    ServerSocket serveur = new ServerSocket(1414);
    System.out.println("Attente de connexion");
    try (Socket s = serveur.accept()) {
      System.out.println("Connecté");
      PrintStream pw = new PrintStream(s.getOutputStream());
      for(int i = 0; i < 100; i++) {
        pw.println(i);
} } } }
