
package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class Case {
    private Integer value;
    public final boolean isFixed;
    private final Set<Integer> possibility;
    
    private final List<Zone9> ligne, colonne, carré;

    public Case(Integer value) {
        if (value != null && (value < 1 || value > 9))
                throw new IllegalArgumentException("Value must be null or between 1 and 9");
        this.value = value;
        this.possibility = new HashSet<>();
        if (value == null) {
            isFixed = false;
            for(int i = 1; i <= 9; i++) {
                this.possibility.add(i);
            }
        } else {
            isFixed = true;
            this.possibility.add(value);
        }
        
        ligne = new ArrayList<>();
        colonne = new ArrayList<>();
        carré = new ArrayList<>();
                
    }
    
    public Case() {
        this(null);
    }

    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        if (!isFixed)
            if (value == null || (value >= 1 && value <= 9)) 
                this.value = value;
    }
    
    
    
}
