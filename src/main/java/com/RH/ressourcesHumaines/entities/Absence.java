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
	  private String heuresAbs;
	  private String statut;
	  
	  
	  @ManyToOne
	  private Assiduite assiduite;
	 
	 
	  public Absence() {
	        super() ;
	    }
	  
	public Absence(Long idAbs,String typeAbs, String heuresAbs, String statut) {
		super();
		this.idAbs = idAbs;
		this.typeAbs = typeAbs;
		this.heuresAbs = heuresAbs;
		this.statut = statut;
		
	}
	
	
	public String getTypeAbs() {
		return typeAbs;
	}
	public void setTypeAbs(String typeAbs) {
		this.typeAbs = typeAbs;
	}
	public String getHeuresAbs() {
		return heuresAbs;
	}
	public void setHeuresAbs(String heuresAbs) {
		this.heuresAbs = heuresAbs;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Absence [id=" + idAbs + ", type=" + typeAbs + ", HeuresAbs=" + heuresAbs+ 
				", statut=" + statut + "]";
	}
	 
	
}