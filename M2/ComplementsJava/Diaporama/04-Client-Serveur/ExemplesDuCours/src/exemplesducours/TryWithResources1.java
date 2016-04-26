/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplesducours;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yvan
 */
public class TryWithResources1 {
    public static void main(String[] args) throws IOException {
    // Utilisation d’une ressource de type BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            // Lecture de la première ligne
            System.out.println(br.readLine());
        }
    }
}
