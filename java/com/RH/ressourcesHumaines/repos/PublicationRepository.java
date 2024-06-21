package com.RH.ressourcesHumaines.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
