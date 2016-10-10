
package langues;

import java.awt.GridLayout;
import java.util.Locale;
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
    private final JLabel jLlangue, jLregion, jLautre;
    private StopWatch stopWatch;

    @Override
    public void setLocale(Locale l) {
        super.setLocale(l);
        try {
            jLlangue.setText(java.util.ResourceBundle.getBundle("langues/dico", l).getString("LANGUE"));
            jLregion.setText(java.util.ResourceBundle.getBundle("langues/dico", l).getString("REGION"));
            jLautre.setText(java.util.ResourceBundle.getBundle("langues/dico", l).getString("AUTRE"));
        } catch (NullPointerException ne) {

        }
    }

    public ChoixDeLangue(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        langue = new JTextField(8);
        region = new JTextField(8);
        autre = new JTextField(8);
        jLlangue = new JLabel(java.util.ResourceBundle.getBundle("langues/dico").getString("LANGUE"));
        jLregion = new JLabel(java.util.ResourceBundle.getBundle("langues/dico").getString("REGION"));
        jLautre = new JLabel(java.util.ResourceBundle.getBundle("langues/dico").getString("AUTRE"));
        
        init();
        
        CaretListener caret = new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                Locale locale = new Locale(langue.getText(), region.getText(), autre.getText());
                ChoixDeLangue.this.setLocale(locale);
                ChoixDeLangue.this.stopWatch.setLocale(locale);
            }
        };

        langue.addCaretListener(caret);
        region.addCaretListener(caret);
        autre.addCaretListener(caret);
    }
    
    private void init() {        
        getContentPane().setLayout(new GridLayout(2, 3));
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
