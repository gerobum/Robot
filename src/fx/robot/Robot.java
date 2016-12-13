package fx.robot;


import fx.terrain.Cellule;
import fx.terrain.OrientationRobot;
import fx.terrain.Terrain;
import instruction.Instruction;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Robot implements Cellule/*, Runnable*/ {

    private Cellule passage = null;
    private static Random random = new Random();
    private boolean stop = false;
    // La durée en ms pour avancer d'une case.
    public int duréeReference = 200;
    private Orientation[] tOrientation = {new Orientation(0, 0, -1), new Orientation(1, 1, 0), new Orientation(2, 0, 1), new Orientation(3, -1, 0)};
    private Orientation vers = tOrientation[0];
    private Color couleur;
    private Terrain terrain;
    private int x, y;
    private Instruction programme;
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

    public void avance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void enleverUneMarque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void poserUneMarque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void tourne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Orientation {

        public final int direction, pasx, pasy;

        Orientation(int ix, int px, int py) {
            pasx = px;
            pasy = py;
            direction = ix;
        }
    };


    private void init(Terrain terrain, int x, int y, int direction, Color couleur) {
        this.terrain = terrain;
        this.couleur = couleur;
        passage = terrain.get(x, y);
        this.x = x;
        this.y = y;
        vers = tOrientation[direction];
        terrain.set(x, y, this);
        
        image = new ImageView(new Image("/fx/robot/images/robotVersNord.png"));
        orientation = OrientationRobot.values()[random.nextInt(4)];
        image.setRotate(orientation.angle);
    }

    /**
     * Créer un robot "quelque part" sur le terrain.
     *
     * @param terrain : terrain sur lequel circule le robot
     * @see public Robot(Terrain terrain, int x, int y)
     */
    public Robot(Terrain terrain) {
        init(terrain, random.nextInt(terrain.getNx()), random.nextInt(terrain.getNy()), random.nextInt(4), Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    public Robot(Terrain terrain, int x, int y) {
        init(terrain, x, y, random.nextInt(4),  Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    public Robot(Terrain terrain, int x, int y, Color couleur) {
        init(terrain, x, y, random.nextInt(4), Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    public Robot(Terrain terrain, Color couleur) {
        init(terrain, random.nextInt(terrain.getNx()), random.nextInt(terrain.getNy()), random.nextInt(4), couleur);
    }

    public Robot(Terrain terrain, int x, int y, int dir) {
        init(terrain, x, y, dir, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
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

        int xa = x + vers.pasx;
        int ya = y + vers.pasy;

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

}
