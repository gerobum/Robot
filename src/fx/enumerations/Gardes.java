package fx.enumerations;

import fx.programme.expressions.DevantMarque;
import fx.programme.expressions.DevantMur;
import fx.programme.expressions.ExprBool;
import fx.programme.expressions.PasDevantMarque;
import fx.programme.expressions.PasDevantMur;
import fx.programme.expressions.PasSurMarque;
import fx.programme.expressions.PasSurMinerai;
import fx.programme.expressions.SurMarque;
import fx.programme.expressions.SurMinerai;

/**
 *
 * @author yvan
 */
public enum Gardes {
    DevantMur("devant mur") {
        @Override
        public ExprBool newInstance() {
            return new DevantMur();
        }
    },
    PasDevantMur("pas devant mur") {
        @Override
        public ExprBool newInstance() {
            return new PasDevantMur();
        }
    },
    SurMarque("sur marque") {
        @Override
        public ExprBool newInstance() {
            return new SurMarque();
        }
    },
    PasSurMarque("pas sur marque") {
        @Override
        public ExprBool newInstance() {
            return new PasSurMarque();
        }
    },
    DevantMarque("devant marque") {
        @Override
        public ExprBool newInstance() {
            return new DevantMarque();
        }
    },
    PasDevantMarque("pas devant marque") {
        @Override
        public ExprBool newInstance() {
            return new PasDevantMarque();
        }
    },
    SurMinerai("sur minerai") {
        @Override
        public ExprBool newInstance() {
            return new SurMinerai();
        }
    },
    PasSurMinerai("pas sur minerai") {
        @Override
        public ExprBool newInstance() {
            return new PasSurMinerai();
        }
    };

    private final String texte;

    private Gardes(String texte) {
        this.texte = texte;
    }

    @Override
    public String toString() {
        return texte;
    }

    public abstract ExprBool newInstance();
}
