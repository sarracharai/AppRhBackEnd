package com.RH.ressourcesHumaines.entities;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "nomPerson", types = { Personnel.class })
public interface PersonnelProjection {
	
	
	public String getNomPersonnel();
	

}
