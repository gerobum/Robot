package exempleSimple;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maillot
 */
public class Ex1 extends JFrame {

  public Ex1() {
    super("Table vide");
    JTable table = new JTable(10, 4);

    getContentPane().add(table, "Center");
    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane);

    // Pour placer l'en-tête (en l'absence d'ascenseur)
    getContentPane().add(table.getTableHeader(), "North");




    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  public static void main(String[] args) {
    new Ex1();
  }
}
