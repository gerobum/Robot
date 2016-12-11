package fx.main;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author maillot
 */
public class CelluleVide implements Cellule {

    private int lx, ly;
    private Rectangle rectangle;

    public CelluleVide(int lx, int ly) {
        this.lx = lx;
        this.ly = ly;
        rectangle = new Rectangle(lx, ly);
        
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
    public void setTaille(int lx, int ly) {
        this.lx = lx;
        this.ly = ly;
    }

}
