package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="habitation")
public class Habitation {
	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	//
	@Column(name="adrRueHab")
	private String adrRueHab;
	//
	@Column(name="cpHab")
	private String cpHab;
	//
	@Column(name="adrVilleHab")
	private String adrVilleHab;
	//
	@Column(name="nbPersonne")
	private int nbPersonne;
	//
	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	//
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Poubelle> lesPoubelles;
	
	public Habitation(String idHabitation, String adrRueHab, String cpHab, String adrVilleHab, int nbPersonne, Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adrRueHab;
		this.cpHab = cpHab;
		this.adrVilleHab = adrVilleHab;
		this.nbPersonne = nbPersonne;
		this.usager = usager;
		lesPoubelles = new ArrayList<Poubelle>();
	}
	
	public Habitation(){
		super();
	}

	public String getAdrRueHab() {
		return adrRueHab;
	}

	public void setAdrRueHab(String adrRueHab) {
		this.adrRueHab = adrRueHab;
	}

	public String getCpHab() {
		return cpHab;
	}

	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}

	public String getAdrVilleHab() {
		return adrVilleHab;
	}

	public void setAdrVilleHab(String adrVilleHab) {
		this.adrVilleHab = adrVilleHab;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getIdHabitation() {
		return idHabitation;
	}
	
	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public List<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}
	public int getCountLesPoubelles() {
		return lesPoubelles.size();
	}

	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}

	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adrRueHab=" + adrRueHab + ", cpHab=" + cpHab
				+ ", adrVilleHab=" + adrVilleHab + ", nbPersonne=" + nbPersonne + ", usager=" + usager
				+ ", lesPoubelles=" + lesPoubelles + "]";
	}
	/**
	 * @param p
	 * correspond à l'objet poubelle que l'on veut ajouter
	 * @return boolean
	 * retourne true ou false : true si l'ajout à fonctionner false sinon
	 */
	public boolean addPoubelle(Poubelle p){
		boolean retour;
		if (lesPoubelles.add(p)){
			retour = true;
		}
		else{
			retour = false;
		}
		return retour;
	}
	/**
	 * @param an
	 * correspond à l'année des levées qui nous intéressent
	 * @param mois
	 * correspond au mois des levées qui nous intéressent
	 * @return double
	 * retourne le total des couts des poubelles
	 */
	public double getCout(int an, int mois){
		double cout = 0;
		for (Poubelle p : lesPoubelles){
			cout = cout + p.getCout(an, mois);
		}
		return cout;
	}
}
