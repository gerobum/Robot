package fx.panneaux;

import fx.programme.Initialisation;
import fx.terrain.Marque;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author maillot
 */
public class InitialisationDialog extends Dialog<String> {

    public InitialisationDialog() {
    
        
        ButtonType ok = new ButtonType("Valider", ButtonData.OK_DONE);
        ButtonType annuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
        setDialogPane(new PanneauInitialisation());
        getDialogPane().getButtonTypes().addAll(ok, annuler);
        boolean disabled = false; // computed based on content of text fields, for example
        getDialogPane().lookupButton(ok).setDisable(disabled);
    }
}
