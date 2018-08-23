package com.sid.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types= {Etudiant.class})
public interface EtudiantProjection1 {

	public Long getId();
	public String getNom();
	public Formation getFormation();
}
