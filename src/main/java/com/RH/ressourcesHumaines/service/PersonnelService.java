package com.RH.ressourcesHumaines.service;

import java.util.List;

import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;

public interface PersonnelService {

	Personnel savePersonnel(Personnel p);
	Personnel updatePersonnel(Personnel p);
	void deletePersonnel(Personnel p);
	void deletePersonnelById(Long id);
	Personnel getPersonnel(Long id);
	List<Personnel> getAllPersonnels();
	List<Personnel> findByNomPersonnel(String nom);
	List<Personnel> findByDepartementIdDep(Long id);
	List<Personnel> findByDepartement(Departement departement);
	List<Personnel> findByNomPersonnelContains(String nomPersonnel);
	
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
	 DocAdministratifs saveDocument(DocAdministratifs document);
	 DocAdministratifs updateDocument(DocAdministratifs document);
	 void deleteDocument(DocAdministratifs document);
	 void deleteDocumentById(Long id);
	
	 
	 List<Contrat> getAllContrats();
	 Contrat getContratById(Long id);
	 Contrat saveContrat(Contrat c);
	 Contrat updateContrat(Contrat c);
	 void deleteContrat(Contrat c);
	 void deleteContratById(Long id);
	
	
	
}
