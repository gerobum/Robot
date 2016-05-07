/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vraimentPasUneBonneIdee;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Maillot
 */
public abstract class JLabelAniméAbstrait extends JLabel {

    private JLabel label;

    protected JLabel getLabel() {
        return label;
    }

    protected void setLabel(JLabel label) {
        this.label = label;
    }

    public abstract void faireQuelqueChose();




    public JLabelAniméAbstrait(String text) {
        super(text);
        setLabel(this);
    }

    public JLabelAniméAbstrait(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setLabel(this);
    }



}
