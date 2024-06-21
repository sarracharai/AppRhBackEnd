package com.RH.ressourcesHumaines.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.entities.Publication;
import com.RH.ressourcesHumaines.entities.Responsable;
import com.RH.ressourcesHumaines.entities.Utilisateur;
import com.RH.ressourcesHumaines.repos.AdminRepository;
import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Admin;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Commentaire;
import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;
import com.RH.ressourcesHumaines.entities.Notification;

public interface PersonnelService {

	Personnel savePersonnel(Personnel p);
	Personnel updatePersonnel(Personnel p);
	void deletePersonnel(Personnel p);
	void deletePersonnelById(Long id);
	Personnel getPersonnel(Long id);
	List<Personnel> getAllPersonnels();
	List<Personnel> findByNom(String nom);
	List<Personnel> findByDepartementIdDep(Long id);
	List<Personnel> findByDepartement(Departement departement);
	List<Personnel> findByNomContains(String nom);
	
	Personnel getPersonnelByUsername(String username);
	Conge getCongeByUsername(String username);
	Pret getPretByUsername(String username);
	Contrat getContratByUsername(String username);
	Assiduite getAssiduiteByUsername(String username);
	Responsable getResponsableByUsername(String username);

	//Notification getNotificationByUsername(String username);
	
	Conge saveConge(Conge c);
	Conge updateConge(Conge c);
	void deleteConge(Conge c);
	void deleteCongeById(Long id);
	Conge getConge(Long id);
	List<Conge>getAllConges();
	Conge getCongeById(Long id);
	
	
	Pret savePret(Pret p);
	Pret updatePret(Pret p);
	void deletePret(Pret p);
	void deletePretById(Long id);
	Pret getPret(Long id);
	List<Pret>getAllPrets();
	
	
	List<Absence> getAllAbsences();
	Absence getAbsence(Long idAbs);
	Absence saveAbsence(Absence ab);
	Absence updateAbsence(Absence ab);
	void deleteAbsenceById(Long idAbs);
	
	List<Assiduite> getAllAssiduites();
	Assiduite getAssiduite(Long idAssiduite);
	Assiduite saveAssiduite(Assiduite a);
	
	Assiduite updateAssiduite(Assiduite a);
	void deleteAssiduite(Assiduite a);
	void deleteAssiduiteById(Long idAssiduite);
	//List<Assiduite> findByAbsenceIdAbs(Long idAbs);
	
	 List<DocAdministratifs> getAllDocuments();
	 DocAdministratifs getDocumentById(Long id);
	 //DocAdministratifs saveDocument(DocAdministratifs document);
	 DocAdministratifs updateDocument(DocAdministratifs document);
	 void deleteDocument(DocAdministratifs document);
	 void deleteDocumentById(Long id);
	
	 
	 List<Contrat> getAllContrats();
	 Contrat getContratById(Long id);
	 Contrat saveContrat(Contrat c);
	 Contrat updateContrat(Contrat c);
	 void deleteContrat(Contrat c);
	 void deleteContratById(Long id);
	 
	Departement updateDepartement(Departement departement);
	void deleteDepartementById(Long id);
	
	
	List<Notification>getAllNotifications();
	Notification saveNotification(Notification n);
	Notification updateNotification(Notification n);
	void deleteNotification(Notification n);
	void deleteNotificationById(Long id);
	Notification getNotification(Long id);
	Notification getNotificationById(Long id);
	
	List<Responsable>getAllResponsables();
	List<Notification> getNotificationsByUsername(String username);
	void markNotificationsAsRead(String username, List<Notification> notifications);
	Responsable updateResponsable(Responsable responsable);
	Admin getAdminByUsername(String username);
	Admin updateAdmin(Admin admin);
	DocAdministratifs getDocAdministratifsByUsername(String username);
		
	   //////////////////2 juin////////
	Publication addPublication(Publication publication);
    void deletePublication(Long publicationId);
    List<Publication> getAllPublications();  
    Commentaire addCommentaire(Long publicationId, Commentaire commentaire);
    List<Commentaire> getCommentairesByPublicationId(Long publicationId);
    void deleteCommentaire(Long commentaireId);
    void deleteCommentaireById(Long idCommentaire);
	List<Admin> getAllAdmins();
	Admin getAdmin(Long id);
	DocAdministratifs saveDocument(String type, String dateCreation, String username, MultipartFile file) throws IOException;
		
	
   
}
