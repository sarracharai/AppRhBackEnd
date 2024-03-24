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
import com.RH.ressourcesHumaines.service.PersonnelService;

@RestController
@RequestMapping("/api/conge")
@CrossOrigin("*")
public class CongeRESTController {
    
    @Autowired
    PersonnelService personnelService;
    
    @RequestMapping(value ="/all",method=RequestMethod.GET)
    public List<Conge> getAllConges() {
        return personnelService.getAllConges();
    }
    
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Conge getCongeById(@PathVariable("id") Long id) {
        return personnelService.getConge(id);
    }
     
    @RequestMapping(value="/addConge", method = RequestMethod.POST)
    public Conge createConge(@RequestBody Conge conge) {
        return personnelService.saveConge(conge);
    }
    
    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public Conge updateConge(@RequestBody Conge conge) {
        return personnelService.updateConge(conge);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteConge(@PathVariable("id") Long id) {
        personnelService.deleteCongeById(id);
    }
}
