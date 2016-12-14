/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.terrain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author maillot
 */
public class Marque implements Cellule {

    private ImageView image;

    public Marque(int width, int height) {

        image = new ImageView(new Image("/fx/terrain/images/marque.png"));
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
