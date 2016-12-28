package fx.panneaux;

import fx.programme.Initialisation;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class InitialisationDialog extends Dialog<Initialisation> {
    private PanneauInitialisation panneauInitialisation;
    public InitialisationDialog() {

        ButtonType ok = new ButtonType("Valider", ButtonData.OK_DONE);
        ButtonType annuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
        panneauInitialisation = new PanneauInitialisation();
        setDialogPane(panneauInitialisation);
        setResultConverter(p -> panneauInitialisation.getInitialisation(p.getButtonData()));
        getDialogPane().getButtonTypes().addAll(ok, annuler);
        boolean disabled = false; // computed based on content of text fields, for example
        getDialogPane().lookupButton(ok).setDisable(disabled);
    }
    
    public void setInitialisation(Initialisation initialisation) {
        panneauInitialisation.setInitialisation(initialisation);
    }
            
}
