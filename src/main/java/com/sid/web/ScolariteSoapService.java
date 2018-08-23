package com.sid.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.dao.EtudiantRepository;
import com.sid.dao.FormationRepository;
import com.sid.entities.Etudiant;
import com.sid.entities.Formation;

//il faut utiliser ll a nnotation component pour que ce composant soit deployer sur spring car sinon il ne sera ps injecter
//1 pour que ce soit un web service utiliser la notations jax-ws WEBSERVICE===>SOAP

@Component
@WebService
public class ScolariteSoapService {

	//je fait appel a etudiantrepository car j ai besoin de faire appel au donnée de la couche dao

	@Autowired
	private EtudiantRepository etudiantRepository;

	//pour faire a ppel au donnée formation repopsitory couche dao

	@Autowired
	private FormationRepository formationRepository;

	//je consulte une liste qui contient des etudiant
	//2 les methodes doivent utiliser l'annotation @webmethod pour qu'il fasse partis de WSDL
	//et on specifie l operation avec operationName

	@WebMethod(operationName="listeEtudiabts")
	public List<Etudiant> list(){
		return etudiantRepository.findAll();
	}

	//consulter un etudiant
	@WebMethod(operationName="UnSeulparId")
	public Etudiant getOne(@WebParam(name="id") Long id) {
		//il a fallut ajouter .get() pour faire marcher findbyid
		return etudiantRepository.findById(id).get();
	}

	//inscrire(ajouter) une formation
	@WebMethod
	public Formation save(@WebParam(name="formation")Formation f) {

		return formationRepository.save(f);
	}

}
