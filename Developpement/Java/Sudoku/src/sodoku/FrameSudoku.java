package sodoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class Bouton extends JButton {
    PetitCarré carré;
    public final int l, c;
    public Bouton(PetitCarré carré, int l, int c) {
        super();
        this.l = l;
        this.c = c;
        this.carré = carré;
    }
    public Bouton(String nom, PetitCarré carré, int l, int c) {
        super(nom);
        this.carré = carré;
        this.l = l;
        this.c = c;

    }    
    public PetitCarré getCarré() {
        return carré;
    }
}

public class FrameSudoku extends JFrame implements ActionListener, KeyListener, MouseListener, FocusListener {
    GrandCarré grand_carré;
    LinkedList<GrandCarré> liste;
    Bouton[][] bouton;
    Bouton boutonQuiaLeFocus;
    JMenuItem action_nouvelle_partie, action_récure, action_précédent, action_résoudre, action_init, action_vérif;
    /** Creates a new instance of FrameSudoku */
    public FrameSudoku() {
        liste = new LinkedList<>();
        grand_carré = new GrandCarré();
        bouton = new Bouton[9][9];
        miseEnplaceDesComposants();
    }
    private void miseEnplaceDesComposants() {
        
        setJMenuBar(new JMenuBar());
        getJMenuBar().add(new JMenu("Jeu"));
        action_nouvelle_partie = new JMenuItem("Nouvelle partie");
        getJMenuBar().getMenu(0).add(action_nouvelle_partie);
        action_nouvelle_partie.addActionListener(this);
        action_récure = new JMenuItem("Récure");
        getJMenuBar().getMenu(0).add(action_récure);
        action_récure.addActionListener(this);
        action_précédent = new JMenuItem("Précédent");
        getJMenuBar().getMenu(0).add(action_précédent);
        action_précédent.addActionListener(this);
        action_résoudre = new JMenuItem("Résoudre");
        getJMenuBar().getMenu(0).add(action_résoudre);
        action_résoudre.addActionListener(this);
        action_init = new JMenuItem("Init");
        getJMenuBar().getMenu(0).add(action_init);
        action_init.addActionListener(this);
        action_vérif = new JMenuItem("Vérification");
        getJMenuBar().getMenu(0).add(action_vérif);
        action_vérif.addActionListener(this);
        getContentPane().setLayout(new GridLayout(3, 4, 20, 20));
        getContentPane().addKeyListener(this);
        getContentPane().setBackground(Color.ORANGE);
        
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                getContentPane().add(créer_panneau_avec_9_boutons(i, j));
            }
        }
        boutonQuiaLeFocus = bouton[0][0];
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private JPanel créer_panneau_avec_9_boutons(int l, int c) {
        JPanel panneau = new JPanel();
        panneau.setLayout(new GridLayout(3,3, 5,5));
        panneau.setBackground(Color.ORANGE);
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                int L = l*3+i;
                int C = c*3+j;
                
                bouton[L][C] = new Bouton(grand_carré.getCarré(L, C), L, C);
                Dimension dim = new Dimension(70, 70);
                bouton[L][C].setPreferredSize(dim);
                bouton[L][C].setFont(new Font("Bradley Hand ITC", Font.BOLD, 16));
                grand_carré.getCarré(L,C).setBouton(bouton[L][C]);
                grand_carré.getCarré(L,C).construire_nom_bouton();
                bouton[L][C].addKeyListener(this);
                bouton[L][C].addMouseListener(this);
                bouton[L][C].addFocusListener(this);
                bouton[L][C].setBackground(Color.WHITE);
                panneau.add(bouton[L][C]);
            }
        panneau.setVisible(true);
        return panneau;
    }
    private void mettre_à_blanc() {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) {
                bouton[i][j].setBackground(Color.WHITE);
                bouton[i][j].carré = grand_carré.getCarré(i,j);

            }
    }
    private void tenter_petit_carré(int l, int c) {
        GrandCarré gc = grand_carré.copie();
        PetitCarré petit_carré = gc.getCarré(l, c);
        if (petit_carré.valeurs_possible().size() > 1) {
            for(Integer i : petit_carré.valeurs_possible()) {
                petit_carré.setValeur(i);
                gc.récure();
                if (gc.erreur()) {
                    grand_carré.getCarré(l, c).enlever(i);
                }  
                gc = grand_carré.copie();
            }
        }
    }
    private void résoudre() {
         for(int i = 0; i < 9; i++)
             for(int j = 0; j < 9; j++)
                 tenter_petit_carré(i, j);
         mettre_à_blanc();
    }
     /*
    private GrandCarré résoudre(GrandCarré gc) {
        if (gc.fini()) {
            return gc;
        } else {
            GrandCarré gc2 = gc.copie();
            for(int i = 0; i < 9; i++)
                for(int j = 0; j < 9;j++)
                    for(Integer I : gc2.getCarré(i, j).valeurs_possible()) {
                        System.out.println(I);
                        gc2.getCarré(i, j).setValeur(I);
                        if (gc2.erreur()) {
                            gc2 = gc.copie();
                        } else {
                            gc2 = résoudre(gc2);
                            if (gc2 != null) {
                                return gc2;
                            } else {
                                gc2 = gc.copie();
                            }
                        }
                        return null;
                    }
                        
            
        }
        return null;
    }
      **/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == action_nouvelle_partie) {
            grand_carré.nouvelle_partie();
            liste.clear();
        } else if (e.getSource() == action_récure) {
            grand_carré.récure();
        } else if (e.getSource() == action_précédent) {
            if (!liste.isEmpty()) {
                grand_carré = liste.removeFirst();
                for(int i = 0; i < 9; i++)
                    for(int j = 0; j < 9; j++) {
                        bouton[i][j].setBackground(Color.WHITE);
                        bouton[i][j].carré = grand_carré.getCarré(i,j);
                    }
                grand_carré.mise_à_jour_des_boutons();
            }
        } else if (e.getSource() == action_résoudre) {
            /*GrandCarré gc = résoudre(grand_carré);
            if (gc != null)
                gc = grand_carré;*/
            résoudre();
            pack();
        } else if (e.getSource() == action_init) {
            grand_carré.getCarré(0,0).setValeur(6);
            grand_carré.getCarré(0,3).setValeur(8);
            grand_carré.getCarré(0,6).setValeur(3);
            grand_carré.getCarré(1,1).setValeur(4);
            grand_carré.getCarré(1,3).setValeur(5);
            grand_carré.getCarré(1,7).setValeur(8);
            grand_carré.getCarré(2,2).setValeur(7);
            grand_carré.getCarré(2,4).setValeur(9);
            grand_carré.getCarré(2,6).setValeur(1);
            grand_carré.getCarré(2,8).setValeur(4);
            grand_carré.getCarré(3,0).setValeur(5);
            grand_carré.getCarré(3,6).setValeur(9);
            grand_carré.getCarré(3,7).setValeur(6);
            grand_carré.getCarré(4,4).setValeur(5);
            grand_carré.getCarré(5,1).setValeur(8);
            grand_carré.getCarré(5,2).setValeur(2);
            grand_carré.getCarré(5,8).setValeur(3);
            grand_carré.getCarré(6,0).setValeur(4);
            grand_carré.getCarré(6,2).setValeur(3);
            grand_carré.getCarré(6,4).setValeur(2);
            grand_carré.getCarré(6,6).setValeur(6);
            grand_carré.getCarré(7,1).setValeur(6);
            grand_carré.getCarré(7,5).setValeur(8);
            grand_carré.getCarré(7,7).setValeur(3);
            grand_carré.getCarré(8,2).setValeur(8);
            grand_carré.getCarré(8,5).setValeur(7);        
            grand_carré.getCarré(8,8).setValeur(2);        
        } else if (e.getSource() == action_vérif) {
            //for(int i = 0)
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        Bouton b;
        if (e.getKeyChar() >= '1' && e.getKeyChar() <= '9') {
            /*try {
                liste.addFirst(grand_carré.clone());
                
            } catch (CloneNotSupportedException exp) {
                exp.printStackTrace();
            }*/  
            liste.addFirst(grand_carré.copie());
            b = (Bouton)e.getSource();
            

            b.getCarré().setValeur(Integer.parseInt(e.getKeyChar()+""));
            grand_carré.récure();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int l = boutonQuiaLeFocus.l;
        int c = boutonQuiaLeFocus.c;
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_UP:
                l--;
                if (l < 0) l = 8;
                break;
            case KeyEvent.VK_DOWN:
                l++;
                if (l > 8) l = 0;
                break;
            case KeyEvent.VK_LEFT:
                c--;
                if (c < 0) c = 8;
                break;
            case KeyEvent.VK_RIGHT:
                c++;
                if (c > 8) c = 0;
                break;
            case KeyEvent.VK_BACK_SPACE:
                action_précédent.doClick();
                break;
            default:
                break;
        }
        if (bouton[l][c].requestFocusInWindow())
            boutonQuiaLeFocus = bouton[l][c];  
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (((Bouton) e.getSource()).requestFocusInWindow())
            boutonQuiaLeFocus = (Bouton) e.getSource();  
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void focusLost(FocusEvent e) {
        ((Bouton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }
    @Override
    public void focusGained(FocusEvent e) {
        ((Bouton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
    }
}
