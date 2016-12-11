package fx.robot;


import fx.main.Cellule;
import fx.main.Marque;
import fx.main.Terrain;
import instruction.Instruction;
import java.awt.Paint;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import robot.DansLeMur;
import terrain.Mur;

public class Robot implements Cellule, Runnable {

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
    private Image[] image;
    private Image[] robotN = new Image[1];
    private Image[] robotS = new Image[1];
    private Image[] robotE = new Image[1];
    private Image[] robotO = new Image[1];
    private Image[] robotCasse = new Image[4];
    private Image[] robotNeM = new Image[4];
    private Image[] robotSeM = new Image[4];
    private Image[] robotEeM = new Image[4];
    private Image[] robotOeM = new Image[4];
    private Image[] robotNprem = new Image[1];
    private Image[] robotSprem = new Image[1];
    private Image[] robotEprem = new Image[1];
    private Image[] robotOprem = new Image[1];
    private Image[] robotCasseprem = new Image[4];
    private Image[] robotNeMprem = new Image[4];
    private Image[] robotSeMprem = new Image[4];
    private Image[] robotEeMprem = new Image[4];
    private Image[] robotOeMprem = new Image[4];
    private Thread processus;
    private boolean enMarche = false;
    private int numeroImage = 0;

    public Cellule quoiDessous() {
        return passage;
    }

