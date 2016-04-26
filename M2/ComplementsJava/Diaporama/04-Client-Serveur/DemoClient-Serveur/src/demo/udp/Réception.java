/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author yvan
 */
public class Réception {
  public static void main(String[] args) throws SocketException, IOException {
      try (DatagramSocket ds = new DatagramSocket(1414)) {
          byte[] tampon = new byte[256];
          DatagramPacket dp = new DatagramPacket(tampon, tampon.length);
          for(int i = 0; i < 100; i++) {
              ds.receive(dp);
              System.out.println(new String(tampon).trim());
}   }   }   }
