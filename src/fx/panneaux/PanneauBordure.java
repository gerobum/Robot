package fx.panneaux;

import fx.programme.Initialisation;
import fx.programme.NoeudProgramme;
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
public abstract class PanneauBordure extends GridPane {

    public PanneauBordure(String titreBordure) {

        doingUI(titreBordure);

    }

    private void doingUI(String titreBordure) {
        setPadding(new Insets(20));

        getStyleClass().add("main-panel");

        Label titre = new Label(titreBordure);
        titre.getStyleClass().add("bordered-titled-title");
        add(titre, 0, 0);
    }
}
