/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
<<<<<<< HEAD
import javafx.scene.image.ImageView;
=======
>>>>>>> 0626dad20545a488abf539b407b0c6a766fcbad2
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author maillot
 */
public class Marque implements Cellule {
<<<<<<< HEAD
    private ImageView image;
=======
    private Image image;
>>>>>>> 0626dad20545a488abf539b407b0c6a766fcbad2
    private Cellule cellule;
    private boolean exterieur;

    public boolean isExterieur() {
        return exterieur;
    }

    public Marque(int lx, int ly, boolean exterieur) {

            this.exterieur = exterieur;
<<<<<<< HEAD
            image = new ImageView(new Image("/fx/robot/images/marque.png"));
=======
            image = new Image(Marque.class.getResourceAsStream("images/marque.png"));
>>>>>>> 0626dad20545a488abf539b407b0c6a766fcbad2
      
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
<<<<<<< HEAD
    public ImageView getNode() {
=======
    public Image getImage() {
>>>>>>> 0626dad20545a488abf539b407b0c6a766fcbad2
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
