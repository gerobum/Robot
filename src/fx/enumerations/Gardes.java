package fx.enumerations;

/**
 *
 * @author yvan
 */
public enum Gardes {
    DevantMur("devant mur"), 
    PasDevantMur("pas devant mur"),
    SurMarque("sur marque"),
    PasSurMarque("pas sur marque"),
    DevantMarque("devant marque"),
    PasDevantMarque("pas devant marque"),
    SurMinerai("sur minerai"),
    PasSurMinerai("pas sur minerai");
    
    private final String texte;

    private Gardes(String texte) {
        this.texte = texte;
    }
    
    @Override
    public String toString() {
        return texte;
    }
}
