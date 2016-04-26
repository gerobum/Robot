package avec_interfaces_standards.main;

import interfaces.Chercheur;
import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import personne.Personne;

interface Operation {
    int calcul(int a, int b);
}

interface OperationM {
    double calcul(double a, double... b);
}

interface Salutation {
    void salutation();
}

/**
 *
 * @author yvan
 */
public class Main {
    

    static Operation pgcd;

    public static void envoyerSelonCritère(List<Personne> personne, String msg,
            Predicate<Personne> critère) {
        for (Personne p : personne) {
            if (critère.test(p)) {
                p.envoyerMessage(msg);
            }
        }
    }

    public static void ouEnSommesNous(Personne p, Predicate<Personne> critère, String msg) {
        if (critère.test(p)) {
            System.out.println("Bonjour " + p + " Vous avez moins de 50 ans");
        } else {
            System.out.println("Bonjour " + p + "Vous avez plus de 50 ans");
        }
    }

    public static void envoyerAuxAdultes(List<Personne> personne, String msg) {
        for (Personne p : personne) {
            if (p.getAge() >= 18) {
                p.envoyerMessage(msg);
            }
        }
    }
    
    

    public static void afficheCalcul(int a, int b, Operation op) {
        System.out.println(op.calcul(a, b));
    }

    public static <T, U, R> void afficheCalcul(T a, U b, BiFunction<T, U, R> op) {
        System.out.println(op.apply(a, b));
    }

    public static void main(String[] args) {
        List<Personne> liste = new LinkedList<>();

        for (int i = 0; i < 10000; ++i) {
            liste.add(new Personne());
        }

        //envoyerAuxAdultes(liste, "Hello");
        //envoyerSelonCritère(liste, "Hello", new ToutesLesFilles());
        //envoyerSelonCritère(liste, "Hello", new Adolescent());
        envoyerSelonCritère(liste, "Les jeunes...",
                p -> p.getAge() >= 13 && p.getAge() < 20);

        ouEnSommesNous(new Personne(), x -> x.getAge() < 50, "...");

        Predicate<String> estvide = String::isEmpty;
        BinaryOperator<Integer> soustraction = (a, b) -> a - b;
        BinaryOperator<Double> hyp = Math::hypot;

        Chercheur<Integer> min = (l) -> {
            Iterator<Integer> i = l.iterator();
            Integer x = i.next();
            while (i.hasNext()) {
                Integer y = i.next();
                if (y < x) {
                    x = y;
                }
            }
            return x;
        };
        Salutation c;
        c = () -> {
            System.out.println("coucou");
        };
        c.salutation();
        Predicate<Personne> lesAdultes = p -> p.getAge() >= 18;
        Predicate<Personne> lesFilles = p -> p.genre == Personne.Genre.FILLE;

        Salutation familier = () -> {
            System.out.println("Ciao");
        };

        Salutation soutenu = () -> {
            System.out.println("Je vous prie de bien vouloir accepter dans votre "
                    + "haute bienveillance mes plus respectueuses salutations");
        };

        BiFunction<Double, Double, Double> op;

        op = (a, b) -> a + b;

        afficheCalcul(1.0, 2.0, op);

        op = Math::atan2;

        afficheCalcul(1.0, 2.0, op);

        op = Math::min;
        afficheCalcul(1.0, 2.0, op);
        System.out.println("----------------------");
        // Référence à une lambda-expression
        afficheCalcul(1, 2, (a, b) -> a - b);
        // Référence à une méthode statique
        afficheCalcul(1, 2, Math::max);
        // Référence à une méthode d'instance d'un objet donné
        //afficheCalcul("([Jvmr\\s])([aeoui])", "$1av$2", "Java 5 est mort, vive Java 6"::replaceAll);
        afficheCalcul("([JVv])([aei])", "$1av$2", "Vive Java"::replaceAll);
        // Référence à une méthode d'instance d'un objet quelconque d'un type donné
        afficheCalcul("Vive Java", 5, String::charAt);
        afficheCalcul(new Random(), 6, Random::nextInt/*, "tirage de dés"*/);
        // Référence à un constructeur
        afficheCalcul(22 * 256 * 256 + 33 * 256 + 44, true, Color::new);

        pgcd = (a, b) -> {
            if (b == 0) {
                return a;
            } else if (a < b) {
                return pgcd.calcul(b, a);
            } else {
                return pgcd.calcul(a - b, b);
            }
        };
        // Récursivité


        /*System.out.println(op.operation(5.0, 6.0));
        
        
        
         Machin machin = "azerty"::charAt;
        
         System.out.println(machin.n(2));*/
        // Bidon b = () -> (double) 4;
        
        //liste.stream().filter(lesFilles).filter(e-> e.getAge() > 12).filter(e->e.getAge()<20).forEach(e -> System.out.println(e));
        
        //envoyerSelonCritère(liste, "Bonjour les centenaires", p -> p.getAge()==100);
        //envoyerSelonCritère(liste, "Vous êtes grands maintenant", lesAdultes);
        //envoyerSelonCritère(liste, "Salut les filles", lesFilles);
        
        IntStream.range(2, 100)
                .filter(p->p!=2&&p%2!=0)
                .forEach(System.out::println);
        
        Operation addition = (a,b) -> a+b;
        Operation maxi = (a,b) -> a>b ? a : b;

        pgcd = (a, b) -> {
            if (b == 0) {
                return a;
            } else if (a < b) {
                return pgcd.calcul(b, a);
            } else {
                return pgcd.calcul(a - b, b);
            }
        };
        
        OperationM mini = (a,b) -> {
            double m = a;
            for(double x : b) {
                if (x < m) {
                    m = x;
                }
            }
            return m;
        };
        
        OperationM somme = (a,b) -> {
            double s = a;
               for(double x : b) {
                s += x;
            }
            return s;         
        };

        
        System.out.println(maxi.calcul(45, 6));
        afficheCalcul(12, 114, pgcd);

    }
}
