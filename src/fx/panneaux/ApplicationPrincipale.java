package fx.panneaux;

//import fx.panneaux.swing.PanneauPrincipal;
import fx.programme.*;
import fx.programme.instructions.Instruction;
import fx.robot.*;
import fx.terrain.*;
import static fx.utilitaires.Utilitaires.alert;
import java.util.*;
import javafx.animation.ScaleTransition;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;

public class ApplicationPrincipale extends Application {

    private int nX = 15;
    private int nY = 10;
    private int tailleCellule = 60;
    private int largeur;
    private int hauteur;
    private Set<Robot> robots = new HashSet<>();
    private Robot selectedRobot = null;
    //private Robot robot;
    private Terrain grid;
    private Button avance;
    private Button tourne;
    private Button marque;
    private Button efface;
    private Button init;

    private Stage stage;

    private PanneauPrincipal panneauPrincipal;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Le robot explorateur");

        largeur = tailleCellule * nX;
        hauteur = tailleCellule * nY;

        grid = new Terrain();
        avance = new Button("Avance");
        avance.setOnAction(e -> {
            if (selectedRobot == null) {
                alert("Sélectionner un robot", "Il faut sélectionner un robot\n"
                        + "pour le commander");
            } else {
                selectedRobot.avance();
            }
        });
        tourne = new Button("Tourne");
        tourne.setOnAction(e -> {
            if (selectedRobot == null) {
                alert("Sélectionner un robot", "Il faut sélectionner un robot\n"
                        + "pour le commander");
            } else {
                selectedRobot.tourne();
            }
        });
        marque = new Button("Marque");
        marque.setOnAction(e -> {
            if (selectedRobot == null) {
                alert("Sélectionner un robot", "Il faut sélectionner un robot\n"
                        + "pour le commander");
            } else {
                selectedRobot.poserUneMarque();
            }
        });
        efface = new Button("Efface");
        efface.setOnAction(e -> {
            if (selectedRobot == null) {
                alert("Sélectionner un robot", "Il faut sélectionner un robot\n"
                        + "pour le commander");
            } else {
                selectedRobot.enleverUneMarque();
            }
        });
        init = new Button("Init");
        init.setOnAction(e -> {

            //DIALOG_INIT.showAndWait();
        });

        BorderPane root = new BorderPane();

        //programme = new Programme();
        //arbre = new JTreeRobot(programme.getArbreProgramme());
        panneauPrincipal = new PanneauPrincipal(this);

        //SplitPane splitPane = new SplitPane(panneauPrincipal, grid);
        root.setCenter(grid);
        root.setTop(panneauPrincipal);

        FlowPane bottom = new FlowPane();
        bottom.getChildren().add(avance);
        bottom.getChildren().add(tourne);
        bottom.getChildren().add(efface);
        bottom.getChildren().add(marque);
        bottom.getChildren().add(init);
        root.setRight(bottom);

        // ######
        robots.add(new Robot(this));
        robots.add(new Robot(this));
        // ######

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.sizeToScene();
        primaryStage.setOnCloseRequest(p -> {
            Platform.exit();
            System.exit(0);
        });
        robots.stream().forEach((r) -> {
            r.fit();
        });
        Platform.setImplicitExit(true);
        grid.setOnMouseClicked(p -> {
            for (Robot r : robots) {
                if (r.getNode().getBoundsInParent().contains(p.getX(), p.getY())) {
                    selectedRobot = r;
                    return;
                }
            }
            selectedRobot = null;
        });
    }

    public int getTailleCelluleX() {
        return tailleCellule;
    }

    public int getTailleCelluleY() {
        return tailleCellule;
    }

    public void setTailleCelluleX(int tailleCellule) {
        this.tailleCellule = tailleCellule;
    }

    public void setTailleCelluleY(int tailleCellule) {
        this.tailleCellule = tailleCellule;
    }

    private void tombe(Robot robot) {
        robot.stopThread();
        ScaleTransition st = new ScaleTransition(Duration.seconds(2), robot.getNode());
        st.setByX(-0.5);
        st.setByY(-0.5);
        st.setCycleCount(1);
        st.setRate(1.5);
        st.setFromX(robot.getNode().getScaleX() * 1.4);
        st.setFromY(robot.getNode().getScaleY() * 1.4);
        st.setToX(0);
        st.setToY(0);
        st.play();
    }

    public void change(Robot robot) {
        GridPane.setConstraints(robot.getNode(), robot.getX(), robot.getY());
        if (grid.getChildren()
                .stream()
                .filter(n -> GridPane.getColumnIndex(n) == robot.getX() && GridPane.getRowIndex(n) == robot.getY())
                .filter(n -> grid.get(n) != null)
                .map(n -> grid.get(n))
                .anyMatch(n -> n.getClass() == Trou.class)) {
            System.out.println("Plouf");
            tombe(robot);
        } else {
            robot.getNode().toFront();
        }
        System.out.println("CHANGE");
    }

    public void add(Robot robot) {
        grid.add(robot, robot.getX(), robot.getY());
    }

    public int getNx() {
        return nX;
    }

    public int getNy() {
        return nY;
    }

    public void add(Cellule passage, int xa, int ya) {
        grid.add(passage, xa, ya);
    }

    public void remove(Cellule passage) {
        grid.remove(passage);
    }

    public void setTitle(String nom) {
        stage.setTitle(nom);
    }

    public void montreDialInit() {
        //DIALOG_INIT.showAndWait();
        System.out.println("INITIALISATION");
    }

    public Cellule get(int x, int y) {
        return grid.get(x, y);
    }

    public Robot getSelectedRobot() {
        return selectedRobot;
    }

    public Instruction getRoot() {
        return panneauPrincipal.getProgramme();
    }

    public Programme getProgramme() {
        return (Programme) panneauPrincipal.getProgramme();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
