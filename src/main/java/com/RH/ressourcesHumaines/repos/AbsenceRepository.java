package com.RH.ressourcesHumaines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.RH.ressourcesHumaines.entities.Absence;



@RepositoryRestResource(path = "abs")
@CrossOrigin("http://localhost:4200/")
public interface AbsenceRepository extends JpaRepository<Absence, Long>{

	
}