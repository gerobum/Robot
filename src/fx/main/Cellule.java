/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.main;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 *
 * @author maillot
 */
public interface Cellule {
    Color getCouleur();
    Image getImage();
    void setTaille(int lx, int ly);
    //void prend(Cellule c);
}
