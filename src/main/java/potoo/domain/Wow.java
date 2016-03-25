package potoo.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;




@NodeEntity
@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
@JsonRootName(value = "wow")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Wow {

	@GraphId
	private Long id;
	public Long getId() { return id; }
	
	private String wow;
	public String getWow() { return wow; }
	public void setWow(String wow) { this.wow = wow; }
	
	@Relationship(type="WOWED_BY")
	private WowedBy wowedBy;
	public WowedBy getWowedBy() { return wowedBy; }
	public void setWowedBy(WowedBy wowedBy) { this.wowedBy = wowedBy; }
	public void wowedBy(User user, Date when) {
		WowedBy wowedBy = new WowedBy();
		wowedBy.setUser(user);
		wowedBy.setWhen(when);
		wowedBy.setWow(this);
		this.wowedBy = wowedBy;
	}
	
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
		builder.append("id: ").append(id);
		builder.append("\n");
		builder.append("wow: ").append(wow);
		builder.append("\n");
		builder.append("user: ").append(wowedBy);
		return builder.toString();
	}
	
}
