
package fx.programme;

import fx.terrain.Position;
import static fx.terrain.Position.*;
import fx.terrain.OrientationRobot;
import static fx.terrain.OrientationRobot.*;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import terrain.Terrain;

/**
 *
 * @author Yvan
 */
public class Initialisation implements Serializable {
    private static final long serialVersionUID = 1L;

 
    private Position positionRobot = QUELCONQUE;
    private OrientationRobot orientationRobot = null;
    private boolean presenceMinerai = false;
    private Position positionMinerai = QUELCONQUE;
    private boolean presenceHauteur = false;
    private boolean presenceLargeur = false;
    private int hauteur;
    private int largeur;
    private static final Random RANDOM = new Random();

    public static Terrain.Position calculPosition(Position position, Terrain terrain) {

        switch (position) {
            case QUELCONQUE:
                return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 2) + 1, RANDOM.nextInt(terrain.getNy() - 2) + 1);
            case CONTRE_UN_MUR:
                // Tirage au sort du mur
                int mur = RANDOM.nextInt(4);
                switch (mur) {
                    case Terrain.NORD:
                        return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 2) + 1, 1);
                    case Terrain.SUD:
                        return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 2) + 1, terrain.getNy() - 2);
                    case Terrain.OUEST:
                        return new Terrain.Position(1, RANDOM.nextInt(terrain.getNy() - 2) + 1);
                    case Terrain.EST:
                        return new Terrain.Position(terrain.getNx() - 2, RANDOM.nextInt(terrain.getNy() - 2) + 1);
                }
                break;
            case DANS_UN_COIN:
                // Tirage au sort du coin
                int coin = RANDOM.nextInt(4);
                switch (coin) {
                    case Terrain.NORD_EST:
                        return new Terrain.Position(terrain.getNx() - 2, 1);
                    case Terrain.SUD_EST:
                        return new Terrain.Position(terrain.getNx() - 2, terrain.getNy() - 2);
                    case Terrain.SUD_OUEST:
                        return new Terrain.Position(1, terrain.getNy() - 2);
                    case Terrain.NORD_OUEST:
                        return new Terrain.Position(1, 1);
                }
                break;
            case PAS_CONTRE_UN_MUR:
                return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 4) + 2, RANDOM.nextInt(terrain.getNy() - 4) + 2);
            case PAS_DANS_UN_COIN:
                int x;
                int y;
                do {
                    x = RANDOM.nextInt(terrain.getNx() - 2) + 1;
                    y = RANDOM.nextInt(terrain.getNy() - 2) + 1;
                } while (x == 1 && y == 1
                        || x == 1 && y == terrain.getNy() - 2
                        || x == terrain.getNx() - 2 && y == 1
                        || x == terrain.getNx() - 2 && y == terrain.getNy() - 2);
                return new Terrain.Position(x, y);

            case CONTRE_LE_MUR_NORD:
                return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 2) + 1, 1);
            case CONTRE_LE_MUR_EST:
                return new Terrain.Position(terrain.getNx() - 2, RANDOM.nextInt(terrain.getNy() - 2) + 1);
            case CONTRE_LE_MUR_SUD:
                return new Terrain.Position(RANDOM.nextInt(terrain.getNx() - 2) + 1, terrain.getNy() - 2);
            case CONTRE_LE_MUR_OUEST:
                return new Terrain.Position(1, RANDOM.nextInt(terrain.getNy() - 2) + 1);
            case DANS_LE_COIN_NE:
                return new Terrain.Position(terrain.getNx() - 2, 1);
            case DANS_LE_COIN_SE:
                return new Terrain.Position(terrain.getNx() - 2, terrain.getNy() - 2);

            case DANS_LE_COIN_SO:
                return new Terrain.Position(1, terrain.getNy() - 2);
            case DANS_LE_COIN_NO:
                return new Terrain.Position(1, 1);
            default:
                try {
                    throw new Exception("position : " + position + " Ne devrait pas arriver");
                } catch (Exception ex) {             
                }
                return null;
        }
        return null;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public boolean isPresenceHauteur() {
        return presenceHauteur;
    }

    public void setPresenceHauteur(boolean presenceHauteur) {
        this.presenceHauteur = presenceHauteur;
    }

    public boolean isPresenceLargeur() {
        return presenceLargeur;
    }

    public void setPresenceLargeur(boolean presenceLargeur) {
        this.presenceLargeur = presenceLargeur;
    }

    public OrientationRobot getOrientationRobot() {
        return orientationRobot;
    }

    public Position getPositionMinerai() {
        return positionMinerai;
    }

    public Position getPositionRobot() {
        return positionRobot;
    }

    public boolean isPresenceMinerai() {
        return presenceMinerai;
    }

    public void setOrientationRobot(OrientationRobot orientationRobot) {
        this.orientationRobot = orientationRobot;
    }

    public void setPositionMinerai(Position positionMinerai) {
        this.positionMinerai = positionMinerai;
    }

    public void setPositionRobot(Position positionRobot) {
        this.positionRobot = positionRobot;
    }

    public void setPrésenceMinerai(boolean presenceMinerai) {
        this.presenceMinerai = presenceMinerai;
    }

    @Override
    public String toString() {
        return "{Position du robot : " + positionRobot
                + ",\\nOrientation du robot : " + orientationRobot
                + ",\\nPrésence du minerai : " + presenceMinerai
                + ",\\nPosition du minerai : " + positionMinerai
                + ",\\nHauteur définie : " + presenceHauteur
                + ",\\nHauteur : " + hauteur
                + ",\\nLargeur définie : " + presenceLargeur
                + ",\\nLargeur : " + largeur
                + "}";
    }
}
