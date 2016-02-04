/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package terrain;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author maillot
 */
public class Marque implements Cellule {
    private Image imagePrem, image;
    private Cellule cellule;
    private boolean exterieur;

    public boolean isExterieur() {
        return exterieur;
    }

    public Marque(int lx, int ly, boolean exterieur) {
        try {
            this.exterieur = exterieur;
            imagePrem = ImageIO.read(Marque.class.getResourceAsStream("images/marque.png"));
            image = imagePrem.getScaledInstance(lx, ly, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(Marque.class.getName()).log(Level.SEVERE, null, ex);
        }
        cellule = null;
    }
    
    public Marque(int lx, int ly) {
        this(lx, ly, false);
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

    /*public void prend(Cellule c) {
        if (cellule == null)
            cellule = c;
        else
            cellule.prend(c);
    }*/

}
