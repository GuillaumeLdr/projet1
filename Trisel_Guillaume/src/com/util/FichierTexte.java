package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author ledoare-g
 *
 */
public class FichierTexte {
	// buffer de lecture
	private BufferedReader br;
	// buffer d'�criture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	// ouverture du fichier en lecture
	/**
	 * Ouvre un fichier texte en lecture
	 * @param nom
	 * On donne le nom du fichier concern�
	 * @return boolean
	 * � true si l'ouverture du fichier a r�ussi, false sinon
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// ouverture du fichier en �criture
	/**
	 * Ouvre un fichier texte en �criture
	 * @param nom
	 * On donne le nom du fichier concern�
	 * @return boolean
	 * � true si l'ouverture du fichier a r�ussi, false sinon
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// fermeture du flux d'�criture
	/**
	 * Fermeture du fichier ouvert en �criture
	 * @return boolean
	 * � true si la fermeture du fichier a r�ussi, false sinon
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
// fermeture du flux de lecture
	/**
	 * Fermeture du fichier texte ouvert en lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	// �criture d'une ligne
	/**
	 * �crire une ligne dans un fichier texte
	 * @param ligne
	 * On donne la ligne a �crire en param�tre
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	// lecture d'une ligne
	/**
	 * Lire une ligne du fichier texte
	 * @return String
	 * Retourne la ligne lu
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}