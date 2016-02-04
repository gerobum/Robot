/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robot.panneaux;

import interfaces.Detachable;
import robot.*;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Yvan
 */
public class BoiteDeDialogueInit extends JDialog {
    private static final long serialVersionUID = 1L;
    
    private PanneauInitialisation panneauInit;
    private Detachable environnement;
    private JButton valider = new JButton("initialisation");
    private JButton annuler = new JButton("annulation");
    
    private boolean reponse = false;
    public BoiteDeDialogueInit(Detachable environnement) {
        super((Dialog)null, "Initialisation");
        this.environnement = environnement;
        setModalityType(ModalityType.APPLICATION_MODAL);
        panneauInit = new PanneauInitialisation();
        setLayout(new BorderLayout());
        add(panneauInit, "Center");
        JPanel boutons = new JPanel();
        boutons.add(valider);
        boutons.add(annuler);
        add(boutons, "South");
         annuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                reponse = false;
            }
        });
      
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                reponse = true;
            }
        });

        setResizable(false);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        pack();
    }
    public void setInitialisation(Initialisation initialisation)  {
        remove(panneauInit);
        panneauInit = new PanneauInitialisation(initialisation);
        add(panneauInit, "Center"); 

        
        if (environnement != null)
            environnement.redessine();
        //environnement.pack();
        //if (environnement.getExtendedState() != JFrame.MAXIMIZED_BOTH)
        //    environnement.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public Initialisation getInitialisation() {
        return panneauInit.getInitialisation();
    }
    public boolean getOk() {
        return reponse;
    }
}
