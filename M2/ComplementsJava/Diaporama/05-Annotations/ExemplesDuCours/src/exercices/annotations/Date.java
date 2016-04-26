/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercices.annotations;

import exercices.types.Jour;
import exercices.types.Mois;

/**
 *
 * @author maillot
 */
public @interface Date {
    Jour j();
    Mois m();
    int a();
}
