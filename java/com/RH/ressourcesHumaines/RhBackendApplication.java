package com.RH.ressourcesHumaines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.Personnel;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class RhBackendApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RhBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Personnel.class,Departement.class);
		repositoryRestConfiguration.exposeIdsFor(Assiduite.class,Absence.class);
		
	}
}
