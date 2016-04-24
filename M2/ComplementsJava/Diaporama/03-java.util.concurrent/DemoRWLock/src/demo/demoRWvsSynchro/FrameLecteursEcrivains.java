/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.demoRWvsSynchro;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author maillot
 */
public class FrameLecteursEcrivains extends JFrame {

    private JLabel[] ecrivainRW, lecteurRW, ecrivainSynchro, lecteurSynchro;
    private PGRW pgrw = new PGRW();
    private PGSynchro pgsynchro = new PGSynchro();
    private Color ecrivaintEteint = Color.red.darker().darker();
    private Color lecteurEteint = Color.green.darker().darker();
    private Color ecrivaintAllume = Color.red;
    private Color lecteurAllume = Color.green;

    public FrameLecteursEcrivains(int nbe, int nbl) {

        ecrivainRW = new JLabel[nbe];
        ecrivainSynchro = new JLabel[nbe];

        lecteurRW = new JLabel[nbl];
        lecteurSynchro = new JLabel[nbl];

        getContentPane().setLayout(new GridLayout(0, 2, 20, 5));
        getContentPane().add(new JLabel("Ecrivains RW", JLabel.CENTER));
        getContentPane().add(new JLabel("Ecrivains Synchro", JLabel.CENTER));

        for (int i = 0; i < nbe; i++) {

            ecrivainRW[i] = new JLabel("()", JLabel.CENTER);
            ecrivainRW[i].setBackground(ecrivaintEteint);
            ecrivainRW[i].setOpaque(true);


            getContentPane().add(ecrivainRW[i]);

            ecrivainSynchro[i] = new JLabel("[]", JLabel.CENTER);
            ecrivainSynchro[i].setBackground(ecrivaintEteint);
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
    }
    
    public void start() {
        Ecrivain ecrivain;
        for(int i = 0; i < ecrivainRW.length; i++) {
                    
            ecrivain = new Ecrivain(ecrivainRW[i], pgrw, 10*lecteurRW.length, ecrivaintEteint, ecrivaintAllume);
            ecrivain.start();
                        
            ecrivain = new Ecrivain(ecrivainSynchro[i], pgsynchro, 10*lecteurRW.length, ecrivaintEteint, ecrivaintAllume);
            ecrivain.start();
        }
        Lecteur lecteur;
        for(int i = 0; i < lecteurRW.length; i++) {
                    
            lecteur = new Lecteur(lecteurRW[i], pgrw, 10*lecteurRW.length, lecteurEteint, lecteurAllume);
            lecteur.start();
                        
            lecteur = new Lecteur(lecteurSynchro[i], pgsynchro, 10*lecteurRW.length, lecteurEteint, lecteurAllume);
            lecteur.start();
        }
    }

    /**
     * public LecteursEcrivains(int nbe, int nbl) {
     *
     * ecrivainRW = new JLabel[nbe]; ecrivainSynchro = new JLabel[nbe];
     *
     * lecteurRW = new JLabel[nbl]; lecteurSynchro = new JLabel[nbl];
     *
     * getContentPane().setLayout(new GridBagLayout()); GridBagConstraints c =
     * new GridBagConstraints(); c.fill = GridBagConstraints.BOTH; c.insets =
     * new Insets(5, 5, 5, 5); c.gridx = 0; c.gridy = 0; JPanel perw = new
     * JPanel(); perw.add(new JLabel("Ecrivains RW", JLabel.CENTER));
     * getContentPane().add(perw, c); c.gridx = (c.gridx + 1) % 2; perw = new
     * JPanel(); perw.add(new JLabel("Ecrivains Synchro", JLabel.CENTER));
     * getContentPane().add(perw, c); c.gridy++;
     *
     * for (int i = 0; i < nbe; i++) {
     *
     * perw = new JPanel(); ecrivainRW[i] = new JLabel("()", JLabel.CENTER);
     * ecrivainRW[i].setBackground(Color.red); ecrivainRW[i].setOpaque(true);
     * perw.add(ecrivainRW[i]); getContentPane().add(perw, c); c.gridx =
     * (c.gridx + 1) % 2; perw = new JPanel(); ecrivainSynchro[i] = new
     * JLabel("[]", JLabel.CENTER); ecrivainSynchro[i].setBackground(Color.red);
     * ecrivainSynchro[i].setOpaque(true); perw.add(ecrivainSynchro[i]);
     * getContentPane().add(perw, c); c.gridy++; }
     *
     *
     * perw = new JPanel(); perw.add(new JLabel("Lecteurs RW", JLabel.CENTER));
     * getContentPane().add(perw, c); c.gridx = (c.gridx + 1) % 2; perw = new
     * JPanel(); perw.add(new JLabel("Lecteurs Synchro", JLabel.CENTER));
     * getContentPane().add(perw, c); c.gridy++;
     *
     * for (int i = 0; i < nbl; i++) {
     *
     * perw = new JPanel(); lecteurRW[i] = new JLabel("()", JLabel.CENTER);
     * lecteurRW[i].setBackground(Color.green); lecteurRW[i].setOpaque(true);
     * perw.add(lecteurRW[i]); getContentPane().add(perw, c); c.gridx = (c.gridx
     * + 1) % 2; perw = new JPanel(); lecteurSynchro[i] = new JLabel("[]",
     * JLabel.CENTER); lecteurSynchro[i].setBackground(Color.green);
     * lecteurSynchro[i].setOpaque(true); perw.add(lecteurSynchro[i]);
     * getContentPane().add(lecteurSynchro[i], c); c.gridy++; }
     *
     *
     * setVisible(true); pack(); setDefaultCloseOperation(EXIT_ON_CLOSE); }
     *
     *
     */
    public static void main(String[] args) {
        FrameLecteursEcrivains f = new FrameLecteursEcrivains(1, 5);
        f.start();
    }
}