    private void lancementAnimation() {
        Thread animation = new Thread(new Runnable() {

            @Override
            public void run() {
                while (enMarche) {
                    Robot.this.numeroImage = (Robot.this.numeroImage + 1) % Robot.this.image.length;
                    Robot.this.terrain.repaint(x * Robot.this.terrain.getTailleCelluleX(), y * Robot.this.terrain.getTailleCelluleY(), Robot.this.terrain.getTailleCelluleX(), Robot.this.terrain.getTailleCelluleY());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        //animation.setDaemon(true);
        animation.start();
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

        robotE[0] = robotEprem[0];
        robotS[0] = robotSprem[0];
        robotO[0] = robotOprem[0];
        robotN[0] = robotNprem[0];

        robotEeM[0] = robotEeMprem[0];
        robotEeM[1] = robotEeMprem[1];
        robotEeM[2] = robotEeMprem[2];
        robotEeM[3] = robotEeMprem[3];

        robotOeM[0] = robotOeMprem[0];
        robotOeM[1] = robotOeMprem[1];
        robotOeM[2] = robotOeMprem[2];
        robotOeM[3] = robotOeMprem[3];

        robotSeM[0] = robotSeMprem[0];
        robotSeM[1] = robotSeMprem[1];
        robotSeM[2] = robotSeMprem[2];
        robotSeM[3] = robotSeMprem[3];

        robotNeM[0] = robotNeMprem[0];
        robotNeM[1] = robotNeMprem[0];
        robotNeM[2] = robotNeMprem[0];
        robotNeM[3] = robotNeMprem[0];

        robotCasse[0] = robotCasseprem[0];
        robotCasse[1] = robotCasseprem[1];
        robotCasse[2] = robotCasseprem[2];
        robotCasse[3] = robotCasseprem[3];

    }

    private class Orientation {

        public final int direction, pasx, pasy;

        Orientation(int ix, int px, int py) {
            pasx = px;
            pasy = py;
            direction = ix;
        }
    };


    /*
     * public void prend(Cellule c) { if (passage == null) passage = c; else
     * passage.prend(c);
    }
     */
    private Image[] imageSelonOrientation() {

        if (!enMarche) {
            if (vers.direction == Terrain.EST) {
                return robotE;
            } else if (vers.direction == Terrain.OUEST) {
                return robotO;
            } else if (vers.direction == Terrain.SUD) {
                return robotS;
            } else {
                return robotN;
            }
        } else {
            if (vers.direction == Terrain.EST) {
                return robotEeM;
            } else if (vers.direction == Terrain.OUEST) {
                return robotOeM;
            } else if (vers.direction == Terrain.SUD) {
                return robotSeM;
            } else {
                return robotNeM;
            }
        }
    }

    private void init(Terrain terrain, int x, int y, int direction, Color couleur) {
        this.terrain = terrain;
        this.couleur = couleur;
        passage = terrain.get(x, y);
        this.x = x;
        this.y = y;
        vers = tOrientation[direction];
        terrain.set(x, y, this);
 

            robotEprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersEst.png"));
            robotSprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersSud.png"));
            robotOprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersOuest.png"));
            robotNprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersNord.png"));

            robotE[0] = robotEprem[0];
            robotS[0] = robotSprem[0];
            robotO[0] = robotOprem[0];
            robotN[0] = robotNprem[0];

            robotEeMprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersEst1.png"));
            robotEeMprem[1] = new Image(Robot.class.getResourceAsStream("images/robotVersEst2.png"));
            robotEeMprem[2] = new Image(Robot.class.getResourceAsStream("images/robotVersEst3.png"));
            robotEeMprem[3] = new Image(Robot.class.getResourceAsStream("images/robotVersEst4.png"));

            robotEeM[0] = robotEeMprem[0];
            robotEeM[1] = robotEeMprem[1];
            robotEeM[2] = robotEeMprem[2];
            robotEeM[3] = robotEeMprem[3];

            robotOeMprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersOuest1.png"));
            robotOeMprem[1] = new Image(Robot.class.getResourceAsStream("images/robotVersOuest2.png"));
            robotOeMprem[2] = new Image(Robot.class.getResourceAsStream("images/robotVersOuest3.png"));
            robotOeMprem[3] = new Image(Robot.class.getResourceAsStream("images/robotVersOuest4.png"));

            robotOeM[0] = robotOeMprem[0];
            robotOeM[1] = robotOeMprem[1];
            robotOeM[2] = robotOeMprem[2];
            robotOeM[3] = robotOeMprem[3];

            robotSeMprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersSud1.png"));
            robotSeMprem[1] = new Image(Robot.class.getResourceAsStream("images/robotVersSud2.png"));
            robotSeMprem[2] = new Image(Robot.class.getResourceAsStream("images/robotVersSud3.png"));
            robotSeMprem[3] = new Image(Robot.class.getResourceAsStream("images/robotVersSud4.png"));

            robotSeM[0] = robotSeMprem[0];
            robotSeM[1] = robotSeMprem[1];
            robotSeM[2] = robotSeMprem[2];
            robotSeM[3] = robotSeMprem[3];

            robotNeMprem[0] = new Image(Robot.class.getResourceAsStream("images/robotVersNord1.png"));
            robotNeMprem[1] = new Image(Robot.class.getResourceAsStream("images/robotVersNord2.png"));
            robotNeMprem[2] = new Image(Robot.class.getResourceAsStream("images/robotVersNord3.png"));
            robotNeMprem[3] = new Image(Robot.class.getResourceAsStream("images/robotVersNord4.png"));

            robotNeM[0] = robotNeMprem[0];
            robotNeM[1] = robotNeMprem[0];
            robotNeM[2] = robotNeMprem[0];
            robotNeM[3] = robotNeMprem[0];

            robotCasseprem[0] = new Image(Robot.class.getResourceAsStream("images/robotCasse1.png"));
            robotCasseprem[1] = new Image(Robot.class.getResourceAsStream("images/robotCasse2.png"));
            robotCasseprem[2] = new Image(Robot.class.getResourceAsStream("images/robotCasse3.png"));
            robotCasseprem[3] = new Image(Robot.class.getResourceAsStream("images/robotCasse4.png"));

            robotCasse[0] = robotCasseprem[0];
            robotCasse[1] = robotCasseprem[1];
            robotCasse[2] = robotCasseprem[2];
            robotCasse[3] = robotCasseprem[3];

       
        image = imageSelonOrientation();
        terrain.repaint();
    }

    /**
     * Créer un robot "quelque part" sur le terrain.
     *
     * @param terrain : terrain sur lequel circule le robot
     * @see public Robot(Terrain terrain, int x, int y)
     */
    public Robot(Terrain terrain) {
        init(terrain, random.nextInt(terrain.getNx()), random.nextInt(terrain.getNy()), random.nextInt(4), Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        lancementAnimation();

    }

    public Robot(Terrain terrain, int x, int y) {
        init(terrain, x, y, random.nextInt(4),  Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        lancementAnimation();
    }

    public Robot(Terrain terrain, int x, int y, Color couleur) {
        init(terrain, x, y, random.nextInt(4), Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        lancementAnimation();
    }

    public Robot(Terrain terrain, Color couleur) {
        init(terrain, random.nextInt(terrain.getNx()), random.nextInt(terrain.getNy()), random.nextInt(4), couleur);
        lancementAnimation();
    }

    public Robot(Terrain terrain, int x, int y, int dir) {
        init(terrain, x, y, dir, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        lancementAnimation();
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

    /**
     * Avance d'un pas (ou non) sur le terrain dans le sens indiqué par pasx et
     * pasy
     */
    //@Override
    public void avance() throws DansLeMur {
        int xa = x;
        int ya = y;

        x += vers.pasx;
        y += vers.pasy;

        if (x >= terrain.getNx()) {
            x = 0;
        }
        if (x < 0) {
            x = terrain.getNx() - 1;
        }

        if (y >= terrain.getNy()) {
            y = 0;
        }
        if (y < 0) {
            y = terrain.getNy() - 1;
        }

        Cellule cellule = terrain.get(x, y);
        if (cellule != this) {
            if (cellule instanceof Robot || cellule instanceof Mur) {
                x = xa;
                y = ya;
                image = robotCasse;
                terrain.repaint();
                enMarche = false;
                throw new DansLeMur();
            } else {
                terrain.set(xa, ya, passage);
                passage = terrain.get(x, y);
                terrain.set(x, y, this);
            }
        }


        terrain.repaint(x * terrain.getTailleCelluleX(), y * terrain.getTailleCelluleY(), terrain.getTailleCelluleX(), terrain.getTailleCelluleY());
        terrain.repaint(xa * terrain.getTailleCelluleX(), ya * terrain.getTailleCelluleY(), terrain.getTailleCelluleX(), terrain.getTailleCelluleY());


        try {

            Thread.sleep(duréeReference);
        } catch (InterruptedException ex) {
            enMarche = false;
            
            return;
        }


    }

    public Thread getProcessus() {
        return processus;
    }

    //@Override
    public void tourne() throws InterruptedException {
        vers = tOrientation[(vers.direction + 1) % 4];
        image = imageSelonOrientation();
        terrain.repaint(x * terrain.getTailleCelluleX(), y * terrain.getTailleCelluleY(), terrain.getTailleCelluleX(), terrain.getTailleCelluleY());

        Thread.sleep(duréeReference);

    }

    public synchronized void execute(Instruction i) {
        programme = i;
        stop();
        processus = new Thread(this);
        //processus.setDaemon(true);
        processus.start();

    }

    public void stop() {
        enMarche = false;
        if (processus != null) {
            while (processus.isAlive()) {
                processus.interrupt();
            }
        }

    }

    @Override
    public synchronized void run() {
        /*try {
            terrain.repaint();
            Thread.sleep(500);
            enMarche = true;
            image = imageSelonOrientation();
            terrain.repaint();
            Thread.sleep(500);

            programme.go(this);
            enMarche = false;
            Thread.sleep(500);
            image = imageSelonOrientation();
            terrain.repaint();
        } catch (DansLeMur ex) {
            //Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "<html><p>Erreur de programmation</p></html>",
                    "Bouuuum !!! Dans le mur",
                    JOptionPane.ERROR_MESSAGE,
                    new ImageIcon(Robot.class.getResource("images/RobotCasse.png")));
            stop();


        } catch (InterruptedException ex) {
            //Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "<html><p>Arrêt du robot</p>"
                    + "<p>Sans doute s'agit-il d'une erreur de programmation</p></html>",
                    "Arrêt du robot",
                    JOptionPane.ERROR_MESSAGE);
            stop();
        } catch (NullPointerException ex) {
            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "<html><p>Arrêt du robot</p>" +
            //        "<p>Sans doute s'agit-il d'une erreur de programmation (null)</p></html>",
            //        "Arrêt du robot",
            //        JOptionPane.ERROR_MESSAGE);
            //processus.interrupt();

        }*/
    }

    @Override
    public Image getImage() {
        //image.flush();
        return image[numeroImage % image.length];
    }

    //@Override
    public void poserUneMarque() {
        // Pour l'instant, le fait de poser une marque supprime tout ce qu'il pourra y avoir ici
        passage = new Marque(terrain.getTailleCelluleX(), terrain.getTailleCelluleY());
    }

    //@Override
    public void enleverUneMarque() {
        if (passage instanceof terrain.Marque) {
            passage = null;
        }
    }
}
