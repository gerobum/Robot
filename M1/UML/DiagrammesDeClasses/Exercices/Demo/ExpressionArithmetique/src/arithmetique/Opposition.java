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
public class Opposition extends Operation {

    public Opposition(Expression droite) {
        super(droite);
    }

    @Override
    public double evaluer() {
        return -droite.evaluer();
    }
    
}
