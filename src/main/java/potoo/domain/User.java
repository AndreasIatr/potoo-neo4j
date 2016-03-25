package potoo.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @GraphId
    private Long id;
    public Long getId() { return id; }
    public String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User() {}
    public User(String name) { this.name = name; }
    
    @Override
    public String toString() {
    	return "id: " + id + "\nname: " + name;
    }

}
