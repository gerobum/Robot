/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

/**
 *
 * @author Yvan
 */
public abstract class InstructionElementaire extends Instruction {

    @Override
    public boolean autorisationAjout() {
        return false;
    }
    @Override
    public String deepToString(String decalage) {
        return decalage + toString() + "\n";
    }
}
