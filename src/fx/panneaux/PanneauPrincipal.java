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

    private final Button boutonInitialise = new Button("initialisation");
    private final Label labelProgrammation = new Label("Programmation");
    private final Button boutonAvance = new Button("avance");
    private final Button boutonTourne = new Button("tourne");
    private final Button boutonMarque = new Button("marque");
    private final Button boutonEfface = new Button("efface");
    private final Button boutonSi = new Button("si");
    private final Button boutonTantQue = new Button("tant que");
    private final Button boutonPour = new Button("pour");
    private final Label de = new Label(" de ");
    private final TextField texteDebutPour = new TextField("1");
    private final Label à = new Label(" à ");
    private final TextField texteFinPour = new TextField("10");
    private final Label pas = new Label(" par pas de ");
    private final TextField textePasPour = new TextField("1");
    private final Button boutonBloc = new Button("bloc");
    private final TextField texteBloc = new TextField();
    private final TextArea texteExprBool = new TextArea();
    private ExprBool exprBoolComplexe = null;
    private ParseurExprBool parseur;
    private final Button boutonAjoutProcedure = new Button("nouvelle procédure");
    private final Button boutonAppelProcedure = new Button("appel de procédure");
    private final ComboBox<NoeudProgramme> comboAppelProcedure = new ComboBox<>();
    private final TextField texteNouvelleProcedure = new TextField();
    private final Button boutonEcrire = new Button("écrire");
    private final Button boutonLire = new Button("Lire");
    private final TextField texteLireEcrire = new TextField();
    private final Button boutonSupprime = new Button("supprimer");
    private final Button boutonCopie = new Button("copier");
    private final Button boutonColle = new Button("coller");
    private final Button boutonCoupe = new Button("couper");
    private final Button boutonExecutionProgramme = new Button("Exécution du programme");
    private final Button boutonExecutionSelection = new Button("Exécution de la sélection");
    private ByteArrayOutputStream brancheCopiee[] = null;
    private final ComboBox<ExprBool> comboExpression = new ComboBox<>();

    private final InitialisationDialog DIALOG_INIT = new InitialisationDialog();

    public PanneauPrincipal() {

        doingUI();
        addListeners();
    }

    private void doingUI() {
        ColumnConstraints cc = new ColumnConstraints();
        int row = 0;
        add(boutonInitialise, 0, row++, 8, 1);
        labelProgrammation.setAlignment(Pos.CENTER);
        labelProgrammation.setPrefHeight(10);
        add(labelProgrammation, 0, row++, 8, 1);
        add(boutonAvance, 0, row, 2, 1);
        add(boutonTourne, 2, row, 2, 1);
        add(boutonMarque, 4, row, 2, 1);
        add(boutonEfface, 6, row++, 2, 1);
        add(boutonBloc, 0, row++, 8, 1);
        add(texteExprBool, 0, row++, 8, 1);
        add(boutonSi, 0, row, 2, 1);
        add(boutonTantQue, 2, row, 2, 1);
        add(comboExpression, 4, row++, 4, 1);

        add(boutonPour, 0, row, 2, 1);
        add(de, 2, row);
        texteDebutPour.setPrefColumnCount(2);
        add(texteDebutPour, 3, row);
        add(à, 4, row);
        texteFinPour.setPrefColumnCount(2);
        add(texteFinPour, 5, row);
        add(pas, 6, row);
        textePasPour.setPrefColumnCount(2);
        add(textePasPour, 7, row++);
        add(boutonAjoutProcedure, 0, row, 2, 1);
        add(texteNouvelleProcedure, 2, row++, 6, 1);
        add(boutonAppelProcedure, 0, row, 2, 1);
        add(comboAppelProcedure, 2, row++, 6, 1);
        add(boutonLire, 0, row, 2, 1);
        add(boutonEcrire, 2, row, 2, 1);
        add(texteLireEcrire, 4, row, 4, 1);

        for (Node n : getChildren()) {
            if (n instanceof Region) {
                ((Region) n).setMaxWidth(Double.POSITIVE_INFINITY);
            }
            setFillWidth(n, true);
        }

        comboExpression.getItems().addAll(
                new DevantMur(),
                new PasDevantMur(),
                new SurMarque(),
                new PasSurMarque(),
                new DevantMarque(),
                new PasDevantMarque(),
                new SurMinerai(),
                new PasSurMinerai()
        );
        comboExpression.getSelectionModel().selectFirst();
    }

    private void addListeners() {
        boutonInitialise.setOnAction(e -> {
            Optional<Initialisation> result = DIALOG_INIT.showAndWait();
            if (result.isPresent()) {
                DIALOG_INIT.setInitialisation(result.get());
                System.out.println(result.get());
            }
        });
    }
}
