package com.RH.ressourcesHumaines.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private  Long idDep ;
	private String nomDep;


	@JsonIgnore
	@OneToMany(mappedBy = "departement")
	private List<Personnel>personnels ;
	
	
}
