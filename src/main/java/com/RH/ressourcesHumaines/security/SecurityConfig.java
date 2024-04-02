package com.RH.ressourcesHumaines.security;
import java.util.Arrays;
import java.util.Collections;

//mn lowel k creation mta3 security config w b3ed  bch nhotou l accé lkol user ya sadek 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled= true)
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors()
				.configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						
						
						//on va ajouter caa 

						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						config.setAllowedMethods(Collections.singletonList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Collections.singletonList("*"));
						config.setExposedHeaders(Arrays.asList("Authorization"));
						config.setMaxAge(3600L);
						return config;
	
					}
				}).and().authorizeHttpRequests()
				.anyRequest().permitAll();
				
			
		
		
		/*7atiteha fi commentaire 5atr bch nest3amlou @methodSecurity donc ca sert rien hedhi 
		/*les api vont etre securisés avec methodSecurity et on a plus besoins de ca 
				
		/*			
			//hnee n3tiw l accee
			//hedha b nessba lel personnel akahaw juste taba3et l video ama ba3ed fama methode o5era 
		
				//consulter tous les personnels
			.requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
			//consulter un personnel par son id
			.requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN","USER")
			//ajouter un nouveau personnel
			.requestMatchers(HttpMethod.POST,"/api/addP/**").hasAnyAuthority("ADMIN")
			//modifier un personnel
			.requestMatchers(HttpMethod.PUT,"/api/updatep/**").hasAuthority("ADMIN")
			//supprimer un personnel
			.requestMatchers(HttpMethod.DELETE,"/api/delp/**").hasAuthority("ADMIN").anyRequest().authenticated()
			.and().addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);
		
				*/
				
				
				
				
	
	
	return http.build();
	}
	
}

