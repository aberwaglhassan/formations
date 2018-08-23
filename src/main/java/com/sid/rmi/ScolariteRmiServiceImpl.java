package com.sid.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.dao.EtudiantRepository;
import com.sid.dao.FormationRepository;
import com.sid.entities.Etudiant;
import com.sid.entities.Formation;

@Component
public class ScolariteRmiServiceImpl implements ScolariteRemote{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private FormationRepository formationRepository;
	
	@Override
	public List<Etudiant> listEtudiants() throws RemoteException {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}
	@Override
	public Etudiant getEtudiant(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return etudiantRepository.findById(id).get();
	}
	@Override
	public Formation saveFormation(Formation f) throws RemoteException {
		// TODO Auto-generated method stub
		return formationRepository.save(f);
	}
	
	

}
