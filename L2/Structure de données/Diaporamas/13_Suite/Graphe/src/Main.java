
import graphe.Graphe;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yvan
 */
public class Main {

  public static void main(String[] args) {
    Graphe g = new Graphe(10);
    g.lier(0, 1);
    g.lier(1, 2);
    g.lier(1, 6);
    g.lier(2, 1);
    g.lier(2, 2);
    g.lier(2, 6);
    g.lier(2, 7);
    g.lier(3, 2);
    g.lier(3, 4);
    g.lier(3, 5);
    g.lier(3, 7);
    g.lier(4, 9);
    g.lier(5, 9);
    g.lier(6, 9);
    g.lier(8, 2);
    g.lier(8, 4);
    g.lier(9, 3);
    
    g.profondeur(0);
  }
}
