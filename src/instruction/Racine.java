/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

import javax.swing.ImageIcon;
import robot.DansLeMur;
import robot.Robot;

/**
 *
 * @author Yvan
 */
public class Racine extends InstructionComposee {
    
    private static final long serialVersionUID = 1L;
    
    public Racine(String nom) {
        this.nom = nom;
        setParent(null);
    }
    
    public Racine() {
        this("programme");
    }

    @Override
    public void go(robot.Robot robot) throws DansLeMur {
    }
    
    @Override
    public String toString() {
        return nom;
    }

    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public boolean autorisationAjout() {
        return false;
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }
}
