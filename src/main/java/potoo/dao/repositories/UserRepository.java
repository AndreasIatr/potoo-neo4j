package potoo.dao.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import potoo.domain.User;

public interface UserRepository extends GraphRepository<User> {

    User findByName(String name);

}
