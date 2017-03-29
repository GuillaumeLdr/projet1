package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class HabitationTest {
	private Habitation hab = null;
	private Usager u1 = null;
	private Usager u2 = null;
	private TypeDechet td;
	private Poubelle pb1;
	private Poubelle pb2;
	private ArrayList<Poubelle> listePoubelle;
	private SimpleDateFormat dateFormat;

	@Before
	public void setUp() throws Exception {
		u1 = new Usager("u1", "Dupont", "Albert", "63 grand-rue", "29150", "chateaulin");
		u2 = new Usager("u2", "Durand", "Alain", "63 grand-rue", "29150", "chateaulin");
		hab = new Habitation("hab1", "63 grand-rue", "29150", "Châteaulin", 2, u1);
		td = new TypeDechet("Ver", "verre", 0.10);
		pb1 = new Poubelle("pb1", hab.getIdHabitation(), td);
		listePoubelle = new ArrayList<Poubelle>();
		listePoubelle.add(pb1);
		listePoubelle.add(pb2);
	}

	@Test
	public void testHabitation() {
		assertNotNull(hab);
	}

	@Test
	public void testGetIdHabitation() {
		assertEquals(hab.getIdHabitation(), "hab1");
	}

	@Test
	public void testGetAdrRueHab() {
		assertEquals(hab.getAdrRueHab(), "63 grand-rue");
	}

	@Test
	public void testSetAdrRueHab() {
		hab.setAdrRueHab("50, rue Pasteur");
		assertEquals(hab.getAdrRueHab(), "50, rue Pasteur");
	}

	@Test
	public void testGetCpHab() {
		assertEquals(hab.getCpHab(), "29150");
	}

	@Test
	public void testSetCpHab() {
		hab.setCpHab("29200");
		assertEquals(hab.getCpHab(), "29200");
	}

	@Test
	public void testGetAdrVilleHab() {
		assertEquals(hab.getAdrVilleHab(), "Châteaulin");
	}

	@Test
	public void testSetAdrVilleHab() {
		hab.setAdrVilleHab("Brest");
		assertEquals(hab.getAdrVilleHab(), "Brest");
	}

	@Test
	public void testGetNbPertsonne() {
		assertEquals(hab.getNbPersonne(), 2);
	}

	@Test
	public void testSetNbPertsonne() {
		hab.setNbPersonne(5);
		assertEquals(hab.getNbPersonne(), 5);
	}

	@Test
	public void testGetUnUsager() {
		assertEquals(hab.getUsager(), u1);
	}

	@Test
	public void testSetUnUsager() {
		hab.setUsager(u2);
		assertEquals(hab.getUsager(), u2);
	}

	@Test
	public void testGetLesPoubelles() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.addPoubelle(pb1);
		List<Poubelle> listeP = hab.getLesPoubelles();
		assertEquals(listeP.size(), 1);
		assertEquals(hab.getLesPoubelles(), listeP);
	}

	@Test
	public void testSetLesPoubelles() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.setLesPoubelles(listePoubelle);
		assertEquals(hab.getLesPoubelles(), listePoubelle);
		assertEquals(hab.getLesPoubelles().size(), 2);
	}

	@Test
	public void testAddPoubelle() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.addPoubelle(pb1);
		assertEquals(hab.getLesPoubelles().size(), 1);
		assertEquals(hab.getLesPoubelles().get(0), pb1);
		hab.addPoubelle(pb2);
		assertEquals(hab.getLesPoubelles().size(), 2);
	}
	
	@Test
	public void testGetCout() {
		//jeu d'essaie avec plusieurs poubelle pour 1 habitation
		TypeDechet td1 = new TypeDechet("Ver", "verre", 0.10);
		TypeDechet td2 = new TypeDechet("Pla", "plastique", 0.30);
		
		Poubelle poubelle1 = new Poubelle("pb1", hab.getIdHabitation(), td1);
		Poubelle poubelle2 = new Poubelle("pb2", hab.getIdHabitation(), td2);
		
		hab.addPoubelle(poubelle1);
		hab.addPoubelle(poubelle2);
		
		//les dates
		Date date1;
		Date date2 ;
		Date date3;
		Date date4;
		Date date5;
				
		//les levees
		Levee levee1;
		Levee levee2;
		Levee levee3;
		Levee levee4;
		Levee levee5;
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			date1 = dateFormat.parse("15/05/2015");
			date2 = dateFormat.parse("30/07/2015");
			date3 = dateFormat.parse("05/05/2015");
			date4 = dateFormat.parse("15/06/2015");
			date5 = dateFormat.parse("21/05/2015");
			//jeux d'essai avec plusieurs levees de différents mois
			levee1 = new Levee(date1, 1, "pb1", "immat1", "chauf1");
			levee2 = new Levee(date2, 2, "pb2", "immat2", "chauf2");
			levee3 = new Levee(date3, 3, "pb3", "immat3", "chauf3");
			levee4 = new Levee(date4, 4, "pb4", "immat4", "chauf4");
			levee5 = new Levee(date5, 5, "pb5", "immat5", "chauf5");
			
			
			poubelle1.addLevee(levee1);
			poubelle1.addLevee(levee5);
			
			poubelle2.addLevee(levee2);
			poubelle2.addLevee(levee3);
			poubelle2.addLevee(levee4);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertTrue(1.5 == hab.getCout(2015, 05));
	}
}
