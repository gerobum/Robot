/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.programme;


import fx.programme.instruction.Bloc;
import fx.programme.instruction.Instruction;
import fx.programme.instruction.Racine;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Yvan
 */
public class Programme implements Serializable {
    private static final long serialVersionUID = 1L;

    private Initialisation initialisation;
    private final Map<String, Instruction> PROCEDURE;
    private final DefaultTreeModel ARBRE_PROGRAMME;
    public Programme() {

        initialisation = new Initialisation();
        ARBRE_PROGRAMME = new DefaultTreeModel(new Racine());
        PROCEDURE  = new HashMap<>();
        Bloc principal = new Bloc("procédure principale");
        PROCEDURE.put("procédure principale", principal);
        ARBRE_PROGRAMME.insertNodeInto(principal, (Instruction)ARBRE_PROGRAMME.getRoot(), 0);
        
    }

    @Override
    public String toString() {
        String retour = initialisation.toString() +  "\n" + 

        ((Instruction)ARBRE_PROGRAMME.getRoot()).deepToString("");
        return retour;
    }


    public DefaultTreeModel getArbreProgramme() {
        return ARBRE_PROGRAMME;
    }

    public Instruction getProcedurePrincipal() {
        return PROCEDURE.get("procédure principale");
    }
    public Instruction getProcedure(String nom) {
        return PROCEDURE.get(nom);
    }
    public Collection<Instruction> getProcedures() {
        Collection<Instruction> c = PROCEDURE.values();
        c.remove(getProcedurePrincipal());
        return c;
    }
    public void ajoutProcedure(Bloc bloc) {
        PROCEDURE.put(bloc.toString(), bloc);       
    }
    public void retraitProcedure(String nom) {
        Bloc as = (Bloc) PROCEDURE.remove(nom);
        if (as != null) {
            ARBRE_PROGRAMME.removeNodeFromParent(as);
        }
    }
    public Bloc ajoutProcedure(String nom) {
        Bloc bloc = new Bloc(nom);
        PROCEDURE.put(nom, bloc);
        ARBRE_PROGRAMME.insertNodeInto(bloc, (Instruction)ARBRE_PROGRAMME.getRoot(), 0);
        return bloc;

    }
    public void setInitialisation(Initialisation initialisation) {
        this.initialisation = initialisation;
    }

    public Initialisation getInitialisation() {
        return initialisation;
    }

    public Iterable<Instruction> procedures() {
        return PROCEDURE.values();
    }
    
    public void supprimerProcedure() {
        PROCEDURE.clear();
    }

}
