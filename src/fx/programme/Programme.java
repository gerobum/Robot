/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.programme;


import fx.programme.instructions.Bloc;
import fx.programme.instructions.Instruction;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yvan
 */
public class Programme implements Serializable {
    private static final long serialVersionUID = 1L;

    private Initialisation initialisation;
    private final Map<String, Instruction> PROCEDURE;
    //private final DefaultTreeModel ARBRE_PROGRAMME;
    private final Bloc PRINCIPAL;
    public Programme() {

        initialisation = new Initialisation();
        //ARBRE_PROGRAMME = new DefaultTreeModel(new Racine());
        PROCEDURE  = new HashMap<>();
        PRINCIPAL = new Bloc(null, "procédure principale");
        PROCEDURE.put("procédure principale", PRINCIPAL);
        //ARBRE_PROGRAMME.insertNodeInto(principal, (Instruction)ARBRE_PROGRAMME.getRoot(), 0);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(initialisation.toString() +  "\n");
        for(Instruction p : PROCEDURE.values()) {
            sb.append(p.deepToString("  "));
        }
        return sb.toString();
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

    public Iterable<Instruction> procedures() {
        return PROCEDURE.values();
    }
    
    public void supprimerProcedure() {
        PROCEDURE.clear();
    }
}
