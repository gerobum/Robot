package fx.utilitaires;

import fx.programme.Programme;
import fx.programme.instructions.Bloc;
import fx.programme.instructions.Instruction;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;

public class Utilitaires {
    public final static Random RANDOM = new Random();    
    private final static Alert ALERT;
    
    static {
        ALERT = new Alert(Alert.AlertType.ERROR);
        // Configuration de la boite de dialogue d'alerte
        ALERT.setTitle("Mauvaise sélection");
        ALERT.setHeaderText("Mauvaise sélection");
    }
    
    
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
    
    public static void alert(String message) {
        ALERT.setContentText(message);
        ALERT.showAndWait();
    }
}
