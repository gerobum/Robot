package fx.enumerations;

/**
 *
 * @author yvan
 */
public enum Instructions {
    Appel("appel"),
    Avance("avance"),
    Bloc("bloc"),
    Ecrire("écrire"),
    Efface("efface"),
    Lire("lire"),
    Marque("marque"),
    Pour("pour"),
    Si("si"),
    TantQue("tant que"),
    Tourne("tourne");
    
        
    private final String texte;

    private Instructions(String texte) {
        this.texte = texte;
    }
    
    @Override
    public String toString() {
        return texte;
    }
}
