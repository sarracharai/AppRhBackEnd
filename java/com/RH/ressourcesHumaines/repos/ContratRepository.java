package com.RH.ressourcesHumaines.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long>{
	Contrat findByUsername(String username);
}
