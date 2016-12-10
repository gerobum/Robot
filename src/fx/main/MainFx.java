/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.main;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import terrain.Cellule;

/**
 *
 * @author yvan
 */
public class MainFx extends Application {

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
    private int tailleCelluleX = 30;
    private int tailleCelluleY = 30;
    private int largeur = 1200;
    private int hauteur = 600;

    private Color[] couleurs = {Color.AZURE, Color.WHITESMOKE};

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Le robot explorateur");
        Group root = new Group();
        Canvas canvas = new Canvas(largeur, hauteur);

        nX = largeur / tailleCelluleX;
        nY = hauteur / tailleCelluleY;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void grille(GraphicsContext gc) {
        int i = 0;
        for (int x = 0; x < largeur; x += tailleCelluleX) {
            for (int y = 0; y < hauteur; y += tailleCelluleY) {
                gc.setFill(couleurs[i % 2]);
                gc.fillRect(x, y, x + tailleCelluleX, y + tailleCelluleY);
                i++;
            }
            i++;
        }
    }

    private void drawShapes(GraphicsContext gc) {
        //gc.setFill(Color.ALICEBLUE);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        //gc.fillOval(10, 60, 30, 30);
        grille(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
