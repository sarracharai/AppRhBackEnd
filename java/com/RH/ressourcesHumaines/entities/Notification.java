package com.RH.ressourcesHumaines.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idNotification;
	 private String type;
	 private Date dateDemande;
	  private String etat;
	  private double periode;
	  private double montant;
	  private Date dateRemise;//si il est un pret
	  private Date dateDebut;
	  private Date dateFin;
	  private String username;
	  private boolean lu;
	  
		@ManyToOne
		private  Personnel personnel;
	 
		
		
	

}