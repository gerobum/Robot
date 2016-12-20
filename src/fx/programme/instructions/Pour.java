package fx.programme.instructions;

import javax.swing.ImageIcon;
import fx.robot.DansLeMur;
import fx.robot.Robot;

/**
 *
 * @author Yvan
 */
public class Pour extends InstructionComposee {
    
    private static final long serialVersionUID = 1L;
    
    private String debut;
    private String fin;
    private String pas;
    private String nomCompteur;
    
    public Pour(InstructionComposee parent, String debut, String fin, String pas) {
        super(parent);
        this.nom = "pour";
        this.debut = debut;
        this.fin = fin;
        this.pas = pas;
        char i = 'i';
        nomCompteur = ""+i;
        while(parent.get(nomCompteur) != null) {
            i++;
            nomCompteur = ""+i;
        }
        set(nomCompteur, 0);
    }
    public Pour(InstructionComposee parent, String debut, String fin) {
        this(parent, debut, fin, "1");
    }
    public Pour(InstructionComposee parent, String fin) {
        this(parent, "1", fin, "1");
    }

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
        
        int p = get(pas);
        if (p > 0)
            for (int compteur = get(debut); compteur <= get(fin); compteur+=p)  {
                set(nomCompteur, compteur);
                ((Instruction) getFirstChild()).go(robot);
            }
        else if (p < 0)
            for (int compteur = get(debut); compteur >= get(fin); compteur+=p)  {
                set(nomCompteur, compteur);
                ((Instruction) getFirstChild()).go(robot);
            }
    }

    @Override
    public String toString() {
        return super.toString()+" "+ nomCompteur+ " de " + debut + " à " + fin + " par pas de " + pas;
    }


    @Override
    public boolean autorisationAjout() {
        return getChildCount() < 1;
    }

    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public ImageIcon getIcon() {
        return null;
    }

}
