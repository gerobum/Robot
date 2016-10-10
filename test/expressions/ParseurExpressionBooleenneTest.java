/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yvan
 */
public class ParseurExpressionBooleenneTest {
    private static Random random = new Random();

    public ParseurExpressionBooleenneTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class ParseurExpressionBooleenne.
     */
    @Test
    public void testParse() {
        System.out.println("parse");

        // TODO review the generated test code and remove the default call to fail.
        String[] liste = {"dmr", "pdmr", "smq", "psmq", "smn", "psmn"};
        ParseurExprBool instance = new ParseurExprBool(null, liste);
        
        //(dmr et smq) ou (psmn et pas smq)

        for(String s : liste)
            assertTrue(s, instance.parse(s));

        String s;

        s = "pas " + liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));
        s = liste[random.nextInt(liste.length)]+" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertTrue(s, instance.parse(s));
        s = "("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+") et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertTrue(s, instance.parse(s));
        //(dmr et psmq) ou (pdmr et smq)
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+") ou ("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+")";
        assertTrue(s, instance.parse(s));
        //(dmr et psmq) ou pdmr
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+") ou "+liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));

        s = liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));
        s = liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));
        s = liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));
        s = "pas "+ liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertTrue(s, instance.parse(s));
        
        
        s = "pas "+ liste[random.nextInt(liste.length)] + " pas " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertFalse(s, instance.parse(s));
        s = liste[random.nextInt(liste.length)] + " non et ";
        assertFalse(s, instance.parse(s));
        s = liste[random.nextInt(liste.length)] + liste[random.nextInt(liste.length)] +" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertFalse(s, instance.parse(s));
        s = "("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertFalse(s, instance.parse(s));
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+" ou ()";
        assertFalse(s, instance.parse(s));
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+" ou ()";
        assertFalse(s, instance.parse(s));
        s = "nimp";
        assertFalse(s, instance.parse(s));
        s = "";
        assertFalse(s, instance.parse(s));
        s = null;
        assertFalse(s, instance.parse(s));
    }

    /**
     * Test of compile method, of class ParseurExpressionBooleenne.
     */
    @Test
    public void testCompile() {
        System.out.println("parse");

        // TODO review the generated test code and remove the default call to fail.
        String[] liste = {"dmr", "pdmr", "smq", "psmq", "smn", "psmn"};
        ParseurExprBool instance = new ParseurExprBool(null, liste);

        //(dmr et smq) ou (psmn et pas smq)

        for(String s : liste)
            assertNotNull(s, instance.compile(s));

        String s;

        s = "pas " + liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));
        s = liste[random.nextInt(liste.length)]+" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertNotNull(s, instance.compile(s));
        s = "("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+") et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertNotNull(s, instance.compile(s));
        //(dmr et psmq) ou (pdmr et smq)
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+") ou ("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+")";
        assertNotNull(s, instance.compile(s));
        //(dmr et psmq) ou pdmr
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+") ou "+liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));

        s = liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));
        s = liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));
        s = liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));
        s = "pas "+ liste[random.nextInt(liste.length)] + " et " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertNotNull(s, instance.compile(s));


        s = "pas "+ liste[random.nextInt(liste.length)] + " pas " + liste[random.nextInt(liste.length)] + " ou " + liste[random.nextInt(liste.length)];
        assertNull(s, instance.compile(s));
        s = liste[random.nextInt(liste.length)] + " non et ";
        assertNull(s, instance.compile(s));
        s = liste[random.nextInt(liste.length)] + liste[random.nextInt(liste.length)] +" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertNull(s, instance.compile(s));
        s = "("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+" et ("+liste[random.nextInt(liste.length)]+" ou "+liste[random.nextInt(liste.length)]+")";
        assertNull(s, instance.compile(s));
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+" ou ()";
        assertNull(s, instance.compile(s));
        s = "("+liste[random.nextInt(liste.length)]+" et "+liste[random.nextInt(liste.length)]+" ou ()";
        assertNull(s, instance.compile(s));
        s = "nimp";
        assertNull(s, instance.compile(s));
        s = "";
        assertNull(s, instance.compile(s));
        s = null;
        assertNull(s, instance.compile(s));
    }

    /**
     * Test of enlèveLesParenthèsesExtremes method, of class ParseurExpressionBooleenne.
     */
    @Test
    public void testEnlèveLesParenthèsesExtremes() throws Exception {
        System.out.println("enlèveLesParenthèsesExtremes");
        // TODO review the generated test code and remove the default call to fail.

        assertEquals("(a + b)", "a + b", ParseurExprBool.enlèveLesParenthèsesExtremes("(a + b)"));
        assertEquals("a + b", "a + b", ParseurExprBool.enlèveLesParenthèsesExtremes("a + b"));
        assertEquals(" (a + b)  ", "a + b", ParseurExprBool.enlèveLesParenthèsesExtremes(" (a + b)  "));
        assertEquals("(a + b) et (b * c)", "(a + b) et (b * c)", ParseurExprBool.enlèveLesParenthèsesExtremes("(a + b) et (b * c)"));
        assertEquals("((a + b) et (b * c))", "(a + b) et (b * c)", ParseurExprBool.enlèveLesParenthèsesExtremes("((a + b) et (b * c))"));
        assertEquals("((a + b) et c)", "(a + b) et c", ParseurExprBool.enlèveLesParenthèsesExtremes("((a + b) et c)"));
        assertEquals("(a + b) et )", "(a + b) et c", ParseurExprBool.enlèveLesParenthèsesExtremes("(a + b) et c"));
    }



}