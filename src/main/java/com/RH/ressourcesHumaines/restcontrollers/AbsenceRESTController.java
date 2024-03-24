package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.DTO.AbsenceWrapper;
import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.repos.AbsenceRepository;

@RestController
@RequestMapping("/api/abs")
@CrossOrigin("*")
public class AbsenceRESTController {
	
	@Autowired
	AbsenceRepository absenceRepository;
	 @RequestMapping(method=RequestMethod.GET)
	    public AbsenceWrapper getAllAbsences() {
	        List<Absence> absences = absenceRepository.findAll();
	        return new AbsenceWrapper(absences);
	    }
	 @RequestMapping(value="/{idAbs}", method = RequestMethod.GET)
	    public Absence getAbsenceById(@PathVariable("idAbs") Long idAbs) {
	        return absenceRepository.findById(idAbs).orElse(null);
	    }
	

}
