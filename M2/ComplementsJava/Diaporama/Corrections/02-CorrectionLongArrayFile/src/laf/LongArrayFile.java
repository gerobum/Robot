package laf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Concevoir et développer par composition avec la classe java.io.RandomAccessFile une classe LongArrayFile
 qui implémentera un « tableau » extensible de valeurs de type long stockées dans un fichier. C’est-à-dire qu’on
 veut enrober la RandomAccessFile dans LongArrayFile pour faire un tableau de long (dans un fichier) à partir
 de RandomAccessFile qui est un tableau de byte. Au final votre classe devra être « thread-safe », itérable et
 présenter à ses clients les constructeurs et méthodes suivantes. */
public class LongArrayFile {

    // Par composition avec java.io.RandomAccessFile ...
    private final RandomAccessFile raf;

    // public LongArrayFile(String fileName) qui construira un tableau de taille nulle.
    public LongArrayFile(String fileName) throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(fileName, "rw");
        raf.setLength(0);
    }

    // public long size() qui renvoie la longueur courante du tableau (i.e le nombre de valeurs de type long
    // qu’il contient).
    public synchronized long size() throws IOException {
        return raf.length() / 8; // 8 bytes dans un long
    }

    // public void clear() qui met à zéro le nombre de valeurs du tableau.
    public synchronized void clear() throws IOException {
        raf.setLength(0);
    }

    /* public void put(long p, long valeur) où p est la position, comptée à partir de 0, à laquelle devra être
     insérée la valeur de type long valeur. La taille augmente d’un élément lorsque que p est juste après
     le dernier élément, c’est-à-dire que p est égal à la taille du tableau. C’est la seule façon d’ajouter des
     éléments dans le tableau. Une exception de type ArrayIndefOutOfBoundException est lancée si p est hors
     des limites du tableau.*/
    public synchronized void put(long p, long valeur) throws IOException {
        if (p < 0 || p > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        raf.seek(8 * p);
        raf.writeLong(valeur);
    }

    /* public long get(long p) qui renvoie la valeur de type long stockée à la position p. Cette méthode doit
     vérifier la pertinence des arguments qui lui sont transmis et éventuellement lancer une exception de type
     adéquat. */
    public synchronized long get(long p) throws IOException {
        if (p < 0 || p >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        raf.seek(8 * p);
        return raf.readLong();
    }

    /* public String toString(long p, long n) qui renverra un String contenant la représentation des n valeurs
     stockées à partir de la position p. Cette méthode doit vérifier la pertinence des arguments et lancer une
     exception si nécessaire. */
    public synchronized String toString(long p, long n) throws IOException {
        if (n == 0) {
            return "[]";
        }
        if (p < 0 || n < 0 || p + n > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        raf.seek(8 * p);
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(raf.readLong());
        for (int i = 1; i < n; ++i) {
            sb.append(", ").append(raf.readLong());
        }
        sb.append(']');
        return sb.toString();
    }

    /* public String toString() qui renverra un String contenant la représentation des valeurs de type long
     stockées dans le tableau. */
    @Override
    public synchronized String toString() {
        try {
            return toString(0, size());
        } catch (IOException ex) {
            return "";
        }
    }
    /* public Iterator<Long> iterator() qui renvoie un itérateur permettant de parcourir le contenu de son
     instance courante.
     */

    public class Iterator {

        private long pos;

        private Iterator() throws IOException {
            pos = 0;
        }

        public long next() throws IOException {
            synchronized (LongArrayFile.this) {
                raf.seek(8 * pos++);
                return raf.readLong();
            }
        }

        public boolean hasNext() throws IOException {
            synchronized (LongArrayFile.this) {
                return 8 * pos < raf.length();
            }
        }
    }

    public synchronized Iterator first() throws IOException {
        return new Iterator();
    }
}
