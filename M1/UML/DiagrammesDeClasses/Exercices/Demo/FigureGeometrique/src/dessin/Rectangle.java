
package dessin;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author yvan
 */
public class Rectangle extends FigureSimple {
    
    private final int width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(new Point(x, y));
        this.width = width;
        this.height = height;
    }

    @Override
    public void dessiner(Graphics g) {
        g.drawRect(reference.x, reference.y, width, height);
    }
    
}
