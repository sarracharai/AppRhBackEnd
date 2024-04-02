package com.RH.ressourcesHumaines.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Absence {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idAbs;
	  private String typeAbs;
	  private double heuresAbs;
	  private String statut;
	  
	  @ManyToOne
	  private Assiduite assiduite;
	 
	 
	  public Absence() {
	        super() ;
	    }
	  
	
	
	
	
	
}