package labelAnime;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestAvecDecorateur extends JFrame {

    public TestAvecDecorateur() {
        super("Test");
        JLabel tourne = new JLabel("Tourne ", JLabel.CENTER);
        JLabel clignote = new JLabel("Clignote", JLabel.CENTER);
        JLabel tourneEtClignote = new JLabel("Tourne et Clignote ", JLabel.CENTER);
        JLabel arcEnCiel = new JLabel("Arc en ciel", JLabel.CENTER);
        JLabel vague = new JLabel("Vague", JLabel.CENTER);
        JLabel vagueArcEnCiel = new JLabel("Vague arc en ciel ", JLabel.CENTER);
        JLabel calme = new JLabel("Très calme", JLabel.CENTER);
        JLabel agité = new JLabel("très agité", JLabel.CENTER);
        
        Font font = new Font("Courrier", Font.BOLD, 25);
        tourne.setFont(font);
        clignote.setFont(font);
        tourneEtClignote.setFont(font);
        arcEnCiel.setFont(font);
        vague.setFont(font);
        vagueArcEnCiel.setFont(font);
        calme.setFont(font);
        agité.setFont(font);
        
        new Clignoteur(new AnimateurConcret(clignote)).animer();    
        new Tourneur(new AnimateurConcret(tourne)).animer();
        new Clignoteur(new Tourneur(new AnimateurConcret(tourneEtClignote))).animer();
        new Vague(new ArcEnCiel(new AnimateurConcret(vagueArcEnCiel))).animer();
        new ArcEnCiel(new AnimateurConcret(arcEnCiel)).animer();
        new Vague(new AnimateurConcret(vague)).animer();
        new Tourneur(new Tourneur(new Clignoteur(new ArcEnCiel(new Vague(new AnimateurConcret(agité)))))).animer();

              
        getContentPane().setLayout(new GridLayout(0, 1));
        
        getContentPane().add(tourne);
        getContentPane().add(clignote);
        getContentPane().add(tourneEtClignote);
        getContentPane().add(arcEnCiel);
        getContentPane().add(vague);
        getContentPane().add(vagueArcEnCiel);
        getContentPane().add(calme);
        getContentPane().add(agité);
        
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestAvecDecorateur();
            }
        });

        
    }
}
