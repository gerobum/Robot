package fx.panneaux;

import javafx.scene.Node;
import javafx.scene.control.*;

public class PanneauEdition extends PanneauBordure {

    private final Button boutonSupprime = new Button("supprimer");
    private final Button boutonCopie = new Button("copier");
    private final Button boutonColle = new Button("coller");
    private final Button boutonCoupe = new Button("couper");



    public PanneauEdition() {
        super(" Edition  ");
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
       
    }
}
