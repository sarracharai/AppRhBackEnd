package com.RH.ressourcesHumaines.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Admin;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Commentaire;
import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;
import com.RH.ressourcesHumaines.entities.Notification;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.entities.Publication;
import com.RH.ressourcesHumaines.entities.Responsable;
import com.RH.ressourcesHumaines.entities.Utilisateur;
import com.RH.ressourcesHumaines.repos.AbsenceRepository;
import com.RH.ressourcesHumaines.repos.AdminRepository;
import com.RH.ressourcesHumaines.repos.AssiduiteRepository;
import com.RH.ressourcesHumaines.repos.CommentaireReopsitory;
import com.RH.ressourcesHumaines.repos.CongeRepository;
import com.RH.ressourcesHumaines.repos.ContratRepository;
import com.RH.ressourcesHumaines.repos.DepartementRepository;
import com.RH.ressourcesHumaines.repos.DocAdministratifsRepository;
import com.RH.ressourcesHumaines.repos.NotificationRepository;
import com.RH.ressourcesHumaines.repos.PersonnelRepository;
import com.RH.ressourcesHumaines.repos.PretRepository;
import com.RH.ressourcesHumaines.repos.PublicationRepository;
import com.RH.ressourcesHumaines.repos.ResponsableRepository;




@Service
public class PersonnelServiceImpl implements PersonnelService{
	private final Path rootLocation = Paths.get("uploaded-files");
	
	
	@Autowired
	PersonnelRepository personnelRepository;
	
	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	CongeRepository congeRepository;
	
	@Autowired
	PretRepository pretRepository;
	
	 @Autowired 
	 AssiduiteRepository assiduiteRepository;
	 
	 @Autowired
	 DocAdministratifsRepository docAdministratifsRepository;
	 
	 @Autowired
	 ContratRepository contratRepository;
	 
	 @Autowired
	 private AbsenceRepository absenceRepository;
	 
	 @Autowired
	 ResponsableRepository responsableRepository;
	 
	 @Autowired
	 AdminRepository adminRepository;
	 
	 @Autowired
	 NotificationRepository notificationRepository;
	 
	 @Autowired
	 PublicationRepository publicationRepository;
	 
	 @Autowired
	 CommentaireReopsitory commentaireRepository;
	 
	 
	 
		@Override
		public List<Notification> getNotificationsByUsername(String username) {
			 return notificationRepository.findByUsername(username);
		}
	 
		@Override
		public Responsable getResponsableByUsername(String username) {
			return responsableRepository.findByUsername(username);
		}

	 
	 @Override
	 public Personnel getPersonnelByUsername(String username) {
	        return personnelRepository.findByUsername(username);
	    }
	 
	 @Override
		public Conge getCongeByUsername(String username) {
			return congeRepository.findByUsername(username);
		}
	 
	 @Override
		public Pret getPretByUsername(String username) {
			return pretRepository.findByUsername(username);
		}

	 @Override
		public Contrat getContratByUsername(String username) {
			return contratRepository.findByUsername(username);
		}
	 
	 @Override
		public Assiduite getAssiduiteByUsername(String username) {
			return assiduiteRepository.findByUsername(username);
		}
	 
	 
	
	 
	@Override
	public Personnel savePersonnel(Personnel p) {
		return personnelRepository.save(p);
	}

	@Override
	public Personnel updatePersonnel(Personnel p) {
		return personnelRepository.save(p);
	}

	@Override
	public void deletePersonnel(Personnel p) {
		personnelRepository.save(p);
	}

	
	@Override
	public void deletePersonnelById(Long id) {
		personnelRepository.deleteById(id);
	}

	@Override
	public Personnel getPersonnel(Long id) {
		return personnelRepository.findById(id).get();
	}

	@Override
	public List<Personnel> getAllPersonnels() {
		return personnelRepository.findAll();
	}
	

