/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.terrain;

import fx.robot.Robot;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author yvan
 */
public class Terrain extends Application {

    private static final Random random = new Random();

    public static final int NORD = 0;
    public static final int EST = 1;
    public static final int SUD = 2;
    public static final int OUEST = 3;
    public static final int MAX_X = 30;
    public static final int MAX_Y = 20;
    public static final int MIN_X = 5;
    public static final int MIN_Y = 5;
    public static final int NORD_EST = 0;
    public static final int SUD_EST = 1;
    public static final int SUD_OUEST = 2;
    public static final int NORD_OUEST = 3;

    private int nX;
    private int nY;
    private int tailleCelluleX = 50;
    private int tailleCelluleY = 50;
    private int largeur = 10*50;
    private int hauteur = 6*50;
    private Set<Robot> robots = new HashSet<>();
    private Robot robot;
    private GridPane grid;
    private Button avance;
    private Button tourne;
    private Button plusPetit;
    private Button plusGrand;
    //private ArrayList<ArrayList<Cellule>> nodesGrid;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Le robot explorateur");

        nX = largeur / tailleCelluleX;
        nY = hauteur / tailleCelluleY;

        grid = new GridPane();
        avance = new Button("Avance");
        avance.setOnAction(e -> {
            robot.avance();
            System.out.println("avance");
        });
        tourne = new Button("Tourne");
        tourne.setOnAction(e -> {
            robot.tourne();
            System.out.println("tourne");
        });
        plusPetit = new Button("v");
        plusPetit.setOnAction(e -> {
            robot.plusPetit();
            System.out.println("v");
        });
        plusGrand = new Button("^");
        plusGrand.setOnAction(e -> {
            robot.plusGrand();
            System.out.println("^");
        });

        BorderPane root = new BorderPane(grid);
        FlowPane bottom = new FlowPane();
        bottom.getChildren().add(avance);
        bottom.getChildren().add(tourne);
        bottom.getChildren().add(plusGrand);
        bottom.getChildren().add(plusPetit);
        root.setBottom(bottom);
        grille(grid);

        // ######
        robot = new Robot(this);
        robots.add(robot);
        // ######

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void grille(GridPane root) {
        int i = 0;
        int j = 0;

        Cellule c;

        /*nodesGrid = new ArrayList<>(nX);
        for (int x = 0; x < nX; ++x) {
            nodesGrid.add(new ArrayList<>(nY));
            for(int y = 0; y < nY; ++y) {
                nodesGrid.get(x).add(null);
            }
        }*/
        for (int x = 0; x < nX; ++x) {
            c = new Trou(tailleCelluleX, tailleCelluleY);
            root.add(c.getNode(), x, 0);
            //nodesGrid.get(x).set(0, c);

            c = new Trou(tailleCelluleX, tailleCelluleY);
            root.add(c.getNode(), x, nY - 1);
            //nodesGrid.get(x).set(nY - 1, c);
        }

        for (int y = 0; y < nY; ++y) {
            c = new Trou(tailleCelluleX, tailleCelluleY);
            root.add(c.getNode(), 0, y);
            //nodesGrid.get(0).set(y, c);

            c = new Trou(tailleCelluleX, tailleCelluleY);
            root.add(c.getNode(), nX - 1, y);
            //nodesGrid.get(nX - 1).set(y, c);
        }

        for (int x = 1; x < nX - 1; ++x) {
            for (int y = 1; y < nY - 1; ++y) {
                c = new CelluleVide(tailleCelluleX, tailleCelluleY);
                root.add(c.getNode(), x, y);
                //nodesGrid.get(x).set(y, c);
                i = (i + 1) % 2;
            }
            if (i == j) {
                i = (i + 1) % 2;
            }
            j = i;
        }
    }

    private void drawShapes(GraphicsContext gc) {
        if (gc != null) {
            gc.setFill(Color.ALICEBLUE);
        }
    }

    public int getTailleCelluleX() {
        return tailleCelluleX;
    }

    public int getTailleCelluleY() {
        return tailleCelluleY;
    }

    public void setTailleCelluleX(int tailleCelluleX) {
        this.tailleCelluleX = tailleCelluleX;
    }

    public void setTailleCelluleY(int tailleCelluleY) {
        this.tailleCelluleY = tailleCelluleY;
    }

    public void repaint(int x, int y, int tailleCelluleX, int tailleCelluleY) {
    }

    public Cellule get(int x, int y) {
        return null;
    }

    public void change(Robot robot) {
        GridPane.setConstraints(robot.getNode(), robot.getX(), robot.getY());
        grid.getChildren().filtered(n -> n.getClass()==ImageView.class).stream().forEach((n) -> {
            System.out.println(GridPane.getColumnIndex(n) + ", " + GridPane.getRowIndex(n) + " : " + n);
        });
    }

    public void add(Robot robot) {
        grid.add(robot.getNode(), robot.getX(), robot.getY());
    }

    public int getNx() {
        return nX;
    }

    public int getNy() {
        return nY;
    }

    public void set(int xa, int ya, Cellule passage) {
    }

    public static void main(String[] args) {
        launch(args);
    }

}
