package fx.terrain;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author maillot
 */
public class Trou implements Cellule {

    private final Rectangle rectangle;

    public Trou(int width, int height) {
        rectangle = new Rectangle(width, height, Color.BLACK);    
        rectangle.setStroke(Color.BLACK);
    }

    @Override
    public Color getCouleur() {
        return Color.BLACK;
    }

    @Override
    public Node getNode() {
        return rectangle;
    }

    @Override
    public void setTaille(int width, int height) {
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }

}
