package tableDeMultiplication;

import exempleSimple.*;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * JTable avec le modèle par défaut
 *
 * @author Maillot
 */
public class Table extends JFrame {

  private JTable table;

  private Table(int l, int c) {
    table = new JTable(new TableMultiplicationModel(l, c));

    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    getContentPane().add(scrollPane);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  public static void main(String[] args) {
    new Table(10, 10);
  }
}
