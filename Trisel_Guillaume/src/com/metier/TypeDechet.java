package com.metier;
import javax.persistence.*;

@Entity
@Table(name="typedechet")

public class TypeDechet {
	@Id
	@Column(name="idTypeDechet")
	private String idTypeDechet;
	@Column(name="libelle")
	private String libelle;
	@Column(name="tarif")
	private double tarif;
	
	public TypeDechet(String idTypeDechet, String libelle, double tarif) {
		super();
		this.idTypeDechet = idTypeDechet;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	
	public TypeDechet(){
		super();
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getIdTypeDechet() {
		return idTypeDechet;
	}
	
	public void setIdTypeDechet(String idTypeDechet) {
		this.idTypeDechet = idTypeDechet;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "TypeDechet [idTypeDechet=" + idTypeDechet + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
	
}
