package com.metier;
import javax.persistence.*;

@Entity
@Table(name="facture")
public class Facture {
	@Id
	@Column(name="idFacture")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFacture;
	@Column(name="moisF")
	private int moisF;
	@Column(name="anF")
	private int anF;
	@Column(name="nomFacture")
	private String nomFacture;
	@Column(name="idhabitation")
	private String idHabitation;
	
	public Facture(int idFacture, int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public Facture(int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	
	public Facture(){
		super();
	}
	
	public int getIdFacture() {
		return idFacture;
	}
	public int getMoisF() {
		return moisF;
	}
	public int getAnF() {
		return anF;
	}
	public String getNomFacture() {
		return nomFacture;
	}
	public String getIdHabiattion() {
		return idHabitation;
	}
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", moisF=" + moisF + ", anF=" + anF + ", nomFacture=" + nomFacture
				+ ", idHabitation=" + idHabitation +"]";
	}
}
