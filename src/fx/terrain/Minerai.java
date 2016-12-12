package fx.terrain;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author maillot
 */
public class Minerai implements Cellule {

    private ImageView image;

    public Minerai(int width, int height) {
        image = new ImageView(new javafx.scene.image.Image("/fx/terrain/images/marque.png"));
        image.setFitHeight(height);
        image.setFitWidth(width);
    }

    @Override
    public Color getCouleur() {
        return Color.ORANGE;
    }

    @Override
    public void setTaille(int width, int height) {
        image.setFitHeight(height);
        image.setFitWidth(width);
    }

    @Override
    public Node getNode() {
        return image;
    }

}
