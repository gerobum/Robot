/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendule;

import langues.ChoixDeLangue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 * @author maillot
 */
public class StopWatch extends JFrame implements Runnable {

  private JLabel centre;
  private int heure, minute, seconde;
  private JButton start, stop, reset;

  private Thread runner;
  private JCheckBox changerDeLangue;
  private ChoixDeLangue choixDeLangue;
  //private JMenu menu;
  //private JMenuItem item;

  public StopWatch() {
    super("Chronomètre");

    heure = 0;
    minute = 0;
    seconde = 0;
    start = new JButton("Départ");
    stop = new JButton("Arrêt");
    reset = new JButton("Mise à zéro");


    centre = new JLabel("00:00:00", JLabel.CENTER);
    centre.setFont(centre.getFont().deriveFont(40F));

    centre.setBorder(BorderFactory.createEmptyBorder(10, 70, 10, 70));


    JPanel pan = new JPanel();
    pan.setLayout(new GridLayout(1, 3));
    pan.add(start);
    pan.add(stop);
    pan.add(reset);

    getContentPane().add(centre, "Center");
    getContentPane().add(pan, "South");
    getContentPane().setBackground(Color.orange);
    choixDeLangue = new ChoixDeLangue(this);
    changerDeLangue = new JCheckBox("CHANGER DE LANGUE");
    getContentPane().add(changerDeLangue, "North");


    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);


    changerDeLangue.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        choixDeLangue.setVisible(changerDeLangue.isSelected());
      }
    });
  }

  public static void main(String[] args) {
    StopWatch sw = new StopWatch();

  }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
