package exercices.code;

import exercices.annotations.Creation;
import exercices.annotations.Date;
import exercices.annotations.Version;
import exercices.annotations.Revision;
import static exercices.types.Jour.*;
import static exercices.types.Mois.*;


/**
 *
 * @author yvan
 */
@Revision(
        auteur="Myself",
        date=@Date(j=_9,m=NOVEMBRE,a=2015),
        version=@Version)
@Revision(
        auteur="Me",
        date=@Date(j=_25,m=OCTOBRE,a=2014),
        version=@Version)
@Revision(
        auteur="Bibi",
        date=@Date(j=_11,m=MAI,a=2011),
        version=@Version)
@Creation(
        auteur="Maillot",
        date=@Date(j=_1,m=FEVRIER,a=2010),
        version=@Version)
/*@PreambuleClasse(
        auteur = "Maillot",
        date = @Date(j=9,m=12,a=2011),
        date = {@Date(j=10,m=10,a=2013),@Date(j=8,m=11,a=2015)},
        version = @Version
)*/
public class Annoté {
    void uneMethode() {
        
    }
}
