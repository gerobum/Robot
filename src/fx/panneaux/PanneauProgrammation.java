package fx.panneaux;

import fx.enumerations.Gardes;
import fx.programme.Initialisation;
import fx.programme.Programme;
import fx.programme.expressions.*;
import fx.programme.instructions.Avance;
import fx.programme.instructions.Instruction;
import fx.programme.instructions.Racine;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author yvan
 */
public class PanneauProgrammation extends PanneauBordure {

    private final Button boutonInitialise = new Button("initialisation");
    //private final Label labelProgrammation = new Label("Programmation");
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
    //private final TextField texteBloc = new TextField();
    private final TextArea texteExprBool = new TextArea();
    private ExprBool exprBoolComplexe = null;
    private ParseurExprBool parseur;
    private final Button boutonAjoutProcedure = new Button("nouvelle procédure");
    private final Button boutonAppelProcedure = new Button("appel de procédure");
    private final ComboBox<Instruction> comboAppelProcedure = new ComboBox<>();
    private final TextField texteNouvelleProcedure = new TextField();
    private final Button boutonEcrire = new Button("écrire");
    private final Button boutonLire = new Button("Lire");
    private final TextField texteLireEcrire = new TextField();
    private final ComboBox<Gardes> comboExpression = new ComboBox<>();

    private final InitialisationDialog DIALOG_INIT = new InitialisationDialog();

    private final Programme racine;
    private TreeView<Instruction> tree;

    public PanneauProgrammation(TreeView<Instruction> tree) {
        super("  Programmation  ");
        this.racine = (Programme) tree.getRoot().getValue();
        this.tree = tree;
        doingUI();
        addListeners();
    }

    private void doingUI() {

        //ColumnConstraints cc = new ColumnConstraints();
        int row = 0;
        //boutonInitialise.setMaxWidth(300);
        add(boutonInitialise, 0, row++, 8, 1);
        boutonAvance.setMaxWidth(Double.POSITIVE_INFINITY);
        add(boutonAvance, 0, row, 2, 1);
        add(boutonTourne, 2, row, 2, 1);
        add(boutonMarque, 4, row, 2, 1);
        add(boutonEfface, 6, row++, 2, 1);
        //boutonBloc.setMaxWidth(300);
        add(boutonBloc, 0, row++, 8, 1);
        texteExprBool.setPrefRowCount(2);
        texteExprBool.setPrefColumnCount(20);
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

        comboExpression.getItems().addAll(Gardes.values());

        comboExpression.getSelectionModel().selectFirst();

        for (Node n : getChildren()) {
            /*if (n instanceof Region) {
                ((Region) n).setMaxWidth(Double.POSITIVE_INFINITY);
            }*/
            setFillWidth(n, true);
        }

        boutonAjoutProcedure.setDisable(true);
        texteNouvelleProcedure.setTooltip(new Tooltip("Entrez un nom de procédure"));
        boutonAppelProcedure.setDisable(true);
        comboAppelProcedure.setDisable(true);
    }

