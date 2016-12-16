
package fx.terrain;

/**
 *
 * @author yvan
 */
public enum OrientationPotentielle {
    QUELCONQUE("Quelconque"), NORD("Nord"), EST("Est"), SUD("Sud"), OUEST("Ouest");

    private OrientationPotentielle(String nom) {
        this.nom = nom;
    }
    
    public final String nom;
    
    @Override
    public String toString() {
        return nom;
    }
}
