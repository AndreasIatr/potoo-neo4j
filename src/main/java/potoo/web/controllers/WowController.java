package potoo.web.controllers;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import potoo.dao.services.WowService;
import potoo.domain.Wow;

@RestController
@ComponentScan("potoo.dao.repositories.services")
@RequestMapping("/api/wows")
public class WowController {
	
	@Autowired
	WowService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Set<Wow>>> getWows() {
//		Set<Wow> theSet = service.findAllWows();
		return ResponseEntity.ok(service.findAllWows());
	}
	
//	@RequestMapping(value="/wowedBy/{name}", method=RequestMethod.GET)
//	public ResponseEntity<Map<String, Set<Wow>>> getWow(@PathVariable String name) {
//		Map<String, Set<Wow>> set = service.findWowsByWowedName(name);
//		return ResponseEntity.ok(set);
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Wow getWowById(@PathVariable Long id) {
		return service.findById(id);
	}
	
}
