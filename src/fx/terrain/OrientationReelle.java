
package fx.terrain;

public enum OrientationReelle {
    NORD(0.0, "Nord", 0, -1), EST(90.0, "Est", 1, 0), SUD(180.0, "Sud", 0, 1), OUEST(-90.0, "Ouest", -1, 0);
    public final double angle;
    public final int pasX;
    public final int pasY;

    private OrientationReelle(double angle, String nom, int pasX, int pasY) {
        this.angle = angle;
        this.nom = nom;
        this.pasX = pasX;
        this.pasY = pasY;
    }
    
    public final String nom;
    
    @Override
    public String toString() {
        return nom;
    }
}
