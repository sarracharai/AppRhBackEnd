package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.service.PersonnelService;

@RestController
@RequestMapping("/api/pret")
@CrossOrigin("*")
public class PretRESTController {
	
	@Autowired
	PersonnelService personnelService;
	
	
	@RequestMapping(value ="/all" , method=RequestMethod.GET)
	public List<Pret> getAllPrets()
	{
		return personnelService.getAllPrets();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Pret getPretById(@PathVariable("id") Long id) {
	return personnelService.getPret(id);
	}
	 
	
	 @RequestMapping(value="/addPret",method = RequestMethod.POST)
	public Pret createPret(@RequestBody Pret pret) {
	return personnelService.savePret(pret);
	}
	
	
	 
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Pret updatePret(@RequestBody Pret pret) {
	return personnelService.updatePret(pret);
	}
	


	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePret(@PathVariable("id") Long id)
	{
		personnelService.deletePretById(id);
	}
	
	

}
