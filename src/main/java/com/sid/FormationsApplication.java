package com.sid;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.dao.EtudiantRepository;
import com.sid.dao.FormationRepository;
import com.sid.entities.Etudiant;
import com.sid.entities.Formation;

@SpringBootApplication
public class FormationsApplication implements CommandLineRunner {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private FormationRepository formationRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormationsApplication.class, args);
	}

	@Override
	public void run(String... args0) throws Exception {

		Stream.of("java","jee","orcle").forEach(nf->{
			//formationRepository.save(new Formation(null,nf,30,null));
			Formation f = new Formation();
			f.setNom(nf);f.setDuree(30);
			formationRepository.save(f);
		});
		etudiantRepository.save(new Etudiant(null,"aberwag","lhassan",new Formation(1L,null,0,null)));
		etudiantRepository.save(new Etudiant(null,"aberwag","lhassa",new Formation(1L,null,0,null)));
		etudiantRepository.save(new Etudiant(null,"aberwag","lhass",new Formation(2L,null,0,null)));
		etudiantRepository.save(new Etudiant(null,"aberwag","lhas",new Formation(3L,null,0,null)));
		etudiantRepository.save(new Etudiant(null,"aberwag","lha",new Formation(3L,null,0,null)));

		formationRepository.findAll().forEach(f->{
			System.out.println(f.getNom());
		});
	}

}
