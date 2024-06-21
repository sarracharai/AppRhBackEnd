package com.RH.ressourcesHumaines.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Responsable;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;

@RestController
@RequestMapping("/api/Responsable")
@CrossOrigin("*")
public class ResponsableRESTController {
	
	@Autowired
    PersonnelService personnelService;

 @RequestMapping(value ="/all",method=RequestMethod.GET)
    public List<Responsable> getAllResponsables() {
        return personnelService.getAllResponsables();
    }

 @GetMapping("/data")
	public ResponseEntity<?> getResponsableData(@RequestHeader("Authorization") String authHeader) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
	    }

	    String token = authHeader.replace("Bearer ", "").trim();
	    String username = JWT.decode(token).getSubject();

	    Responsable responsable = personnelService.getResponsableByUsername(username);

	    if (responsable != null) {
	        return ResponseEntity.ok(responsable);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsable not found");
	    }
	}
 
 @RequestMapping(value="/update" , method = RequestMethod.PUT)
	public Responsable updateResponsable(@RequestBody Responsable responsable) {
	return personnelService.updateResponsable(responsable);
	}
 
 
}

