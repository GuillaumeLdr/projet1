package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest {
	private TypeDechet td1, td2;
	private Poubelle pb;
	private Date d1 = null;
	private Date d2 = null;
	private Date d3 = null;
	private Levee le1 = null;
	private Levee le2 = null;
	private Levee le3 = null;
	private ArrayList<Levee> listeLevees;
	private SimpleDateFormat dateFormat;

	@Before
	public void setUp() throws Exception {
		// 2 types déchet pour get et set
		td1 = new TypeDechet("Ver", "verre", 0.10);
		td2 = new TypeDechet("pap", "papier", 0.08);
		// une poubelle
		pb = new Poubelle("pb1", "hab1", td1);
		// 3 levées pour la poubelle
		// instanciation dates de levée
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d1 = dateFormat.parse("15/03/2016");
			d2 = dateFormat.parse("30/03/2016");
			d3 = dateFormat.parse("15/06/2016");
			le1 = new Levee(d1, 5, pb.getIdPoubelle(), "camion1", "chauffeur1");
			le2 = new Levee(d2, 10, pb.getIdPoubelle(), "camion1", "chauffeur1");
			le3 = new Levee(d3, 12, pb.getIdPoubelle(), "camion1", "chauffeur1");
			// collection de travail pour le setLesLevees
			listeLevees = new ArrayList<Levee>();
			listeLevees.add(le1);
			listeLevees.add(le2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void taerDown() throws Exception {
		td1 = null;
		td2 = null;
		pb = null;
		listeLevees = null;
	}

	@Test
	public void testPoubelle() {
		assertNotNull(pb);
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals(pb.getIdPoubelle(), "pb1");
	}

	@Test
	public void testGetIdHabitation() {
		pb.setIdHabitation("hab2");
		assertEquals(pb.getIdHabitation(), "hab2");
	}

	@Test
	public void testSetIdHabitation() {
		assertEquals(pb.getIdHabitation(), "hab1");
	}

	@Test
	public void testGetNature() {
		assertEquals(pb.getNature(), td1);
	}

	@Test
	public void testSetNature() {
		pb.setNature(td2);
		assertEquals(pb.getNature(), td2);
	}

	@Test
	public void testGetLesLevees() {
		assertEquals(pb.getLesLevees().size(), 0);
		pb.addLevee(le1);
		pb.addLevee(le2);
		pb.addLevee(le3);
		assertEquals(pb.getLesLevees().size(), 3);
		assertEquals(pb.getLesLevees().get(0), le1);
		assertEquals(pb.getLesLevees().get(1), le2);
		assertEquals(pb.getLesLevees().get(2), le3);
	}

	@Test
	public void testSetLesLevees() {
		pb.setLesLevees(listeLevees);
		assertEquals(pb.getLesLevees().size(), 2);
		assertEquals(pb.getLesLevees(), listeLevees);
		assertEquals(pb.getLesLevees().get(0), le1);
		assertEquals(pb.getLesLevees().get(1), le2);
	}

	@Test
	public void testAddLevee() {
		pb.addLevee(le1);
		assertEquals(pb.getLesLevees().size(), 1);
	}
	
	@Test
	public void  testGetLesLevees1() {
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
		
		//Liste de Travail
		ArrayList<Levee> listeLeveesDate = new ArrayList<Levee>();
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			date1 = dateFormat.parse("15/05/2015");
			date2 = dateFormat.parse("30/07/2015");
			date3 = dateFormat.parse("05/05/2015");
			date4 = dateFormat.parse("15/06/2015");
			date5 = dateFormat.parse("21/06/2015");
			//jeux d'essai avec plusieurs levees de différents mois
			levee1 = new Levee(date1, 1, "pb1", "immat1", "chauf1");
			levee2 = new Levee(date2, 2, "pb2", "immat2", "chauf2");
			levee3 = new Levee(date3, 3, "pb3", "immat3", "chauf3");
			levee4 = new Levee(date4, 4, "pb4", "immat4", "chauf4");
			levee5 = new Levee(date5, 5, "pb5", "immat5", "chauf5");
			
			pb.addLevee(levee1);
			pb.addLevee(levee2);
			pb.addLevee(levee3);
			pb.addLevee(levee4);
			pb.addLevee(levee5);
			
			listeLeveesDate.add(levee1);
			listeLeveesDate.add(levee3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(listeLeveesDate, pb.getLesLevees(2015, 05));
	}
	
	@Test
	public void testGetCout() {
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
			date5 = dateFormat.parse("21/06/2015");
			//jeux d'essai avec plusieurs levees de différents mois
			levee1 = new Levee(date1, 1, "pb1", "immat1", "chauf1");
			levee2 = new Levee(date2, 2, "pb2", "immat2", "chauf2");
			levee3 = new Levee(date3, 3, "pb3", "immat3", "chauf3");
			levee4 = new Levee(date4, 4, "pb4", "immat4", "chauf4");
			levee5 = new Levee(date5, 5, "pb5", "immat5", "chauf5");
			
			pb.addLevee(levee1);
			pb.addLevee(levee2);
			pb.addLevee(levee3);
			pb.addLevee(levee4);
			pb.addLevee(levee5);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(pb.getCout(2015, 05));
		assertTrue(0.4 == pb.getCout(2015, 05));
	}
}
