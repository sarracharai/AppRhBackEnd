package com.RH.ressourcesHumaines;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RH.ressourcesHumaines.entities.Departement;
import com.RH.ressourcesHumaines.entities.Personnel;
import com.RH.ressourcesHumaines.repos.DepartementRepository;
import com.RH.ressourcesHumaines.repos.PersonnelRepository;



@SpringBootTest
class RhBackendApplicationTests {

	@Autowired
	private PersonnelRepository personnelRepository;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public void testfindByAvion()
	{
		
		Departement dep = new Departement();
		dep.setIdDep(1L);
		List<Personnel> persons = personnelRepository.findByDepartement(dep);
			for (Personnel p : persons)
				{
					System.out.println(p);
				}
	}
	
	@Test
	public void findByAvionIdAv()
	{
		List<Personnel> persons = personnelRepository.findByDepartementIdDep(1L);
			for (Personnel p : persons)
				{
					System.out.println(p);
				}
	}
}
