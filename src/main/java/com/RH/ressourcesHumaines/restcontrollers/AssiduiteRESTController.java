package com.RH.ressourcesHumaines.restcontrollers;


import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.service.PersonnelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assiduite")
@CrossOrigin("*")
public class AssiduiteRESTController {
	
	@Autowired
	PersonnelService personnelService;
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Assiduite> getAllAssiduites() {
	    return personnelService.getAllAssiduites();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	 public Assiduite getAssiduiteById(@PathVariable("id") Long id) {
	    return personnelService.getAssiduite(id);
	  }

	@RequestMapping(path="/addass",method = RequestMethod.POST)
	public Assiduite createAssiduite(@RequestBody Assiduite assiduite) {
	    return personnelService.saveAssiduite(assiduite);
	}
	
	@RequestMapping(path="/updateass",method = RequestMethod.PUT)
	public Assiduite updateAssiduite(@RequestBody Assiduite assiduite) {
	    return personnelService.updateAssiduite(assiduite);
	}
	
	 @RequestMapping(value="/delass/{id}",method = RequestMethod.DELETE)
	 public void deleteAssiduite(@PathVariable("id") Long id)
	 {
		 personnelService.deleteAssiduiteById(id);
	 }
	 
	 
	// @RequestMapping(value="/Aabs/{idAbs}",method = RequestMethod.GET)
	// public List<Assiduite> getAssiduiteByIdAbs(@PathVariable("idAbs") Long id) {
	 //   return personnelService.findByAbsenceIdAbs(id);
	 //}
	
	 
	

}
