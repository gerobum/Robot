/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import annotations.A1PD;
import annotations.ASP;

/**
 *
 * @author yvan
 */
@ASP // Annotation d’une classe
public class UneAutreClasse {

    @A1PD("d’un attribut")
    public @ASP
    int a;

    @A1PD("d’un constructeur")
    public UneAutreClasse(@A1PD("d’un paramètre") int a) {
        @A1PD("d’une variable locale")
        int x;
    }

    @A1PD("d’une méthode")
    public void uneMethode(@A1PD("d’un paramètre") int a) {
        @A1PD("d’une variable locale")
        int x;
        Object uac;
        uac = new @A1PD("Instanciation") Object();
        Object o = new String("");
        String str;
        if (o instanceof @A1PD("instanceof") String) {
            str = (@A1PD("transtypage") String) o;
        }
    }
}
