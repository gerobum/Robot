package dessin;

import java.awt.Point;

/**
 *
 * @author yvan
 */
public abstract class FigureSimple extends Figure {

    protected Point reference;

    public FigureSimple(Point reference) {
        this.reference = reference;
    }

    @Override
    public void translater(int dx, int dy) {
        reference.x += dx;
        reference.y += dy;
    }
}
