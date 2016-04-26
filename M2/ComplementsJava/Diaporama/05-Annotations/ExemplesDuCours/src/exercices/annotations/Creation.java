package exercices.annotations;

import exercices.types.Jour;
import exercices.types.Mois;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author maillot
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Creation {

    String auteur() default "Maillot";

    Date date() default @Date(j=Jour._1, m=Mois.JANVIER, a=1);

    Version version() default @Version; // Un type d’annotation

}
