package fx.panneaux;

import fx.exceptions.DansLeMur;
import fx.programme.Programme;
import fx.programme.instructions.Instruction;
import fx.robot.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.*;
import static fx.utilitaires.Utilitaires.*;

public class PanneauExecution extends PanneauBordure {

    private final Button boutonExecutionProgramme = new Button("Exécution du programme");
    private final Button boutonExecutionSelection = new Button("Exécution de la sélection");
    private ApplicationPrincipale applicationPrincipale;

    public PanneauExecution(ApplicationPrincipale applicationPrincipale) {
        super(" Exécution  ");
        this.applicationPrincipale = applicationPrincipale;
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
        boutonExecutionProgramme.setOnAction(p -> {
            if (applicationPrincipale.getSelectedRobot() == null) {
                alert("Robot non sélectionné", "Veuillez sélectionner un robot\n"
                        + "avant d'exécuter un programme.");
            } else {
                applicationPrincipale.getSelectedRobot().go();
            }
        });
    }
}
