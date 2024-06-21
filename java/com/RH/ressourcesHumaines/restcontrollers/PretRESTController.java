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

import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;

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
	
	  @GetMapping("/data")
		public ResponseEntity<?> getPretData(@RequestHeader("Authorization") String authHeader) {
		    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
		    }

		    String token = authHeader.replace("Bearer ", "").trim();
		    String username = JWT.decode(token).getSubject();

		    Pret pret = personnelService.getPretByUsername(username);

		    if (pret != null) {
		        return ResponseEntity.ok(pret);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pret not found");
		    }
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
	


	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deletePret(@PathVariable("id") Long id)
	{
		personnelService.deletePretById(id);
	}
	
	

}
