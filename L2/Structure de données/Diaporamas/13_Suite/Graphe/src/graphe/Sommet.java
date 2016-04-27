/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

import java.util.ArrayList;

/**
 *
 * @author yvan
 */
public class Sommet {
  int info;
  boolean marque = false;
  ArrayList<Sommet> voisins;
  
  
  public Sommet(int info) {
    this.info = info;
    voisins = new ArrayList<>();
  }
  
  public void ajouter(Sommet voisin) {
    voisins.add(voisin);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 11 * hash + this.info;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Sommet other = (Sommet) obj;
    if (this.info != other.info) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return ""+info;
  }
  
  
}
