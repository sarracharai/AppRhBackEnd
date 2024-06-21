package com.RH.ressourcesHumaines.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.entities.Responsable;


@Repository
public interface ResponsableRepository extends JpaRepository <Responsable , Long> {

	Responsable findByUsername(String username);

}
