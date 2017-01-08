package fx.panneaux;

//import fx.panneaux.swing.PanneauPrincipal;
import fx.interfaces.*;
import fx.programme.*;
import fx.programme.instructions.Instruction;
import fx.robot.*;
import fx.terrain.*;
import java.util.*;
import javafx.animation.ScaleTransition;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;
import javax.swing.JTree;

public class ApplicationPrincipale extends Application {

    private int nX = 15;
    private int nY = 10;
    private int tailleCellule = 60;
    private int largeur;
    private int hauteur;
    private Set<Robot> robots = new HashSet<>();
    private Robot selectedRobot = null;
    private Robot robot;
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
            robot.avance();
        });
        tourne = new Button("Tourne");
        tourne.setOnAction(e -> {
            robot.tourne();
        });
        marque = new Button("Marque");
        marque.setOnAction(e -> {
            robot.poserUneMarque();
        });
        efface = new Button("Efface");
        efface.setOnAction(e -> {
            robot.enleverUneMarque();
        });
        init = new Button("Init");
        init.setOnAction(e -> {

            //DIALOG_INIT.showAndWait();
        });

        BorderPane root = new BorderPane(grid);

        //programme = new Programme();
        //arbre = new JTreeRobot(programme.getArbreProgramme());

        panneauPrincipal = new PanneauPrincipal(this);

        root.setLeft(panneauPrincipal);

        FlowPane bottom = new FlowPane();
        bottom.getChildren().add(avance);
        bottom.getChildren().add(tourne);
        bottom.getChildren().add(efface);
        bottom.getChildren().add(marque);
        bottom.getChildren().add(init);
        root.setBottom(bottom);

        // ######
        robot = new Robot(this);
        robots.add(robot);
        robot = new Robot(this);
        robots.add(robot);
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
            for(Robot r : robots) {
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
        robot.tombe();
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
                .peek(System.out::println)
                .anyMatch(n -> n.getClass() == Trou.class)) {
            System.out.println("Plouf");
            tombe(robot);
        } else {
            robot.getNode().toFront();
        }
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

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
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
        return (Programme) panneauPrincipal.getProgramme();
    }

    public Programme getProgramme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
