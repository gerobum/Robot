
package fx.utilitaires;

import fx.programme.Programme;
import fx.programme.instructions.Bloc;
import fx.programme.instructions.Instruction;
import fx.programme.instructions.Racine;
import java.util.Random;
import javafx.scene.control.TreeItem;

/**
 *
 * @author yvan
 */
public class Utilitaires {
    public final static Random RANDOM = new Random();
    public static TreeItem<Instruction> getArbreFromInstruction(Instruction instruction) {
        TreeItem<Instruction> tr = new TreeItem<>(instruction);
        for(int i = 0; i < instruction.getChildrenCount(); ++i) {
            tr.getChildren().add(getArbreFromInstruction(instruction.getChildAt(i)));
        }
        return tr;
    }
    
    public static TreeItem<Instruction> getArbreFromProgramme(Programme programme) {
        TreeItem<Instruction> tr = new TreeItem<>(programme);
        for(Bloc bloc : programme.getProcedures()) {
            tr.getChildren().add(getArbreFromInstruction(bloc));
        }
        //tr.getChildren().add(getArbreFromInstruction(programme.getProcedurePrincipal()));
        
        return tr;
    }
}
