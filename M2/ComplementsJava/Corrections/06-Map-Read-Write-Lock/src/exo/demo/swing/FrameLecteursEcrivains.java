/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exo.demo.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author maillot
 */
public class FrameLecteursEcrivains extends JFrame {

    private final JLabel[] ecrivainRW, lecteurRW, ecrivainSynchro, lecteurSynchro;
    private final PGRW pgrw = new PGRW();
    private final PGSynchro pgsynchro = new PGSynchro();
    private final Color ecrivainEteint = Color.red.darker().darker();
    private final Color lecteurEteint = Color.green.darker().darker();
    private final Color ecrivainAllume = Color.red;
    private final Color lecteurAllume = Color.green;

    public FrameLecteursEcrivains(int nbe, int nbl) {

        ecrivainRW = new JLabel[nbe];
        ecrivainSynchro = new JLabel[nbe];

        lecteurRW = new JLabel[nbl];
        lecteurSynchro = new JLabel[nbl];

        getContentPane().setLayout(new GridLayout(0, 2, 20, 5));
        final JButton erw = new JButton("Ecrivains RW");
        getContentPane().add(erw);
        final JButton esync = new JButton("Ecrivains Synchro");
        getContentPane().add(esync);

        for (int i = 0; i < nbe; i++) {

            ecrivainRW[i] = new JLabel("()", JLabel.CENTER);
            ecrivainRW[i].setBackground(ecrivainEteint);
            ecrivainRW[i].setOpaque(true);


            getContentPane().add(ecrivainRW[i]);

            ecrivainSynchro[i] = new JLabel("[]", JLabel.CENTER);
            ecrivainSynchro[i].setBackground(ecrivainEteint);
            ecrivainSynchro[i].setOpaque(true);

            
            getContentPane().add(ecrivainSynchro[i]);

        }

        getContentPane().add(new JLabel("Lecteurs RW", JLabel.CENTER));
        getContentPane().add(new JLabel("Lecteurs Synchro", JLabel.CENTER));

        for (int i = 0; i < nbl; i++) {

            lecteurRW[i] = new JLabel("()", JLabel.CENTER);
            lecteurRW[i].setBackground(Color.green.darker().darker());
            lecteurRW[i].setOpaque(true);
            getContentPane().add(lecteurRW[i]);

            lecteurSynchro[i] = new JLabel("[]", JLabel.CENTER);
            lecteurSynchro[i].setBackground(Color.green.darker().darker());
            lecteurSynchro[i].setOpaque(true);

            getContentPane().add(lecteurSynchro[i]);

        }


        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        erw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startRW();
                erw.setEnabled(false);
            }
        });
        
        
        esync.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startSync();
                esync.setEnabled(false);
            }
        });
    }
    
    private void startSync() {
        for (JLabel es : ecrivainSynchro) {
            new Ecrivain(es, pgsynchro, 10*lecteurSynchro.length, ecrivainEteint, ecrivainAllume).start();            
        }
        for (JLabel ls : lecteurSynchro) {
            new Lecteur(ls, pgsynchro, 10*lecteurSynchro.length, lecteurEteint, lecteurAllume).start();
        }
    }
    
    private void startRW() {
        for (JLabel erw : ecrivainRW) {
            new Ecrivain(erw, pgrw, 10*lecteurRW.length, ecrivainEteint, ecrivainAllume).start();            
        }
        for (JLabel lrw : lecteurRW) {
            new Lecteur(lrw, pgrw, 10*lecteurRW.length, lecteurEteint, lecteurAllume).start();
        }
    }
    
    
    
    public static void main(String[] args) {
        FrameLecteursEcrivains f = new FrameLecteursEcrivains(1, 5);
    }
}
