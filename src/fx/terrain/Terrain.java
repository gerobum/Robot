package fx.terrain;

import fx.interfaces.Detachable;
import fx.panneaux.JTreeRobot;
import fx.panneaux.PanneauPrincipal;
import fx.programme.Programme;
import fx.robot.Robot;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingNode;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JTree;

/**
 *
 * @author yvan
 */
public class Terrain extends GridPane {

    private static final Random random = new Random();

    private int nX = 15;
    private int nY = 10;
    private int tailleCellule = 60;
    private int largeur;
    private int hauteur;
 



    private final Map<Node, Cellule> NODE_2_CELLULE = new HashMap<>();



    public Terrain() {
        int i = 0;
        int j = 0;

        Cellule c;

        for (int x = 0; x < nX; ++x) {
            c = new Trou(tailleCellule, tailleCellule);
            add(c.getNode(), x, 0);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(x).set(0, c);

            c = new Trou(tailleCellule, tailleCellule);
            add(c.getNode(), x, nY - 1);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(x).set(nY - 1, c);
        }

        for (int y = 0; y < nY; ++y) {
            c = new Trou(tailleCellule, tailleCellule);
            add(c.getNode(), 0, y);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(0).set(y, c);

            c = new Trou(tailleCellule, tailleCellule);
            add(c.getNode(), nX - 1, y);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(nX - 1).set(y, c);
        }

        for (int x = 1; x < nX - 1; ++x) {
            for (int y = 1; y < nY - 1; ++y) {
                c = new CelluleVide(tailleCellule, tailleCellule);
                add(c.getNode(), x, y);
                //nodesGrid.get(x).set(y, c);
                i = (i + 1) % 2;
            }
            if (i == j) {
                i = (i + 1) % 2;
            }
            j = i;
        }
    }
}
