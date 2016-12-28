package fx.terrain;

import fx.robot.Robot;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

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
            add(c, x, 0);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(x).add(0, c);

            c = new Trou(tailleCellule, tailleCellule);
            add(c, x, nY - 1);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(x).add(nY - 1, c);
        }

        for (int y = 0; y < nY; ++y) {
            c = new Trou(tailleCellule, tailleCellule);
            add(c, 0, y);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(0).add(y, c);

            c = new Trou(tailleCellule, tailleCellule);
            add(c, nX - 1, y);
            NODE_2_CELLULE.put(c.getNode(), c);
            //nodesGrid.get(nX - 1).add(y, c);
        }

        for (int x = 1; x < nX - 1; ++x) {
            for (int y = 1; y < nY - 1; ++y) {
                c = new CelluleVide(tailleCellule, tailleCellule);
                add(c, x, y);
                //nodesGrid.get(x).add(y, c);
                i = (i + 1) % 2;
            }
            if (i == j) {
                i = (i + 1) % 2;
            }
            j = i;
        }
    }

    public Cellule get(int x, int y) {
        return NODE_2_CELLULE.get(getChildren()
                .stream()
                .filter(n -> GridPane.getColumnIndex(n) == x)
                .filter(n -> GridPane.getRowIndex(n) == y)
                .filter(n -> n.isVisible())
                .findFirst().get());
    }

    public Object get(Node n) {
        return NODE_2_CELLULE.get(n);
    }

    public void add(Robot robot) {
        add(robot.getNode(), robot.getX(), robot.getY());
        NODE_2_CELLULE.put(robot.getNode(), robot);
    }

    public void add(Cellule cellule, int xa, int ya) {
        add(cellule.getNode(), xa, ya);
        NODE_2_CELLULE.put(cellule.getNode(), cellule);
    }

    public void remove(Cellule passage) {
        getChildren().remove(passage.getNode());
        NODE_2_CELLULE.remove(passage.getNode());
    }
}
