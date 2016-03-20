package potoo.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RelationshipEntity(type="RE_WOWS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ReWows {
	
	@GraphId
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@StartNode
	@JsonIdentityReference(alwaysAsId = true)
	private Wow wow;
	public Wow getWow() { return wow; }
	public void setWow(Wow wow) { this.wow = wow; }
	
	@EndNode
	// don't wrap with class name
	@JsonTypeInfo(include=As.PROPERTY, use=Id.NONE)
	private Wow originalWow;
	public Wow getOriginalWow() { return originalWow; }
	public void setOriginalWow(Wow originalWow) { this.originalWow = originalWow; }
}
