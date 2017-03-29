package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.TypeDechet;

public class TypeDechetTest {
	private TypeDechet typeDechet;

	@Before
	public void setUp() throws Exception {
		typeDechet = new TypeDechet("type1","libelle1",1.5);
	}

	@After
	public void tearDown() throws Exception {
		typeDechet = null;
	}

	@Test
	public void testTypeDechet() {
		assertNotNull("L'instance camion a été créer");
	}

	@Test
	public void testGetTarif() {
		assertTrue(1.5 == typeDechet.getTarif());
		assertFalse(10.2 == typeDechet.getTarif());
	}

	@Test
	public void testSetTarif() {
		typeDechet.setTarif(31.21);
		assertTrue(31.21 == typeDechet.getTarif());
		assertFalse(10.2 == typeDechet.getTarif());
	}

	@Test
	public void testGetIdTypeDechet() {
		assertEquals("type1", typeDechet.getIdTypeDechet());
		assertNotEquals("type3", typeDechet.getIdTypeDechet());
	}

	private void assertNotEquals(String string, String idTypeDechet) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetLibelle() {
		assertEquals("libelle1", typeDechet.getLibelle());
		assertNotEquals("libelle3", typeDechet.getLibelle());
	}

	/*@Test
	public void testToString() {
		
	}*/

}
