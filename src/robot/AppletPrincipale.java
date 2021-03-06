package robot;

import interfaces.Detachable;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.*;
import robot.panneaux.*;
import terrain.Terrain;


/**
 *
 * @author Yvan
 */
public class AppletPrincipale extends JApplet implements Detachable {
    
    private static final long serialVersionUID = 1L;

    private static Random random = new Random();

    private PanneauPrincipal panneauPrincipal;
    private PanneauTerrain panneauTerrain = new PanneauTerrain();
    private Terrain terrain;
    private Robot robot = null;
    private PanneauCommande panneauCommande;
    private Programme programme;
    private JSplitPane splitPane;
    private PanneauDExecution panneauDExecution;
    private JTree arbre;

    @Override
    public BoiteDeDialogueInit getDialogueInitialisation() {
        return dialogueInitialisation;
    }
    private BoiteDeDialogueInit dialogueInitialisation;
    //private File oldDir;
    
    @Override
    public JMenuBar getJMenuBar() {
        return super.getJMenuBar();
    }


    @Override
    public Terrain getTerrain() {
        return terrain;
    }

    @Override
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public JTree getArbre() {
        return arbre;
    }

    @Override
    public Programme getProgramme() {
        return programme;
    }

    @Override
    public Robot getRobot() {
        return robot;
    }

    @Override
    public JSplitPane getSplitPane() {
        return splitPane;
    }

    @Override
    public void montreDialInit() {
        dialogueInitialisation.setVisible(true);
        if (dialogueInitialisation.getOk()) {
            programme.setInitialisation(dialogueInitialisation.getInitialisation());
            Initialisation.initialiser(dialogueInitialisation.getInitialisation(), this, true);
        }
    }

    @Override
    public void redessine() {
        if (terrain != null) {
            terrain.revalidate();
        }
    }

 




    @Override
    public void init() {
        //super("Le monde de nono");


        //initialisation = new Initialisation(this);
        //programme = new DefaultTreeModel(new Bloc("programme principal"));
        //programme.put("programme principal", new DefaultTreeModel(new Bloc("programme principal")));
        //setSize(800, 600);

        dialogueInitialisation = new BoiteDeDialogueInit(this);

        programme = new Programme();
        arbre = new JTreeRobot(programme.getArbreProgramme());
        
        setJMenuBar(new JMenuBar());
        
        //#########################################
        panneauPrincipal = new PanneauPrincipal(this);

        Dimension tailleMini = new Dimension(0, 0);

        // TEST SPLIT PANE
        JScrollPane scropane1 = new JScrollPane(panneauPrincipal);
        scropane1.setMinimumSize(tailleMini);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scropane1, panneauTerrain);

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(scropane1.getPreferredSize().width);

        getContentPane().add(splitPane, "Center");
        panneauCommande = new PanneauCommande(this);
        getContentPane().add(panneauCommande, "South");

        Initialisation.initialiser(this, false);
        
        panneauDExecution = new PanneauDExecution(this);


        panneauTerrain.add(panneauDExecution, "South");

//#########################################


        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        //chooser = new JFileChooser();

        //FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichiers robot", "rob");
        //chooser.setFileFilter(filtre);

    }

    @Override
    public void viderTerrain() {
        panneauTerrain.remove(terrain);
    }

    @Override
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public PanneauTerrain getPanneauTerrain() {
        return panneauTerrain;
    }

    @Override
    public void setPanneauTerrain(PanneauTerrain panneau) {
        this.panneauTerrain = panneau;
    }

    @Override
    public PanneauCommande getPanneauCommande() {
        return panneauCommande;
    }

    @Override
    public void setPanneauCommande(PanneauCommande panneau) {
        this.panneauCommande = panneau;
    }

    @Override
    public void executeProgramme() {
        panneauDExecution.executeProgramme();
    }

    @Override
    public void executeSelection() {
        panneauDExecution.executeSelection();
    }

    @Override
    public void setTitle(String nom) {
        
    }

  
    


}

