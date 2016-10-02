/*
 * GrandCarré.java
 *
 * Created on 29 mars 2006, 10:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package sodoku;

import java.util.HashSet;

/**
 *
 * @author Yvan Maillot
 */
public class GrandCarré implements Cloneable {
    
    /** Creates a new instance of GrandCarré */
    private PetitCarré[][] damier;
    
    public GrandCarré() { 
        damier = new PetitCarré[9][9];
        for(int i = 0; i < 9; i++) 
            for(int j = 0; j < 9; j++) 
                damier[i][j] = new PetitCarré(i,j, this);
        for(int i = 0; i < 9; i++) 
            for(int j = 0; j < 9; j++) {
                damier[i][j].ligne = ligne(i, j);
                damier[i][j].colonne = colonne(i, j);
                damier[i][j].carré = carré(i, j);
            }
    }
    public void mise_à_jour_des_boutons() {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                damier[i][j].mise_à_jour();
    }
    public GrandCarré copie() {
        GrandCarré grand_carré = new GrandCarré();
        grand_carré.damier = new PetitCarré[9][9];
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) 
                grand_carré.damier[i][j] = damier[i][j].copie();
        
        for(int i = 0; i < 9; i++) 
            for(int j = 0; j < 9; j++) {
                grand_carré.damier[i][j].ligne = grand_carré.ligne(i, j);
                grand_carré.damier[i][j].colonne = grand_carré.colonne(i, j);
                grand_carré.damier[i][j].carré = grand_carré.carré(i, j);
            }  
        return grand_carré;
    }
    public boolean fini() {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if (damier[i][j].valeurs_possible().size()!=1)
                    return false;
        return true;
    }
    public boolean erreur() {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if (damier[i][j].valeurs_possible().size()==0)
                    return true;
        return false;
    }    
    public GrandCarré clone() throws CloneNotSupportedException {
        GrandCarré grand_carré = (GrandCarré) super.clone();
        grand_carré.damier = damier.clone();
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) {
                grand_carré.damier[i][j] = damier[i][j].clone();
                grand_carré.damier[i][j].grand_carré = grand_carré;
            }
        for(int i = 0; i < 9; i++) 
            for(int j = 0; j < 9; j++) {
                grand_carré.damier[i][j].ligne = grand_carré.ligne(i, j);
                grand_carré.damier[i][j].colonne = grand_carré.colonne(i, j);
                grand_carré.damier[i][j].carré = grand_carré.carré(i, j);
            }        
        return grand_carré;
    }
    private PetitCarré[] ligne(int l, int c) {
        PetitCarré[] L = new PetitCarré[8];
        int k=0;
        for(int i = 0; i < c; i++) 
            L[k++] = damier[l][i];
        for(int i = c+1; i < 9; i++)
            L[k++] = damier[l][i];
        return L;
    }
    private PetitCarré[] colonne(int l, int c) {
        PetitCarré[] C = new PetitCarré[8];
        int k=0;
        for(int i = 0; i < l; i++) 
            C[k++] = damier[i][c];
        for(int i = l+1; i < 9; i++)
            C[k++] = damier[i][c];
        return C;
    } 
    private PetitCarré[] carré(int l, int c) {
        int linf, lsup, cinf, csup;
        if (l < 3) {
            linf = 0;
            lsup = 3;
        } else if (l > 5) {
            linf = 6;
            lsup = 9;
        } else {
            linf = 3;
            lsup = 6;
        }
        if (c < 3) {
            cinf = 0;
            csup = 3;
        } else if (c > 5) {
            cinf = 6;
            csup = 9;
        } else {
            cinf = 3;
            csup = 6;
        }  
        PetitCarré[] C = new PetitCarré[8];
        int k = 0;
        for(int i = linf; i < lsup; i++)
            for(int j = cinf; j < csup; j++) {
                if (i != l || j != c) 
                    C[k++] = damier[i][j];
            }
        return C;
    }
    public HashSet<Integer> valeurs_possibles(int l, int c) {
        return damier[l][c].valeurs_possible();
    }
    public PetitCarré getCarré(int l, int c) {
        return damier[l][c];
    }
    public void nouvelle_partie() {
        int[] tous = {1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                   damier[i][j].setValeurs(tous);
            }
        }
    }
    public boolean récure() {
        boolean changement;
        do {
            changement = false;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) {
                HashSet<Integer> possibilité = damier[i][j].valeurs_possible();
                if (possibilité.size() == 0)
                    return false;

                if (possibilité.size() > 1) {
                    for(PetitCarré c : getCarré(i,j).carré) {
                        possibilité.removeAll(c.valeurs_possible());
                    }
                    if (possibilité.size() == 1) {
                        changement = true;
                        getCarré(i,j).setValeur(possibilité.iterator().next());
                    }
                     
                }
                //if (possibilité.size() == 0)
                //    return false;

                possibilité = damier[i][j].valeurs_possible();

                if (possibilité.size() > 1) {
                    for(PetitCarré c : getCarré(i,j).ligne) {
                        possibilité.removeAll(c.valeurs_possible());
                    }
                    if (possibilité.size() == 1) {
                        changement = true;
                        getCarré(i,j).setValeur(possibilité.iterator().next());
                    }
                     
                }            
                //if (possibilité.size() == 0)
                //    return false;

                possibilité = damier[i][j].valeurs_possible();

                if (possibilité.size() > 1) {
                    for(PetitCarré c : getCarré(i,j).colonne) {
                        possibilité.removeAll(c.valeurs_possible());
                    }
                    if (possibilité.size() == 1) {
                        changement = true;
                        getCarré(i,j).setValeur(possibilité.iterator().next());            
                    }
                } 
                //if (possibilité.size() == 0)
                //    return false;

            }
        } while(changement);
        return true;
    }
}
