package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;

public class LeveeTest {
	private Levee levee;
	private Levee levee1;
	private SimpleDateFormat formater = null;
	@Before
	public void setUp() throws Exception {
		Date aujourdhui = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		aujourdhui = formater.parse("17/07/2016");
		levee = new Levee(1, aujourdhui, 10.5, "pb1", "immat1", "id01");
		levee1 = new Levee(aujourdhui, 11, "pb1", "immat1", "id01");
	}

	@After
	public void tearDown() throws Exception {
		levee = null;
	}

	@Test
	public void testLeveeIntDateDoubleStringStringString() {
		assertNotNull("L'instanciation est correct");
	}

	@Test
	public void testLeveeDateDouble() {
		assertNotNull("L'instanciation est correct");
	}

	@Test
	public void testGetIdLevee() {
		assertTrue(1 == levee.getIdLevee());
		assertFalse(2 == levee.getIdLevee());
	}

	@Test
	public void testGetLaDate() {
		assertEquals("17/07/2016", formater.format(levee.getLaDate()));
		assertNotEquals("23/01/2016", formater.format(levee.getLaDate()));
		assertEquals("17/07/2016", formater.format(levee1.getLaDate()));
		assertNotEquals("23/01/2016", formater.format(levee1.getLaDate()));
	}

	private void assertNotEquals(String string, String format) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testSetLaDate() {
		Date aujourdhui = null;
		try {
			aujourdhui = formater.parse("01/01/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		levee.setLaDate(aujourdhui);
		levee1.setLaDate(aujourdhui);
		assertEquals("01/01/2016", formater.format(levee.getLaDate()));
		assertNotEquals("30/08/2016", formater.format(levee.getLaDate()));
		assertEquals("01/01/2016", formater.format(levee1.getLaDate()));
		assertNotEquals("30/08/2016", formater.format(levee1.getLaDate()));
	}

	@Test
	public void testGetPoids() {
		assertTrue(10.5 == levee.getPoids());
		assertFalse(29.44 == levee.getPoids());
		
		assertTrue(11 == levee1.getPoids());
		assertFalse(29.44 == levee1.getPoids());
	}

	@Test
	public void testSetPoids() {
		levee.setPoids(15.5);
		levee1.setPoids(99.9);
		
		assertTrue(15.5 == levee.getPoids());
		assertFalse(29.44 == levee.getPoids());
		
		assertTrue(99.9 == levee1.getPoids());
		assertFalse(29.44 == levee1.getPoids());
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals("pb1", levee.getIdPoubelle());
		assertNotEquals("", levee.getIdPoubelle());
	}

	@Test
	public void testSetIdPoubelle() {
		levee.setIdPoubelle("pb2");
		assertEquals("pb2", levee.getIdPoubelle());
		assertNotEquals("", levee.getIdPoubelle());
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("immat1", levee.getImmatriculation());
		assertNotEquals("", levee.getImmatriculation());
	}

	@Test
	public void testSetImmatriculation() {
		levee.setImmatriculation("immat2");
		assertEquals("immat2", levee.getImmatriculation());
		assertNotEquals("", levee.getImmatriculation());
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("id01", levee.getIdChauffeur());
		assertNotEquals("", levee.getIdChauffeur());
	}

	@Test
	public void testSetIdChauffeur() {
		levee.setIdChauffeur("id02");
		assertEquals("id02", levee.getIdChauffeur());
		assertNotEquals("", levee.getIdChauffeur());
	}

	/*@Test
	public void testToString() {
		
	}*/

}
