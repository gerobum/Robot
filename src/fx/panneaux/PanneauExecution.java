package fx.panneaux;

import fx.programme.Programme;
import fx.programme.instructions.Instruction;
import javafx.scene.Node;
import javafx.scene.control.*;

public class PanneauExecution extends PanneauBordure {

    private final Button boutonExecutionProgramme = new Button("Exécution du programme");
    private final Button boutonExecutionSelection = new Button("Exécution de la sélection");
    private TreeView<Instruction> tree;
    private Programme programme;


    public PanneauExecution(TreeView<Instruction> tree, Programme programme) {
        super(" Exécution  ");
        this.tree = tree;
        this.programme = programme;
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
