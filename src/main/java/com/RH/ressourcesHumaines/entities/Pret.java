package com.RH.ressourcesHumaines.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pret {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPret ;
	private String statutPret;
	private Long montant;
	
	@ManyToOne
	private  Personnel personnel;
	
	
	public Pret(String statutPret, Long montant) {
		super();
		this.statutPret = statutPret;
		this.montant = montant;
	}
	
	

}
