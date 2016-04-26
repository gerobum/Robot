package main;

/**
 *
 * @author maillot
 */
public class Fraction {

    String s;

    public interface Bidule<T> {

        T p(String s, int i);

    }

    static void m(String s, Bidule b) {
        for (int i = 0; i < s.length(); ++i) {
            System.out.println(b.p(s, i));
        }
    }

    public static void main(String[] args) {
        m("maillot", String::codePointAt);
    }
}
