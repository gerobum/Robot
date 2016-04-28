package labelAnime;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import vraimentPasUneBonneIdee.*;

public class TestAvecDecorateur extends JFrame {

    public TestAvecDecorateur() {
        super("Test");
        JLabelConcret l1 = new JLabelConcret("Tourne ", JLabel.CENTER);
        JLabelConcret l2 = new JLabelConcret("Clignote", JLabel.CENTER);
        JLabelConcret l3 = new JLabelConcret("Tourne et Clignote", JLabel.CENTER);

        
        Font font = new Font("Courrier", Font.BOLD, 25);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);

        
        //new Clignoteur(new AnimateurJLabel(clignote));
        //new Tourneur(new AnimateurJLabel(tourne));
        //new Clignoteur(new Tourneur(new AnimateurJLabel(tourneEtClignote)));

        // Enrobage
        JLabelAniméAbstrait tourne = new JLabelTournant(l1);
        JLabelAniméAbstrait clignote = new JLabelClignotant(l2);
        JLabelAniméAbstrait tourneEtClignote = new JLabelTournant(clignote);
        JLabelAniméAbstrait clignoteEtTourne = new JLabelClignotant(tourne);

              
        getContentPane().setLayout(new GridLayout(0, 1));
        
        getContentPane().add(tourne);
        getContentPane().add(clignote);
        getContentPane().add(tourneEtClignote);
        getContentPane().add(clignoteEtTourne);
        
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new TestAvecDecorateur();
    }
}
