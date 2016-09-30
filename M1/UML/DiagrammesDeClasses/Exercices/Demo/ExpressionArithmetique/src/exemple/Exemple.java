/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple;

import arithmetique.Addition;
import arithmetique.Constante;
import arithmetique.Division;
import arithmetique.Expression;
import arithmetique.Multiplication;
import arithmetique.Soustraction;
import arithmetique.Variable;
import java.util.Scanner;

/**
 *
 * @author yvan
 */
public class Exemple {

    public static void main(String[] args) {
        // (2x+3)/(x(3y-2))
        Variable x = new Variable(1);
        Variable y = new Variable(1);
        Constante deux = new Constante(2);
        Constante trois = new Constante(3);
        Expression e = new Division(
                new Addition(new Multiplication(deux, x), trois),
                new Multiplication(x, new Soustraction(new Multiplication(trois, y), deux))
        );
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Entrez x (ou fin pour sortir) : ");
                double v = in.nextDouble();
                x.setValeur(v);
                System.out.print("Entrez y (ou fin pour sortir) : ");
                v = in.nextDouble();
                y.setValeur(v);
                System.out.println(String.format("((2 x %f) + 3)/(%f((3 x %f) - 2)) = %f", x.evaluer(), x.evaluer(), y.evaluer(), e.evaluer()));
            }
        } catch (Exception ex) {
            System.out.println("Au revoir");
        }
    }
}
