package com.RH.ressourcesHumaines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RH.ressourcesHumaines.entities.Absence;
import com.RH.ressourcesHumaines.entities.Assiduite;
import com.RH.ressourcesHumaines.entities.Conge;
import com.RH.ressourcesHumaines.entities.Contrat;
import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.DocAdministratifs;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.entities.Pret;
import com.RH.ressourcesHumaines.repos.AbsenceRepository;
import com.RH.ressourcesHumaines.repos.AssiduiteRepository;
import com.RH.ressourcesHumaines.repos.CongeRepository;
import com.RH.ressourcesHumaines.repos.ContratRepository;
import com.RH.ressourcesHumaines.repos.DocAdministratifsRepository;
import com.RH.ressourcesHumaines.repos.PersonnelRepository;
import com.RH.ressourcesHumaines.repos.PretRepository;



@Service
public class PersonnelServiceImpl implements PersonnelService{
	
	@Autowired
	PersonnelRepository personnelRepository;
	
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
	public List<Personnel> findByNomPersonnel(String nom) {
		return personnelRepository.findByNomPersonnel(nom) ;
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
	public List<Personnel> findByNomPersonnelContains(String nomPersonnel) {
		return personnelRepository.findByNomPersonnelContains(nomPersonnel);
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

   @Override
   public DocAdministratifs saveDocument(DocAdministratifs document) {
       return docAdministratifsRepository.save(document);
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
   
	
}
