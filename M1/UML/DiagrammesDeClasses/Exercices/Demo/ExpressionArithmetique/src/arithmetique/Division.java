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
public class Division extends Operation {

    public Division(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public double evaluer() {
        return gauche.evaluer() / droite.evaluer();
    }
    
}
