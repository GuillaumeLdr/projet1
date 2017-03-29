package com.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;
import com.persistance.AccesData;

import java.util.List;
import java.io.File;
import java.io.IOException;

/**
 * @author ledoare-g
 *
 */
public class InsertionLevee {
	/**
	 * Ouvre et lit le fichier texte
	 * @param nomFichier
	 * On donne le nom du fichier texte concerné
	 */
	public static void TraitementFichierTexte(String nomFichier) {
		// Instanciation objet Fichier Texte
		FichierTexte fichier = new FichierTexte();

		// Affectation au fichier physique passé en paramètre
		boolean ouvrirFichier = fichier.openFileReader(nomFichier);
		Date laDate = null;
		double poids = 0;
		String codePoubelle = "";
		if (ouvrirFichier) {

			// On récupère la 1ère ligne
			String ligne = fichier.readLigne();
			// On split la ligne dans un tableau de chaines avec le séparateur
			// ":"
			String[] part = ligne.split(":");

			// Format de la date en français
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				laDate = formatter.parse(part[2]);
				while ((ligne = fichier.readLigne()) != null) {
					String[] partLevee = ligne.split(":");
					// Parcours des lignes levee
					codePoubelle = partLevee[0];
					poids = Double.parseDouble(partLevee[1]);
					
					Levee levee = new Levee(laDate, poids, codePoubelle, part[0], part[1]);
					if (AccesData.ajoutLevee(levee)){
						System.out.println("Insertion réussi");
					}
					else{
						System.out.println("Échec insertion");
					}
				}
				// Conversion de la date chaine en date Date java.util
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		fichier.closeFileReader();
	}

	/**
	 * Lire un fichier XML
	 * @param nomFichier
	 * On donne le nom du fichier concerné
	 */
	public static void traitementFichierXml(String nomFichier) {
		// déclaration document xml
		Document document = null;
		// déclaration élément racine
		Element racine = null;
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		//VAR
		Date laDate = null;
		String immatriculation = "";
		String codeChauffeur = "";
		String codePoubelle = "";
		double poids = 0;
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File(nomFichier));
			// On initialise un nouvel élément racine avec l'élément racine du
			// document.
			racine = document.getRootElement();
			// parcours
			immatriculation = racine.getChild("immatriculation").getText();
			codeChauffeur = racine.getChild("codechauffeur").getText();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			List<Element> listLevee = racine.getChildren("levee");
			try {
				laDate = formatter.parse(racine.getChild("date").getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			for (Element e : listLevee) {
				codePoubelle = e.getChild("poubelle").getText();
				poids = Double.parseDouble(e.getChild("poids").getText());
				
				Levee levee = new Levee(laDate, poids, codePoubelle, immatriculation, codeChauffeur);
				if (AccesData.ajoutLevee(levee)){
					System.out.println("Insertion réussi");
				}
				else{
					System.out.println("Échec insertion");
				}
			}
		} catch (JDOMException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	/**
	 * Méthode pour transférez des fichiers par rapport à leur extension
	 */
	public static void TraitementLevee(){
		//var : on récupère les chemins des dossiers
		String cheminAtraiter = Parametre.getCheminLeveeATraiter();
		String cheminLog = Parametre.getCheminLeveeLog();
		String cheminTraites = Parametre.getCheminLeveeTraites();
		
		File f = new File(cheminAtraiter);
		//On regarde si il y a des fichiers dans le dossier
		if ((f.list()) == null){
		} 
		else{
			File[] listFichier = f.listFiles();
			//Ensuite on parcours chaque fichier du dossier pour 
			for (File fichier : listFichier){
				//vérifiez si c'est bien un fichier et pas un autre dossier
				if (fichier.isFile()){
					//récupérez son extension
					String extensionFichier = Parametre.getExtensionFichier(fichier.getAbsolutePath());
					//par rapport à son extension plusieurs cas :
					switch(extensionFichier){
					//cas .txt : On utilise la fonction LireFichierTexte et on transfère le fichier dans le dossier traites
					case ("txt") : InsertionLevee.TraitementFichierTexte(fichier.getAbsolutePath());
									if (Parametre.transfertFichier(fichier, cheminTraites)){
									}
									else{
									}
						break;
					//cas .xml : On utilise la fonction traitementFichierXml et on transfère le fichier dans le dossier traites
					case ("xml") : InsertionLevee.traitementFichierXml(fichier.getAbsolutePath());
									if (Parametre.transfertFichier(fichier, cheminTraites)){
									}
									else{
									}
						break;
					//Si l'extension est ni en .txt ni en .xml c'est que le fichier à une autre extension (.docx par exemple) On le transfert dans le dossier log
					default :
								if (Parametre.transfertFichier(fichier, cheminLog)){
								}
								else{
								}
						break;
					}
				}
				else {
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}