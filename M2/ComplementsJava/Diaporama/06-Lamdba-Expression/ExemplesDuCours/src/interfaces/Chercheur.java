package interfaces;

import java.util.Collection;

@FunctionalInterface
public interface Chercheur<T> {
    T chercher(Collection<T> c);
}
