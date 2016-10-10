package partie1;
import javax.swing.JFrame;

/**
 *
 * @author maillot
 */
public class AfficheCalendar extends JFrame {

    public AfficheCalendar() {
        init();
    }

    private void init() {
        getContentPane().add(new JLabelCalendar());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        AfficheCalendar afficheCalendar = new AfficheCalendar();
    }

}
