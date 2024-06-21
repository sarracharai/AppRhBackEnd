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

import com.RH.ressourcesHumaines.entities.Admin;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Responsable;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;


@RestController
@RequestMapping("/api/Admin")
@CrossOrigin("*")
public class AdminRESTController {
	
	@Autowired
    PersonnelService personnelService;
	
	@RequestMapping(value="/all" ,method=RequestMethod.GET)
    public List<Admin> getAllAdmins() {
        return personnelService.getAllAdmins();
    } 
	
	@GetMapping("/data")
	public ResponseEntity<?> getAdminData(@RequestHeader("Authorization") String authHeader) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
	    }

	    String token = authHeader.replace("Bearer ", "").trim();
	    String username = JWT.decode(token).getSubject();

	    Admin admin = personnelService.getAdminByUsername(username);

	    if (admin != null) {
	        return ResponseEntity.ok(admin);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
	    }
	}
 
 @RequestMapping(value="/update" , method = RequestMethod.PUT)
	public Admin updateAdmin(@RequestBody Admin admin) {
	return personnelService.updateAdmin(admin);
	}

 @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Admin getAdminById(@PathVariable("id") Long id) {
	return personnelService.getAdmin(id);
	 }
 
}
