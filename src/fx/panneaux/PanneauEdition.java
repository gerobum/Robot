package fx.panneaux;

import fx.programme.Programme;
import fx.programme.instructions.Instruction;
import javafx.scene.Node;
import javafx.scene.control.*;
import static fx.utilitaires.Utilitaires.*;

public class PanneauEdition extends PanneauBordure {

    private final Button boutonSupprime = new Button("supprimer");
    private final Button boutonCopie = new Button("copier");
    private final Button boutonColle = new Button("coller");
    private final Button boutonCoupe = new Button("couper");
    private TreeView<Instruction> tree;
    private Programme programme;
    private Instruction copied = null;

    public PanneauEdition(TreeView<Instruction> tree, Programme programme) {
        super(" Edition  ");
        this.programme = programme;
        this.tree = tree;
        doingUI();
        addListeners();
    }

    private void doingUI() {

        add(boutonSupprime, 0, 0);
        add(boutonCopie, 1, 0);
        add(boutonColle, 2, 0);
        add(boutonCoupe, 3, 0);

        for (Node n : getChildren()) {
            /*if (n instanceof Region) {
                ((Region) n).setMaxWidth(Double.POSITIVE_INFINITY);
            }*/
            setFillWidth(n, true);
        }
    }

    private void addListeners() {
        boutonCoupe.setOnAction(p -> {
            TreeItem<Instruction> selectedInstruction = tree.getSelectionModel().getSelectedItem();
            copied = selectedInstruction.getValue();
            copied.getParent().remove(copied);
            selectedInstruction.getParent().getChildren().remove(selectedInstruction);
        });
        boutonColle.setOnAction(p -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            TreeItem<Instruction> selectedInstruction = tree.getSelectionModel().getSelectedItem();
            if (selectedInstruction == null) {
                alert("Pour coller une instruction, il faut \n"
                        + "sélectionner une instruction dans le programme");
            } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
                // L'ajout se fait à la fin
                TreeItem<Instruction> parent = selectedInstruction;
                if (parent.getValue().getClass() == Programme.class) {
                    alert("Pour coller une instruction,\n"
                            + "il faut sélectionner autre\n"
                            + "chose que le programme");
                } else {
                    parent.getChildren().add(new TreeItem<>(copied));
                    parent.getValue().addChild(copied);
                    copied = null;
                }
            } else {
                // Sinon, la nouvelle instruction prend la place de celle sélectionnée
                // Détermination de la position de l'instruction sélectionnée
                TreeItem<Instruction> parent = selectedInstruction.getParent();
                if (parent.getValue().autorisationAjout()) {
                    int x = parent.getChildren().indexOf(selectedInstruction);

                    parent.getChildren().add(x, new TreeItem<>(copied));
                    parent.getValue().addChild(x, copied);
                    copied = null;
                }
            }
        });
    }

    public Instruction getCopied() {
        return copied;
    }
}
