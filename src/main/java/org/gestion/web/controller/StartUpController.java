package org.gestion.web.controller;

import org.gestion.services.IInitializeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;



@Controller
public class StartUpController {
	
	@Autowired
	private IInitializeService initService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StartUpController.class);
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent(){
		
		//code exécuté une fois que le contexte Spring est chargé
		LOGGER.info("Initialisation des données");
		System.out.println("ça marche !!!!!!!!!!!!!!!!!!!!!!!!!");
<<<<<<< HEAD

=======
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
		
		initService.initialize();
	}

}

