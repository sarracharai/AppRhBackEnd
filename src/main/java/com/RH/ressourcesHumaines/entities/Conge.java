package com.RH.ressourcesHumaines.entities;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConge;
	private String typeConge;
	private Date dateDebut; 
	private Date dateFin;
	private String justifConge;
	private Date dateDemande;
	
	
	@ManyToOne
	private  Personnel personnel;
	
	
	
	public Conge(String nomPersonnel, String prenomPersonnel, String typeConge, Date dateDebut, Date dateFin,
			String justifConge, Date dateDemande) {
		super();
		
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.justifConge = justifConge;
		this.dateDemande = dateDemande;
	}
	
	
	
	

}
