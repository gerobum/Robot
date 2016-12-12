
package fx.terrain;






import javafx.scene.Node;
import javafx.scene.paint.Color;


/**
 *
 * @author maillot
 */
public interface Cellule {
    Color getCouleur();

    Node getNode();

    void setTaille(int lx, int ly);
    //void prend(Cellule c);
}
