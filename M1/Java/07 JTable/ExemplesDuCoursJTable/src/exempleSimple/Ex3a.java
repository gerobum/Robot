package exempleSimple;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maillot
 */
public class Ex3a extends JFrame {

  private JButton bouton = new JButton("Alea Jacta Est");
  //private Integer[] titre = {1, 10, 100, 1000};
  private Vector<Integer> titre;
  private Random random = new Random();
  //private Object[][] donnée = new Object[10][4];
  private Vector<Vector<Object>> donnée;

  public Ex3a() {
    super("Valeurs aléatoires");
    titre = new Vector<>();
    titre.add(1);
    titre.add(10);
    titre.add(100);
    titre.add(1000);
    
    donnée = new Vector<>();
    for(int i = 0; i < 10; i++) {
      Vector<Object> v = new Vector<>();
      v.add(null);
      v.add(null);
      v.add(null);
      v.add(null);
      donnée.add(v);
    }
    
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
    for (int i = 0; i < donnée.size(); i++) {
      for (int j = 0; j < donnée.get(i).size(); j++) {
        donnée.get(i).set(j, random.nextInt(10) * (titre.get(j)));
      }
    }
  }
  
  public static void main(String[] args) {
    new Ex3a();
  }
}
