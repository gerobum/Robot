/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import robot.Initialisation;
import robot.Programme;
import robot.Robot;
import robot.panneaux.BoiteDeDialogueInit;
import robot.panneaux.PanneauCommande;
import robot.panneaux.PanneauTerrain;
import terrain.Terrain;

/**
 *
 * @author yvan.maillot
 */
public interface Detachable {



    public Programme getProgramme();
    
    public Terrain getTerrain();
    
    public void setTerrain(Terrain terrain);
    
    public JSplitPane getSplitPane();    

    public void redessine();

    public Robot getRobot();

    public void setRobot(Robot robot);

    public Dimension getSize();

    public JTree getArbre();

    public void montreDialInit();
    
    public JMenuBar getJMenuBar();
    
    public BoiteDeDialogueInit getDialogueInitialisation();
    
    public void viderTerrain();
    
    public PanneauTerrain getPanneauTerrain();
    
    public void setPanneauTerrain(PanneauTerrain panneau);
    
    public PanneauCommande getPanneauCommande();
    
    public void setPanneauCommande(PanneauCommande panneau);
    
    public void executeProgramme();
    
    public void executeSelection();
    
    public void setTitle(String nom);

}
