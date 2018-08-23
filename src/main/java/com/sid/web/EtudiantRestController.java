package com.sid.web;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.EtudiantRepository;
import com.sid.entities.Etudiant;
//ici nous utilisons les annotations REST CONTROLLER
//attention on a plus utilisé le path scolarite donc directelment /etudiants

//@RestController
public class EtudiantRestController {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@GetMapping("/etudiants")

	public List<Etudiant> listEtudiant(){
		return etudiantRepository.findAll();
	}


	@GetMapping("/etudiants/{id}")
	//ici @PathParam deviens PathVariable et variable deviens name
	public Optional<Etudiant> getOne(@PathVariable(name="id")Long id){
		return etudiantRepository.findById(id);
	}


	@PostMapping("/etudiants")
	//ici comme c 'est une requet post on indique qu'il faut recuprer les donnés du cors de la requete avec 
	//@RequestBody
	public Etudiant save(@RequestBody Etudiant etudiant){
		return etudiantRepository.save(etudiant);
	}


	@PutMapping("/etudiants/{id}")

	//tjrs avec le name de path variable et request body 
	public Etudiant update(@PathVariable(name="id")Long id,@RequestBody Etudiant etudiant){
		etudiant.setId(id);
		return etudiantRepository.save(etudiant);
	}


	@DeleteMapping("/etudiants/{id}")

	public  void delete(@PathVariable("id")Long id){
		etudiantRepository.deleteById(id);
	}
}
