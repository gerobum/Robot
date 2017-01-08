package fx.panneaux;

import fx.enumerations.Gardes;
import fx.programme.Initialisation;
import fx.programme.Programme;
import fx.programme.expressions.*;
import fx.programme.instructions.*;
import java.util.Optional;
import java.util.regex.*;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import static fx.utilitaires.Utilitaires.*;

public class PanneauProgrammation extends PanneauBordure {

    abstract class BoutonInstructionElementaire extends Button {

        public BoutonInstructionElementaire(String texte) {
            super(texte);
        }

        public abstract Instruction newInstance(Instruction parent);
    }

    abstract class BoutonInstructionGardee extends Button {

        public BoutonInstructionGardee(String texte) {
            super(texte);
        }

        public abstract Instruction newInstance(Instruction parent, ExprBool garde);
    }

    class BoutonAvance extends BoutonInstructionElementaire {

        public BoutonAvance() {
            super("avance");
        }

        @Override
        public Instruction newInstance(Instruction parent) {
            return new Avance(parent);
        }

    }

    class BoutonTourne extends BoutonInstructionElementaire {

        public BoutonTourne() {
            super("tourne");
        }

        @Override
        public Instruction newInstance(Instruction parent) {
            return new Tourne(parent);
        }

    }

    class BoutonEfface extends BoutonInstructionElementaire {

        public BoutonEfface() {
            super("efface");
        }

        @Override
        public Instruction newInstance(Instruction parent) {
            return new Efface(parent);
        }

    }

    class BoutonMarque extends BoutonInstructionElementaire {

        public BoutonMarque() {
            super("marque");
        }

        @Override
        public Instruction newInstance(Instruction parent) {
            return new Marque(parent);
        }

    }

    class BoutonBloc extends BoutonInstructionElementaire {

        public BoutonBloc() {
            super("bloc");
        }

        @Override
        public Instruction newInstance(Instruction parent) {
            return new Bloc(parent, "bloc");
        }

    }

    class BoutonPour extends Button {

        public BoutonPour() {
            super("pour");
        }

        public Pour newInstance(InstructionComposee parent, String debut, String fin, String pas) {
            return new Pour(parent, debut, fin, pas);
        }
    }

    class BoutonSi extends BoutonInstructionGardee {

        public BoutonSi() {
            super("si");
        }

        @Override
        public Instruction newInstance(Instruction parent, ExprBool garde) {

            return new Si(parent, garde);
        }
    }

    class BoutonTantQue extends BoutonInstructionGardee {

        public BoutonTantQue() {
            super("tant que");
        }

        @Override
        public Instruction newInstance(Instruction parent, ExprBool garde) {
            return new TantQue(parent, garde);
        }

    }

    class BoutonProcedure extends Button {

        public BoutonProcedure() {
            super("nouvelle procédure");
        }

        public Instruction newInstance(Instruction parent, String nom) {
            return new Bloc(parent, nom);
        }

    }

    class BoutonAppelProcedure extends Button {

        public BoutonAppelProcedure() {
            super("appel de procédure");
        }

        public Instruction newInstance(Instruction parent, Bloc bloc) {
            return new Appel(parent, bloc);
        }

    }

    class BoutonLire extends Button {

        public BoutonLire() {
            super("lire");
        }

        public Instruction newInstance(Instruction parent, String variable, String message) {
            return new Lire(parent, variable, message);
        }

    }

    class BoutonEcrire extends Button {

        public BoutonEcrire() {
            super("écrire");
        }

        public Instruction newInstance(Instruction parent, String message) {
            return new Ecrire(parent, message);
        }

    }

    private final Button boutonInitialise = new Button("initialisation");
    //private final Label labelProgrammation = new Label("Programmation");
    private final BoutonAvance boutonAvance = new BoutonAvance();
    private final BoutonTourne boutonTourne = new BoutonTourne();
    private final BoutonMarque boutonMarque = new BoutonMarque();
    private final BoutonEfface boutonEfface = new BoutonEfface();
    private final BoutonSi boutonSi = new BoutonSi();
    private final BoutonTantQue boutonTantQue = new BoutonTantQue();
    private final BoutonBloc boutonBloc = new BoutonBloc();
    private final BoutonPour boutonPour = new BoutonPour();
    private final Label de = new Label(" de ");
    private final TextField texteDebutPour = new TextField("1");
    private final Label à = new Label(" à ");
    private final TextField texteFinPour = new TextField("10");
    private final Label pas = new Label(" par pas de ");
    private final TextField textePasPour = new TextField("1");

