package exempleSimple;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modele.Modele7;

/**
 *
 * @author Maillot
 */
public class Ex7 extends JFrame {
    public Ex7() {
        super("Table avec Modèle");
        Modele7 dtm = new Modele7();
       
        JTable table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getContentPane().add(scrollPane);


        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Madame");
        comboBox.addItem("Mademoiselle");
        comboBox.addItem("Monsieur");
        comboBox.addItem("Maître");
        comboBox.addItem("Docteur");
        comboBox.addItem("Monseigneur");
        comboBox.addItem("Son altesse");
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Ex7();
    }
}
