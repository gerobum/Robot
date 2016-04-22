package exempleSimple;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maillot
 */
public class Ex3 extends JFrame {

  private JButton bouton = new JButton("Alea Jacta Est");
  private Integer[] titre = {1, 10, 100, 1000};
  private Random random = new Random();
  private Object[][] donnée = new Object[10][4];

  public Ex3() {
    super("Valeurs aléatoires");
    remplissage();
    JTable table = new JTable(donnée, titre);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);

    getContentPane().add(table, "Center");
    getContentPane().add(bouton, "East");

    JScrollPane scrollPane = new JScrollPane(table);

    getContentPane().add(scrollPane);

    bouton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        remplissage();
        getContentPane().repaint();
      }
    });

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  private void remplissage() {
    for (int i = 0; i < donnée.length; i++) {
      for (int j = 0; j < donnée[i].length; j++) {
        donnée[i][j] = random.nextInt(10) * (titre[j]);
      }
    }
  }
  
  public static void main(String[] args) {
    new Ex3();
  }
}
