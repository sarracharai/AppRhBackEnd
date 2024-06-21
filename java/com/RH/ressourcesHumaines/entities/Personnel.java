package com.RH.ressourcesHumaines.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personnel extends Utilisateur {
	
private String fonction;
@Column(unique = true) 
private String numCin;
private String sexe;
private String username;

	
	public Personnel(Long id, String nom, String prenom, Date dateNaissance, String email, Integer numTelephone,
			String adresse, String fonction, String numCin , String username, String sexe ) {
		super(id, nom, prenom, dateNaissance, email, numTelephone, adresse);
		 this.fonction = fonction;
		 this.numCin= numCin;
		 this.sexe= sexe;
		 this.username=username;
	}
	
	
	
	
	@ManyToOne
	private Departement departement;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel")
	private List<Conge>conges ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel")
	private List<Pret>prets ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
	private List<Notification>notifications ;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "personnel")
	//private List<Contrat>contrat;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "personnel")
	//private List<DocAdministratifs>DocumentsAdministratifs;
	
	
	//@JsonIgnore
	//@OneToOne(mappedBy = "personnel")
	//private Assiduite assiduite ;
	
	
	
	
	
	
	

	
	

}
