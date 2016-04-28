package labelAnime;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestAvecDecorateurSimple extends JFrame {

    public TestAvecDecorateurSimple() {
        super("Test");
        JLabel tourne = new JLabel("Tourne ", JLabel.CENTER);
        JLabel clignote = new JLabel("Clignote", JLabel.CENTER);
        JLabel tourneEtClignote = new JLabel("Tourne et Clignote ", JLabel.CENTER);

        
        Font font = new Font("Courrier", Font.BOLD, 25);
        tourne.setFont(font);
        clignote.setFont(font);
        tourneEtClignote.setFont(font);
        
        new Clignoteur(new AnimateurConcret(clignote)).animer();
        new Tourneur(new AnimateurConcret(tourne)).animer();
        new Clignoteur(new Tourneur(new AnimateurConcret(tourneEtClignote))).animer();

              
        getContentPane().setLayout(new GridLayout(0, 1));
        
        getContentPane().add(tourne);
        getContentPane().add(clignote);
        getContentPane().add(tourneEtClignote);
        
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestAvecDecorateurSimple();
            }
        });

        
    }
}
