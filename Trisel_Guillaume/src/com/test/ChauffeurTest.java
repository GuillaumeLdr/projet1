package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Chauffeur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChauffeurTest {
	private Chauffeur chauffeur;
	private SimpleDateFormat formater = null;
	@Before
	public void setUp() throws Exception {
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date aujourdhui = null;
		aujourdhui = formater.parse("17/07/2016");
		chauffeur = new Chauffeur("id01","nom1","prenom1",aujourdhui);
	}

	@After
	public void tearDown() throws Exception {
		chauffeur = null;
	}

	@Test
	public void testChauffeur() {
		assertNotNull("L'instance camion a été créer");
	}

	@Test
	public void testGetNomChauffeur() {
		assertEquals("nom1", chauffeur.getNomChauffeur());
		assertNotEquals("nom3", chauffeur.getNomChauffeur());
	}

	private void assertNotEquals(String string, String nomChauffeur) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testSetNomChauffeur() {
		chauffeur.setNomChauffeur("nom2");
		assertEquals("Est ce que le nom du chauffeur est correct", "nom2", chauffeur.getNomChauffeur());
		assertNotEquals("nom3", chauffeur.getNomChauffeur());
	}

	@Test
	public void testGetPrenomChauffeur() {
		assertEquals("prenom1", chauffeur.getPrenomChauffeur());
		assertNotEquals("prenom3", chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testSetPrenomChauffeur() {
		chauffeur.setPrenomChauffeur("prenom2");
		assertEquals("Est ce que le nom du chauffeur est correct", "prenom2", chauffeur.getPrenomChauffeur());
		assertNotEquals("prenom3", chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testGetDateEmbauche() {
		assertEquals("17/07/2016", formater.format(chauffeur.getDateEmbauche()));
		assertNotEquals("", formater.format(chauffeur.getDateEmbauche()));
	}

	@Test
	public void testSetDateEmbauche() {
		Date aujourdhui = null;
		try {
			aujourdhui = formater.parse("01/01/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chauffeur.setDateEmbauche(aujourdhui);
		assertEquals("Est ce que la date est correct", "01/01/2016", formater.format(chauffeur.getDateEmbauche()));
		assertNotEquals("", formater.format(chauffeur.getDateEmbauche()));
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("id01", chauffeur.getIdChauffeur());
		assertNotEquals("id03", chauffeur.getIdChauffeur());
	}

	/*@Test
	public void testToString() {
		
	}*/

}
