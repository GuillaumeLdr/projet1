package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Usager;

public class UsagerTest {
	private Usager usager;
	private ArrayList<Habitation> lesHabitations = new ArrayList<Habitation>();
	private ArrayList<Habitation> lesHabitationsSet = new ArrayList<Habitation>();
	private Habitation habitation1;
	private Habitation habitation2;

	@Before
	public void setUp() throws Exception {
		usager = new Usager("idU1", "nom1", "prenom1", "adr1", "cp1", "adrV1");
		habitation1 = new Habitation("idhab1", "adrRue1", "cphab1", "adrvillehab1", 5, usager);
		habitation2 = new Habitation("idhab2", "adrRue2", "cphab2", "adrvillehab2", 7, usager);
	}

	@After
	public void tearDown() throws Exception {
		usager= null;
		habitation1 = null;
		habitation2 = null;
	}

	@Test
	public void testUsager() {
		assertNotNull("L'instanciation est corret");
	}

	@Test
	public void testGetIdUsager() {
		assertEquals("idU1", usager.getIdUsager());
		assertNotEquals("", usager.getIdUsager());
	}

	private void assertNotEquals(String string, String idUsager) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetNom() {
		assertEquals("nom1", usager.getNom());
		assertNotEquals("", usager.getNom());
	}

	@Test
	public void testSetNom() {
		usager.setNom("nom2");
		assertEquals("nom2", usager.getNom());
		assertNotEquals("", usager.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals("prenom1", usager.getPrenom());
		assertNotEquals("", usager.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		usager.setPrenom("prenom2");
		assertEquals("prenom2", usager.getPrenom());
		assertNotEquals("", usager.getPrenom());
	}

	@Test
	public void testGetAdrRueUsager() {
		assertEquals("adr1", usager.getAdrRueUsager());
		assertNotEquals("", usager.getAdrRueUsager());
	}

	@Test
	public void testSetAdrRueUsager() {
		usager.setAdrRueUsager("adr2");
		assertEquals("adr2", usager.getAdrRueUsager());
		assertNotEquals("", usager.getAdrRueUsager());
	}

	@Test
	public void testGetCpUsager() {
		assertEquals("cp1", usager.getCpUsager());
		assertNotEquals("", usager.getCpUsager());
	}

	@Test
	public void testSetCpUsager() {
		usager.setCpUsager("cp2");
		assertEquals("cp2", usager.getCpUsager());
		assertNotEquals("", usager.getCpUsager());
	}

	@Test
	public void testGetAdrVilleUsager() {
		assertEquals("adrV1", usager.getAdrVilleUsager());
		assertNotEquals("", usager.getAdrVilleUsager());
	}

	@Test
	public void testSetAdrVilleUsager() {
		usager.setAdrVilleUsager("adrV2");
		assertEquals("adrV2", usager.getAdrVilleUsager());
		assertNotEquals("", usager.getAdrVilleUsager());
	}

	@Test
	/*public void testGetLesHabitations() {
		lesHabitations.add(habitation1);
		lesHabitations.add(habitation2);
		
		usager.setLesHabitations(lesHabitations);
		
		assertEquals(lesHabitations, usager.getLesHabitations());
		assertNotEquals("", usager.getLesHabitations());
	}*/

	private void assertNotEquals(String string, List<Habitation> lesHabitations2) {
		// TODO Auto-generated method stub
		
	}

	//@Test
	/*public void testSetLesHabitations() {
		lesHabitationsSet.add(habitation1);
		lesHabitationsSet.add(habitation2);
		
		usager.setLesHabitations(lesHabitations);
		usager.setLesHabitations(lesHabitationsSet);
		
		assertEquals(lesHabitationsSet, usager.getLesHabitations());
		assertNotEquals("", usager.getLesHabitations());
	}*/

	/*@Test
	public void testToString() {
		
	}*/

	/*@Test
	public void testAjoutHabitation() {
		
		assertEquals("true", usager.AjoutHabitation(habitation1));
		assertNotEquals("false", usager.AjoutHabitation(habitation1));
	}

	@Test
	public void testSupprimerHabitation() {
		assertEquals("true", usager.SupprimerHabitation(habitation1));
		assertNotEquals("false", usager.SupprimerHabitation(habitation1));
	}*/

}
