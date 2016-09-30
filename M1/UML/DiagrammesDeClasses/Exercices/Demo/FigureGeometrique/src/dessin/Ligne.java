
package dessin;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author yvan
 */
public class Ligne extends FigureSimple {
    
    private int dx, dy;

    public Ligne(int x1, int y1, int x2, int y2) {
        super(new Point(x1, y1));
        this.dx = x2-x1;
        this.dy = y2-y1;
    }

    @Override
    public void dessiner(Graphics g) {
        g.drawLine(reference.x, reference.y, reference.x+dx, reference.y+dy);
    }

    
}
