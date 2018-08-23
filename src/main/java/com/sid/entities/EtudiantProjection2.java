package com.sid.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

public interface EtudiantProjection2 {

	@Projection(name="p2",types= {Etudiant.class})
	public interface EtudiantProjection {

		@Value("#{target.nom} #{target.prenom}")
	
		public String getFullName();
		
	}

}
