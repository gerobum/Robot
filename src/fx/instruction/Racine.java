package fx.instruction;

import javax.swing.ImageIcon;
import fx.robot.DansLeMur;
import fx.robot.Robot;

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
}
