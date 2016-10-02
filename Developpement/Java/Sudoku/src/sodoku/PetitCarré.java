/*
 * PetitCarré.java
 *
 * Created on 28 mars 2006, 19:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package sodoku;

import java.awt.Color;
import java.awt.Font;
import java.util.HashSet;

/**
 * Une case du Sudoku
 * @author Yvan Maillot
 */
public class PetitCarré implements Cloneable {

    private Bouton bouton;
    private HashSet<Integer> possibilité;
    private int l, c;
    PetitCarré[] ligne;
    PetitCarré[] colonne;
    PetitCarré[] carré;
    GrandCarré grand_carré;
    Font FontePour1Caractère, Fonte;
    
   public PetitCarré(int l, int c, GrandCarré grand_carré) {
        Fonte = new Font("Bradley Hand ITC", Font.BOLD, 16);
        FontePour1Caractère = new Font("Bradley Hand ITC", Font.BOLD, 50);
        this.grand_carré = grand_carré;
        this.l = l+1;
        this.c = c+1;
        possibilité = new HashSet<Integer>();
        for(int v = 1; v <= 9; v++) {
            possibilité.add(v);
        }
    }
    public void mise_à_jour() {
        //bouton.setText(construire_nom());
        construire_nom_bouton();
    }    
    public PetitCarré copie() {
        PetitCarré petit_carré = new PetitCarré(l, c, null);
        petit_carré.Fonte = Fonte;
        petit_carré.FontePour1Caractère = FontePour1Caractère;

        petit_carré.bouton = bouton;
        petit_carré.possibilité = new HashSet<Integer>();
        for(Integer i : possibilité)
            petit_carré.possibilité.add(i.intValue());
        petit_carré.ligne = null;
        petit_carré.colonne = null;
        petit_carré.carré = null;
        
        return petit_carré;
    }    
    public PetitCarré clone() throws CloneNotSupportedException {
        PetitCarré petit_carré = (PetitCarré)super.clone();
        if (possibilité.size() == 1)
            System.out.println("AVANT");
        //petit_carré.possibilité = (HashSet<Integer>)possibilité.clone();
        //petit_carré.possibilité = new HashSet<Integer>();
        if (possibilité.size() == 1)
            System.out.println("APRES");
        
        // Les 4 attributs suivants ne peuvent être mis à jour que depuis
        // le grand_carré
        petit_carré.ligne = null;
        petit_carré.colonne = null;
        petit_carré.carré = null;
        petit_carré.grand_carré = null;
        
        return petit_carré;
    }    
    public void setBouton(Bouton bouton) {
        this.bouton = bouton;
    }
    
    public HashSet<Integer> valeurs_possible() {
        return (HashSet<Integer>)possibilité.clone();
    }
    public void setValeurs(int[] v) {
        for(int i = 0; i < v.length; i++) {
            possibilité.add(v[i]);
        }
        //bouton.setText(construire_nom());
        construire_nom_bouton();
    }    
    public void setValeur(int v) {
        if (possibilité.size() > 1) {
            possibilité.clear();
            possibilité.add(v);
            //bouton.setText(construire_nom());
            construire_nom_bouton();
            nettoie();
        }
    }
    /**
     *Ne doit être lancé que si la case ne contient qu'un seul élément.
     *Elle retire cet élément de toutes les cases de la ligne,
     *de la colonne et du carré associé à la case.
     *Retourne faux, si une case se retrouve vide
     **/
    private boolean nettoie_ligne() {
        for(PetitCarré c : ligne) {
            if (!c.enlever(possibilité))
                return false;
        }
        return true;
    }
    private boolean nettoie_colonne() {
        for(PetitCarré c : colonne) {
            if (!c.enlever(possibilité))
                return false;
        }
        return true;
    }
    private boolean nettoie_carré() {
        for(PetitCarré c : carré) {
            if (!c.enlever(possibilité))
                return false;
        }
        return true;
    }  
    private boolean nettoie() {
       
        boolean ok = possibilité.size() == 1 &&
                nettoie_ligne() && 
                nettoie_colonne() && 
                nettoie_carré();
        return ok;
    }
    
    /**
     * 
     * Enlève des possibilités d'une case la valeur en argument
     * Rien n'est fait si cette valeur est déjà absente.
     * Attention : 1 <= e <= 9
     * @param e La valeur à retirer
     */
    public boolean enlever(int e) {
            int size = possibilité.size();
            possibilité.remove(e);
            if (size != possibilité.size()) {
                //bouton.setText(construire_nom());
                construire_nom_bouton();
                if (possibilité.size() == 0) {
                    bouton.setBackground(Color.RED);
                    return false;
                } else if (possibilité.size() == 1) {
                    //bouton.setText(construire_nom());
                    construire_nom_bouton();
                    return nettoie();
                } 
            }
            return true;      
    }
    public void construire_nom_bouton() {
        if (possibilité.size() == 1) {
            bouton.setText(possibilité.iterator().next().toString());
            bouton.setFont(FontePour1Caractère);
        } else {
            bouton.setFont(Fonte);
            String nom = "<html>";
            int k = 1;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if (possibilité.contains(k)) {
                        nom+=k+"";
                    } else {
                        nom+=" ";
                    }
                    k++;
                }
                nom+="<br>";
            }
            bouton.setText(nom+"</html>");  
        }
    }

    /**
     * 
     * Enlève des possibilités d'une case la valeur en argument
     * Rien n'est fait si cette valeur est déjà absente.
     * Attention : 1 <= e <= 9
     * @param e La valeur à retirer
     */
    public boolean enlever(HashSet<Integer> e) {
        int size = possibilité.size();
        possibilité.removeAll(e);
        if (size != possibilité.size()) {
            //bouton.setText(construire_nom());
            construire_nom_bouton();
            if (possibilité.size() == 0) {
                bouton.setBackground(Color.RED);
                return false;
            }
            else if (possibilité.size() == 1)  {
                //bouton.setText(construire_nom());
                construire_nom_bouton();
                return nettoie();
            } 
        }
        return true;      
    }
    /** 
     *Ajoute e.
     *Attention : 1 <= e <= 9
     * @param e La valeur à ajouter
     **/
    public void ajouter(int e) {
        possibilité.add(e);
    }
   
}
