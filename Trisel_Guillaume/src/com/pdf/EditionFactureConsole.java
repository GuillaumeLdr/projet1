package com.pdf;

import java.text.*;
import java.util.*;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.AccesData;

public class EditionFactureConsole {
	
	public static void testFacture() {
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		if (lesHabitations.size() != 0) {
			for(Habitation h : lesHabitations) {
				EditionFacturePdf.editionElementfacture(h, 2015, 7) ;
			}
		}
	}
	
	
	public static void editionElementfacture(Habitation h, int an, int mois) {
		//VAR
		
		//USAGER
		String nomUsager;
		String prenomUsager;
		String adresseRueUsager;
		String adresseVilleUsager;
		String cpUsager;
		String idUsager;
		
		//LOGEMENT
		String adresseRueH;
		String adresseVilleH;
		String cpH;
		int nbrPersonne;
		
		//TARIF
		double tauxPartFixe;
		
		//POUBELLE
		String idPoubelle;
		String libelleNature;
		
		//LEVEE
		Date datePesee;
		double poids;
		
		//TYPE DECHET
		double prix;
		
		//DEBUT
		Date laDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy"); 
		String date = formatter.format(laDate);
		System.out.println(date + "\n");
		
		nomUsager = h.getUsager().getNom();
		prenomUsager = h.getUsager().getPrenom();
		adresseRueUsager = h.getUsager().getAdrRueUsager();
		adresseVilleUsager = h.getUsager().getAdrVilleUsager();
		cpUsager = h.getUsager().getCpUsager();
		idUsager = h.getUsager().getIdUsager();
		
		System.out.println("Usager concern� : ");
		System.out.println(nomUsager + " " + prenomUsager + "\n" + adresseRueUsager + "\n" + cpUsager + " " + adresseVilleUsager);
		
		
		adresseRueH = h.getAdrRueHab();
		adresseVilleH = h.getAdrVilleHab();
		cpH = h.getCpHab();
		
		System.out.println("Adresse du logement concern� : ");
		System.out.println(adresseRueH + "\n" + cpH + " " + adresseVilleH + "\n");
		
		nbrPersonne = h.getNbPersonne();
		
		System.out.println("Code Usager : " + idUsager);
		System.out.println("Nombre de personne d�clar�es : " + nbrPersonne + "\n");
		
		tauxPartFixe = AccesData.getValeurTarif(1);
		int taux = (int) tauxPartFixe;
		int TotalHtTaux = taux * nbrPersonne;
		
		System.out.println("******************************************************************************");
		System.out.println("Taux part fixe           Nombre de personnes                         Total HT");
		System.out.println("      " + tauxPartFixe + "                           " + nbrPersonne + "                                     " + TotalHtTaux);
		System.out.println("******************************************************************************");
		System.out.println("//////////////////////////////////////////////////////////////////////////////");
		
		List<Poubelle> listePoubelle = h.getLesPoubelles();
		for (Poubelle p : listePoubelle){
			idPoubelle = p.getIdPoubelle();
			libelleNature = p.getNature().getLibelle();
			prix = p.getNature().getTarif();
			List<Levee> listeLevee = p.getLesLevees();
			for (Levee l : listeLevee){
				datePesee = l.getLaDate();
				poids = l.getPoids();
				double TotalHTPb = poids * prix;
				double coutTotalHT = p.getCout(an, mois);
				
				System.out.println("******************************************************************************");
				System.out.println("    Poubelle : " + idPoubelle + " // Nature des d�chets : " + libelleNature);
				System.out.println("******************************************************************************");
				System.out.println("Date de pes�e    **    nombre de kg    **    prix HT au kg    **    total HT  ");
				System.out.println("******************************************************************************");
				System.out.println("    " + datePesee + "              " + poids + "                 " + prix + "              " + TotalHTPb);
				System.out.println("******************************************************************************");
				System.out.println("                                                     total HT : " + coutTotalHT);
				System.out.println("******************************************************************************");
				System.out.println("//////////////////////////////////////////////////////////////////////////////");
				
			}
		}
		double coutTotalHtHab = h.getCout(an, mois) + TotalHtTaux;
		double tva = coutTotalHtHab * 0.20;
		double Total�Payer = coutTotalHtHab + tva;
		
		System.out.println("******************************************************************************");
		System.out.println("Total HT : " + coutTotalHtHab);
		System.out.println("******************************************************************************");
		System.out.println("Montant TVA : " + tva);
		System.out.println("******************************************************************************");
		System.out.println("Total � payer : " + Total�Payer);
		System.out.println("****************************************************************************** \n \n");
	}
}
