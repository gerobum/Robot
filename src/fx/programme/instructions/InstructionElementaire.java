/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.programme.instructions;

/**
 *
 * @author Yvan
 */
public abstract class InstructionElementaire extends Instruction {

    public static final long serialVersionUID = 0L;
    @Override
    public boolean autorisationAjout() {
        return false;
    }
    @Override
    public String deepToString(String decalage) {
        return decalage + toString() + "\n";
    }
}
