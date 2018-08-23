package com.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Etudiant implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;

	@ManyToOne
	private Formation formation;



	public Etudiant(Long id, String nom, String penom, Formation formation) {

		this.id = id;
		this.nom = nom;
		this.prenom = penom;
		this.formation = formation;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}



}
