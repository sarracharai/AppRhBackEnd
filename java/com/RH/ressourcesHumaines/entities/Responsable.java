package com.RH.ressourcesHumaines.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Responsable extends Utilisateur{
	
	private String fonction;
	private String username;
	
	public Responsable(Long id, String nom, String prenom, Date dateNaissance, String email, Integer numTelephone,
			String adresse, String fonction, String username) {
		super(id, nom, prenom, dateNaissance, email, numTelephone, adresse);
		this.fonction = fonction;
		this.username = username;
	}
	

}
