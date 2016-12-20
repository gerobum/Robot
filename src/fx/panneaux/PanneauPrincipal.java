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
        PanneauProgrammation panneauProgrammation = new PanneauProgrammation();  
        panneauProgrammation.getStyleClass().add("main-panel");
        getStylesheets().add(getClass().getResource("panneaux.css").toExternalForm());
        
        Label titreProgrammation = new Label("  Programmation  ");
        titreProgrammation.getStyleClass().add("bordered-titled-title");
      
        add(panneauProgrammation, 0, 1);
        add(titreProgrammation, 0, 0);
    }

    private void addListeners() {
     
    }
}
