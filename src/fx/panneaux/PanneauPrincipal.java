package fx.panneaux;

import javafx.scene.layout.*;

/**
 *
 * @author yvan
 */
public class PanneauPrincipal extends GridPane {

  

    public PanneauPrincipal() {

        doingUI();
        addListeners();
    }

    private void doingUI() {
        getStylesheets().add(getClass().getResource("panneaux.css").toExternalForm());
        setVgap(15);
        int row = 1;
        add(new PanneauProgrammation(), 0, row++);
        add(new PanneauEdition(), 0, row++);
        add(new PanneauExecution(), 0, row++);
    }

    private void addListeners() {
     
    }
}
