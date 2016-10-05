/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author yvan
 */
public class ExtendedMapTest {
    
    @Test
    public void testAll() throws IOException, ClassNotFoundException {
        ExtendedMap<Integer> em = new ExtendedMap<>();
        
        assertEquals("{\n}", em.toString());
        
        assertNull(em.put("Un", 2));
        assertEquals("{\n\t\"Un\" => 2\n}", em.toString());
        
        assertEquals(new Integer(2), em.put("Un", 1));
        assertEquals("{\n\t\"Un\" => 1\n}", em.toString());
        
        assertNull(em.put("Deux", 2));
        assertEquals("{\n\t\"Deux\" => 2,\n"
                + "\t\"Un\" => 1\n}", em.toString());
        
        assertNull(em.put("Trois", 3));
        assertEquals("{\n\t\"Deux\" => 2,\n"
                + "\t\"Trois\" => 3,\n"
                + "\t\"Un\" => 1\n}", em.toString());
        
        assertNull(em.put("Quatre", 4));
        assertEquals("{\n\t\"Deux\" => 2,\n"
                + "\t\"Quatre\" => 4,\n"
                + "\t\"Trois\" => 3,\n"
                + "\t\"Un\" => 1\n}", em.toString());
        
        assertEquals(new Integer(1), em.get("Un"));
        assertEquals(new Integer(2), em.get("Deux"));
        assertEquals(new Integer(3), em.get("Trois"));
        assertEquals(new Integer(4), em.get("Quatre"));
        
        Set<Integer> sl, sc;
        sl = em.grepGet(".*j.*");
        sc = new HashSet<>();
        assertEquals(sc, sl);
        
        sl = em.grepGet(".*x.*");
        sc.add(2);
        assertEquals(sc, sl);
        
        sl = em.grepGet("..");
        sc.clear();
        sc.add(1);
        assertEquals(sc, sl);
        
        sl = em.grepGet(".*");
        sc.clear();
        sc.add(1);
        sc.add(2);
        sc.add(3);
        sc.add(4);
        assertEquals(sc, sl);
        
        sl = em.grepGet(".*[Uu].*");
        sc.clear();
        sc.add(1);
        sc.add(2);
        sc.add(4);
        assertEquals(sc, sl);
        
        sl = em.grepGet(".+[Uu].*");
        sc.clear();
        sc.add(2);
        sc.add(4);
        assertEquals(sc, sl);
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fichier"));
        oos.writeObject(em);
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fichier"));
        
        ExtendedMap<Integer> embis;
        
        embis = (ExtendedMap<Integer>) ois.readObject();
        
        assertEquals((Integer)1, embis.get("Un"));
        assertEquals((Integer)2, embis.get("Deux"));
        assertEquals((Integer)3, embis.get("Trois"));
        assertEquals((Integer)4, embis.get("Quatre"));
        
    }
}
