package fx.robot;

import fx.exceptions.DansLeMur;
import fx.panneaux.ApplicationPrincipale;
import fx.terrain.Cellule;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import fx.terrain.Marque;
import fx.terrain.OrientationReelle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Robot implements Cellule, Runnable {

    private Cellule passage = null;
    private static Random random = new Random();
    private boolean stop = false;
    // La durée en ms pour avancer d'une case.
    public int duréeReference = 200;
    private Color couleur;
    private ApplicationPrincipale applicationPrincipale;
    private int x, y;
    //private Instruction programme;
    private Thread processus;
    private boolean enMarche = false;
    private int numeroImage = 0;

    private OrientationReelle orientation;

    private ImageView image;

    public Cellule quoiDessous() {
        return passage;
    }

    public void bloquer() {
        stop = true;
    }

    public synchronized void deBloquer() {
        stop = false;
        notifyAll();
    }

    public boolean isStopped() {
        return stop;
    }

    @Override
    public void setTaille(int lx, int ly) {

    }

    public void enleverUneMarque() {
         }

    public void poserUneMarque() {
        applicationPrincipale.add(new Marque(applicationPrincipale.getTailleCelluleX(), applicationPrincipale.getTailleCelluleY()), x, y);
        applicationPrincipale.change(this);
     }

    public void avance() {
        x += orientation.pasX;
        y += orientation.pasY;
        applicationPrincipale.change(this);
    }

    public void tourne() {
        orientation = OrientationReelle.values()[(orientation.ordinal() + 1) % 4];
        image.setRotate(image.getRotate() + 90);
    }

    public void echelle(double s) {
        image.setScaleX(image.getScaleX() * s);
        image.setScaleY(image.getScaleY() * s);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void init(ApplicationPrincipale applicationPrincipale, int x, int y, OrientationReelle orientation, Color couleur) {
        this.applicationPrincipale = applicationPrincipale;
        this.couleur = couleur;
        passage = applicationPrincipale.get(x, y);
        this.x = x;
        this.y = y;

        image = new ImageView(new Image("/fx/robot/images/robotVersNord.png"));
        this.orientation = orientation;
        image.setPreserveRatio(true);
        image.setSmooth(true);
        image.setCache(true);
        image.setRotate(orientation.angle);

        applicationPrincipale.add(this);
    }

    /**
     * Créer un robot "quelque part" sur le terrain.
     *
     * @param applicationPrincipale : terrain sur lequel circule le robot
     * @see public Robot(ApplicationPrincipale terrain, int x, int y)
     */
    public Robot(ApplicationPrincipale applicationPrincipale) {
        init(applicationPrincipale,
                random.nextInt(applicationPrincipale.getNx() - 2) + 1,
                random.nextInt(applicationPrincipale.getNy() - 2) + 1,
                OrientationReelle.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(ApplicationPrincipale applicationPrincipale, int x, int y) {
        init(applicationPrincipale,
                x,
                y,
                OrientationReelle.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(ApplicationPrincipale applicationPrincipale, int x, int y, Color couleur) {
        init(applicationPrincipale,
                x,
                y,
                OrientationReelle.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(ApplicationPrincipale applicationPrincipale, Color couleur) {
        init(applicationPrincipale,
                random.nextInt(applicationPrincipale.getNx() - 2) + 1,
                random.nextInt(applicationPrincipale.getNy() - 2) + 1,
                OrientationReelle.values()[random.nextInt(4)], couleur
        );
    }

    public Robot(ApplicationPrincipale applicationPrinciaple, int x, int y, OrientationReelle orientation) {
        init(
                applicationPrinciaple,
                x,
                y,
                orientation,
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    /**
     * Pour connaître la couleur du robot
     *
     * @return la couleur du robot
     */
    @Override
    public Color getCouleur() {
        return couleur;
    }

    public Cellule quoiDevant() {

        int xa = x + orientation.pasX;
        int ya = y + orientation.pasY;

        if (xa >= applicationPrincipale.getNx()) {
            xa = 0;
        }
        if (xa < 0) {
            xa = applicationPrincipale.getNx() - 1;
        }

        if (ya >= applicationPrincipale.getNy()) {
            ya = 0;
        }
        if (ya < 0) {
            ya = applicationPrincipale.getNy() - 1;
        }

        return applicationPrincipale.get(xa, ya);
    }

    @Override
    public ImageView getNode() {
        return image;
    }

    public void fit() {
        double fit = Math.min(applicationPrincipale.getTailleCelluleY(), applicationPrincipale.getTailleCelluleX());
        image.setFitHeight(fit);
        image.setFitWidth(fit);
    }
    
    public void go() {
        processus = new Thread(this);
        processus.start();
    }

    public void stopThread() {
        // Arrêter le thread en cours
        processus.interrupt();

        System.out.println("ARRET DU PROCESSUS");
    }

    @Override
    public void run() {
        try {
            applicationPrincipale.getProgramme().go(this);
        } catch (DansLeMur | InterruptedException ex) {
            
        }
    }
}
