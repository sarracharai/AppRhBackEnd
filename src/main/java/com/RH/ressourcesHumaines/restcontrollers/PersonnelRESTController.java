package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Personnel;

import com.RH.ressourcesHumaines.service.PersonnelService;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PersonnelRESTController {
	
	@Autowired
	PersonnelService personnelService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Personnel> getAllPersonnels()
	{
	return personnelService.getAllPersonnels();
	}
	

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Personnel getPersonnelById(@PathVariable("id") Long id) {
	return personnelService.getPersonnel(id);
	 }
	
	
	
	@RequestMapping(value="/addP",method = RequestMethod.POST)
	public Personnel createPersonnel(@RequestBody Personnel personnel) {
	return personnelService.savePersonnel(personnel);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Personnel updatePersonnel(@RequestBody Personnel personnel) {
	return personnelService.updatePersonnel(personnel);
	}
	


	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePersonnel(@PathVariable("id") Long id)
	{
		personnelService.deletePersonnelById(id);
	}
	
	
	
	@RequestMapping(value="/personsdep/{idDep}",method = RequestMethod.GET)
	public List<Personnel> getPersonnelsByDepId(@PathVariable("idDep") Long idDep) {
	return personnelService.findByDepartementIdDep(idDep);
	}
	
	
	@RequestMapping(value="/personsByName/{nomPersonnel}",method = RequestMethod.GET)
	public List<Personnel> findByNomPersonnelContains(@PathVariable("nomPersonnel") String nomPersonnel) {
	return personnelService.findByNomPersonnelContains(nomPersonnel);
	}
	
}
