package com.metier;
import javax.persistence.*;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@Column(name="idUtilisateur")
	private String id;
	@Column(name="nomUtilisateur")
	private String nom;
	@Column(name="prenomUtilisateur")
	private String prenom;
	@Column(name="login")
	private String login;
	@Column(name="mdp")
	private String mdp;
	@Column(name="niveau")
	private int niveau;
	
	public Utilisateur(String id, String nom, String prenom, String login, String mdp, int niveau) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.niveau = niveau;
	}
	
	public Utilisateur() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp
				+ ", niveau=" + niveau + "]";
	}
}
