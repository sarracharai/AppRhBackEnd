package com.RH.ressourcesHumaines.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.RH.ressourcesHumaines.entities.Notification;
import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin("*")
public class NotificationRESTController {
    
    @Autowired
    PersonnelService personnelService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Notification> getAllNotifications() {
        return personnelService.getAllNotifications();
    }
    
    @GetMapping("/data")
    public ResponseEntity<?> getNotificationData(@RequestHeader("Authorization") String authHeader) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
	    }

	    String token = authHeader.replace("Bearer ", "").trim();
	    String username = JWT.decode(token).getSubject();

	    List<Notification> notifications = personnelService.getNotificationsByUsername(username);

	    if (!notifications.isEmpty()) {
	        return ResponseEntity.ok(notifications);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notifications not found");
	    }
	
    }
    
    @PutMapping("/markAsRead")
    public ResponseEntity<?> markNotificationsAsRead(@RequestHeader("Authorization") String authHeader, @RequestBody List<Notification> notifications) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
        }

        String token = authHeader.replace("Bearer ", "").trim();
        String username = JWT.decode(token).getSubject();

        personnelService.markNotificationsAsRead(username, notifications);
        return ResponseEntity.ok().build();
    }
   
    
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Notification getNotificationById(@PathVariable("id") Long id) {
        return personnelService.getNotificationById(id);
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Notification createNotification(@RequestBody Notification n) {
        return personnelService.saveNotification(n);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Notification updateNotification(@RequestBody Notification n) {
        return personnelService.updateNotification(n);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable("id") Long id) {
    	personnelService.deleteNotificationById(id);
    }
    

    
}
