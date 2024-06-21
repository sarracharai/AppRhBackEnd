package com.RH.ressourcesHumaines.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RH.ressourcesHumaines.entities.Commentaire;

public interface CommentaireReopsitory extends JpaRepository <Commentaire , Long>{
	 List<Commentaire> findByPublicationIdPublication(Long publicationId);

}
