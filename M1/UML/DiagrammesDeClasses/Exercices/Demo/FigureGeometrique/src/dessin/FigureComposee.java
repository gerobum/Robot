package dessin;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

public class FigureComposee extends Figure {

    private final Set<Figure> figures = new HashSet<>();

    @Override
    public void dessiner(Graphics g) {
        for (Figure figure : figures) {
            figure.dessiner(g);
        }
    }

    @Override
    public void translater(int x, int y) {
        for (Figure figure : figures) {
            figure.translater(x, y);
        }
    }

    public void ajouter(Figure figure) {
        figures.add(figure);
    }

    public void enlever(Figure figure) {
        figures.remove(figure);
    }

}
