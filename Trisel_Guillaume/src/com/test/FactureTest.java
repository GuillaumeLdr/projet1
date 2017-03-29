package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Facture;

public class FactureTest {
	private Facture facture1;
	private Facture facture2;

	@Before
	public void setUp() throws Exception {
		facture1 = new Facture(1, 12, 2016, "facture1", "idH1");
		facture2 = new Facture(06, 2014, "facture2", "idH2");
	}

	@After
	public void tearDown() throws Exception {
		facture1 = null;
		facture2 = null;
	}

	@Test
	public void testFactureIntIntIntString() {
		assertNotNull("L'instance a été créer");
	}

	@Test
	public void testFactureIntIntString() {
		assertNotNull("L'instance a été créer");
	}

	@Test
	public void testGetIdFacture() {
		assertTrue(1 == facture1.getIdFacture());
		assertFalse(5 == facture1.getIdFacture());
	}

	@Test
	public void testGetMoisF() {
		assertTrue(12 == facture1.getMoisF());
		assertFalse(5 == facture1.getMoisF());
		assertTrue(06 == facture2.getMoisF());
		assertFalse(5 == facture2.getMoisF());
	}

	@Test
	public void testGetAnF() {
		assertTrue(2016 == facture1.getAnF());
		assertFalse(1997 == facture1.getAnF());
		assertTrue(2014 == facture2.getAnF());
		assertFalse(1997 == facture2.getAnF());
	}

	@Test
	public void testGetNomFacture() {
		assertEquals("facture1", facture1.getNomFacture());
		assertNotEquals("", facture1.getNomFacture());
		assertEquals("facture2", facture2.getNomFacture());
		assertNotEquals("", facture2.getNomFacture());
	}

	private void assertNotEquals(String string, String nomFacture) {
		// TODO Auto-generated method stub
		
	}

	/*@Test
	public void testToString() {
		
	}*/

}
