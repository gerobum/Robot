
package map;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 *
 * @author yvan
 * @param <V>
 */
public class ExtendedMap<V extends Serializable> implements Serializable {
    /* Par composition avec (une implémentation adéquate de) java.util.Map concevoir et développer une classe
    ExtendedMap qui proposera à ses clients l’interface suivante. */
    private final Map<String, V> map = new TreeMap<>();

    /**
     * permet l’insertion dans l’instance courante du nouveau couple (key,
     * value). Si la clé key était déjà présente elle renverra l’ancienne valeur
     * associée à key sinon elle renverra null.
     */
    public V put(String key, V value) {
        return map.put(key, value);
    }

    /**
     * permet de récupérer dans l’instance courante la valeur associée à la clé
     * key si cette clé est présente ou null si elle est absente.
     */
    public V get(String key) {
        return map.get(key);
    }

    /**
     * permet de récupérer dans l’instance courante l’ensemble des valeurs dont
     * les clés vérifient l’expression régulière regExp
     */
    public Set<V> grepGet(String regExp) {
        Set<V> set = new HashSet<>();
        Pattern p = Pattern.compile(regExp);
        for (String s : map.keySet()) {
            if (p.matcher(s).matches()) {
                set.add(map.get(s));
            }
        }
        return set;
    }

    /**
     * qui renverra sous forme d’une chaîne le contenu de la table ordonné par
     * ordre croissant des clés. Cette représentation devra avoir la forme
     * ci-dessous. 
     * { 
     *    "key1" => value1, 
     *    "key2" => value2 
     * }
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (!map.isEmpty()) {
            Iterator<String> i = map.keySet().iterator();
            String k = i.next();
            sb.append("\n\t\"").append(k).append("\" => ").append(map.get(k));
            while (i.hasNext()) {
                k = i.next();
                sb.append(",\n").append("\t\"").append(k).append("\" => ").append(map.get(k));
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
