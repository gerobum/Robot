package code;

import annotations.PreambuleClasse;
import annotations.PreambuleRevision;
import annotations.Version;

/**
 *
 * @author yvan
 */
@PreambuleRevision(
        auteur="Maillot",
        date="yesterday",
        version=@Version)
@PreambuleRevision(
        auteur="Bibi",
        date="today",
        version=@Version)
@PreambuleClasse(
        auteur = "Maillot",
        creation = "09/12/2011",
        revision = {"10/10/2013","08/11/2015"},
        version = @Version()
)
public class Annoté {
}
