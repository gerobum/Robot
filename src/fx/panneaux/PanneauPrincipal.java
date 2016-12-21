package fx.panneaux;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;

/**
 *
 * @author yvan
 */
public class PanneauPrincipal extends SplitPane {

    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();
  

    public PanneauPrincipal() {

        doingUI();
        addListeners();
    }

    private void doingUI() {
        getStylesheets().add(getClass().getResource("panneaux.css").toExternalForm());
        gridPane.setVgap(15);
        int row = 1;
        gridPane.add(new PanneauProgrammation(), 0, row++);
        gridPane.add(new PanneauEdition(), 0, row++);
        gridPane.add(new PanneauExecution(), 0, row++);
        stackPane.setPrefWidth(500);
        getItems().addAll(gridPane, stackPane);
    }

    private void addListeners() {
     
    }
}
