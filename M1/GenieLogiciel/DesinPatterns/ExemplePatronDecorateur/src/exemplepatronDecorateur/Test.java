package exemplepatronDecorateur;
public class Test {
    public static void main(String[] args) {
        Composant c1 = new ComposantConcret();
        System.out.println(c1);
        Composant c2 = new DecorateurConcretA(c1);
        System.out.println(c2);
        Composant c3 = new DecorateurConcretB(c2);
        System.out.println(c3);
        Composant c4 = new DecorateurConcretA(c3);
        System.out.println(c4);
        int v = 0, vn = 0;
        int d = 0;
        for(int i = 1; i < 35; ++i) {
            vn = (int) Math.round(i/35.0*8);
            if (vn != v) {
                System.out.println(String.format("Entre %d et %d \t-> %d", d, i-1, v));
                v = vn;
                d = i;
            }
        }
        System.out.println(String.format("Entre %d et %d \t-> %d", d, 37, 8));
    }

}
