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
	  private double totalAbsences;
	 
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "assiduite")
	   private List<Absence> absences; 
	   
	   
	  
	   public double getTotalAbsences() {
		    double totalAbsences = 0.0;
		    if (absences != null) { // Vérifier si absences est non nul pour éviter une NullPointerException
		        for (Absence absence : absences) {
		            if (absence.getAssiduite() != null && absence.getAssiduite().getIdAssiduite().equals(this.idAssiduite)) {
		                Double heuresAbs = absence.getHeuresAbs(); // Utiliser Double au lieu de String
		                if (heuresAbs != null) { // Vérifier si heuresAbs est non nul
		                    totalAbsences += heuresAbs; // Ajouter la valeur directement
		                }
		            }
		        }
		    }
		    return totalAbsences;
		}
	   
	   
	  public Assiduite() {
	        super() ;
	    }

	   
		

}