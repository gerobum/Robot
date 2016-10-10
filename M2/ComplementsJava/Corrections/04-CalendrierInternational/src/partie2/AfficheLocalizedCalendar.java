package partie2;

import javax.swing.JFrame;

/**
 *
 * @author maillot
 */
public class AfficheLocalizedCalendar extends JFrame {
    public AfficheLocalizedCalendar() {
        init();
    }
    
    private void init() {        
        getContentPane().add(new LocalizedCalendar());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        AfficheLocalizedCalendar afficheLocalizedCalendar = new AfficheLocalizedCalendar();
    }

}
