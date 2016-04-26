package exo;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class Fichiers {
    
    public final static Random random = new Random();

    //private final Path racine;

   /* public Fichiers(String nom) {
        this.racine = new File(nom).toPath();
    }*/

    public static Stream<Path> tousLesDossiersCaches(Path racine) throws IOException {

        return Files.walk(racine)
                .filter(p -> p.toFile().isHidden())
                .filter(p -> p.toFile().isDirectory());

    }

    public static Stream<Path> tousLesFichiersCaches(Path racine) throws IOException {

        return Files.walk(racine)
                .filter(p -> p.toFile().isHidden());

    }

    public static Stream<Path> tousLesDossiers(Path racine) throws IOException {

        return Files.walk(racine)
                .filter(p -> p.toFile().isDirectory());

    }

    public static Stream<Path> tousLesFichiersDeTailleNulle(Path racine) throws IOException {

        return Files.walk(racine)
                .filter(p -> p.toFile().length()==0);

    }
    
    public static long nombreDOctets(Path racine) throws IOException {
         return Files.walk(racine)
                 .mapToLong(p -> p.toFile().length())
                 .sum();
    }
    
    public static long nombreDOctetsDesFichiersCaches(Path racine) throws IOException {
         return Files.walk(racine)
                 .mapToLong(p -> p.toFile().length())
                 .sum();
    }
    
    public static Stream<?> tousLesFichiersCachésTriés(Path racine) throws IOException {
         return Files.walk(racine)
                 .map(p -> p.toFile())
                 .filter(p -> p.isHidden())
                 .sorted()
                 .map(p -> p.length() + " -> " + p.getName())
                 .distinct();
    }
    
    public static void afficherTousLesDossiersDontLaTailleDesFichiersDirectementContenusEstSuperieureAl(Path racine, long l) throws IOException {
        Files.walk(racine)
                .filter(p -> {
                    File pf = p.toFile();
                    if(pf.isFile()) return false;
                    else {
                       long n = 0;
                       for(File f : pf.listFiles()) {
                           if (f.isFile()) {
                               n += f.length();
                               if (n > l) {
                                   return true;
                               }
                           }
                       }
                       return false;
                    }
                })
                .forEach(System.out::println);
    }
    
    public static void afficherTousLesFichiersRangésParTailleEtParNom(Path racine) throws IOException {
        Files.walk(racine)
                .filter(p -> p.toFile().isFile())
                .sorted((a,b) -> {
                    if (a.toFile().length() < b.toFile().length()) {
                        return -1;
                    } else if (a.toFile().length() > b.toFile().length()) {
                        return 1;
                    } else {
                        return a.toFile().getName().compareTo(b.toFile().getName());
                    }
                })
                /*.sorted((a,b) -> {
                    return a.toFile().getName().compareTo(b.toFile().getName());
                })*/
                .forEach(p -> {
                    System.out.println(p.toFile().length()+ " -> " + p.toFile().getName() + " : " + p);
                });
    }
    
    public static void afficherTousLesFichiersDifferentsDefMaisDeMemeTailleEtDeMemeNom(Path racine, File f) throws IOException {
        Files.walk(racine)
                .filter(p -> p.toFile().length() == f.length())
                .filter(p -> p.toFile().isFile())
                .filter(p -> p.toFile().getName().equals(f.getName()))
                .filter(p -> !p.toFile().equals(f))
                .forEach(System.out::println);
    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        
        Path racine = Paths.get(URI.create("file:///home/maillot/AutresSauvegardes/Travail/"));
        
        // tousLesFichiersDeTailleNulle(racine).forEach(System.out::println);

        //System.out.println("Il y a " + tousLesFichiersDeTailleNulle(racine).count() + " fichiers de taille nulle");
        
        // System.out.println(nombreDOctets(racine));
        
        // System.out.println("Il y a " + tousLesDossiersCaches(racine).count() + " dossiers cachés");

        // tousLesDossiersCaches(racine).forEach(System.out::println);
        
        // System.out.println("Il y a " + Files.walk(racine).count() + " fichiers");
        
        // System.out.println("Il y a " + Files.walk(racine).distinct().count() + " fichiers distincts");
        
        //tousLesFichiersCachésTriés(racine).forEach(System.out::println);
        
        //afficherTousLesDossiersDontLaTailleDesFichiersDirectementContenusEstSuperieureAl(racine, 1);
        
        afficherTousLesFichiersDifferentsDefMaisDeMemeTailleEtDeMemeNom(racine, new File("/home/maillot/AutresSauvegardes/Travail/Enseignement/2012-2013/M2/ComplementsJava/sujet1.html"));
        
        // afficherTousLesFichiersRangésParTailleEtParNom(racine);
    }
}
