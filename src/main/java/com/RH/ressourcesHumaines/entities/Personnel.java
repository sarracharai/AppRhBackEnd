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


@Data
@AllArgsConstructor
@Entity
public class Personnel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonnel;
	private String nomPersonnel;
	private String prenomPersonnel;
	private Date dateNaissance;
	private String email;
	private Integer numTelephone;
	private String adresse;
	private String fonction;
	
	@ManyToOne
	private Departement departement;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel")
	private List<Conge>conges ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel")
	private List<Pret>prets ;
	
	
	
	public Personnel() {
        
    }

	public Personnel(String nomPersonnel, String prenomPersonnel, Date dateNaissance, String email,
			Integer numTelephone, String adresse, String fonction) {
		super();
		this.nomPersonnel = nomPersonnel;
		this.prenomPersonnel = prenomPersonnel;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.numTelephone = numTelephone;
		this.adresse = adresse;
		this.fonction = fonction;
	}
	
	
	
	

	
	

}
