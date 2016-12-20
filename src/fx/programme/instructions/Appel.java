package fx.programme.instructions;

import fx.robot.DansLeMur;
import fx.robot.Robot;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yvan
 */
public class Appel extends InstructionElementaire {

    private static final long serialVersionUID = 1L;

    private final Bloc BLOC;

    public Appel(Instruction parent, Bloc bloc) {
        super(parent);
        this.BLOC = bloc;
        Scanner sc = new Scanner(bloc.toString());
        sc.useDelimiter(", ");
        this.nom = sc.next();
        while (sc.hasNext()) {
            String var = sc.next();
            String n = JOptionPane.showInputDialog(
                    "<html>"
                    + "<p>" + bloc + "</p>"
                    + "<p>Donnez une valeur à " + var + "</p>"
                    + "</html>");
            nom += ", " + var + "=" + n;
        }
    }

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
        Scanner sc = new Scanner(toString());
        sc.useDelimiter(", ");
        sc.next();
        while (sc.hasNext()) {
            String varValeur = sc.next();
            Scanner psc = new Scanner(varValeur);
            psc.useDelimiter("=");
            String var = psc.next();
            //int valeur = psc.nextInt();
            BLOC.set(var, ((InstructionComposee) getParent()).get(psc.next()));

        }
        BLOC.go(robot);
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
