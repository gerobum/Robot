package fx.panneaux;

import fx.programme.Programme;
import fx.programme.instructions.Instruction;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import static fx.utilitaires.Utilitaires.*;

public class PanneauPrincipal extends SplitPane {
    
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();
    private TreeView<Instruction> tree;
    private ApplicationPrincipale applicationPrincipale;
    
    
    public PanneauPrincipal(ApplicationPrincipale applicationPrincipale) {
        this.applicationPrincipale = applicationPrincipale;
        doingUI();
        addListeners();        
    }
    
    private void doingUI() {
        getStylesheets().add(getClass().getResource("panneaux.css").toExternalForm());
        gridPane.setVgap(15);
        int row = 1;
        Programme programme = new Programme();
        /*Instruction tq = new TantQue(programme.getProcedurePrincipal(), new PasDevantMur());
        tq.addChild(new Avance(tq));
        
        programme.getProcedurePrincipal().addChild(tq);
        
        tq = new TantQue(programme.getProcedurePrincipal(), new PasSurMinerai());
        Instruction si = new Si(tq, new DevantMur());
        si.addChild(new Tourne(si));
        si.addChild(new Avance(si));  
        tq.addChild(si);
        
        programme.getProcedurePrincipal().addChild(tq);*/
        TreeItem<Instruction> treeProg = getArbreFromProgramme(programme);
        //setOrientation(Orientation.VERTICAL);
             
        tree = new TreeView<>(treeProg); 
        
        tree.getSelectionModel().select(treeProg.getChildren().get(0));
        
        gridPane.add(new PanneauProgrammation(tree), 0, row++);
        gridPane.add(new PanneauEdition(tree), 0, row++);
        gridPane.add(new PanneauExecution(applicationPrincipale), 0, row++);
        stackPane.setPrefWidth(500);
        //stackPane.setOrientation(Orientation.VERTICAL);
        stackPane.getChildren().add(tree);
        getItems().addAll(gridPane, stackPane);
          
        
    }
    
    public Instruction getProgramme() {
        return tree.getRoot().getValue();
    }
    
    private void addListeners() {
        
    }
}
