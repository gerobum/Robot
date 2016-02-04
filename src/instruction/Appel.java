/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import robot.DansLeMur;

/**
 *
 * @author Yvan
 */
public class Appel extends InstructionElementaire {
    private static final long serialVersionUID = 1L;
    
    private Bloc bloc;

    
    public Appel(Bloc bloc) {
        this.bloc = bloc;
        Scanner sc = new Scanner(bloc.toString());
        sc.useDelimiter(", ");
        this.nom = sc.next();
        while(sc.hasNext()) {
            String var = sc.next();
            String n = JOptionPane.showInputDialog(
                    "<html>" +
                    "<p>"+bloc+"</p>"+
                    "<p>Donnez une valeur à " + var + "</p>"+
                    "</html>");
            nom += ", " + var + "=" + n;
        }
    }
    
    @Override
    public void go(robot.Robot robot) throws DansLeMur, InterruptedException {
        Scanner sc = new Scanner(toString());
        sc.useDelimiter(", ");
        sc.next();
        while(sc.hasNext()) {
            String varValeur = sc.next();
            Scanner psc = new Scanner(varValeur);
            psc.useDelimiter("=");
            String var = psc.next();
            //int valeur = psc.nextInt();
            bloc.set(var, ((InstructionComposee)getParent()).get(psc.next()));

        }
        bloc.go(robot);
    }
    
    
    @Override
    public String toString() {
        return nom;
    }

    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public ImageIcon getIcon() {
        return null;
    }



}
