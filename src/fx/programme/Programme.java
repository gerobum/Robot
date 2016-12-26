/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.programme;

import fx.programme.instructions.Bloc;
import fx.programme.instructions.Instruction;
import fx.programme.instructions.Racine;
import fx.exceptions.DansLeMur;
import fx.robot.Robot;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.TreeItem;
import javax.swing.ImageIcon;

/**
 *
 * @author Yvan
 */
public class Programme extends Instruction implements Serializable {

    private static final long serialVersionUID = 1L;

    private Initialisation initialisation;
    private final Map<String, Bloc> PROCEDURE;
    // #### private final DefaultTreeModel ARBRE_PROGRAMME;
    private final TreeItem<Instruction> PROGRAMME;
    private final Bloc PRINCIPAL;

    public Programme() {
        super(null);
        initialisation = new Initialisation();
        // #### ARBRE_PROGRAMME = new DefaultTreeModel(new Racine());
        PROGRAMME = new TreeItem<>(new Racine("programme"));
        PROGRAMME.setExpanded(true);

        PROCEDURE = new HashMap<>();
        PRINCIPAL = new Bloc(this, "procédure principale");
        PROCEDURE.put("procédure principale", PRINCIPAL);
        // #### ARBRE_PROGRAMME.insertNodeInto(principal, (Instruction)ARBRE_PROGRAMME.getRoot(), 0);
        PROGRAMME.getChildren().add(new TreeItem<>(PRINCIPAL));

    }
    
    @Override
    public String toString() {
        return "programme";
    }

    public String deepToString() {
        StringBuilder sb = new StringBuilder(initialisation.toString() + "\n");
        for (Instruction p : PROCEDURE.values()) {
            sb.append(p.deepToString(""));
        }
        return sb.toString();
    }

    public TreeItem<Instruction> getProgramme() {
        return PROGRAMME;
    }

    public Bloc getProcedurePrincipal() {
        return PROCEDURE.get("procédure principale");
    }

    public Bloc getProcedure(String nom) {
        return PROCEDURE.get(nom);
    }

    public Collection<Bloc> getProcedures() {
        Collection<Bloc> c = PROCEDURE.values();
        //c.remove(getProcedurePrincipal());
        return c;
    }

    public void ajoutProcedure(Bloc bloc) {
        PROCEDURE.put(bloc.toString(), bloc);
    }

    public void retraitProcedure(String nom) {
        Bloc as = (Bloc) PROCEDURE.remove(nom);
    }

    public Bloc ajoutProcedure(String nom) {
        Bloc bloc = new Bloc(PRINCIPAL, nom);
        PROCEDURE.put(nom, bloc);
        return bloc;

    }

    public void setInitialisation(Initialisation initialisation) {
        this.initialisation = initialisation;
    }

    public Initialisation getInitialisation() {
        return initialisation;
    }

    public Iterable<Bloc> procedures() {
        return PROCEDURE.values();
    }

    public void supprimerProcedure() {
        PROCEDURE.clear();
    }

    @Override
    public boolean autorisationAjout() {
        return true;
    }

    @Override
    public String deepToString(String decalage) {
        StringBuilder sb = new StringBuilder(nom);
        sb.append(initialisation.toString());
        for (Instruction procedure : PROCEDURE.values()) {
            sb.append(procedure.deepToString("  "));
        }
        sb.append(PRINCIPAL.deepToString("   "));
        return sb.toString();
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
        PRINCIPAL.go(robot);
    }
}
