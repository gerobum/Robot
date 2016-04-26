/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotations;

import java.lang.annotation.Repeatable;

/**
 *
 * @author yvan
 */
@Repeatable(DesAnnotations.class)
public @interface UneAnnotation {
    int value() default 1;
    boolean unBooleen() default true;
    double unDouble() default 2.0;
    String uneChaine() default "3";
}

