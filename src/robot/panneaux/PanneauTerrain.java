/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.panneaux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author maillot
 */
public class PanneauTerrain extends JPanel {
    private static final long serialVersionUID = 1L; 
    
    public PanneauTerrain() {
        super(new BorderLayout(), true);
        setMinimumSize(new Dimension(0, 0));
    }
    
}
