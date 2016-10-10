/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package terrain;

import java.awt.Color;
import java.awt.Image;

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
