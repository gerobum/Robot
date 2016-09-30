package dessin;

import java.awt.Graphics;
import java.awt.Point;

public final class Cercle extends FigureSimple {
    private final int rayon;

    public Cercle(Point centre, int rayon) {
        super(centre);
        this.rayon = rayon;
    }

  

    @Override
    public void dessiner(Graphics g) {
        
        g.drawOval(reference.x-rayon, reference.y-rayon, rayon+rayon, rayon+rayon);
    }


    
}
