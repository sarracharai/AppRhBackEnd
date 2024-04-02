package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.repos.AbsenceRepository;
import com.RH.ressourcesHumaines.service.PersonnelService;

@RestController
@RequestMapping("/api/abs")
@CrossOrigin("*")
public class AbsenceRESTController {

    @Autowired
    AbsenceRepository absenceRepository;
    
    @Autowired
	PersonnelService personnelService;

    @RequestMapping(value="all" , method=RequestMethod.GET)
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }
    
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	 public Absence getAbsenceById(@PathVariable("id") Long id) {
	    return personnelService.getAbsence(id);
	  }
    @RequestMapping(path="/value",method = RequestMethod.POST)
	public Absence createAbsence(@RequestBody Absence absence) {
	    return personnelService.saveAbsence(absence);
	}    
    
    
    
    @RequestMapping(path="updateab",method = RequestMethod.PUT)
	public Absence updateAbsence(@RequestBody Absence absence) {
	    return personnelService.updateAbsence(absence);
	}
    
    @RequestMapping(value="/delab/{id}",method = RequestMethod.DELETE)
	 public void deleteAbsence(@PathVariable("id") Long id)
	 {
		 personnelService.deleteAbsenceById(id);
	 }
}
