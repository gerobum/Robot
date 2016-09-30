/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetique;

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
public class ExpressionIT {

    public ExpressionIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of evaluer method, of class Expression.
     */
    @Test
    public void testEvaluer() {
        Variable X = new Variable(0);
        Variable Y = new Variable(0);
        Expression e = new Division(
                new Addition(
                        new Multiplication(
                                new Constante(2), X),
                        new Constante(3)),
                new Multiplication(
                        X,
                        new Soustraction(
                                new Multiplication(new Constante(3), Y),
                                new Constante(2))));

        for (double x = 0.2; x <= 10; x += 0.5) {
            for (double y = 0; y <= 10; y += 0.5) {
                X.setValeur(x);
                Y.setValeur(y);
                assertEquals(e.evaluer(), (2 * x + 3) / (x * (3 * y - 2)), 0.0001);
            }
        }
    }

}
