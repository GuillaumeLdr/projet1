package com.util;
import java.io.File;

import com.metier.Habitation;

/**
 * @author ledoare-g
 *
 */
public class Parametre {
	private static String nomFichier = "paramAppli.ini";
	private static final String tabMois[] = {"","Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
	
	public static String getNomFichier(Habitation hab, int mois, int an)
	{
		String nomFichier = hab.getIdHabitation()+"-"+hab.getUsager().getIdUsager()+"-"+"Facture"+"-"+tabMois[mois]+"-"+an+".pdf";
		return nomFichier;
	}
	
	public static String getCheminFichier(Habitation hab, int mois, int an){
		String nomDossier = Parametre.getCheminFacturePdf() + "\\" + tabMois[mois];
		String nomFichier = getNomFichier(hab, mois, an);
		String cheminComplet = nomDossier + "\\" + nomFichier;
		return cheminComplet;
	}
	/**
	 * Lire le fichier param�tre(.ini)
	 * @param n
	 * On donne le nombre ligne que l'on veut lire
	 * @return String
	 * Retourne la derni�re ligne lue
	 */
	public static String LireFichierParametre(int n) {
		FichierTexte fichierParam = new FichierTexte();
		fichierParam.openFileReader(nomFichier);
		String ligne = null;
		for (int i = 0 ; i < n ; i ++){
			ligne = fichierParam.readLigne();
		}
		fichierParam.closeFileReader();
		return ligne;
	}
	/**
	 * Retourne la ligne du fichier param�tre voulue
	 * @return String
	 * Retourne la ligne
	 */
	public static String getCheminBd(){
		return LireFichierParametre(2);
	}
	/**
	 * Retourne la ligne du fichier param�tre voulue
	 * @return String
	 * Retourne la ligne
	 */
	public static String getCheminLeveeATraiter() {
		return LireFichierParametre(4);
	}
	/**
	 * Retourne la ligne du fichier param�tre voulue
	 * @return String
	 * Retourne la ligne
	 */
	public static String getCheminLeveeLog() {
		return LireFichierParametre(10);
	}
	/**
	 * Retourne la ligne du fichier param�tre voulue
	 * @return String
	 * Retourne la ligne
	 */
	public static String getCheminLeveeTraites() {
		return LireFichierParametre(6);
	}
	/**
	 * Retourne la ligne du fichier param�tre voulue
	 * @return String
	 * Retourne la ligne
	 */
	public static String getCheminFacturePdf() {
		return LireFichierParametre(8);
	}
	/**
	 * R�cup�rer l'extension du fichier pass� en param�tre
	 * @param nomFichier
	 * On donne le nom du fichier concern�
	 * @return String
	 * On retourne l'extension du fichier
	 */
	public static String getExtensionFichier(String nomFichier){
		String[] extension = nomFichier.split("\\.");
		return extension[1];
	}
	//Fonction pour transf�rez un fichier dans un autre dossier
	/**
	 * On r�cup�re le chemin de destination est on le recompose avec le nom du fichier source et un \
	 * @param source
	 * Le nom du fichier que l'on veut d�placer
	 * @param destination
	 * le chemin du dossier de destination pour le fichier
	 * @return boolean
	 * Retourne true ou false celon si le transfert a fonctionner
	 */
	public static boolean transfertFichier(File source, String destination){
		//On r�cup�re le chemin de destination est on le recompose avec le nom du fichier source et un \
		destination = destination + "\\" + source.getName();
		File cheminDestination = new File(destination);
		if (source.renameTo(cheminDestination)){
			return true;
		}
		else {
			return false;
		}
	}
	// ram�ne le nombre de fichiers du dossier atraiter
		public static int  nbLevee() {
			String cheminLevee = getCheminLeveeATraiter();
			File f = new File(cheminLevee);
			return f.listFiles().length; 
		}
}