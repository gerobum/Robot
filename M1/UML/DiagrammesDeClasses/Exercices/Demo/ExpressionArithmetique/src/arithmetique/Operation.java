/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetique;

/**
 *
 * @author yvan
 */
public abstract class Operation extends Expression {
    protected Expression gauche, droite;

    public Operation(Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Operation(Expression droite) {
        this(null, droite);
    }
}
