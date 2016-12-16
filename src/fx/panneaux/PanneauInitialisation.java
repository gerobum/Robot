package fx.panneaux;

import javafx.embed.swing.SwingNode;
import javafx.scene.control.DialogPane;

/**
 *
 * @author maillot
 */
public class PanneauInitialisation extends DialogPane {

    public PanneauInitialisation() {
        SwingNode sn = new SwingNode();
        sn.setContent(new fx.panneaux.swing.PanneauInitialisation());
        setContent(sn);
        sn.setVisible(true);
    }
    
}
