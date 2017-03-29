package com.vue;
import com.util.*;
import com.persistance.*;
import com.metier.*;
import com.pdf.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.*;

import java.sql.*;


public class ProgPrinc {

	public static void main(String[] args) {
		/*if (AccesBd.getInstance() == null){
			System.out.println("connection fail");
		}
		else{
			System.out.println("connection réussie");
		}*/
		
		//InsertionLevee.LireFichierTexte("pesee.txt");
		
		//InsertionLevee.TraitementFichierTexte("pesee.txt");
		//InsertionLevee.traitementFichierXml("pesee.xml");
		
		//TEST MÉTHODE FIND.DAO
		
		/*System.out.println("test Find(string id) --> TypeDechetDAO :");
		TypeDechetDAO typeDAO = new TypeDechetDAO();
		TypeDechet type = typeDAO.find("pla");
		System.out.println(type.toString());*/
		
		//
		
		/*System.out.println("//");
		System.out.println("test Find(int id) --> LeveeDAO :");
		LeveeDAO leveeDAO = new LeveeDAO();
		Levee levee = leveeDAO.find(1);
		System.out.println(levee.toString());*/
		
		//
		
		/*System.out.println("//");
		System.out.println("test Find(int id) --> UsagerDAO :");
		UsagerDAO usagerDAO = new UsagerDAO();
		Usager usager = usagerDAO.find("usag1");
		System.out.println(usager.toString());*/
		
		//
		
		/*System.out.println("//");
		System.out.println("test Find(int id) --> PoubelleDAO :");
		PoubelleDAO poubelleDAO = new PoubelleDAO();
		Poubelle poubelle = poubelleDAO.find("pb1");
		System.out.println(poubelle.toString());*/
		
		//
		
		/*System.out.println("//");
		System.out.println("test Find(int id) --> HabitationDAO :");
		HabitationDAO habitationDAO = new HabitationDAO();
		Habitation habitation = habitationDAO.find("hab1");
		System.out.println(habitation.toString());*/
		
		//
		
		/*System.out.println("//");
		System.out.println("test Retreive(ArrayList<Habitation>) --> HabitationDAO :");
		HabitationDAO habitationDAO2 = new HabitationDAO();
		ArrayList<Habitation> listeHab = habitationDAO2.retrieve();
		for (Habitation habitation2 : listeHab ){
			System.out.println(habitation2.toString());
		}*/
		
		/*ArrayList<Habitation> listeH = AccesData.getLesHabitations();
		for (Habitation h : listeH){
			ArrayList<Facture> listeF = AccesData.getLesFacturesParHabitation(h.getIdHabitation());
			System.out.println("Pour " + h.getIdHabitation() + " :");
			for (Facture f : listeF){
				System.out.println(f.toString() + "\n");
			}
		}*/
		
		//EditionFacturePdf.testFacture();
		//Find
		/*TypeDechet td = (TypeDechet)s.get(TypeDechet.class, "ver");
		System.out.println(td);*/
		//OK
		
		//Retrieve
		/*ArrayList<TypeDechet> listeDechet = (ArrayList<TypeDechet>) s.createQuery("FROM TypeDechet").list();
		for(TypeDechet tyd : listeDechet){
			System.out.println(tyd);
		} */
		//OK
		
		//Create
		/*TypeDechet td1 = new TypeDechet("pap", "papier", 1);
		Transaction t = s.beginTransaction();
		s.save(td1);
		t.commit();*/
		//OK
		
		/*Date date = new Date(2015-07-22);
		Levee l = new Levee(date, 1200, "pb1", "BM-330-EF", "c120");
		AccesData.ajoutLevee(l);*/ //OK
		
		
		/*ArrayList<Habitation> lesHab = AccesData.getLesHabitations();
		for (Habitation h : lesHab)
		{
			System.out.println(h.toString());
		}*/
		
		//EditionFacturePdf.testFacture();
		/*List<Habitation> listeHabitation = AccesData.getLesHabitationsUsager("usag1");
		  for(Habitation h : listeHabitation)
		  {
			System.out.println(h.toString());
		}*/
		
		
		//Menu Console :
		//MenuConsole.main(args);
		
		
		//test class utilisateur
		/*Utilisateur u = AccesData.utilisateur("lequay", "tyty");
		System.out.println(u.toString());*/
		
		//test liste usagers
		/*List<Usager> listU = new ArrayList<Usager>();
		listU = AccesData.getLesUsagers();
		for(Usager usag : listU){
			System.out.println(usag.toString());
		}*/
	}
}