package potoo.dao.repositories;

import java.util.Set;

//import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import potoo.domain.Wow;

public interface WowRepository extends GraphRepository<Wow> {
	
//	alternative to findOne if IDs have duplicates later on
//	@Query("MATCH (w:Wow) " +
//			"WHERE ID(w) = {id} " +
//			"RETURN w")
//	Wow findById(@Param("id") Long id);
	
//	Set<Wow> findByWowedByName(@Param("name") String name);
	
}