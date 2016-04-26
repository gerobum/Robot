package exercices.annotations;

/**
 *
 * @author maillot
 */
public @interface PreambuleClasse {

    String auteur();

    Date creation();

    Date[] revision();

    Version version(); // Un type d’annotation

}
