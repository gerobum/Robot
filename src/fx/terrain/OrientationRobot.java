
package fx.terrain;

/**
 *
 * @author yvan
 */
public enum OrientationRobot {
    NORD(0.0), EST(90.0), SUD(180.0), OUEST(-90.0);
    public final double angle;

    private OrientationRobot(double angle) {
        this.angle = angle;
    }
    
   
}
