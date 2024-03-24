package com.RH.ressourcesHumaines.restcontrollers;



import com.RH.ressourcesHumaines.entities.DocAdministratifs;

import com.RH.ressourcesHumaines.service.PersonnelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin("*")
public class DocAdministratifsRESTController {
	
	
	@Autowired
    PersonnelService personnelService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DocAdministratifs> getAllDocuments() {
        return personnelService.getAllDocuments();
    }
    
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public DocAdministratifs getDocumentById(@PathVariable("id") Long id) {
        return personnelService.getDocumentById(id);
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public DocAdministratifs createDocument(@RequestBody DocAdministratifs document) {
        return personnelService.saveDocument(document);
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