	@Override
	public List<Personnel> findByNom(String nom) {
		return personnelRepository.findByNom(nom) ;
	}
	

 	@Override
	public List<Personnel> findByDepartement(Departement departements) {
		return personnelRepository.findByDepartement(departements);
	}

	@Override
	public List<Personnel> findByDepartementIdDep(Long id) {
		return personnelRepository.findByDepartementIdDep(id);
	}

	@Override
	public List<Personnel> findByNomContains(String nom) {
		return personnelRepository.findByNomContains(nom);
	}

	
	
	
	@Override
	public Conge saveConge(Conge c) {
		return congeRepository.save(c);
	}

	@Override
	public Conge updateConge(Conge c) {
		return congeRepository.save(c);
	}

	@Override
	public void deleteConge(Conge c) {
		congeRepository.save(c); 
		
	}

	@Override
	public void deleteCongeById(Long id) {
		congeRepository.deleteById(id);
		
	}

	@Override
	public Conge getConge(Long id) {
		return congeRepository.findById(id).get();
	}

	@Override
	public List<Conge> getAllConges() {
		return congeRepository.findAll();
	}
 

	@Override
	public Conge getCongeById(Long id) {
		return congeRepository.findById(id).get();
	}
	
	
	
	
	@Override
	public Pret savePret(Pret p) {
		return pretRepository.save(p);
	}

	@Override
	public Pret updatePret(Pret p) {
		return pretRepository.save(p);
	}

	@Override
	public void deletePret(Pret p) {
		pretRepository.save(p); 
		
	}

	@Override
	public void deletePretById(Long id) {
		pretRepository.deleteById(id);
		
	}

	@Override
	public Pret getPret(Long id) {
		return pretRepository.findById(id).get();
	}

	@Override
	public List<Pret> getAllPrets() {
		return pretRepository.findAll();
	}

	
	@Override
	public List<Assiduite> getAllAssiduites() {
		return assiduiteRepository.findAll();
	}
	
	@Override
	public Assiduite getAssiduite(Long idAssiduite) {
		return assiduiteRepository.findById(idAssiduite).get();
	}
	@Override
	public Assiduite saveAssiduite(Assiduite a) {
		return assiduiteRepository.save(a);
	}
	
	@Override
	public Assiduite updateAssiduite(Assiduite a) {
		return assiduiteRepository.save(a);
	}
	@Override
	public void deleteAssiduite(Assiduite a) {
		assiduiteRepository.save(a);	
	}
	@Override
	public void deleteAssiduiteById(Long idAssiduite) {
		assiduiteRepository.deleteById(idAssiduite);
	}
	//@Override
	//public  List<Assiduite> findByAbsenceIdAbs(Long idAbs) {
	//	return assiduiteRepository.findByAbsenceIdAbs(idAbs);	
	//}
	
	////////////////////////////////////////////////////////
	@Override
   public List<DocAdministratifs> getAllDocuments() {
       return docAdministratifsRepository.findAll();
   }

   @Override
   public DocAdministratifs getDocumentById(Long id) {
       return docAdministratifsRepository.findById(id).orElse(null);
   }

//   @Override
//   public DocAdministratifs saveDocument(DocAdministratifs document) {
//       return docAdministratifsRepository.save(document);
//   }
   
   public DocAdministratifs saveDocument(String type, String dateCreation, String username, MultipartFile file) throws IOException {
       Files.createDirectories(rootLocation);

       if (!file.isEmpty()) {
           String fileName = file.getOriginalFilename();
           Path destinationFile = rootLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();

           file.transferTo(destinationFile.toFile());
           String fileUrl = "http://localhost:8080/uploaded-files/" + fileName; // Remplacez localhost:8080 par l'URL de votre serveur

           DocAdministratifs document = new DocAdministratifs();
           document.setType(type);
           document.setDateCreation(dateCreation);
           document.setUsername(username);
           document.setUrl(fileUrl);

           return docAdministratifsRepository.save(document);
       } else {
           throw new IOException("Le fichier est vide");
       }
   }

