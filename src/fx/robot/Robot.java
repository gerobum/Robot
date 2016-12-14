package fx.robot;

import fx.terrain.Cellule;
import fx.terrain.OrientationRobot;
import fx.terrain.Terrain;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import fx.terrain.Marque;

public class Robot implements Cellule/*, Runnable*/ {

    private Cellule passage = null;
    private static Random random = new Random();
    private boolean stop = false;
    // La durée en ms pour avancer d'une case.
    public int duréeReference = 200;
    private Color couleur;
    private Terrain terrain;
    private int x, y;
    //private Instruction programme;
    private Thread processus;
    private boolean enMarche = false;
    private int numeroImage = 0;

    private OrientationRobot orientation;

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
        terrain.set(x, y, new Marque(terrain.getTailleCelluleX(), terrain.getTailleCelluleY()));
        terrain.change(this);
     }

    public void avance() {
        x += orientation.pasX;
        y += orientation.pasY;
        terrain.change(this);
    }

    public void tourne() {
        orientation = OrientationRobot.values()[(orientation.ordinal() + 1) % 4];
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

    private void init(Terrain terrain, int x, int y, OrientationRobot orientation, Color couleur) {
        this.terrain = terrain;
        this.couleur = couleur;
        passage = terrain.get(x, y);
        this.x = x;
        this.y = y;

        image = new ImageView(new Image("/fx/robot/images/robotVersNord.png"));
        this.orientation = orientation;
        image.setPreserveRatio(true);
        image.setSmooth(true);
        image.setCache(true);
        image.setRotate(orientation.angle);

        terrain.add(this);
    }

    /**
     * Créer un robot "quelque part" sur le terrain.
     *
     * @param terrain : terrain sur lequel circule le robot
     * @see public Robot(Terrain terrain, int x, int y)
     */
    public Robot(Terrain terrain) {
        init(
                terrain,
                random.nextInt(terrain.getNx() - 2) + 1,
                random.nextInt(terrain.getNy() - 2) + 1,
                OrientationRobot.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(Terrain terrain, int x, int y) {
        init(
                terrain,
                x,
                y,
                OrientationRobot.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(Terrain terrain, int x, int y, Color couleur) {
        init(
                terrain,
                x,
                y,
                OrientationRobot.values()[random.nextInt(4)],
                Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        );
    }

    public Robot(Terrain terrain, Color couleur) {
        init(
                terrain,
                random.nextInt(terrain.getNx() - 2) + 1,
                random.nextInt(terrain.getNy() - 2) + 1,
                OrientationRobot.values()[random.nextInt(4)], couleur
        );
    }

    public Robot(Terrain terrain, int x, int y, OrientationRobot orientation) {
        init(
                terrain,
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

        if (xa >= terrain.getNx()) {
            xa = 0;
        }
        if (xa < 0) {
            xa = terrain.getNx() - 1;
        }

        if (ya >= terrain.getNy()) {
            ya = 0;
        }
        if (ya < 0) {
            ya = terrain.getNy() - 1;
        }

        return terrain.get(xa, ya);
    }

    @Override
    public ImageView getNode() {
        return image;
    }

    public void fit() {
        double fit = Math.min(terrain.getTailleCelluleY(), terrain.getTailleCelluleX());
        image.setFitHeight(fit);
        image.setFitWidth(fit);
    }
}
