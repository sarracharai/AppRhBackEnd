package com.RH.ressourcesHumaines.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.RH.ressourcesHumaines.entities.Pret;

@RepositoryRestResource(path = "pret")
@CrossOrigin(origins = "http://localhost:4200")
public interface PretRepository extends JpaRepository <Pret, Long> {

}
