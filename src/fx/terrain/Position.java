
package fx.terrain;

/**
 *
 * @author yvan
 */
public enum Position {
    QUELCONQUE("Queconque"), 
    CONTRE_UN_MUR("Contre un mur"),
    DANS_UN_COIN("Dans un coin"),
    PAS_CONTRE_UN_MUR("Pas contre un mur"),
    PAS_DANS_UN_COIN("Pas dans un coin"),
    CONTRE_LE_MUR_NORD("Contre le mur nord"),
    CONTRE_LE_MUR_EST("Contre le mur est"),
    CONTRE_LE_MUR_SUD("Contre le mur sud"),
    CONTRE_LE_MUR_OUEST("Contre le mur ouest"),
    DANS_LE_COIN_NE("Dans le coin nord-est"),
    DANS_LE_COIN_SE("Dans le coin sud-est"),
    DANS_LE_COIN_SO("Dans le coin sud-ouest"),
    DANS_LE_COIN_NO("Dans le coin nord-ouest");
    
    public final String nom;

    private Position(String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString() {
        return nom;
    }
}
