package com.RH.ressourcesHumaines.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.RH.ressourcesHumaines.entities.Departement;


@RepositoryRestResource(path = "dep")
@CrossOrigin(origins = "http://localhost:4200")
public interface DepartementRepository extends JpaRepository <Departement , Long> {

}
