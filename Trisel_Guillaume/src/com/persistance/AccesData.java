package com.persistance;
import com.metier.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*; 

public class AccesData {
	private static Session s = HibernateSession.getSession();
	/**
	 * @return
	 * ArrayList<Habitation> : retourne la liste de toutes les habitations
	 */
	public static ArrayList<Habitation> getLesHabitations(){ 
		ArrayList<Habitation> listehabitation = (ArrayList<Habitation>) s.createQuery("FROM Habitation").list();
		return listehabitation;
	}
	
	/**
	 * @param l
	 * l : un objet Levee
	 * @return
	 * boolean : true ou false (true si le create à fonctionner, flase sinon)
	 */
	public static boolean ajoutLevee(Levee l){
		boolean retour = false;
		
		Transaction t = s.beginTransaction();
		try{
			s.save(l);
			retour = true;
			t.commit();
		} catch (HibernateException e){
			retour = false;
		}
		return retour;
	}
	
	public static boolean ajoutTypeDechet(TypeDechet typeD){
		boolean retour = false;
		
		Transaction t = s.beginTransaction();
		try{
			s.save(typeD);
			retour = true;
			t.commit();
		} catch (HibernateException e){
			retour = false;
		}
		return retour;
	}
	
	/**
	 * @param f
	 * f : un objet Facture
	 * @return
	 * boolean : true ou false (true si le create à fonctionner, flase sinon)
	 */
	public static boolean ajoutFacture(Facture f){
		boolean retour = false;
		
		try{
			Transaction t = s.beginTransaction();
			s.save(f);
			retour = true;
			t.commit();
		} catch (HibernateException e){
			e.printStackTrace();
		}
		return retour;
	}
	
	public static boolean controleAjoutFacture(Facture f){
		//Vérification que la facture n'existe pas dans la base de données
		boolean ok = false;
		String hql = "from Facture f where f.anF=" + f.getAnF();
		hql = hql + " and f.moisF = " + f.getMoisF();
		hql = hql + " and f.idHabitation = '" + f.getIdHabiattion() + "'";
		Facture existf = (Facture) s.createQuery(hql).uniqueResult();//R'amène 0 ou 1 donc uniqueResult()
		if (existf == null){
		try{
			Transaction t = s.beginTransaction();
			s.save(f);
			t.commit();
			ok = true;
		} catch (HibernateException e){
			e.printStackTrace();
		}
		}
		return ok;
	}
	
	/**
	 * @param idHab
	 * idHab : l'id de l'habitation que l'on veut récupérer dans la base de données
	 * @return
	 * Habitation : retourne l'objet Habitation récupérer
	 */
	public static Habitation getHabitation (String idHab){
		Habitation h = (Habitation)s.get(Habitation.class, idHab);
		return h;
	}
	
	/**
	 * @return
	 * ArrayList<Facture> : retourne la liste de toutes les factures
	 */
	public static ArrayList<Facture> getLesFactures(){
		ArrayList<Facture> listefacture = (ArrayList<Facture>) s.createQuery("FROM Facture").list();
		return listefacture;
	}
	
	public static ArrayList<Facture> getLesFacturesParHabitation(String id){
		ArrayList<Facture> listefacture = (ArrayList<Facture>) s.createQuery("FROM Facture WHERE idHabitation = '"+ id + "'").list();
		return listefacture;
	}
	
	public static double getValeurTarif(int typeTarif) {
		Tarif t = (Tarif)s.get(Tarif.class, typeTarif);
		double valeur = t.getValeurTarf();
		return valeur;
	}
	
	public static List<Habitation> getLesHabitationsUsager(String idUsager) {
		return   s.createQuery("from Habitation h where h.usager.idUsager ='"+ idUsager +"'").list();
	}
	
	public static Utilisateur utilisateur(String login, String mdp){
		return (Utilisateur) s.createQuery("from Utilisateur u where u.login = '"+ login + "' and u.mdp = '" + mdp + "'").uniqueResult();
	}
	public static List<Usager> getLesUsagers() {
		return   s.createQuery("from Usager").list();
	}
	public static List<TypeDechet> getLesTypeDechet() {
		return   s.createQuery("from TypeDechet").list();
	}
	public static boolean updateTarif(TypeDechet typeDechet){
		boolean retour = false;
		try{
			Transaction t = s.beginTransaction();
			s.update(typeDechet);
			retour = true;
			t.commit();
		} catch (HibernateException e){
			e.printStackTrace();
		}
		return retour;
	}
}
