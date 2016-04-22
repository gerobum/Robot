package exempleSimple;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maillot
 */
public class Ex4 extends JFrame {
    public Ex4() {
        super("Table avec Modèle");
        DefaultTableModel dtm = new DefaultTableModel();      
        String[] columnNames = {"Integer", "Double", "Boolean", "String"};
        Object donnée[][] = {{1, 1.0, true, "Un"}};
        dtm.setDataVector(donnée, columnNames);
       
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getContentPane().add(scrollPane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Ex4();
    }
}
