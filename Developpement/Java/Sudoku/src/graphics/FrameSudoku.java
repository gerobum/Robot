package graphics;

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
import sodoku.GrandCarré;
import sudoku.Case;
import sudoku.Grille;
import sudoku.Zone9;

class Bouton extends JButton {
    
    private final Font FONT_FOR_1_CAR = new Font("Bradley Hand ITC", Font.BOLD, 50);
    private final Font FONT_FOR_9_CAR = new Font("Bradley Hand ITC", Font.BOLD, 16);;
    
    
    private final Case aCase;
    public final int l, c;
    public Bouton(Case aCase, int l, int c) {
        this.l = l;
        this.c = c;
        this.aCase = aCase;
        construireNomBouton();
    }
    /*public Bouton(String nom, Case aCase, int l, int c) {
        super(nom);
        this.aCase = aCase;
        this.l = l;
        this.c = c;

    }*/    
    public Case getCarré() {
        return aCase;
    }
    
    
    public final void construireNomBouton() {
        if (aCase.numberOfPossibily() == 1) {
            setText(aCase.getPossibilities()[0]+"");
            setFont(FONT_FOR_1_CAR);
        } else {
            setFont(FONT_FOR_9_CAR);
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            Integer[] p = aCase.getPossibilities();
            int x=1;
            for(int k : p) {
                sb.append(k);
                if (x % 3 == 0)
                    sb.append("<br>");
                ++x;
            }
            
            sb.append("</html>");
            setText(sb.toString());  
        }
    }
}

public class FrameSudoku extends JFrame implements ActionListener, KeyListener, MouseListener, FocusListener {
    Grille grille;
    LinkedList<Zone9> liste;
    Bouton[][] bouton;
    Bouton boutonQuiaLeFocus;
    JMenuItem action_nouvelle_partie, action_récure, action_précédent, action_résoudre, action_init, action_vérif;
    
    public FrameSudoku(Grille g) {
        liste = new LinkedList<>();
        grille = g;
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
                
                bouton[L][C] = new Bouton(grille.getCase(L, C), L, C);
                bouton[L][C].setPreferredSize(new Dimension(70, 70));
                bouton[L][C].setFont(new Font("Bradley Hand ITC", Font.BOLD, 16));
                //grille.getCarré(L,C).setBouton(bouton[L][C]);
                //grille.getCarré(L,C).construire_nom_bouton();
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
                //bouton[i][j].aCase = grille.getCarré(i,j);

            }
    }
    private void tenter_petit_carré(int l, int c) {
        /*GrandCarré gc = grille.copie();
        PetitCarré petit_carré = gc.getCarré(l, c);
        if (petit_carré.valeurs_possible().size() > 1) {
            for(Integer i : petit_carré.valeurs_possible()) {
                petit_carré.setValeur(i);
                gc.récure();
                if (gc.erreur()) {
                    grille.getCarré(l, c).enlever(i);
                }  
                gc = grille.copie();
            }
        }*/
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
        /*if (e.getSource() == action_nouvelle_partie) {
            grille.nouvelle_partie();
            liste.clear();
        } else if (e.getSource() == action_récure) {
            grille.récure();
        } else if (e.getSource() == action_précédent) {
            if (!liste.isEmpty()) {
                grille = liste.removeFirst();
                for(int i = 0; i < 9; i++)
                    for(int j = 0; j < 9; j++) {
                        bouton[i][j].setBackground(Color.WHITE);
                        bouton[i][j].aCase = grille.getCarré(i,j);
                    }
                grille.mise_à_jour_des_boutons();
            }
        } else if (e.getSource() == action_résoudre) {
         
            résoudre();
            pack();
        } else if (e.getSource() == action_init) {
            grille.getCarré(0,0).setValeur(6);
            grille.getCarré(0,3).setValeur(8);
            grille.getCarré(0,6).setValeur(3);
            grille.getCarré(1,1).setValeur(4);
            grille.getCarré(1,3).setValeur(5);
            grille.getCarré(1,7).setValeur(8);
            grille.getCarré(2,2).setValeur(7);
            grille.getCarré(2,4).setValeur(9);
            grille.getCarré(2,6).setValeur(1);
            grille.getCarré(2,8).setValeur(4);
            grille.getCarré(3,0).setValeur(5);
            grille.getCarré(3,6).setValeur(9);
            grille.getCarré(3,7).setValeur(6);
            grille.getCarré(4,4).setValeur(5);
            grille.getCarré(5,1).setValeur(8);
            grille.getCarré(5,2).setValeur(2);
            grille.getCarré(5,8).setValeur(3);
            grille.getCarré(6,0).setValeur(4);
            grille.getCarré(6,2).setValeur(3);
            grille.getCarré(6,4).setValeur(2);
            grille.getCarré(6,6).setValeur(6);
            grille.getCarré(7,1).setValeur(6);
            grille.getCarré(7,5).setValeur(8);
            grille.getCarré(7,7).setValeur(3);
            grille.getCarré(8,2).setValeur(8);
            grille.getCarré(8,5).setValeur(7);        
            grille.getCarré(8,8).setValeur(2);        
        } else if (e.getSource() == action_vérif) {
            //for(int i = 0)
        }*/
    }
    @Override
    public void keyTyped(KeyEvent e) {
        /*Bouton b;
        if (e.getKeyChar() >= '1' && e.getKeyChar() <= '9') {
            /*try {
                liste.addFirst(grille.clone());
                
            } catch (CloneNotSupportedException exp) {
                exp.printStackTrace();
            }*//*  
            liste.addFirst(grille.copie());
            b = (Bouton)e.getSource();
            

            b.getCarré().setValeur(Integer.parseInt(e.getKeyChar()+""));
            grille.récure();
        }*/
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
