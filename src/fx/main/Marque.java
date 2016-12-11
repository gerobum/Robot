/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author maillot
 */
public class Marque implements Cellule {
    private Image image;
    private Cellule cellule;
    private boolean exterieur;

    public boolean isExterieur() {
        return exterieur;
    }

    public Marque(int lx, int ly, boolean exterieur) {

            this.exterieur = exterieur;
            image = new Image(Marque.class.getResourceAsStream("images/marque.png"));
      
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
        
    }

    /*public void prend(Cellule c) {
        if (cellule == null)
            cellule = c;
        else
            cellule.prend(c);
    }*/

}
