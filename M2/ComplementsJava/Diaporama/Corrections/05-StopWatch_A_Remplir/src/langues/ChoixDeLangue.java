/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package langues;

import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import pendule.StopWatch;

/**
 *
 * @author yvan
 */
public class ChoixDeLangue extends JDialog {

  private JTextField langue, region, autre;
  private JLabel jLlangue, jLregion, jLautre;
  private StopWatch stopWatch;


  public ChoixDeLangue(StopWatch stopWatch) {
    this.stopWatch = stopWatch;
    getContentPane().setLayout(new GridLayout(2, 3));
    langue = new JTextField(8);
    region = new JTextField(8);
    autre = new JTextField(8);
    jLlangue = new JLabel("LANGUE");
    jLregion = new JLabel("REGION");
    jLautre = new JLabel("AUTRE");
    getContentPane().add(jLlangue);
    getContentPane().add(jLregion);
    getContentPane().add(jLautre);
    getContentPane().add(langue);
    getContentPane().add(region);
    getContentPane().add(autre);
    setModal(false);

    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    pack();
  }
}
