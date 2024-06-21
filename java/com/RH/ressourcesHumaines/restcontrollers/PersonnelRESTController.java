package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.repos.PersonnelRepository;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PersonnelRESTController {
	
	@Autowired
	PersonnelService personnelService;
	
	@Autowired
    private PersonnelRepository personnelRepository;
	
	@RequestMapping(path="all", method=RequestMethod.GET)
	public List<Personnel> getAllPersonnels()
	{
	return personnelService.getAllPersonnels();
	}
	
	@GetMapping("/personnel/data")
	public ResponseEntity<?> getPersonnelData(@RequestHeader("Authorization") String authHeader) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
	    }

	    String token = authHeader.replace("Bearer ", "").trim();
	    String username = JWT.decode(token).getSubject();

	    Personnel personnel = personnelService.getPersonnelByUsername(username);

	    if (personnel != null) {
	        return ResponseEntity.ok(personnel);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Personnel not found");
	    }
	}

	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Personnel getPersonnelById(@PathVariable("id") Long id) {
	return personnelService.getPersonnel(id);
	 }
	
	
	
	@RequestMapping(value="/addP",method = RequestMethod.POST)
	public Personnel createPersonnel(@RequestBody Personnel personnel) {
	return personnelService.savePersonnel(personnel);
	}
	
	
	
	
	@RequestMapping(value="/updatep" , method = RequestMethod.PUT)
	public Personnel updatePersonnel(@RequestBody Personnel personnel) {
	return personnelService.updatePersonnel(personnel);
	}
	

	
	@RequestMapping(value="/delp/{id}",method = RequestMethod.DELETE)
	public void deletePersonnel(@PathVariable("id") Long id)
	{
		personnelService.deletePersonnelById(id);
	}
	
	
	
	@RequestMapping(value="/personsdep/{idDep}",method = RequestMethod.GET)
	public List<Personnel> getPersonnelsByDepId(@PathVariable("idDep") Long idDep) {
	return personnelService.findByDepartementIdDep(idDep);
	}
	
	
	@RequestMapping(value="/personsByName/{nom}",method = RequestMethod.GET)
	public List<Personnel> findByNomContains(@PathVariable("nomPersonnel") String nom) {
	return personnelService.findByNomContains(nom);
	}
	
}

