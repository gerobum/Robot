package mois;

import java.util.GregorianCalendar;

public enum Mois {

    JANVIER("Janvier", 31),
    FEVRIER("Février", 28) {
        @Override
        public int nbJours() {
            GregorianCalendar gc = new GregorianCalendar();
            int aec = anneeEnCours;
            if (aec < 0) {
                aec = gc.get(GregorianCalendar.YEAR);
            }
            if (gc.isLeapYear(aec)) {
                return super.nbJours()+1;
            } else {
                return super.nbJours();
            }
        }
    },
    MARS("Mars", 31),
    AVRIL("Avril", 30),
    MAI("Mai", 31),
    JUIN("Juin", 30),
    JUILLET("Juillet", 31),
    AOUT("Août", 31),
    SEPTEMBRE("Septembre", 30),
    OCTOBRE("Octobre", 31),
    NOVEMBRE("Novembre", 30),
    DECEMBRE("Décembre", 31);
    private final int nbJours;
    public final String nom;

    Mois(String nom, int n) {
        this.nom = nom;
        nbJours = n;
    }

    public int nbJours() {
        return nbJours;
    }

    @Override
    public String toString() {
        return nom;
    }

    public int numéro() {
        return ordinal() + 1;
    }
    
    private static int anneeEnCours = -1;

    public static void setAnneeEnCours(int anneeEnCours) {
        Mois.anneeEnCours = anneeEnCours;
    }

    public static void setAnneeEnCours() {
        Mois.anneeEnCours = -1;
    }

    public static int getAnneeEnCours() {
        return anneeEnCours;
    }
}
