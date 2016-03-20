package potoo.dao.services;

import static potoo.utils.DataStructureUtils.toMap;
import static potoo.utils.DataStructureUtils.toSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import potoo.dao.repositories.WowRepository;
import potoo.domain.Wow;

@Service
public class WowService {

	@Autowired
	WowRepository repo;
	
	public Map<String, Set<Wow>> findAllWows() {
		return toMap("Wows", repo.findAll());
	}
	
	public Set<Wow> findWows() {		
		return toSet(repo.findAll());
	}
	
	public Map<String, Set<Wow>> findWowsByWowedName(String name) {
		Set<Wow> wows = repo.findByWowedByName(name);
		Map<String, Set<Wow>> theMap = new HashMap<>();
		theMap.put("Wows", wows);
		return theMap;
	}
	
	public Wow findById(Long id) {
		// depth 2 in order to get wowedBy from the originalWow
		Wow wow = repo.findOne(id, 2);
		return wow;
	}
}
