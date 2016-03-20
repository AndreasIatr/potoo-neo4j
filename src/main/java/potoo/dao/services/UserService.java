package potoo.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import potoo.dao.repositories.UserRepository;
import potoo.domain.User;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public User findById(Long id) {
		User user = repo.findOne(id);
		return user;
	}
}
