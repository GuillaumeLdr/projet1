package com.util;

import java.io.File;
import java.util.*;
import com.metier.*;
import com.pdf.EditionFacturePdf;
import com.persistance.AccesData;

public class Traitement {
	public static void Insertion(){
		String cheminAtraiter = Parametre.getCheminLeveeATraiter();
		File f = new File(cheminAtraiter);
		if (f.list().length == 0){
			System.out.println("Aucun fichier � traiter");
		}
		else{
			System.out.println("Il y a " + f.list().length + " fichier(s) � traiter :");
			for (String file : f.list()){
				System.out.println(file);
			}
			System.out.println("Traitement en cours : ...");
			InsertionLevee.TraitementLevee();
			System.out.println("Traitement termin�");
		}
	}
	
	public static void Facturation(){
		int ann�e = 0;
		int mois = 0;
		Scanner in=new Scanner(System.in);
		ArrayList<Habitation> listeHab = AccesData.getLesHabitations();
		if (listeHab.size() == 0){
			System.out.println("Il n'y a pas d'habitation ! ");
		}
		else{
			System.out.println("Veuillez saisir l'ann�e et le mois :");
			System.out.println("L'ann�e : ");
			ann�e = in.nextInt();
			System.out.println("Le mois : ");
			mois = in.nextInt();
			System.out.println("Traitement en cours : ...");
			EditionFacturePdf.generateFacture(ann�e, mois);
			System.out.println("Traitement termin�");
		}
	}
}
