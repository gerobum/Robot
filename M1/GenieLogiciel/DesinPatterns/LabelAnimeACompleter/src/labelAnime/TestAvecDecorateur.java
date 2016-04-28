package labelAnime;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestAvecDecorateur extends JFrame {

    public TestAvecDecorateur() {
        super("Test");
        JLabel tourne = new JLabel("Tourne ", JLabel.CENTER);
        JLabel clignote = new JLabel("Clignote", JLabel.CENTER);
        JLabel tourneEtClignote = new JLabel("Tourne et Clignote", JLabel.CENTER);

        
        Font font = new Font("Courrier", Font.BOLD, 25);
        tourne.setFont(font);
        clignote.setFont(font);
        tourneEtClignote.setFont(font);

              
        getContentPane().setLayout(new GridLayout(0, 1));
        
        getContentPane().add(tourne);
        getContentPane().add(clignote);
        getContentPane().add(tourneEtClignote);
        
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new TestAvecDecorateur();
    }
}
