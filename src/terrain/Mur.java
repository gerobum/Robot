/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package terrain;

import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author maillot
 */
public class Mur implements Cellule {
    private static Image imagePrem, image;
    
    public Mur(int lx, int ly) {
        try {
            imagePrem = ImageIO.read(Mur.class.getResourceAsStream("images/mur.bmp"));
            image = imagePrem.getScaledInstance(lx, ly, Image.SCALE_SMOOTH);
        } catch (Exception ex) {
            image = null;
        }
    }

    @Override
    public Color getCouleur() {
        return Color.ORANGE;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setTaille(int lx, int ly) {
        image = imagePrem.getScaledInstance(lx, ly, Image.SCALE_SMOOTH);
    }
/*
    @Override
    public void prend(Cellule c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

}
