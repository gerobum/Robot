/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jours;

/**
 *
 * @author yvan
 */
public enum Jour {
  LUNDI("Lundi"), MARDI("Mardi"), MERCREDI("Mercredi"),
  JEUDI("Jeudi"), VENDREDI("Vendredi") {
      public void questCeQuonMange() {
         System.out.println("c'est spaghetti");
      }
   },
  SAMEDI, DIMANCHE {
      public void questCeQuonMange() {
         System.out.println("c'est cèleri-branche");
      }
   };
  public final String nom;
  Jour() { this.nom = name(); }
  Jour(String nom) { this.nom = nom;}
  public void questCeQuonMange() {
    System.out.println("c'est ravioli");
  }
}
