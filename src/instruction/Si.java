/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

import expressions.ExprBool;
import java.awt.Image;
import javax.swing.ImageIcon;
import robot.DansLeMur;

/**
 *
 * @author Yvan
 */
public class Si extends InstructionComposee {
    
    private static final long serialVersionUID = 1L;
    
    public static final int ALORS = 1;
    public static final int SINON = 2;
    private ExprBool garde;
    private static ImageIcon icone;
    
    static {
        Image tmp = new ImageIcon(instruction.Si.class.getResource("images/SI.png")).getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING);
        icone = new ImageIcon(tmp);
    }

    public Si() {
        this(null);      
    }
    public Si(ExprBool garde) {
        this.nom = "si";
        this.garde = garde;
        
    }


    @Override
    public void go(robot.Robot robot) throws DansLeMur, InterruptedException {
        
        //try {
            if (garde.evalue(robot))
                ((Instruction) getChildAt(0)).go(robot);
            else if (getChildCount()>1)
                ((Instruction)getChildAt(1)).go(robot);
        //} catch (InterruptedException ex) {
        //    throw ex;
        //}
    }


    @Override
    public String toString() {        
        return super.toString()+" ("+garde+")";
    }

    /*@Override
    public void set(Object o) {
        garde.set(o);
    }*/

    @Override
    public boolean autorisationAjout() {
        return getChildCount() < 2;
    }

    @Override
    public ImageIcon getIcon() {
        // Ca marche bien mais ça comme l'icone s'écrit avant le texte
        // celà m'empêche d'écrire alors ou sinon pour distinguer les branches
        // du si (il faudrait construire l'icône pour que ça marche, en ajoutant
        // à gauche de l'existant une image image avec alors ou sinon...
        //return icone;
        return null;
    }
}
