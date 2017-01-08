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
    
    
    
    public PanneauPrincipal() {
        
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
        
             
        tree = new TreeView<>(treeProg); 
        
        tree.getSelectionModel().select(treeProg.getChildren().get(0));
        
        gridPane.add(new PanneauProgrammation(tree), 0, row++);
        gridPane.add(new PanneauEdition(tree, programme), 0, row++);
        gridPane.add(new PanneauExecution(tree, programme), 0, row++);
        stackPane.setPrefWidth(500);
        getItems().addAll(gridPane, stackPane);
          
        
        stackPane.getChildren().add(tree);
        
    }
    
    private void addListeners() {
        
    }
}
