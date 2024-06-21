package com.RH.ressourcesHumaines.entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DocAdministratifs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocument;
    private String type;
    private String dateCreation;
    private String username;
    private String url; 
    
    public DocAdministratifs() {
        super();
    }

    public DocAdministratifs(Long idDocument, String type, String dateCreation, String username, String url) {
        super();
        this.idDocument = idDocument;
        this.type = type;
        this.dateCreation = dateCreation;
        this.username = username;
        this.url = url;
    }


}
