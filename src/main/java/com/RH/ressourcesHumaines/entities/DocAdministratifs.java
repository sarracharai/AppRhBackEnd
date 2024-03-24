package com.RH.ressourcesHumaines.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
public class DocAdministratifs {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idDocument;
	  private String type;
	  private Date dateCreation;
	  
	  public DocAdministratifs () {
	        super() ;
	    }

	  
	public DocAdministratifs (Long idDocument,String type, Date dateCreation) {
		super();
		this.idDocument = idDocument;
		this.type = type;
		this.dateCreation=dateCreation;
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "DocAdministratifs [idDocument=" + idDocument + ", type=" + type + ", dateCreation=" + dateCreation
				+ "]";
	}
	
}