    private void addListeners() {
        boutonInitialise.setOnAction(e -> {
            Optional<Initialisation> result = DIALOG_INIT.showAndWait();
            if (result.isPresent()) {
                DIALOG_INIT.setInitialisation(result.get());
                System.out.println(result.get());
            }
        });
        EventHandler<KeyEvent> changeTexteProcedure = e -> {
            if (texteNouvelleProcedure.getText() != null
                    && texteNouvelleProcedure.getText().length() > 0
                    && comboAppelProcedure.getItems()
                    .stream()
                    .map(p -> p.toString())
                    .noneMatch(p -> p.equals(texteNouvelleProcedure.getText()))) {
                boutonAjoutProcedure.setDisable(false);
            } else {
                boutonAjoutProcedure.setDisable(true);
            }
        };
        
        EventHandler<ActionEvent> eh = e -> {
            //programme.getProgramme().
            TreeItem<Instruction> selectedItem = tree.getSelectionModel().getSelectedItem();
            //if (selectedItem.getValue().autorisationAjout())
            selectedItem.getChildren().add(new TreeItem<>(new Avance(null)));
            //else
            //    selectedItem.getParent().getChildren().add(new TreeItem<>(new Avance(null)));
        };
        //texteNouvelleProcedure
        boutonAvance.setOnAction(eh);
        texteNouvelleProcedure.setOnKeyReleased(changeTexteProcedure);

        /*ajoutInstruction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TreePath treePath = PanneauPrincipal.this.frameParente.getArbre().getSelectionPath();
                Instruction select;
                //if (treePath != null) {
                if (treePath == null) {
                    select = (Instruction) PanneauPrincipal.this.frameParente.getArbre().getModel().getRoot();
                } else {
                    select = (Instruction) treePath.getLastPathComponent();
                }
                if (select.getParent() == null) {
                    select = PanneauPrincipal.this.frameParente.getProgramme().getProcedurePrincipal();
                }

                JButton source = (JButton) e.getSource();

                Instruction instruction = null;
                if (source == boutonAvance) {
                    instruction = new Avance();
                } else if (source == boutonTourne) {
                    instruction = new Tourne();
                } else if (source == boutonMarque) {
                    instruction = new Marque();
                } else if (source == boutonEfface) {
                    instruction = new Efface();
                } else if (source == boutonTantQue) {
                    ExprBool exp;
                    if (exprBoolComplexe != null) {
                        exp = exprBoolComplexe;
                        texteExprBool.setText("");
                    } else {
                        exp = (ExprBoolElt) PanneauPrincipal.this.comboExpression.getSelectedItem();
                    }
                    //ExpressionBoolenne pasDevantMur = new PasDevantMur(Programme.this.robot);
                    instruction = new TantQue(exp);
                } else if (source == boutonSi) {
                    ExprBool exp;
                    if (exprBoolComplexe == null) {
                        exp = (ExprBool) PanneauPrincipal.this.comboExpression.getSelectedItem();
                    } else {
                        exp = exprBoolComplexe;
                    }
                    instruction = new Si(exp);
                } else if (source == boutonBloc) {
                    if (texteBloc.getText().equalsIgnoreCase("")) {
                        instruction = new Bloc("bloc");
                    } else {
                        instruction = new Bloc(texteBloc.getText());
                    }
                } else if (source == boutonAjoutProcedure) {
                    if (texteNouvelleProcedure.getText().length() > 0
                            && PanneauPrincipal.this.frameParente.getProgramme().getProcedure(texteNouvelleProcedure.getText()) == null) {
                        instruction = PanneauPrincipal.this.frameParente.getProgramme().ajoutProcedure(texteNouvelleProcedure.getText());
                        comboAppelProcedure.addItem(instruction);
                        instruction = null; // Important, ne pas enlever
                    }
                } else if (source == boutonAppelProcedure) {
                    instruction = new Appel((Bloc) comboAppelProcedure.getSelectedItem());
                } else if (source == boutonPour) {
                    if (select instanceof InstructionComposee) {
                        InstructionComposee parent = (InstructionComposee) select;
                        String de, a, pas;
                        de = texteDebutPour.getText();
                        a = texteFinPour.getText();
                        pas = textePasPour.getText();

                        instruction = new Pour((InstructionComposee) select, de, a, pas);

                    } else {
                        //instruction = null; // Important, ne pas enlever
                        return;
                    }
                } else if (source == boutonEcrire) {
                    instruction = new Ecrire(texteLireEcrire.getText());
                } else if (source == boutonLire) {
                    String variable = JOptionPane.showInputDialog("Quelle variable doit être affectée ?", instruction);
                    instruction = new Lire(variable, texteLireEcrire.getText());
                }
                if (instruction != null) {
                    if (select.autorisationAjout()) {
                        PanneauPrincipal.this.frameParente.getProgramme().getArbreProgramme().insertNodeInto(instruction, select, select.getChildCount());
                    } else {
                        Instruction parent = (Instruction) select.getParent();
                        if (parent != null && parent.autorisationAjout()) {
                            PanneauPrincipal.this.frameParente.getProgramme().getArbreProgramme().insertNodeInto(instruction, parent, parent.getIndex(select));
                        }
                    }
                    JTree arbre = PanneauPrincipal.this.frameParente.getArbre();
                    for (int i = 0; i < arbre.getRowCount(); i++) {
                        arbre.expandRow(i);
                    }
                    //instruction.setParent(select);
                }
            }
            //}
        };*/
    }
}
