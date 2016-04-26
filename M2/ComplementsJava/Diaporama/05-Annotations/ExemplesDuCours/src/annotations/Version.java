package annotations;

/**
 *
 * @author yvan
 */
public @interface Version {
    int majeur() default 1;
    int mineur() default 0;
}
