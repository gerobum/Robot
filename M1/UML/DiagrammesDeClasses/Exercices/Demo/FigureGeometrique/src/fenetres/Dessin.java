package fenetres;

import dessin.Figure;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dessin extends JFrame {

    private final Figure figure;
    private final JPanel panneau;

    public Dessin(Figure figure) {
        this.figure = figure;
        panneau = new JPanel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Dessin.this.figure.dessiner(g);
            }
        };
        panneau.setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        panneau.setPreferredSize(new Dimension(500, 500));
        getContentPane().add(panneau);
        pack();
    }
    
    public void translater(int dx, int dy) {
        figure.translater(dx, dy);
        repaint();
    }

}
