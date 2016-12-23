package fx.panneaux;

import fx.enumerations.Instructions;
import fx.programme.Programme;
import fx.programme.expressions.DevantMur;
import fx.programme.expressions.PasDevantMur;
import fx.programme.expressions.PasSurMinerai;
import fx.programme.instructions.Avance;
import fx.programme.instructions.Instruction;
import fx.programme.instructions.Si;
import fx.programme.instructions.TantQue;
import fx.programme.instructions.Tourne;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.*;
import static fx.utilitaires.Utilitaires.*;

/**
 *
 * @author yvan
 */
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
             
        tree = new TreeView<>(getArbreFromProgramme(programme)); 
        
        gridPane.add(new PanneauProgrammation(tree), 0, row++);
        gridPane.add(new PanneauEdition(), 0, row++);
        gridPane.add(new PanneauExecution(), 0, row++);
        stackPane.setPrefWidth(500);
        getItems().addAll(gridPane, stackPane);
          
        
        stackPane.getChildren().add(tree);
        
    }
    
    private void addListeners() {
        
    }
}
