package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest2 {
	private Poubelle poubelle;
	private TypeDechet typeDechet;
	private SimpleDateFormat formater = null;
	
	private Levee levee1;
	private Levee levee2;
	private ArrayList<Levee> lesLevees = new ArrayList<Levee>();
	
	private Levee newLevee1;
	private Levee newLevee2;
	private ArrayList<Levee> lesLeveeSet = new ArrayList<Levee>();

	@Before
	public void setUp() throws Exception {
		typeDechet = new TypeDechet("type1","libelle1",1.5);
		poubelle = new Poubelle("pb1", "hb1", typeDechet);
		
		Date date = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formater.parse("17/07/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		levee1 = new Levee(1, date, 10.5, "pb1", "immat1", "id01");
		levee2 = new Levee(date, 11 ,"pb1", "immat1", "id01");
		
		newLevee1 = new Levee(2, date, 29.44, "pb3", "immat3", "id03");
		newLevee2 = new Levee(date, 30, "pb3", "immat3", "id03");
		
	}

	@After
	public void tearDown() throws Exception {
		typeDechet = null;
		poubelle = null;
		levee1 = null;
		levee2 = null;
		newLevee1 = null;
		newLevee2 = null;
	}

	@Test
	public void testPoubelle() {
		assertNotNull("L'instanciation est corret");
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals("pb1", poubelle.getIdPoubelle());
		assertNotEquals("", poubelle.getIdPoubelle());
	}

	private void assertNotEquals(String string, String idPoubelle) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetIdHabitation() {
		assertEquals("hb1", poubelle.getIdHabitation());
		assertNotEquals("", poubelle.getIdHabitation());
	}

	@Test
	public void testSetIdHabitation() {
		poubelle.setIdHabitation("hb2");
		assertEquals("hb2", poubelle.getIdHabitation());
		assertNotEquals("", poubelle.getIdHabitation());
	}

	@Test
	public void testGetNature() {
		assertEquals(typeDechet, poubelle.getNature());
		assertNotEquals("", poubelle.getNature());
	}

	@Test
	public void testSetNature() {
		TypeDechet typeDechet2 = new TypeDechet("type2","libelle2",3);
		poubelle.setNature(typeDechet2);
		
		assertEquals(typeDechet2, poubelle.getNature());
		assertNotEquals("", poubelle.getNature());
	}

	private void assertNotEquals(String string, TypeDechet nature) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetLesLevees() {
		lesLevees.add(levee1);
		lesLevees.add(levee2);
		
		poubelle.setLesLevees(lesLevees);
		
		assertEquals(lesLevees, poubelle.getLesLevees());
		assertNotEquals("", poubelle.getLesLevees());
	}

	@Test
	public void testSetLesLevees() {
		lesLeveeSet.add(newLevee1);
		lesLeveeSet.add(newLevee2);
		
		poubelle.setLesLevees(lesLevees);
		poubelle.setLesLevees(lesLeveeSet);
		
		assertEquals(lesLeveeSet, poubelle.getLesLevees());
		assertNotEquals("", poubelle.getLesLevees());
	}

	private void assertNotEquals(String string, List<Levee> lesLevees2) {
		// TODO Auto-generated method stub
		
	}

	/*@Test
	public void testToString() {
		
	}*/

}
