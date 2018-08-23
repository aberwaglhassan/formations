package com.sid.web;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sid.dao.EtudiantRepository;
import com.sid.entities.Etudiant;

@Component
public class JMSListeners {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	//creation listener
	@JmsListener(destination="scolarite.queue")
	public void reception(Message message) throws Exception {
		if(message instanceof TextMessage) {
			String contenu = ((TextMessage) message).getText();
			System.out.println("########################################################################");
			System.out.println("reception du massage : "+contenu);
			System.out.println("########################################################################");
			Etudiant et = new Etudiant();
			et.setNom(contenu);
			etudiantRepository.save(et);
		}
	}
	

}
