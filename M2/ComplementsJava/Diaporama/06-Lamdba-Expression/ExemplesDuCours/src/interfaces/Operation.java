package interfaces;

@FunctionalInterface
public interface Operation<T,U,R> {
    R calcul(T a, U b);
}
