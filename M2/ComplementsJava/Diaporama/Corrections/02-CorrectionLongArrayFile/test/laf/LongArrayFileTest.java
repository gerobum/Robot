package laf;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LongArrayFileTest {

    private static LongArrayFile laf;

    @BeforeClass
    public static void setUpClass() throws Exception {
        laf = new LongArrayFile("TestLAF");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        laf.clear();
    }

    @Test
    public void testSize() throws Exception {
        laf.clear();
        assertEquals(0, laf.size());
        for (int i = 0; i < 100; ++i) {
            laf.put(i, 1);
            assertEquals(i+1, laf.size());
        }
        laf.clear();
        assertEquals(0, laf.size());
    }

    @Test
    public void testClear() throws Exception {
        laf.clear();
        assertEquals(0, laf.size());
    }

    @Test
    public void testPut() throws Exception {
        laf.clear();
        boolean exceptionLancee = false;
        try { // Ajout d'une valeur à une fausse position -1
            laf.put(-1, 1);
            fail("Ne devrait pas passer par là (exception)");
        } catch (ArrayIndexOutOfBoundsException a) {
            exceptionLancee = true;
        }
        assertTrue("exceptionLancee devrait être vraie", exceptionLancee); 
        exceptionLancee = false;
        try { // Ajout d'une valeur à une fausse position 1
            laf.put(1, 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {
            exceptionLancee = true;
        }
        assertTrue("exceptionLancee devrait être vraie", exceptionLancee); 
        
        laf.put(0, 1);// Ajout d'une valeur en fin
        assertEquals(1, laf.size()); // La taille change.

        laf.put(1, 2);// Ajout d'une valeur en fin
        assertEquals(2, laf.size()); // La taille change.

        laf.put(2, 3);// Ajout d'une valeur en fin
        assertEquals(3, laf.size()); // La taille change.

        laf.put(0, 10);// Remplacement d'une valeur
        assertEquals(3, laf.size()); // La taille ne change pas.

        laf.put(1, 20);// Remplacement d'une valeur
        assertEquals(3, laf.size());// La taille ne change pas.

        laf.put(2, 30);// Remplacement d'une valeur
        assertEquals(3, laf.size());// La taille ne change pas.

        exceptionLancee = false;
        try {// Ajout d'une valeur à une fausse position 4
            laf.put(4, 3);
            fail("Ne devrait pas passer par là (exception)");
        } catch (ArrayIndexOutOfBoundsException a) {
            exceptionLancee = true;
        }
        assertTrue("exceptionLancee devrait être vraie", exceptionLancee); 
        
        laf.clear();
        assertEquals(0, laf.size());
    }

    @Test
    public void testGet() throws Exception {
        laf.clear();
        try {
            laf.get(-1);
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {

        }
        try {
            laf.get(laf.size());
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {

        }
        for (int i = 0; i < 100; ++i) {
            laf.put(i, i * 10);
        }

        for (int i = 0; i < 100; ++i) {
            assertEquals(i * 10, laf.get(i));
        }
        try {
            laf.get(-1);
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {

        }
        try {
            laf.get(laf.size());
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }

    @Test
    public void testToString() throws Exception {
        laf.clear();
        assertEquals("[]", laf.toString());
        try {
            laf.toString(-1, 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {

        }
        try {
            laf.toString(0, 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException a) {

        }
        assertEquals("[]", laf.toString(0, 0));
        for (int i = 0; i < 10; ++i) {
            laf.put(i, (i + 1) * 10);
        }
        for (int i = 0; i < 10; ++i) {
            assertEquals("[" + (i + 1) * 10 + "]", laf.toString(i, 1));
        }
        String r = "";
        assertEquals("[" + r + "]", laf.toString(0, 0));
        r += "10";
        assertEquals("[" + r + "]", laf.toString(0, 1));
        for (int i = 1; i < 10; ++i) {
            r += ", " + (i + 1) * 10;
        }
        assertEquals("[" + r + "]", laf.toString());
    }

    @Test
    public void testIterateur() throws IOException {
        laf.clear();
        LongArrayFile.Iterator it = laf.first();
        assertFalse(it.hasNext());
        
        for (int i = 0; i < 100; ++i) {
            laf.put(i, (i + 1) * 10);
            it = laf.first();
            for (int j = 0; j <= i; ++j) {
                assertEquals((j + 1) * 10, it.next());
            }
            assertFalse(it.hasNext());
        }
    }

}
