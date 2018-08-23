package com.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Formation implements Serializable {

	@Id @GeneratedValue
	private Long id;
	private String Nom;
	private int duree;

	@OneToMany(mappedBy="formation")
	@JsonIgnore//pour jaxson seulement plus bas l equivalent pour soap @XmlTransient avec plus haut @XmlAccessor(XmlAccessType.FIELD) pour indiquer a jax que mes annontation sur les chanmp et pas sur les getters et setters sinon on met XmlTransient sur ses dernier
	@XmlTransient
	private Collection<Etudiant> etudiants;



	public Formation(Long id, String nom, int duree, Collection<Etudiant> etudiants) {

		this.id = id;
		Nom = nom;
		this.duree = duree;
		this.etudiants = etudiants;
	}

	public Formation() {
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
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


}
