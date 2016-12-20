package fx.programme.instructions;

import java.util.Scanner;
import javax.swing.ImageIcon;
import fx.robot.DansLeMur;
import fx.robot.Robot;

/**
 *
 * @author Yvan
 */
public class Bloc extends InstructionComposee {
    private static final long serialVersionUID = 1L;
    
    public Bloc(Instruction parent, String nom) {       
        super(parent);
        Scanner sc = new Scanner(nom);
        sc.useDelimiter(", ");
        this.nom = sc.next();
        while(sc.hasNext()) {
            String var = sc.next();
            if (set(var, 0) == null)
                this.nom += ", " + var;
        }
    }
    
    /*public Bloc() {
        this(null, "bloc");
    }*/

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
        for(int i = 0; i < getChildCount(); i++) {
            Instruction I = (Instruction) getChildAt(i);
          
                I.go(robot);
           
        }
    }


    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public boolean autorisationAjout() {
        return true;
    }

    @Override
    public ImageIcon getIcon() {
        return null; 
    }
}