   @Override
   public DocAdministratifs updateDocument(DocAdministratifs document) {
       return docAdministratifsRepository.save(document);
   }

   @Override
   public void deleteDocument(DocAdministratifs document) {
       docAdministratifsRepository.delete(document);
   }

   @Override
   public void deleteDocumentById(Long id) {
       docAdministratifsRepository.deleteById(id);
   }
   
   ///////////////////////////////////////////////////
   
   @Override
   public List<Contrat> getAllContrats() {
       return contratRepository.findAll();
   }

   @Override
   public Contrat getContratById(Long id) {
       return contratRepository.findById(id).orElse(null);
   }

   @Override
   public Contrat saveContrat(Contrat c) {
       return contratRepository.save(c);
   }

   @Override
   public Contrat updateContrat(Contrat c) {
       return contratRepository.save(c);
   }

   @Override
   public void deleteContrat(Contrat c) {
       contratRepository.delete(c);
   }

   @Override
   public void deleteContratById(Long id) {
       contratRepository.deleteById(id);
   }

	
   
///////////////////////////////////////////////////
   
   @Override
	public List<Absence> getAllAbsences() {
		return absenceRepository.findAll();
	}
	@Override
	public Absence getAbsence(Long idAbs) {
		return absenceRepository.findById(idAbs).get();
	}
	@Override
	public Absence saveAbsence(Absence ab) {
		return absenceRepository.save(ab);
	}
	@Override
	public Absence updateAbsence(Absence ab) {
		return absenceRepository.save(ab);
	}

	@Override
	public void deleteAbsenceById(Long idAbs) {
		absenceRepository.deleteById(idAbs);
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public void deleteDepartementById(Long id) {
		departementRepository.deleteById(id);
		
	}

	
	@Override
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	@Override
	public Notification updateNotification(Notification n) {
		return notificationRepository.save(n);
	}

	@Override
	public Notification saveNotification(Notification n) {
		return notificationRepository.save(n);
		
	}

	@Override
	public Notification getNotification(Long id) {
		return notificationRepository.findById(id).get();
		
	}
	@Override
	public Notification getNotificationById(Long id) {
		return notificationRepository.findById(id).orElse(null);
	}
	@Override
	public void deleteNotification(Notification n) {
		notificationRepository.save(n);
	}

	@Override
	public void deleteNotificationById(Long id) {
		notificationRepository.deleteById(id);
		
	}
	
	@Override
	public List<Responsable> getAllResponsables() {
		return responsableRepository.findAll();
	}

	@Override
	public void markNotificationsAsRead(String username, List<Notification> notifications) {
		for (Notification notification : notifications) {
            if (notification.getUsername().equals(username)) {
                notification.setLu(true);
                notificationRepository.save(notification);
            }
		
	}


	}

	@Override
	public Responsable updateResponsable(Responsable responsable) {
		return responsableRepository.save(responsable);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public DocAdministratifs getDocAdministratifsByUsername(String username) {
		return docAdministratifsRepository.findByUsername(username);
	}
	
	/////////2 juin ///////////
	
	
	@Override
    public Publication addPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public void deletePublication(Long publicationId) {
    	publicationRepository.deleteById(publicationId);
    }

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Commentaire addCommentaire(Long publicationId, Commentaire commentaire) {
    	Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new RuntimeException("Publication not found"));
        commentaire.setPublication(publication);
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> getCommentairesByPublicationId(Long publicationId) {
        return commentaireRepository.findByPublicationIdPublication(publicationId);
    }
    @Override
    public void deleteCommentaire(Long commentaireId) {
        commentaireRepository.deleteById(commentaireId);
    }

    @Override
    public void deleteCommentaireById(Long idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);
    }

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdmin(Long id) {
		return adminRepository.findById(id).get();
	}

	

	
	

}
	
	

	

	
	
	
	
	




