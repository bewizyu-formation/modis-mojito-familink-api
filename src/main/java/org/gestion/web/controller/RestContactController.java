package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
<<<<<<< HEAD
@RequestMapping("/groups/{idGroup}")
=======
@RequestMapping("/groups/{idGroup}") // {idGroup}/
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
public class RestContactController {

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;

	// ******* GET LIST CONTACTS ********** //

	@RequestMapping(path = "/contacts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
<<<<<<< HEAD
	public List<Contact> getContacts(@PathVariable("idGroup") String idGroup) {
		return contactServiceRepository.getContacts(Integer.parseInt(idGroup));
=======
	public List<Contact> getContacts() {
		return contactServiceRepository.getContacts();
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
	}
	
	// ******* GET CONTACT BY ID ********** //
	
	@RequestMapping(path = "/contacts/{idContact}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Contact getContactById(@PathVariable("idContact") String idContact) {
		return contactServiceRepository.getContactById(Integer.parseInt(idContact));
	}
	

	// ********** CREATE CONTACT ********** //
	
	@RequestMapping(path = "/contact", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public Contact createContact(@RequestBody Contact contact) {
		return contactServiceRepository.create(contact);
	}

	// ********** UPDATE CONTACT ********** //
	
	// updateContact : nom, prenom, profil (enum), coordonnees, gravatar
	@RequestMapping(path = "/contact", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateContact(@RequestBody Contact updateContact) {
		contactServiceRepository.update(updateContact);
	}

	// ******* DELETE CONTACT BY ID ******** //
	
	@RequestMapping(path = "contacts/{idContact}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteContact(@PathVariable("idContact") String idContact) {
		contactServiceRepository.deleteContact(Integer.parseInt(idContact));
	}

}
