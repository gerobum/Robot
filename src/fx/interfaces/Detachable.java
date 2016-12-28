package fx.interfaces;

import javax.swing.JTree;
import fx.programme.Programme;
import fx.robot.Robot;

public interface Detachable {



    public Programme getProgramme();
    
    //public Terrain getTerrain();
    
    //public void setTerrain(Terrain terrain);
    
    //public JSplitPane getSplitPane();    

    //public void redessine();

    public Robot getRobot();

    public void setRobot(Robot robot);

    //public Dimension getSize();

    public JTree getArbre();

    public void montreDialInit();
    
    //public JMenuBar getJMenuBar();
    
    //public BoiteDeDialogueInit getDialogueInitialisation();
    
    //public void viderTerrain();
    
    //public PanneauTerrain getPanneauTerrain();
    
    //public void setPanneauTerrain(PanneauTerrain panneau);
    
    //public PanneauCommande getPanneauCommande();
    
    //public void setPanneauCommande(PanneauCommande panneau);
    
    public void executeProgramme();
    
    public void executeSelection();
    
    public void setTitle(String nom);

}