    //private final TextField texteBloc = new TextField();
    private final TextArea texteExprBool = new TextArea();
    private ExprBool exprBoolComplexe = null;
    private ParseurExprBool parseur;
    private final Button boutonAjoutProcedure = new Button("nouvelle procédure");
    private final BoutonAppelProcedure boutonAppelProcedure = new BoutonAppelProcedure();
    private final ComboBox<Instruction> comboAppelProcedure = new ComboBox<>();
    private final TextField texteNouvelleProcedure = new TextField();
    private final BoutonEcrire boutonEcrire = new BoutonEcrire();
    private final TextField texteVariableALire = new TextField();
    private final BoutonLire boutonLire = new BoutonLire();
    private final TextField texteLireEcrire = new TextField();
    private final ComboBox<Gardes> comboExpression = new ComboBox<>();

    private final InitialisationDialog DIALOG_INIT = new InitialisationDialog();

    private final Programme programme;
    private TreeView<Instruction> tree;


    public PanneauProgrammation(TreeView<Instruction> tree) {
        super("  Programmation  ");
        this.programme = (Programme) tree.getRoot().getValue();
        this.tree = tree;
        
        doingUI();
        addListeners();
    }

    private ExprBool getGardeFromCombo() {
        return comboExpression.getSelectionModel().getSelectedItem().newInstance();
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
   
        texteVariableALire.setPrefColumnCount(6);
        FlowPane fp = new FlowPane(texteVariableALire, new Label(" = "), boutonLire);
        add(fp, 0, row, 2, 1);
        
        fp = new FlowPane(boutonEcrire, texteLireEcrire);
        add(fp, 3, row, 6, 1);

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
        boutonLire.setDisable(true);
        boutonEcrire.setDisable(true);

    }

