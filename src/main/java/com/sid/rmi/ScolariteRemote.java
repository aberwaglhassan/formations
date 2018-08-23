package com.sid.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.sid.entities.Etudiant;
import com.sid.entities.Formation;

public interface ScolariteRemote extends Remote {

	public List<Etudiant> listEtudiants() throws RemoteException;
	public Etudiant getEtudiant(Long id) throws RemoteException;
	public Formation saveFormation(Formation f) throws RemoteException;
}
