package com.RH.ressourcesHumaines.DTO;


import java.util.List;

import com.RH.ressourcesHumaines.entities.Absence;

public class AbsenceWrapper {

	 private List<Absence> absences;

	    public AbsenceWrapper(List<Absence> absences) {
	        this.absences = absences;
	    }

	    // Getters and setters
	
}
