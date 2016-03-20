package potoo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import potoo.dao.services.UserService;
import potoo.domain.User;

@RestController
@ComponentScan("potoo.dao.repositories.services")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);
	}
	
}
