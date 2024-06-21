package com.RH.ressourcesHumaines.restcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;
@RestController
@RequestMapping("/api/contrat")
@CrossOrigin("*")
public class ContratRESTController {
	
	  	@Autowired
	    PersonnelService personnelService;
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<Contrat> getAllContrats() {
	        return personnelService.getAllContrats();
	    }
	    
	    @GetMapping("/data")
		public ResponseEntity<?> getContratData(@RequestHeader("Authorization") String authHeader) {
		    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
		    }

		    String token = authHeader.replace("Bearer ", "").trim();
		    String username = JWT.decode(token).getSubject();

		    Contrat contrat = personnelService.getContratByUsername(username);

		    if (contrat != null) {
		        return ResponseEntity.ok(contrat);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pret not found");
		    }
		}
	    
	    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	    public Contrat getContratById(@PathVariable("id") Long id) {
	        return personnelService.getContratById(id);
	    }
	    
	    
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public Contrat createContrat(@RequestBody Contrat c) {
	        return personnelService.saveContrat(c);
	    }
	    
	    @RequestMapping(value = "/update", method = RequestMethod.PUT)
	    public Contrat updateContrat(@RequestBody Contrat c) {
	        return personnelService.updateContrat(c);
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    public void deleteContrat(@PathVariable("id") Long id) {
	    	personnelService.deleteContratById(id);
	    }
	    
	

}
