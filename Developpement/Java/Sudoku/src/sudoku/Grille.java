package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Grille {
    
    public static final class SetFixed {
        public final int l, c, v;

        public SetFixed(int l, int c, int v) {
            this.l = l;
            this.c = c;
            this.v = v;
        }
        
    }

    private final List<Zone9> ligne;
    private final List<Zone9> colonne;
    private final List<Zone9> carré;

    {
        ligne = new ArrayList<>();
        colonne = new ArrayList<>();
        carré = new ArrayList<>();
    }

    public Grille(SetFixed... sfs) {
        for (int i = 0; i < 9; ++i) {
            ligne.add(new Zone9());
        }
        for (int i = 0; i < 9; ++i) {

            colonne.add(new Zone9(
                    ligne.get(0).getCase(i),
                    ligne.get(1).getCase(i),
                    ligne.get(2).getCase(i),
                    ligne.get(3).getCase(i),
                    ligne.get(4).getCase(i),
                    ligne.get(5).getCase(i),
                    ligne.get(6).getCase(i),
                    ligne.get(7).getCase(i),
                    ligne.get(8).getCase(i)));
        }
        carré.add(new Zone9(
                ligne.get(0).getCase(0),
                ligne.get(0).getCase(1),
                ligne.get(0).getCase(2),
                ligne.get(1).getCase(0),
                ligne.get(1).getCase(1),
                ligne.get(1).getCase(2),
                ligne.get(2).getCase(0),
                ligne.get(2).getCase(1),
                ligne.get(2).getCase(2)));
        carré.add(new Zone9(
                ligne.get(0).getCase(3),
                ligne.get(0).getCase(4),
                ligne.get(0).getCase(5),
                ligne.get(1).getCase(3),
                ligne.get(1).getCase(4),
                ligne.get(1).getCase(5),
                ligne.get(2).getCase(3),
                ligne.get(2).getCase(4),
                ligne.get(2).getCase(5)));
        carré.add(new Zone9(
                ligne.get(0).getCase(6),
                ligne.get(0).getCase(7),
                ligne.get(0).getCase(8),
                ligne.get(1).getCase(6),
                ligne.get(1).getCase(7),
                ligne.get(1).getCase(8),
                ligne.get(2).getCase(6),
                ligne.get(2).getCase(7),
                ligne.get(2).getCase(8)));
        carré.add(new Zone9(
                ligne.get(3).getCase(0),
                ligne.get(3).getCase(1),
                ligne.get(3).getCase(2),
                ligne.get(4).getCase(0),
                ligne.get(4).getCase(1),
                ligne.get(4).getCase(2),
                ligne.get(5).getCase(0),
                ligne.get(5).getCase(1),
                ligne.get(5).getCase(2)));
        carré.add(new Zone9(
                ligne.get(3).getCase(3),
                ligne.get(3).getCase(4),
                ligne.get(3).getCase(5),
                ligne.get(4).getCase(3),
                ligne.get(4).getCase(4),
                ligne.get(4).getCase(5),
                ligne.get(5).getCase(3),
                ligne.get(5).getCase(4),
                ligne.get(5).getCase(5)));
        carré.add(new Zone9(
                ligne.get(3).getCase(6),
                ligne.get(3).getCase(7),
                ligne.get(3).getCase(8),
                ligne.get(4).getCase(6),
                ligne.get(4).getCase(7),
                ligne.get(4).getCase(8),
                ligne.get(5).getCase(6),
                ligne.get(5).getCase(7),
                ligne.get(5).getCase(8)));
        carré.add(new Zone9(
                ligne.get(6).getCase(0),
                ligne.get(6).getCase(1),
                ligne.get(6).getCase(2),
                ligne.get(7).getCase(0),
                ligne.get(7).getCase(1),
                ligne.get(7).getCase(2),
                ligne.get(8).getCase(0),
                ligne.get(8).getCase(1),
                ligne.get(8).getCase(2)));
        carré.add(new Zone9(
                ligne.get(6).getCase(3),
                ligne.get(6).getCase(4),
                ligne.get(6).getCase(5),
                ligne.get(7).getCase(3),
                ligne.get(7).getCase(4),
                ligne.get(7).getCase(5),
                ligne.get(8).getCase(3),
                ligne.get(8).getCase(4),
                ligne.get(8).getCase(5)));
        carré.add(new Zone9(
                ligne.get(6).getCase(6),
                ligne.get(6).getCase(7),
                ligne.get(6).getCase(8),
                ligne.get(7).getCase(6),
                ligne.get(7).getCase(7),
                ligne.get(7).getCase(8),
                ligne.get(8).getCase(6),
                ligne.get(8).getCase(7),
                ligne.get(8).getCase(8))); 
        
        for(SetFixed sf : sfs) {
            ligne.get(sf.l).getCase(sf.c).setValue(sf.v);
        }
    }

    public Zone9 getLigne(int i) {
        return ligne.get(i);
    }

    public Zone9 getColonne(int i) {
        return colonne.get(i);
    }

    public Zone9 getCarré(int l, int c) {
        return carré.get(l * 3 + c);
    }
    
    public Case getCase(int l, int c) {
        return ligne.get(l).getCase(c);
    }

}
