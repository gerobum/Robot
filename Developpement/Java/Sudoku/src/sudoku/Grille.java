package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Grille {

    private final List<Zone9> ligne;
    private final List<Zone9> colonne;
    private final List<Zone9> carré;

    {
        ligne = new ArrayList<>();
        colonne = new ArrayList<>();
        carré = new ArrayList<>();
    }

    public Grille() {
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
    }

    public Zone9 getLigne(int i) {
        return ligne.get(i);
    }

    public Zone9 getColonne(int i) {
        return colonne.get(i);
    }

    public Zone9 getCarré(int l, int c) {
        return carré.get(l * c + c);
    }

}
