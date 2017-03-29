package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class HabitationTest2 {
	private Habitation habitation1;
	private Usager usager1;
	private Usager usager2;
	private ArrayList<Poubelle> listepoubelle = new ArrayList<Poubelle>();
	private ArrayList<Poubelle> listepoubelleset = new ArrayList<Poubelle>();
	private Poubelle poubelle1;
	private Poubelle poubelle2;
	private TypeDechet typeDechet;
	@Before
	public void setUp() throws Exception {
		usager1 = new Usager("idU1", "nom1", "prenom1", "adr1", "cp1", "adrV1");
		usager2 = new Usager("idU2", "nom2", "prenom2", "adr2", "cp2", "adrV2");
		habitation1 = new Habitation("idhab1", "adrRue1", "cphab1", "adrvillehab1", 5, usager1);
		typeDechet = new TypeDechet("type1","libelle1",1.5);
		poubelle1 = new Poubelle("pb1", "hb1", typeDechet);
		poubelle2 = new Poubelle("pb2", "hb2", typeDechet);
	}

	@After
	public void tearDown() throws Exception {
		usager1 = null;
		usager2 = null;
		habitation1 = null;
		typeDechet = null;
		poubelle1 = null;
		poubelle2 = null;
	}

	@Test
	public void testHabitation() {
		assertNotNull("L'instanciation est corret");
	}

	@Test
	public void testGetAdrRueHab() {
		assertEquals("adrRue1", habitation1.getAdrRueHab());
		assertNotEquals("", habitation1.getAdrRueHab());
	}

	@Test
	public void testSetAdrRueHab() {
		habitation1.setAdrRueHab("adrRueHab");
		assertEquals("adrRueHab", habitation1.getAdrRueHab());
		assertNotEquals("", habitation1.getAdrRueHab());
	}

	private void assertNotEquals(String string, String adrRueHab) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetCpHab() {
		assertEquals("cphab1", habitation1.getCpHab());
		assertNotEquals("", habitation1.getCpHab());
	}

	@Test
	public void testSetCpHab() {
		habitation1.setCpHab("cpHabSet");
		assertEquals("cpHabSet", habitation1.getCpHab());
		assertNotEquals("", habitation1.getCpHab());
	}

	@Test
	public void testGetAdrVilleHab() {
		assertEquals("adrvillehab1", habitation1.getAdrVilleHab());
		assertNotEquals("", habitation1.getAdrVilleHab());
	}

	@Test
	public void testSetAdrVilleHab() {
		habitation1.setAdrVilleHab("adrV2");
		assertEquals("adrV2", habitation1.getAdrVilleHab());
		assertNotEquals("", habitation1.getAdrVilleHab());
	}

	@Test
	public void testGetNbPersonne() {
		assertTrue(5 == habitation1.getNbPersonne());
		assertFalse(2 == habitation1.getNbPersonne());
	}

	@Test
	public void testSetNbPersonne() {
		habitation1.setNbPersonne(3);
		assertTrue(3 == habitation1.getNbPersonne());
		assertFalse(2 == habitation1.getNbPersonne());
	}

	@Test
	public void testGetIdHabitation() {
		assertEquals("idhab1", habitation1.getIdHabitation());
		assertNotEquals("", habitation1.getIdHabitation());
	}

	@Test
	public void testGetUsager() {
		assertEquals(usager1, habitation1.getUsager());
		assertNotEquals("", habitation1.getUsager());
	}

	@Test
	public void testSetUsager() {
		habitation1.setUsager(usager2);
		assertEquals(usager2, habitation1.getUsager());
		assertNotEquals("", habitation1.getUsager());
	}

	private void assertNotEquals(String string, Usager usager) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetLesPoubelles() {
		assertEquals(0, habitation1.getLesPoubelles().size());
		
		listepoubelle.add(poubelle1);
		listepoubelle.add(poubelle2);
		
		habitation1.setLesPoubelles(listepoubelle);
		
		assertEquals(listepoubelle, habitation1.getLesPoubelles());
		assertNotEquals("", habitation1.getLesPoubelles());
	}

	@Test
	public void testSetLesPoubelles() {
		listepoubelleset.add(poubelle1);
		listepoubelleset.add(poubelle2);
		
		habitation1.setLesPoubelles(listepoubelle);
		habitation1.setLesPoubelles(listepoubelleset);
		
		assertEquals(listepoubelleset, habitation1.getLesPoubelles());
		assertNotEquals("", habitation1.getLesPoubelles());
	}

	private void assertNotEquals(String string, List<Poubelle> lesPoubelles) {
		// TODO Auto-generated method stub
		
	}

	/*@Test
	public void testToString() {
		
	}*/

}
