package com.pdf;

import java.text.*;
import java.util.*;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.AccesData;
import com.persistance.HibernateSession;
import com.util.Parametre;

public class EditionFacturePdf {
	private static Session s = HibernateSession.getSession();
	/**
	 * Vérifie qu'il existe des habitations
	 */
	public static void generateFacture(int an, int mois) {
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		if (lesHabitations.size() != 0) {
			for(Habitation h : lesHabitations) {
				EditionFacturePdf.editionElementfacture(h, an, mois) ;
			}
		}
	}
	
	/**
	 * @param h
	 * correspond à l'objet Habitation.
	 * @param an
	 * correspond à l'année qui nous intéressent
	 * @param mois
	 * correspond au mois qui nous intéressent
	 */
	public static void editionElementfacture(Habitation h, int an, int mois) {
		//CREATION PDF
		Document pdf = new Document();
		try {
			PdfWriter.getInstance(pdf, new FileOutputStream(Parametre.getCheminFichier(h, mois, an)));
			pdf.open();
		
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
			
			//pour la date système
			Paragraph dateSystem = new Paragraph(date);
			dateSystem.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(dateSystem);
			//pour l'image
			Image logo = Image.getInstance("Trisel.jpg");
			pdf.add(logo);
			
			//pour les infos de l'usager
			nomUsager = h.getUsager().getNom();
			prenomUsager = h.getUsager().getPrenom();
			adresseRueUsager = h.getUsager().getAdrRueUsager();
			adresseVilleUsager = h.getUsager().getAdrVilleUsager();
			cpUsager = h.getUsager().getCpUsager();
			idUsager = h.getUsager().getIdUsager();
			
			
			Phrase nomPrenomUsagerPdf = new Phrase(nomUsager + " " + prenomUsager);
			Paragraph nomPrenomUsager = new Paragraph(nomPrenomUsagerPdf);
			nomPrenomUsager.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(nomPrenomUsager);
			
			Paragraph adrRUsagerPdf = new Paragraph(adresseRueUsager);
			adrRUsagerPdf.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(adrRUsagerPdf);
			
			Phrase cpVilleUsagerPdf = new Phrase(cpUsager + " " + adresseVilleUsager);
			Paragraph cpVilleUsager = new Paragraph(cpVilleUsagerPdf);
			cpVilleUsager.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(cpVilleUsager);
			
			
			//Pour le logement
			adresseRueH = h.getAdrRueHab();
			adresseVilleH = h.getAdrVilleHab();
			cpH = h.getCpHab();
			
			Phrase logement = new Phrase("Adresse du logement concerné : ");
			pdf.add(logement);
			Paragraph espace = new Paragraph("\n");
			pdf.add(espace);
			Phrase adrRlogement = new Phrase(adresseRueH);
			Paragraph adrRlogementPdf = new Paragraph(adrRlogement);
			pdf.add(adrRlogementPdf);
			Phrase cpVilleLogement = new Phrase(cpH + " " + adresseVilleH);
			Paragraph cpVilleLogementPdf = new Paragraph(cpVilleLogement);
			pdf.add(cpVilleLogementPdf);
			
			nbrPersonne = h.getNbPersonne();
			
			pdf.add(espace);
			
			Paragraph codeU = new Paragraph("Code Usager : " + idUsager);
			pdf.add(codeU);
			Phrase nbPersonne = new Phrase("Nombre de personnes déclarées : " + nbrPersonne);
			pdf.add(nbPersonne);
			
			pdf.add(espace);
			
			
			//Créer Tableau
			pdf.add(espace);
			//pour partTauxFixe
			tauxPartFixe = AccesData.getValeurTarif(1);
			int taux = (int) tauxPartFixe;
			int TotalHtTaux = taux * nbrPersonne;
			
			PdfPTable tableT = new PdfPTable (3);
			
			PdfPCell cell1 = new PdfPCell (new Paragraph("Taux part fixe"));
			PdfPCell cell2 = new PdfPCell (new Paragraph("Nombre de personnes"));
			PdfPCell cell3 = new PdfPCell (new Paragraph("Total HT"));
			
			cell1.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			cell2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			cell3.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableT.addCell (cell1);
			tableT.addCell (cell2);
			tableT.addCell (cell3);

			PdfPCell cell1V = new PdfPCell (new Paragraph(" "+tauxPartFixe));
			PdfPCell cell2V = new PdfPCell (new Paragraph(" "+nbrPersonne));
			PdfPCell cell3V = new PdfPCell (new Paragraph(" "+TotalHtTaux));
			
			cell1V.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			cell2V.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			cell3V.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableT.addCell (cell1V);
			tableT.addCell (cell2V);
			tableT.addCell (cell3V);
					
			pdf.add (tableT);
				
			List<Poubelle> listePoubelle = h.getLesPoubelles();
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			for (Poubelle p : listePoubelle){
				idPoubelle = p.getIdPoubelle();
				libelleNature = p.getNature().getLibelle();
				prix = p.getNature().getTarif();
				List<Levee> listeLevee = p.getLesLevees();
				
				pdf.add(espace);
				pdf.add(espace);
				
				//Tableau pour poubelle
				PdfPTable tableP = new PdfPTable (4);
				
				PdfPCell cell1P = new PdfPCell(new Phrase("Poubelle : " + idPoubelle + " Nature des déchets : " + libelleNature));			
				cell1P.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
				cell1P.setColspan(4);

				tableP.addCell (cell1P);
				
				PdfPCell cell1PEntete = new PdfPCell (new Phrase("Dateb de pesée"));
				PdfPCell cell2PEntete = new PdfPCell (new Phrase("nombre de kg"));
				PdfPCell cell3PEntete = new PdfPCell (new Phrase("prix HT au kg"));
				PdfPCell cell4PEntete = new PdfPCell (new Phrase("total HT"));
				cell1PEntete.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
				cell2PEntete.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
				cell3PEntete.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
				cell4PEntete.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);

				tableP.addCell (cell1PEntete);
				tableP.addCell (cell2PEntete);
				tableP.addCell (cell3PEntete);
				tableP.addCell (cell4PEntete);
				
				pdf.add (tableP);
				
				
				
				double coutTotalHT = p.getCout(an, mois);
				
				
				for (Levee l : listeLevee){
					datePesee = l.getLaDate();
					poids = l.getPoids();
					double TotalHTPb = poids * prix;
					SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
					
					PdfPTable tablePValeur = new PdfPTable (4);
					
					PdfPCell cell1PValeur = new PdfPCell (new Phrase(" " + formatDate.format(datePesee)));
					PdfPCell cell2PValeur = new PdfPCell (new Phrase(" " + poids));
					PdfPCell cell3PValeur = new PdfPCell (new Phrase(" " + prix));
					PdfPCell cell4PValeur = new PdfPCell (new Phrase(" " + df.format(TotalHTPb)));
					cell1PValeur.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					cell2PValeur.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					cell3PValeur.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					cell4PValeur.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					tablePValeur.addCell (cell1PValeur);
					tablePValeur.addCell (cell2PValeur);
					tablePValeur.addCell (cell3PValeur);
					tablePValeur.addCell (cell4PValeur);
					pdf.add (tablePValeur);
					
				}
				PdfPTable tablePTotal = new PdfPTable (4);
				
				PdfPCell cell1PTotal = new PdfPCell (new Phrase("total HT"));
				PdfPCell cell2PTotal = new PdfPCell (new Phrase(" " + df.format(coutTotalHT)));
				cell1PTotal.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
				cell2PTotal.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);

				cell1PTotal.setColspan(3);
				
				tablePTotal.addCell (cell1PTotal);
				tablePTotal.addCell (cell2PTotal);

				pdf.add (tablePTotal);
			}
			double coutTotalHtHab = h.getCout(an, mois) + TotalHtTaux;
			double tva = coutTotalHtHab * 0.20;
			double TotalaPayer = coutTotalHtHab + tva;
			
