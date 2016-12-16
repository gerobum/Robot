package fx.panneaux;

import fx.programme.Initialisation;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DialogPane;

/**
 *
 * @author maillot
 */
public class PanneauInitialisation extends DialogPane {
    
    private final fx.panneaux.swing.PanneauInitialisation PANNEAU_INIT;

    public PanneauInitialisation() {
        PANNEAU_INIT = new fx.panneaux.swing.PanneauInitialisation();
        SwingNode sn = new SwingNode();
        sn.setContent(PANNEAU_INIT);
        setContent(sn);
        sn.setVisible(true);
    }
    public PanneauInitialisation(Initialisation initialisation) {
        PANNEAU_INIT = new fx.panneaux.swing.PanneauInitialisation(initialisation);
        SwingNode sn = new SwingNode();
        sn.setContent(PANNEAU_INIT);
        setContent(sn);
        sn.setVisible(true);
    }
    
    public Initialisation getInitialisation(ButtonBar.ButtonData choix) {
        return choix == ButtonBar.ButtonData.CANCEL_CLOSE ? PANNEAU_INIT.getAfterValidation() : PANNEAU_INIT.getAfterCancelation();
    }
}
