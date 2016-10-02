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
    
    public Case getCase(int i) {
        return sousZone.get(i);
    }
    public Case getCase(int l, int c) {
        return sousZone.get(l*c+c);
    }
    
}
