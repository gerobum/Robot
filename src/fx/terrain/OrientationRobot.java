
package fx.terrain;

/**
 *
 * @author yvan
 */
public enum OrientationRobot {
    NORD(0.0, "Nord"), EST(90.0, "Est"), SUD(180.0, "Sud"), OUEST(-90.0, "Ouest");
    public final double angle;

    private OrientationRobot(double angle, String nom) {
        this.angle = angle;
        this.nom = nom;
    }
    
    public final String nom;
    
}
