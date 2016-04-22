package exempleSimple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modele.Modele5;

/**
 *
 * @author Maillot
 */
public class Ex5 extends JFrame {

    public Ex5() {
        super("Table avec Modèle");
        final Object[][] datas = new Object[10][4];
        final String[] columnNames = {"Entiers", "Nombres à virgule", "Booléen", "Chaîne de caractères"};
        final Class<?>[] columnTypes = {Integer.class, Double.class, Boolean.class, String.class};

        JTable table = new JTable(new Modele5(datas, columnNames, columnTypes));

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getContentPane().add(scrollPane);

        JButton afficher = new JButton("Afficher données");
        afficher.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object[] v : datas) {
                    for (Object o : v) {
                        System.out.print(o + ", ");
                    }
                    System.out.println();
                }
            }
        });

        JButton remplir = new JButton("Remplir au hasard");
        remplir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int l = r.nextInt(10);
                datas[l][0] = r.nextInt(10);
                datas[l][1] = r.nextInt(100) / 10.0;
                datas[l][2] = r.nextBoolean();
                datas[l][3] = "alea jacta est";
                getContentPane().repaint();
            }
        });

        getContentPane().add(afficher, "South");
        getContentPane().add(remplir, "North");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {
        Ex5 e = new Ex5();

    }
}
