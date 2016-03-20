package potoo.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;




@NodeEntity
@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
@JsonRootName(value = "wow")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Wow implements Entity {

	@GraphId
	private Long id;
	@Override
	public Long getId() { return id; }
	
	private String wow;
	public String getWow() { return wow; }
	public void setWow(String wow) { this.wow = wow; }
	
	@Relationship(type="WOWED_BY")
	private User wowedBy;
	public User getWowedBy() { return wowedBy; }
	@JsonSetter
	public void setWowedBy(User wowedBy) { this.wowedBy = wowedBy; }
	
	@Relationship(type="RE_WOWS")
	private ReWows reWows;
	public ReWows getReWows() { return reWows; }
	public void setReWows(ReWows reWows) { this.reWows = reWows; }
	public void reWows(Wow otherWow) {
		reWows = new ReWows();
		reWows.setWow(this);
		reWows.setOriginalWow(otherWow);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id: " + id);
		builder.append("\n");
		builder.append("wow: " + wow);
		builder.append("\n");
		builder.append("user: " + wowedBy);
		return builder.toString();
	}
	
}
