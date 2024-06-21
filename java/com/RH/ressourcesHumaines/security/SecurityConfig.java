package com.RH.ressourcesHumaines.security;

import java.util.Arrays;
import java.util.Collections;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Désactiver CSRF
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Politique de gestion des sessions
            .and()
            .cors()  // Configuration CORS
                .configurationSource(corsConfigurationSource())
            .and()
            .authorizeRequests()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Autoriser les requêtes OPTIONS sans authentification
                .anyRequest().permitAll();  // Autoriser toutes les autres requêtes sans authentification
        
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // Autoriser l'origine spécifiée
        config.setAllowedMethods(Arrays.asList("*")); // Autoriser toutes les méthodes HTTP (GET, POST, etc.)
        config.setAllowedHeaders(Arrays.asList("*")); // Autoriser tous les en-têtes
        config.setExposedHeaders(Arrays.asList("Authorization")); // Exposer l'en-tête Authorization
        config.setAllowCredentials(true); // Autoriser les credentials (cookies, authentification basique)
        config.setMaxAge(3600L); // Durée maximale de validité de la pré-lecture des informations (preflight)

        return request -> config;
    }
}


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

/*
 * 
 * package com.RH.ressourcesHumaines.security;

import java.util.Collections;
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
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Désactiver CSRF pour les API REST
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Utiliser JWT
            .and()
            .cors().configurationSource(corsConfigurationSource()) // Configuration CORS
            .and()
            .authorizeHttpRequests(requests -> {
                requests
                    // Autorisation basée sur les rôles
                    .requestMatchers("/api/all/**").hasAuthority("ADMIN") // Rôle ADMIN uniquement
                    .requestMatchers(HttpMethod.GET, "/api/currentuser/personnel/**").hasAnyAuthority("USER") // Rôle USER
                    .requestMatchers(HttpMethod.POST, "/api/addP/**").hasAuthority("ADMIN") // Rôle ADMIN pour POST
                    .requestMatchers(HttpMethod.PUT, "/api/updatep/**").hasAuthority("ADMIN") // ADMIN pour PUT
                    .requestMatchers(HttpMethod.DELETE, "/api/delp/**").hasAuthority("ADMIN") // ADMIN pour DELETE
                    .anyRequest().authenticated(); // Autres requêtes doivent être authentifiées
            })
            .addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class); // Utilisation de JWT

        return http.build();
    }

    // Configuration CORS pour permettre les requêtes du frontend Angular
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*")); // Autoriser toutes les méthodes HTTP
        config.setAllowedHeaders(Collections.singletonList("*")); // Autoriser tous les headers
        config.setExposedHeaders(Collections.singletonList("Authorization")); // Exposer le header "Authorization"
        config.setAllowCredentials(true); // Autoriser les cookies
        config.setMaxAge(3600L); // Temps de cache pour la configuration CORS
        return request -> config; // Retourner un CorsConfigurationSource valide
    }
}

 */
