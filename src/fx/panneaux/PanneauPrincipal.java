package fx.panneaux;

import fx.programme.Initialisation;
import fx.programme.NoeudProgramme;
import fx.programme.expressions.*;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
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
        int row = 1;
        add(new PanneauProgrammation(), 0, row++);
        add(new PanneauEdition(), 0, row++);
        add(new PanneauExecution(), 0, row++);
    }

    private void addListeners() {
     
    }
}
