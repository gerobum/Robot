package partie2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import partie1.JLabelCalendar;

/**
 * Extension : Par extension de la classe javax.swing.JPanel et composition avec
 * la classe PerpetualCalendar développer la classe LocalizedCalendar qui
 * permettra d'afficher la date et l'heure courante dans une des localisations
 * reconnues par votre JVM. Cette localisation sera sélectionnée par
 * l'intermédiaire d'une javax.swing.JComboBox. L'image ci-dessous visualise
 * l'aspect attendu du calendrier.
 * @author maillot
 */
public class LocalizedCalendar extends JPanel {
    private final JLabelCalendar pc = new JLabelCalendar();
    private final JComboBox liste = new JComboBox(DateFormat.getAvailableLocales());
 
    public LocalizedCalendar() {
        init();
    }
    
    private void init() {        
        setLayout(new BorderLayout());
        add(pc, "Center");
        liste.setSelectedItem(getLocale());
        add(liste, "South");
        liste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pc.setLocale((Locale) liste.getSelectedItem());
            }
        });
    }
}
