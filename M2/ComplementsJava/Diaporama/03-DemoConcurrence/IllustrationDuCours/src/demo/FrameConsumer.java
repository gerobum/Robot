/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.LinkedBlockingDeque;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author maillot
 */
public class FrameConsumer extends JFrame {
    private JPanel centre;
    private JPanel sud;
    private JButton ajouter = new JButton("Ajouter");
    private LinkedBlockingDeque<Double> queue;

    public FrameConsumer(LinkedBlockingDeque<Double> q) {
        centre = new JPanel(new GridLayout(0, 1));
        sud = new JPanel();

        this.queue = q;
        
        getContentPane().add(centre, "Center");
        sud.add(ajouter);
        ajouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                centre.add(new PanelConsumer(new Consumer(queue, "Consommateur", 0, null)));
                FrameConsumer.this.pack();
            }
        });
        getContentPane().add(sud, "South");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    
    public static void main(String[] args) {
        LinkedBlockingDeque<Double> queue = new LinkedBlockingDeque<Double>(2);
        Producer p = new Producer(queue, "Producteur", 100, -1, false);
        
        new FrameConsumer(queue);
        p.start();
    }

}
