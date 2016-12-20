package fx.panneaux;

import fx.programme.Initialisation;
import fx.programme.expressions.*;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author yvan
 */
public class PanneauExecution extends PanneauBordure {

    private final Button boutonExecutionProgramme = new Button("Exécution du programme");
    private final Button boutonExecutionSelection = new Button("Exécution de la sélection");


    public PanneauExecution() {
        super(" Exécution  ");
        doingUI();
        addListeners();
    }

    private void doingUI() {

        add(boutonExecutionProgramme, 0, 0);
        add(boutonExecutionSelection, 1, 0);

        for (Node n : getChildren()) {
            /*if (n instanceof Region) {
                ((Region) n).setMaxWidth(Double.POSITIVE_INFINITY);
            }*/
            setFillWidth(n, true);
        }
    }

    private void addListeners() {
       
    }
}
