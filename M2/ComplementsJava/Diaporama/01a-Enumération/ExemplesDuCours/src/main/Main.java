/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import jours.Jour;
import static jours.Jour.*;

public class Main {

  public static void main(String[] args) {
    boolean encore = true;
    Scanner clavier = new Scanner(System.in);
    Jour jour = LUNDI;
    do {
      System.out.print("Un jour ? ");
      try {
        jour = Jour.valueOf(clavier.next().toUpperCase());
        System.out.println(jour + " a été choisi.");
        encore = false;
      } catch (IllegalArgumentException iae) {
        System.err.println("Lundi ou mardi ou ...");
      }
    } while (encore);

    switch (jour) {
      case LUNDI:
        System.out.println("Ca va comme un lundi");
        break;
      case MARDI:
      case MERCREDI:
      case JEUDI:
        System.out.println("Boulot, boulot");
        break;
      case VENDREDI:
        System.out.println("C'est bientôt fini");
        break;
      case SAMEDI:
      case DIMANCHE:
        System.out.println("C'est cool");
        break;
    }
    
    for(Jour j : Jour.values()) {
      System.out.print(j.nom + " ");
      j.questCeQuonMange();
    }
  }
}
