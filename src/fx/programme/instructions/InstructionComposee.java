/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.programme.instructions;

import java.util.HashMap;

/**
 *
 * @author Yvan
 */
public abstract class InstructionComposee extends Instruction {

    public static final long serialVersionUID = 0L;
    
    private final HashMap<String, Integer> VARIABLE = new HashMap<>();

    public InstructionComposee(Instruction parent) {
        super(parent);
    }

    /**
     * Retourne la valeur d'une variable passée en paramètre
     * @param nomVar
     * @return
     */
    public Integer get(String nomVar) {
        Integer valeur;
        try {
            valeur = Integer.parseInt(nomVar);
        } catch(NumberFormatException nfe) {
            valeur = VARIABLE.get(nomVar);
            if (valeur == null)
                if (getParent() == null)
                    return null;
                else
                    return ((InstructionComposee)getParent()).get(nomVar);
            else
                return valeur;
        }
        return valeur;
    }

    public Integer set(String nomVar, int valeur) {
        if (get(nomVar) == null)
            return VARIABLE.put(nomVar, valeur);
        else
            return affecte(nomVar, valeur);
    }

    private Integer affecte(String nomVar, int valeur) {
        if (VARIABLE.containsKey(nomVar))
            return VARIABLE.put(nomVar, valeur);
        else
            return affecte(nomVar, valeur);
    }
    public String[] getVars() {
        return VARIABLE.keySet().toArray(new String[0]);
    }

    /*@Override
    public String deepToString(String decalage) {
        int n = getChildCount();
        String s = decalage + nom + "\ndébut\n";
        for(int i = 0; i < n; i++) {
            s += ((Instruction)getChildAt(i)).deepToString(decalage+" ");
        }
        s += "fin\n";
        return s;
    }*/

}
