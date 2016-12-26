package fx.programme.instructions;

import fx.exceptions.DansLeMur;
import fx.robot.Robot;
import javax.swing.ImageIcon;


/**
 *
 * @author Yvan
 */
public class Racine extends InstructionComposee {
    
    private static final long serialVersionUID = 1L;
    
    public Racine(String nom) {
        super(null);
        this.nom = nom;
    }
    
    public Racine() {
        this("programme");
    }

    @Override
    public void go(Robot robot) throws DansLeMur {
    }
    
    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean autorisationAjout() {
        return false;
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

    @Override
    public String deepToString(String decalage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
