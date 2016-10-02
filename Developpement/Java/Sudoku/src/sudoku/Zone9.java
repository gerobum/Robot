package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Zone9 {
    private final List<Case> sousZone;
    
    {
        sousZone = new ArrayList<>();             
    }
    
    public Zone9() {
        for(int i = 0; i < 9; ++i) {
            sousZone.add(new Case());
        }
    }
    
    public Zone9(Case c1, Case c2, Case c3, Case c4, Case c5, Case c6, Case c7, Case c8, Case c9) {
        for(int i = 0; i < 9; ++i) {
            sousZone.add(new Case());
        }
    }
    
    public Case getCase(int i) {
        return sousZone.get(i);
    }
    public Case getCase(int l, int c) {
        return sousZone.get(l*c+c);
    }
    
}
