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
public class Graphe {

 
    ArrayList<Sommet> graphe = new ArrayList<>();
    
    public Graphe(int n) {
      for(int i = 0; i < n; i++) {
        ajouter();
      }
    }
    
    public void ajouter() {
      graphe.add(new Sommet(graphe.size()));
    }
    
    public void lier(int a, int b) {
      graphe.get(a).ajouter(graphe.get(b));
    }
    
    public void profondeur(int i) {
      for(Sommet s : graphe) {
        s.marque = false;
      }
      profond(graphe.get(i));
    }
    
    private void profond(Sommet s) {
      s.marque = true;
      System.out.println(s);
      for(Sommet v : s.voisins) {
        if (!v.marque) {
          profond(v);
        }
      }
    }
    
  
}
