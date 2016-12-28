package fx.programme.instructions;

import fx.programme.expressions.ExprBool;
import java.awt.Image;
import javax.swing.ImageIcon;
import fx.exceptions.DansLeMur;
import fx.robot.Robot;

public class Si extends InstructionComposee {

    private static final long serialVersionUID = 1L;

    public static final int ALORS = 0;
    public static final int SINON = 1;
    private ExprBool garde;
    private static ImageIcon icone;

    static {
        Image tmp = new ImageIcon(instruction.Si.class.getResource("images/SI.png")).getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING);
        icone = new ImageIcon(tmp);
    }

    /*public Si() {
        this(null);      
    }*/
    public Si(Instruction parent, ExprBool garde) {
        super(parent);
        this.nom = "si";
        this.garde = garde;

    }

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {

        if (garde.evalue(robot)) {
            ((Instruction) getChildAt(0)).go(robot);
        } else if (getChildrenCount() > 1) {
            ((Instruction) getChildAt(1)).go(robot);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (" + garde + ")";
    }

    /*@Override
    public void set(Object o) {
        garde.set(o);
    }*/
    @Override
    public boolean autorisationAjout() {
        return getChildrenCount() < 2;
    }

    @Override
    public ImageIcon getIcon() {
        // Ca marche bien mais ça comme l'icone s'écrit avant le texte
        // celà m'empêche d'écrire alors ou sinon pour distinguer les branches
        // du si (il faudrait construire l'icône pour que ça marche, en ajoutant
        // à gauche de l'existant une image image avec alors ou sinon...
        //return icone;
        return null;
    }

    @Override
    public String deepToString(String decalage) {
        StringBuilder sb = new StringBuilder();
        sb.append(decalage)
                .append(toString())
                .append("\n");

        if (getChildrenCount() > 0) {
            sb.append(decalage);
            sb.append("alors\n");
            sb.append(getChildAt(ALORS).deepToString(decalage + " "));
        }
        if (getChildrenCount() > 1) {
            sb.append(decalage);
            sb.append("sinon\n");
            sb.append(getChildAt(SINON).deepToString(decalage + " "));
        }
        return sb.toString();
    }
}
