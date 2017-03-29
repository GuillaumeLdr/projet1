package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Camion;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CamionTest {
	private Camion camion;
	private SimpleDateFormat formater = null;
	@Before
	public void setUp() throws Exception {
		Date aujourdhui = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		aujourdhui = formater.parse("17/07/2016");
		camion = new Camion("AC-683-ET",aujourdhui);
	}

	@After
	public void tearDown() throws Exception {
		camion = null;
	}

	@Test
	public void testCamion() {
		assertNotNull("L'instance camion a été créer");
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("AC-683-ET", camion.getImmatriculation());
		assertNotEquals("", camion.getImmatriculation());
	}

	@Test
	public void testSetImmatriculation() {
		camion.setImmatriculation("BD-001-BD");
		assertEquals("BD-001-BD", camion.getImmatriculation());
		assertNotEquals("", camion.getImmatriculation());
	}

	@Test
	public void testGetDateMiseEnCirculation() {
		assertEquals("17/07/2016", formater.format(camion.getDateMiseEnCirculation()));
		assertNotEquals("", formater.format(camion.getDateMiseEnCirculation()));
	}

	private void assertNotEquals(String string, String format) {
		// TODO Auto-generated method stub
		
	}

	/*@Test
	public void testToString() {
		assertEquals("Est ce que le ToString() est correct", "BD-001-BD , 17/07/2016", camion.toString());
		
	}*/

}
