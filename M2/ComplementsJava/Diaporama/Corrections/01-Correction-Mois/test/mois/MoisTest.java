/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mois;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maillot
 */
public class MoisTest {

  /**
   * Test of numéro method, of class Mois.
   */
  @Test
  public void test() {
    int i = 0;
    int num = 1;

    Mois m = Mois.values()[i++];
    assertEquals("Janvier", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Février", m.toString());
    GregorianCalendar gc = new GregorianCalendar();
    if (gc.isLeapYear(gc.get(GregorianCalendar.YEAR))) {
      assertEquals(29, m.nbJours());
    } else {
      assertEquals(28, m.nbJours());
    }
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Mars", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Avril", m.toString());
    assertEquals(30, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Mai", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Juin", m.toString());
    assertEquals(30, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Juillet", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Août", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Septembre", m.toString());
    assertEquals(30, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Octobre", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Novembre", m.toString());
    assertEquals(30, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.values()[i++];
    assertEquals("Décembre", m.toString());
    assertEquals(31, m.nbJours());
    assertEquals(num++, m.numéro());

    m = Mois.FEVRIER;

    Mois.setAnneeEnCours(2012);
    assertEquals(29, m.nbJours());

    Mois.setAnneeEnCours(2014);
    assertEquals(28, m.nbJours());
    
    Mois.setAnneeEnCours();
    assertEquals(28, m.nbJours());
  }
}
