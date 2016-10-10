/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robot;

import instruction.Bloc;
import instruction.Instruction;
import instruction.Racine;
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
    private Map<String, Instruction> procedure;
    private DefaultTreeModel arbreProgramme;
    public Programme() {

        initialisation = new Initialisation();
        arbreProgramme = new DefaultTreeModel(new Racine());
        procedure  = new HashMap<String, Instruction>();
        Bloc principal = new Bloc("procédure principale");
        procedure.put("procédure principale", principal);
        arbreProgramme.insertNodeInto(principal, (Instruction)arbreProgramme.getRoot(), 0);
        
    }

    @Override
    public String toString() {
        String retour = initialisation.toString() +  "\n" + 

        ((Instruction)arbreProgramme.getRoot()).deepToString("");
        return retour;
    }

/*
    public static void changerDeRobot(Instruction instruction, Robot robot) {
        instruction.set(robot);
        for(int i = 0; i < instruction.getChildCount(); i++)
            changerDeRobot((Instruction) instruction.getChildAt(i), robot);
    }*/
    public DefaultTreeModel getArbreProgramme() {
        return arbreProgramme;
    }

    public Instruction getProcedurePrincipal() {
        return procedure.get("procédure principale");
    }
    public Instruction getProcedure(String nom) {
        return procedure.get(nom);
    }
    public Collection<Instruction> getProcedures() {
        Collection<Instruction> c = procedure.values();
        c.remove(getProcedurePrincipal());
        return c;
    }
    public void ajoutProcedure(Bloc bloc) {
        procedure.put(bloc.toString(), bloc);       
    }
    public void retraitProcedure(String nom) {
        Bloc as = (Bloc) procedure.remove(nom);
        if (as != null) {
            arbreProgramme.removeNodeFromParent(as);
        }
    }
    public Bloc ajoutProcedure(String nom) {
        Bloc bloc = new Bloc(nom);
        procedure.put(nom, bloc);
        arbreProgramme.insertNodeInto(bloc, (Instruction)arbreProgramme.getRoot(), 0);
        return bloc;

    }
    public void setInitialisation(Initialisation initialisation) {
        this.initialisation = initialisation;
    }

    public Initialisation getInitialisation() {
        return initialisation;
    }

    public Iterable<Instruction> procedures() {
        return procedure.values();
    }
    
    public void supprimerProcedure() {
        procedure.clear();
    }

}
