package fx.terrain;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Mur implements Cellule {

    private ImageView image;

    public Mur(int width, int height) {
        image = new ImageView(new Image("/fx/terrain/images/mur.bmp"));
        image.setFitHeight(height);
        image.setFitWidth(width);
    }

    @Override
    public Color getCouleur() {
        return Color.ORANGE;
    }

    @Override
    public Node getNode() {
        return image;
    }

    @Override
    public void setTaille(int width, int height) {
        image.setFitHeight(height);
        image.setFitWidth(width);
    }
}
