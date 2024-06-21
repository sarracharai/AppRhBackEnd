package com.RH.ressourcesHumaines.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.ressourcesHumaines.entities.Notification;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
//Notification findByUsername(String username);

List<Notification> findByUsername(String username);
	

}
