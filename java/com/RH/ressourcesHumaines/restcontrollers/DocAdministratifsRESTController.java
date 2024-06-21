package com.RH.ressourcesHumaines.restcontrollers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;

import com.RH.ressourcesHumaines.service.PersonnelService;
import com.auth0.jwt.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class DocAdministratifsRESTController {
	
	 private static final String FILE_PATH = "/path/to/your/pdf/file.pdf";
	
	  @Autowired
	    private PersonnelService personnelService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DocAdministratifs> getAllDocuments() {
        return personnelService.getAllDocuments();
    }
    
    @GetMapping("/data")
	public ResponseEntity<?> getDocAdministratifsData(@RequestHeader("Authorization") String authHeader) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization header");
	    }

	    String token = authHeader.replace("Bearer ", "").trim();
	    String username = JWT.decode(token).getSubject();

	    DocAdministratifs docAdministratifs = personnelService.getDocAdministratifsByUsername(username);

	    if (docAdministratifs != null) {
	        return ResponseEntity.ok(docAdministratifs);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
	    }
	}
    
    
    
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public DocAdministratifs getDocumentById(@PathVariable("id") Long id) {
        return personnelService.getDocumentById(id);
    }
    
    @PostMapping("/add")
    public ResponseEntity<DocAdministratifs> createDocument(
            @RequestParam("type") String type,
            @RequestParam("dateCreation") String dateCreation,
            @RequestParam("username") String username,
            @RequestParam("file") MultipartFile file) {
        
        try {
            DocAdministratifs newDocument = personnelService.saveDocument(type, dateCreation, username, file);
            return new ResponseEntity<>(newDocument, HttpStatus.CREATED);
        } catch (IOException e) {
        	
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/uploaded-files/{fileName:.+}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String fileName) {
        String filePath = "/path/to/your/files/" + fileName; // Remplacez par le chemin correct
        FileSystemResource resource = new FileSystemResource(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    
    @RequestMapping(value = "/updatedoc", method = RequestMethod.PUT)
    public DocAdministratifs updateDocument(@RequestBody DocAdministratifs document) {
        return personnelService.updateDocument(document);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteDocument(@PathVariable("id") Long id) {
    	personnelService.deleteDocumentById(id);
    }
    
    


}
