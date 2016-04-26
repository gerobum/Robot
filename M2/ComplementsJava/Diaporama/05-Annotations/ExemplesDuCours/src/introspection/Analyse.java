/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspection;

import annotations.A1PD;
import annotations.ASP;
import code.UneAutreClasse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 * @author maillot
 */
public class Analyse {

    public static void main(String[] args) {
        Class<UneAutreClasse> classe = UneAutreClasse.class;
        System.out.println("getAnnotations() : ------------------");
        for (Annotation a : classe.getAnnotations()) {
            System.out.println(a);
        }
        System.out.println("getDeclaredAnnotations : ------------------");
        for (Annotation a : classe.getDeclaredAnnotations()) {
            System.out.println(a);
        }
        System.out.println("getAnnotationsByType : ------------------");
        for (Annotation a : classe.getAnnotationsByType(ASP.class)) {
            System.out.println(a);
        }
        System.out.println("--> getAnnotationsByType : " + classe.getAnnotation(ASP.class));

        for (Constructor c : classe.getConstructors()) {
            System.out.println(c);

            System.out.println("getAnnotations() : ------------------");
            for (Annotation a : c.getAnnotations()) {
                System.out.println(a);
            }
            System.out.println("getDeclaredAnnotations : ------------------");
            for (Annotation a : c.getDeclaredAnnotations()) {
                System.out.println(a);
            }
            System.out.println("getAnnotationsByType : ------------------");
            for (Annotation a : c.getAnnotationsByType(ASP.class)) {
                System.out.println(a);
            }
            System.out.println("--> getAnnotationsByType : " + c.getAnnotation(ASP.class));
        }
        for (Method m : classe.getDeclaredMethods()) {
            System.out.println(m);

            System.out.println("getAnnotations() : ------------------");
            for (Annotation a : m.getAnnotations()) {
                System.out.println(a);
            }
            System.out.println("getDeclaredAnnotations : ------------------");
            for (Annotation a : m.getDeclaredAnnotations()) {
                System.out.println(a);
            }
            System.out.println("getAnnotationsByType : ------------------");
            for (Annotation a : m.getAnnotationsByType(A1PD.class)) {
                System.out.println(a);
            }
            System.out.println("--> getAnnotationsByType : " + m.getAnnotation(A1PD.class));
        }
    }
}