    private void ajoutInstruction(TreeItem<Instruction> selectedInstruction, BoutonInstructionElementaire bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.
        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance(parent.getValue());
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            //if (parent.getParent().getValue().getc)
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);
                Instruction instruction = bouton.newInstance(parent.getValue());
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }

    private void ajoutInstructionGardee(TreeItem<Instruction> selectedInstruction, BoutonInstructionGardee bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.

        ExprBool garde;
        if (exprBoolComplexe != null) {
            garde = exprBoolComplexe;
            texteExprBool.setText("");
        } else {
            //exp = (ExprBoolElt) PanneauPrincipal.this.comboExpression.getSelectedItem();
            garde = getGardeFromCombo();
        }
        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance(parent.getValue(), garde);
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);

                Instruction instruction = bouton.newInstance(parent.getValue(), garde);
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }

    private void ajoutPour(TreeItem<Instruction> selectedInstruction, BoutonPour bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.

        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance((InstructionComposee) parent.getValue(), texteDebutPour.getText(), texteFinPour.getText(), textePasPour.getText());
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);

                Instruction instruction = bouton.newInstance((InstructionComposee) parent.getValue(), texteDebutPour.getText(), texteFinPour.getText(), textePasPour.getText());
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }

    private void ajoutAppelProcedure(TreeItem<Instruction> selectedInstruction, BoutonAppelProcedure bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.

        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance(parent.getValue(), (Bloc) comboAppelProcedure.getSelectionModel().getSelectedItem());
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);

                Instruction instruction = bouton.newInstance(parent.getValue(), (Bloc) comboAppelProcedure.getSelectionModel().getSelectedItem());
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }

    private void ajoutLire(TreeItem<Instruction> selectedInstruction, BoutonLire bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.

        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance(parent.getValue(), texteVariableALire.getText(), texteLireEcrire.getText());
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);

                Instruction instruction = bouton.newInstance(parent.getValue(), texteVariableALire.getText(), texteLireEcrire.getText());
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }
    
    private void ajoutEcrire(TreeItem<Instruction> selectedInstruction, BoutonEcrire bouton) {
        // Ajout d'une instruction élémentaire dans l'arbre de programme.

        if (selectedInstruction == null) {
            alert("Mauvaise sélection", "Pour ajouter une instruction, il faut \n"
                    + "sélectionner une instruction dans le programme");
        } else if (selectedInstruction.getValue().autorisationAjout()) {// Si l'instruction autorise les ajouts
            // L'ajout se fait à la fin
            TreeItem<Instruction> parent = selectedInstruction;
            if (parent.getValue().getClass() == Programme.class) {
                alert("Mauvaise sélection", "Pour ajouter une instruction,\n"
                        + "il faut sélectionner autre\n"
                        + "chose que le programme");
            } else {
                Instruction instruction = bouton.newInstance(parent.getValue(), texteLireEcrire.getText());
                parent.getChildren().add(new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(instruction);
            }
        } else {
            // Sinon, la nouvelle instruction prend la place de celle sélectionnée
            // Détermination de la position de l'instruction sélectionnée
            TreeItem<Instruction> parent = selectedInstruction.getParent();
            if (parent.getValue().autorisationAjout()) {
                int x = parent.getChildren().indexOf(selectedInstruction);

                Instruction instruction = bouton.newInstance(parent.getValue(), texteLireEcrire.getText());
                parent.getChildren().add(x, new TreeItem<>(instruction));
                parent.setExpanded(true);
                parent.getValue().addChild(x, instruction);
            }
        }
    }

    private void addListeners() {
        boutonInitialise.setOnAction(e -> {
            Optional<Initialisation> result = DIALOG_INIT.showAndWait();
            if (result.isPresent()) {
                DIALOG_INIT.setInitialisation(result.get());
            }
            programme.setInitialisation(result.get());
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

        EventHandler<ActionEvent> actionInstructionElementaire = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.

            ajoutInstruction(tree.getSelectionModel().getSelectedItem(), (BoutonInstructionElementaire) e.getSource());
            System.out.println(programme.deepToString());

        };
        EventHandler<ActionEvent> actionInstructionGardee = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            ajoutInstructionGardee(tree.getSelectionModel().getSelectedItem(), (BoutonInstructionGardee) e.getSource());
            System.out.println(programme.deepToString());

        };
        EventHandler<ActionEvent> actionPour = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            ajoutPour(tree.getSelectionModel().getSelectedItem(), (BoutonPour) e.getSource());
            System.out.println(programme.deepToString());

        };
        EventHandler<ActionEvent> actionNouvelleProcedure = e -> {
            TreeItem<Instruction> parent = tree.getRoot();

            Bloc instruction = new Bloc(parent.getValue(), texteNouvelleProcedure.getText());
            parent.getChildren().add(0, new TreeItem<>(instruction));
            ((Programme) parent.getValue()).ajoutProcedure(instruction);
            comboAppelProcedure.getItems().add(instruction);
            comboAppelProcedure.setDisable(false);
            comboAppelProcedure.getSelectionModel().select(instruction);
            boutonAppelProcedure.setDisable(false);
            System.out.println(programme.deepToString());
            texteNouvelleProcedure.setText("");
        };
        EventHandler<ActionEvent> actionAppelProcedure = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            ajoutAppelProcedure(tree.getSelectionModel().getSelectedItem(), (BoutonAppelProcedure) e.getSource());
            System.out.println(programme.deepToString());
        };
        EventHandler<ActionEvent> actionLire = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            ajoutLire(tree.getSelectionModel().getSelectedItem(), (BoutonLire) e.getSource());
            texteVariableALire.setText("");
            texteLireEcrire.setText("");
            boutonLire.setDisable(true);
            boutonEcrire.setDisable(true);
            System.out.println(programme.deepToString());
        };
        EventHandler<ActionEvent> actionLireEcrire = e -> {
            // Ajout d'une instruction élémentaire dans l'arbre de programme.
            ajoutEcrire(tree.getSelectionModel().getSelectedItem(), (BoutonEcrire) e.getSource());
            texteLireEcrire.setText("");
            boutonEcrire.setDisable(true);
            System.out.println(programme.deepToString());
        };
        //texteNouvelleProcedure
        boutonAvance.setOnAction(actionInstructionElementaire);
        boutonTourne.setOnAction(actionInstructionElementaire);
        boutonMarque.setOnAction(actionInstructionElementaire);
        boutonEfface.setOnAction(actionInstructionElementaire);
        boutonBloc.setOnAction(actionInstructionElementaire);
        boutonSi.setOnAction(actionInstructionGardee);
        boutonTantQue.setOnAction(actionInstructionGardee);
        boutonPour.setOnAction(actionPour);
        boutonAjoutProcedure.setOnAction(actionNouvelleProcedure);
        texteNouvelleProcedure.setOnAction(actionNouvelleProcedure);
        texteNouvelleProcedure.setOnKeyReleased(changeTexteProcedure);
        boutonAppelProcedure.setOnAction(actionAppelProcedure);
        boutonLire.setOnAction(actionLire);
        boutonEcrire.setOnAction(actionLireEcrire);
        
        texteVariableALire.setOnKeyReleased(p -> {
          //  Matcher variable = new Matcher();
           Matcher variable = Pattern.compile("[A-Za-z][A-Za-z0-9]*").matcher(texteVariableALire.getText());
           if (variable.matches()) {
               boutonLire.setDisable(false);
           } else {
               boutonLire.setDisable(true);
           }
        });
        
        texteLireEcrire.setOnKeyReleased(p -> {
            if (texteLireEcrire.getText().isEmpty()) {
               boutonEcrire.setDisable(true);
           } else {
               boutonEcrire.setDisable(false);
           }
        });
    }
}