			pdf.add(espace);
			pdf.add(espace);
			
			//Tableau pour total 
			
			PdfPTable tableTotal = new PdfPTable(4);
			
			PdfPCell cellule1 = new PdfPCell (new Phrase("TotalHT"));
			PdfPCell cellule2 = new PdfPCell (new Phrase(" " + df.format(coutTotalHtHab)));
			
			PdfPCell cellule3 = new PdfPCell (new Phrase("Montant TVA"));
			PdfPCell cellule4 = new PdfPCell (new Phrase(" " + df.format(tva)));
			
			PdfPCell cellule5 = new PdfPCell (new Phrase("Total à payer"));
			PdfPCell cellule6 = new PdfPCell (new Phrase(" " + df.format(TotalaPayer)));
			
			cellule1.setColspan(3);
			cellule1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cellule2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			cellule3.setColspan(3);
			cellule3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cellule4.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			cellule5.setColspan(3);
			cellule5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cellule6.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableTotal.addCell (cellule1);
			tableTotal.addCell (cellule2);
			tableTotal.addCell (cellule3);
			tableTotal.addCell (cellule4);
			tableTotal.addCell (cellule5);
			tableTotal.addCell (cellule6);

			pdf.add (tableTotal);
			
			pdf.close();
			Runtime.getRuntime().exec("explorer.exe " + Parametre.getCheminFichier(h, mois, an));
			Facture f = new Facture (mois, an, Parametre.getNomFichier(h, mois, an), h.getIdHabitation());
			if (AccesData.controleAjoutFacture(f)){
				AccesData.ajoutFacture(f);
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
