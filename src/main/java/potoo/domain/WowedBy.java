package potoo.domain;

import com.fasterxml.jackson.annotation.*;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.Date;

@RelationshipEntity(type="WOWED_BY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WowedBy {

    public WowedBy() {}

    public WowedBy(User user, Wow wow) {
        this.user = user;
        this.wow = wow;
        when = new Date();
    }

    @GraphId
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @StartNode
    @JsonTypeInfo(include= JsonTypeInfo.As.PROPERTY, use= JsonTypeInfo.Id.NONE)
    private Wow wow;
    public Wow getWow() { return wow; }
    public void setWow(Wow wow) { this.wow = wow; }

    @EndNode
    private User user;
    public User getUser() { return user; }
    @JsonSetter
    public void setUser(User user) { this.user = user; }

    private Date when;
    public Date getWhen() { return when; }
    public void setWhen(Date when) { this.when = when; }
}
