package com.metier;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usager")
public class Usager {
	@Id
	@Column(name="idUsager")
	private String idUsager;
	//
	@Column(name="nom")
	private String nom;
	//
	@Column(name="prenom")
	private String prenom;
	//
	@Column(name="adrRueUsager")
	private String adrRueUsager;
	//
	@Column(name="cpUsager")
	private String cpUsager;
	//
	@Column(name="adrVilleUsager")
	private String adrVilleUsager;
	//
	/*@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Habitation> lesHabitations;*/
	
	public Usager(String idUsager, String nom, String prenom, String adrRueUsager, String cpUsager,
			String adrVilleUsager) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adrRueUsager = adrRueUsager;
		this.cpUsager = cpUsager;
		this.adrVilleUsager = adrVilleUsager;
		//lesHabitations = new ArrayList<Habitation>();
	}
	
	public Usager(){
		super();
	}

	public String getIdUsager() {
		return idUsager;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdrRueUsager() {
		return adrRueUsager;
	}

	public void setAdrRueUsager(String adrRueUsager) {
		this.adrRueUsager = adrRueUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public String getAdrVilleUsager() {
		return adrVilleUsager;
	}

	public void setAdrVilleUsager(String adrVilleUsager) {
		this.adrVilleUsager = adrVilleUsager;
	}

	/*public List<Habitation> getLesHabitations() {
		return lesHabitations;
	}

	public void setLesHabitations(ArrayList<Habitation> lesHabitations) {
		this.lesHabitations = lesHabitations;
	}*/

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager
				+ ", cpUsager=" + cpUsager + ", adrVilleUsager=" + adrVilleUsager + "]";
	}
	
	//Méthode
	//AjoutHabitation
	/**
	 * @param h
	 * correspond à l'onjet Habitation que l'on veut ajouter à la base de données
	 * @return boolean
	 * retourne true ou false : true si l'ajout à fonctionner false sinon
	 */
	/*public boolean AjoutHabitation(Habitation h){
		boolean retour;
		if (lesHabitations.add(h)){
			retour = true;
		}
		else{
			retour = false;
		}
		return retour;
	}*/
	
	//SupprimerHabitation
	/**
	 * @param h
	 * correspond à l'objet Habitation que l'on veut supprimer
	 * @return boolean.
	 * retourne true ou false : true si l'ajout à fonctionner false sinon
	 */
	/*public boolean SupprimerHabitation(Habitation h){
		boolean retour;
		if (lesHabitations.remove(h)){
			retour = true;
		}
		else{
			retour = false;
		}
		return retour;
	}*/
}
