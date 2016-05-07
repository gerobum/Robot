/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vraimentPasUneBonneIdee;

/**
 *
 * @author Maillot
 */
public class JLabelConcret extends JLabelAniméAbstrait {

    @Override
    public void faireQuelqueChose() {

    }


    public JLabelConcret(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public JLabelConcret(String text) {
        super(text);
        setLabel(this);
    }


}
