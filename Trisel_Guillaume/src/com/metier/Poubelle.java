package com.metier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="poubelle")
public class Poubelle {
	@Id
	@Column(name="idPoubelle")
	private String idPoubelle;
	//
	@Column(name="idHabitation")
	private String idHabitation;
	//
	@ManyToOne
	@JoinColumn(name="idTypeDechet")
	private TypeDechet nature;
	//
	@OneToMany
	@JoinColumn(name="idPoubelle")
	private List<Levee> lesLevees;

	public Poubelle(String idPoubelle, String idHabitation, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.idHabitation = idHabitation;
		this.nature = nature;
		lesLevees = new ArrayList<Levee>();
	}
	public Poubelle(){
		super();
	}

	public String getIdPoubelle() {
		return idPoubelle;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public TypeDechet getNature() {
		return nature;
	}

	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}

	public List<Levee> getLesLevees() {
		return lesLevees;
	}

	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}

	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", nature=" + nature
				+ ", lesLevees=" + lesLevees + "]";
	}
	public boolean addLevee(Levee l){
		boolean retour;
		if (lesLevees.add(l)){
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
	 * @return ArrayList<Levee>
	 * retourne les levées pour ce mois de cette année
	 */
	public ArrayList<Levee> getLesLevees(int an, int mois){
		ArrayList<Levee> lesLeveesAnMois = new ArrayList<Levee>();
		Calendar date = Calendar.getInstance();
		int year;
		int month;
		for (Levee l : lesLevees){
			date.setTime(l.getLaDate());
			year = date.get(Calendar.YEAR);
			month = date.get(Calendar.MONTH) +1 ;
			if ((year == an) && (month == mois)){
				lesLeveesAnMois.add(l);
			}
		}
		return lesLeveesAnMois;
	}
	/**
	 * @param an
	 * correspond à l'année des levées qui nous intéressent
	 * @param mois
	 * correspond au mois des levées qui nous intéressent
	 * @return double
	 * retourne le total du cout entre le poids de la levée * par le prix (de la nature du déchet)
	 */
	public double getCout(int an, int mois){
		double cout = 0;
		ArrayList<Levee> listelevee = this.getLesLevees(an, mois);
		for (Levee l : listelevee){
			cout = cout + l.getPoids()*nature.getTarif();
		}
		return cout;
	}
}
