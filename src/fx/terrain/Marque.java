/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.terrain;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author maillot
 */
public class Marque implements Cellule {

    private ImageView image;

    public Marque(int width, int height) {

        image = new ImageView(new Image("/fx/robot/images/marque.png"));
        image.setFitWidth(width);
        image.setFitHeight(height);
    }

    @Override
    public Color getCouleur() {
        return Color.ORANGE;
    }

    @Override
    public ImageView getNode() {
        return image;
    }

    @Override
    public void setTaille(int width, int height) {

        image.setFitWidth(width);
        image.setFitHeight(height);
    }
}
