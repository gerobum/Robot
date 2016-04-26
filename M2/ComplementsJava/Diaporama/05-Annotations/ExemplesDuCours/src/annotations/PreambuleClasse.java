package annotations;

/**
 *
 * @author maillot
 */
public @interface PreambuleClasse {

    String auteur();

    String creation();

    String[] revision();

    Version version(); // Un type d’annotation

}
