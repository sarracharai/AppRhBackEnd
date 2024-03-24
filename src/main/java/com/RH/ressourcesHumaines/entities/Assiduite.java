package com.RH.ressourcesHumaines.entities;
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
public class Assiduite {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idAssiduite;
	  private double heuresSupp;
	  private double nbHeures;
	 
	   
	  
	   @OneToMany(mappedBy = "assiduite")
	   @JsonIgnore
	   private List<Absence> absences; 
	  
	   
	   
	  public Assiduite() {
	        super() ;
	    }

	    public Assiduite(double heuresSupp, double nbHeures) {
	        this.heuresSupp = heuresSupp;
	        this.nbHeures = nbHeures;
	    }

		public Long getId() {
					return idAssiduite;
				}
		
				public void setId(Long id) {
					this.idAssiduite = id;
				}
		
				public Double getHeuresSupp() {
					return heuresSupp;
				}
		
				public void setHeuresSupp(double heuresSupp) {
					this.heuresSupp = heuresSupp;
				}
		
				public double getNbHeures() {
					return nbHeures;
				}
		
				public void setNbHeures(double nbHeures) {
					this.nbHeures = nbHeures;
				}
		
				@Override
				public String toString() {
					return "Assiduite [id=" + idAssiduite + ", heuresSupp=" + heuresSupp + ", nbHeures=" + nbHeures + "]";
				}
	    

		

}