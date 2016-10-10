/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robot.panneaux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Yvan
 */
public class BoiteDeDialHTML extends javax.swing.JDialog {
    
    private static final long serialVersionUID = 1L;
    
    /** Creates new form exercicesDialog */
    private URL texteURL;
    public BoiteDeDialHTML(URL texteURL) {
        super((JFrame)null, false);
        this.texteURL = texteURL;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
        add(textPaneExercices(), "Center");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
    }

    private JScrollPane textPaneExercices() {
        textPaneExercices = new JTextPane();

        JScrollPane paneScrollPane = new JScrollPane(textPaneExercices);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));
        textPaneExercices.setEditable(false);
        //java.net.URL texteURL = BoiteDeDialExo.class.getResource("exercices.html");


        try {
            textPaneExercices.setPage(texteURL);
        } catch (IOException ex) {
            Logger.getLogger(BoiteDeDialHTML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paneScrollPane;
    }

    private javax.swing.JTextPane textPaneExercices;
}
