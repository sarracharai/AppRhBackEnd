package com.RH.ressourcesHumaines.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.RH.ressourcesHumaines.entities.Commentaire;
import com.RH.ressourcesHumaines.entities.Publication;
import com.RH.ressourcesHumaines.service.PersonnelService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PublicationRESTController {

    @Autowired
    private PersonnelService personnelService;

    @PostMapping("/publication/ajouter")
    public Publication addMessagerie(@RequestBody Publication publication) {
        return personnelService.addPublication(publication);
    }

    @DeleteMapping("/publication/supprimer/{id}")
    public void deletePublication(@PathVariable Long id) {
        personnelService.deletePublication(id);
    }

    @GetMapping("/publications/tous")
    public List<Publication> getAllPublications() {
        return personnelService.getAllPublications();
    }

    @PostMapping("/ajouterCommentaires/{publicationId}")
    public Commentaire addCommentaire(@PathVariable Long publicationId, @RequestBody Commentaire commentaire) {
        return personnelService.addCommentaire(publicationId, commentaire);
    }

    @GetMapping("/tousCommentaires/{publicationId}")
    public List<Commentaire> getCommentairesByPublicationId(@PathVariable Long publicationId) {
        return personnelService.getCommentairesByPublicationId(publicationId);
    }
    
    @DeleteMapping("/supprimerCommentaire/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        personnelService.deleteCommentaire(id);
    }
}
