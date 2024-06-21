package com.RH.ressourcesHumaines.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Contrat {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idContrat;
	 private String type;
	 private String username;
	 private Date dateEmbauche;
	 private Date dateSignature;
     private String nomSociete;
     
     public Contrat () {
	        super() ;
	    }
	  
	public Contrat( String type, Date dateEmbauche, Date dateSignature, String nomSociete, String username) {
		super();
		
		this.type = type;
		this.dateEmbauche = dateEmbauche;
		this.dateSignature = dateSignature;
		this.nomSociete = nomSociete;
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Date getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + ", type=" + type + ", dateEmbauche=" + dateEmbauche
				+ ", dateSignature=" + dateSignature + ", nomSociete=" + nomSociete + "]";
	}
	  
}