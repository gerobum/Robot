
package fx.exceptions;

/**
 *
 * @author yvan
 */
public class AjoutImpossible extends RuntimeException {
    public AjoutImpossible() {
        super("Ajout dans ce type d'instructions");
    }
}
