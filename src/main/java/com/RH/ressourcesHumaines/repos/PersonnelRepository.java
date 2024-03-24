package com.RH.ressourcesHumaines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.Personnel;


@Repository
public interface PersonnelRepository extends JpaRepository <Personnel,Long> {
	List<Personnel> findByNomPersonnel(String nom);
	
	@Query("select p from Personnel p where p.departement = ?1") 
	List<Personnel> findByDepartement(Departement departement);
	List<Personnel> findByDepartementIdDep(Long idDep);

	List<Personnel> findByNomPersonnelContains(String nomPersonnel);
	
}