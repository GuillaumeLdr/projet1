package com.metier;
import javax.persistence.*;

// test

@Entity
@Table(name="tarif")
public class Tarif {
	@Id
	@Column(name="typeTarif")
	private int typeTarif;
	@Column(name="libelle")
	private String libelleTarif;
	@Column(name="valeur")
	private double valeurTarf;
	
	public int getTypeTarif() {
		return typeTarif;
	}
	public void setTypeTarif(int typeTarif) {
		this.typeTarif = typeTarif;
	}
	public String getLibelleTarif() {
		return libelleTarif;
	}
	public void setLibelleTarif(String libelleTarif) {
		this.libelleTarif = libelleTarif;
	}
	public double getValeurTarf() {
		return valeurTarf;
	}
	public void setValeurTarf(double valeurTarf) {
		this.valeurTarf = valeurTarf;
	}
	@Override
	public String toString() {
		return "Tarif [typeTarif=" + typeTarif + ", libelleTarif=" + libelleTarif + ", valeurTarf=" + valeurTarf + "]";
	}
	
}
