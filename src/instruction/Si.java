/*
 * Creative commons CC BY-NC-SA 2020 Yvan Maillot <yvan.maillot@uha.fr>
 *
 *     Share - You can copy and redistribute the material in any medium or format
 * 
 *     Adapt - You can remix, transform, and build upon the material 
 * 
 * Under the following terms :
 * 
 *     Attribution - You must give appropriate credit, provide a link to the license, 
 *     and indicate if changes were made. You may do so in any reasonable manner, 
 *     but not in any way that suggests the licensor endorses you or your use. 
 * 
 *     NonCommercial — You may not use the material for commercial purposes. 
 * 
 *     ShareAlike — If you remix, transform, or build upon the material, 
 *     you must distribute your contributions under the same license as the original. 
 * 
 * Notices:    You do not have to comply with the license for elements of 
 *             the material in the public domain or where your use is permitted 
 *             by an applicable exception or limitation. 
 * 
 * No warranties are given. The license may not give you all of the permissions 
 * necessary for your intended use. For example, other rights such as publicity, 
 * privacy, or moral rights may limit how you use the material. 
 * 
 * See <https://creativecommons.org/licenses/by-nc-sa/4.0/>.
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
