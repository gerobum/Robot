package fx.programme.instructions;

public abstract class InstructionElementaire extends Instruction {

    public static final long serialVersionUID = 0L;

    public InstructionElementaire(Instruction parent) {
        super(parent);
    }
    @Override
    public boolean autorisationAjout() {
        return false;
    }
    @Override
    public String deepToString(String decalage) {
        return decalage + toString() + "\n";
    }
}
