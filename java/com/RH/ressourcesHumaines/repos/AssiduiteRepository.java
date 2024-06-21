package com.RH.ressourcesHumaines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Contrat;

@RepositoryRestResource(path = "rest")
public interface AssiduiteRepository extends JpaRepository<Assiduite, Long> {
	Assiduite findByUsername(String username);
   
}
