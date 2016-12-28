package fx.programme.instructions;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;
import fx.exceptions.DansLeMur;
import fx.robot.Robot;

public class Ecrire extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;
    
    String message;
    private transient JDialog boite;
    private transient Robot robot;

    
    

    public Ecrire(Instruction parent, String message) {
        super(parent);
        this.message = message;
        nom = "écrire, " + message;
        créerDialogue();
    }
    
    /*
     * private JDialog creerDialogue(String message) {
     *
     * }
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        créerDialogue();
    }
    
    private void créerDialogue() {
        
        boite = new JDialog((Frame) null, "Nono vous informe");
        boite.setModal(false);
        boite.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        boite.setLayout(new BorderLayout());
        boite.add(new JLabel(message));
        JButton ok = new JButton("Ok");
        JPanel p = new JPanel();
        p.add(ok);
        
        boite.add(p, "South");
        if (Toolkit.getDefaultToolkit().isAlwaysOnTopSupported()) {
            boite.setAlwaysOnTop(true);
        }
        boite.pack();
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (robot != null) {
                    robot.deBloquer();
                }
                boite.setVisible(false);
            }
        });
    }
    
    
    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
        this.robot = robot;
        if (boite != null) {
            robot.bloquer();
            boite.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, message, "Nono vous informe", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    public ImageIcon getIcon() {
        return null;
    }
}
