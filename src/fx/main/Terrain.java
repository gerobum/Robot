/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.main;

import fx.robot.Robot;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Cellule[][] terrain;
    private int nX;
    private int nY;
    private int tailleCelluleX = 50;
    private int tailleCelluleY = 50;
    private int largeur = 1200;
    private int hauteur = 600;


    private Color[] couleurs = {Color.AZURE, Color.WHITESMOKE};

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Le robot explorateur");
        //Group root = new Group();
        //Canvas canvas = new Canvas(largeur, hauteur);

        nX = largeur / tailleCelluleX;
        nY = hauteur / tailleCelluleY;

        terrain = new Cellule[nX][nY];

        GridPane root = new GridPane();
        grille(root);

        // ######
        Robot robot = new Robot(this);
        // ######

        //gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        //root.getChildren().add(canvas);
        root.add(robot.getNode(), 0, 0);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void grille(GridPane root) {
        int i = 0;
        int j = 0;
        
        for (int x = 0; x < largeur; x += tailleCelluleX) {
            for (int y = 0; y < hauteur; y += tailleCelluleY) {
                root.add(new CelluleVide(tailleCelluleX, tailleCelluleY).getNode(), x, y);
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
            //gc.setStroke(Color.BLUE);
            //gc.setLineWidth(5);
            //gc.fillOval(10, 60, 30, 30);
            //grille(gc);
        }
    }

    public int getTailleCelluleX() {
        return tailleCelluleX;
    }

    public int getTailleCelluleY() {
        return tailleCelluleY;
    }

    public void repaint(int x, int y, int tailleCelluleX, int tailleCelluleY) {
    }

    public Cellule get(int x, int y) {
        return terrain[x][y];
    }

    public void set(int x, int y, Robot robot) {
        terrain[x][y] = robot;
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

    /*private void drawCellule(int x, int y, Cellule cellule) {
        x *= tailleCelluleX;
        y *= tailleCelluleY;
    
        
        gc.drawImage(cellule.getImage().getImage(), x, y);
    }*/
}
