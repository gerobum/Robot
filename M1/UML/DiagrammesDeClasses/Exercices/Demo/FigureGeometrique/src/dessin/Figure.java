
package dessin;

import java.awt.Graphics;

public abstract class Figure {
    public abstract void dessiner(Graphics g);   
    public abstract void translater(int dx, int dy); 
}
