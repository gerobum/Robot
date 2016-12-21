package fx.panneaux;

import fx.programme.Programme;
import fx.programme.instructions.Avance;
import fx.programme.instructions.Instruction;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
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
    
    public PanneauPrincipal() {
        
        doingUI();
        addListeners();
    }
    
    private void doingUI() {
        getStylesheets().add(getClass().getResource("panneaux.css").toExternalForm());
        gridPane.setVgap(15);
        int row = 1;
        gridPane.add(new PanneauProgrammation(), 0, row++);
        gridPane.add(new PanneauEdition(), 0, row++);
        gridPane.add(new PanneauExecution(), 0, row++);
        stackPane.setPrefWidth(500);
        getItems().addAll(gridPane, stackPane);
        
        TreeItem<Instruction> rootItem = new Programme().getProgramme();

        /*        
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<Instruction> item = new TreeItem<>(new Avance(rootItem.getValue()));            
            rootItem.getChildren().add(item);
            for (int j = 1; j < RANDOM.nextInt(5); j++) {
                TreeItem<Instruction> ni = new TreeItem<>(new Avance(item.getValue()));                
                item.getChildren().add(ni);
            }
        }    */    
        TreeView<Instruction> tree = new TreeView<>(rootItem);        
        stackPane.getChildren().add(tree);
        
    }
    
    private void addListeners() {
        
    }
}
