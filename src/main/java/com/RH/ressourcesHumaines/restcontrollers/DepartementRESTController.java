package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Departement;

import com.RH.ressourcesHumaines.repos.DepartementRepository;
import com.RH.ressourcesHumaines.service.PersonnelService;



@RestController
@RequestMapping("/dep")
@CrossOrigin("*")
public class DepartementRESTController {
	
	@Autowired
	PersonnelService personnelService;
	
	@Autowired
	DepartementRepository departementRepository;
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Departement> getAllDepartements()
	{
	return departementRepository.findAll();
	}
	
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Departement getDepartementById(@PathVariable("id") Long id) {
	return departementRepository.findById(id).get();
	}
	
	@RequestMapping(value="/updateDep", method = RequestMethod.PUT)
	public Departement updateDepartement(@RequestBody Departement departement) {
	return personnelService.updateDepartement(departement);
	    }
	    
	@RequestMapping(value="/delDep/{id}", method = RequestMethod.DELETE)
	public void deleteDepartement(@PathVariable("id") Long id) {
		personnelService.deleteDepartementById(id);
	    }

	

}
