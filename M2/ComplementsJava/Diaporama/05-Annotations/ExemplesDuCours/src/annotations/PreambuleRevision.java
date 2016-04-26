package annotations;

import java.lang.annotation.Repeatable;

/**
 *
 * @author yvan
 */
@Repeatable(PreambuleRevisions.class)
public @interface PreambuleRevision {
    String auteur();
    String date();
    Version version();
}
