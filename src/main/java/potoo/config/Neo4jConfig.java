package potoo.config;



import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableNeo4jRepositories(basePackages = "potoo.dao.repositories")
@EnableTransactionManagement
class Neo4jConfig extends Neo4jConfiguration {

	@Autowired Environment env;
	
	@Bean
	@Override
    public Neo4jServer neo4jServer() {
        RemoteServer remoteServer = new RemoteServer("http://" + env.getProperty("neo4j.url"),
        		env.getProperty("neo4j.username"), env.getProperty("neo4j.password"));
		return remoteServer;
    }

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("potoo.domain");
	}
}
