/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vraimentPasUneBonneIdee;

/**
 *
 * @author Maillot
 */
public class Decorateur extends JLabelAniméAbstrait {

    private JLabelAniméAbstrait composant;

    public Decorateur(JLabelAniméAbstrait composant) {
        //super(composant.getText());
        super(composant.getText(), composant.getHorizontalAlignment());
        setFont(composant.getFont());
        this.composant = composant;
        setLabel(this);
    }



    @Override
    public void faireQuelqueChose() {
        composant.faireQuelqueChose();
    }

}
