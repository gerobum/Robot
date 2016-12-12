package fx.terrain;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author maillot
 */
public class CelluleVide implements Cellule {

    private final Rectangle rectangle;

    public CelluleVide(int width, int height) {
        rectangle = new Rectangle(width, height, Color.WHITE);  
        rectangle.setStroke(Color.ALICEBLUE);
    }

    @Override
    public Color getCouleur() {
        return Color.WHITE;
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
