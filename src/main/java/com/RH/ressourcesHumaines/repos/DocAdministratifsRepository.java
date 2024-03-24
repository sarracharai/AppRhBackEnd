package com.RH.ressourcesHumaines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.DocAdministratifs;

@Repository
public interface DocAdministratifsRepository extends JpaRepository<DocAdministratifs, Long> {
   
}
