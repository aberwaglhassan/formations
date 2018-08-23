package com.sid.web;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.dao.EtudiantRepository;
import com.sid.entities.Etudiant;
//ici nous utilisons les annotations JAX-rs
@Component
@Path("/scolarite")
public class EtudiantRestService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@GET
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> listEtudiant(){
		return etudiantRepository.findAll();
	}

	@GET
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Etudiant> getOne(@PathParam(value="id")Long id){
		return etudiantRepository.findById(id);
	}

	@POST
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant save(Etudiant etudiant){
		return etudiantRepository.save(etudiant);
	}

	@PUT
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant update(@PathParam("id")Long id,Etudiant etudiant){
		etudiant.setId(id);
		return etudiantRepository.save(etudiant);
	}

	@DELETE
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  void delete(@PathParam("id")Long id){
		etudiantRepository.deleteById(id);
	}
}
