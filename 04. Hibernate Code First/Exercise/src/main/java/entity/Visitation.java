package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private String name;
    private String comment;

    @ManyToOne
    private Patient patient;

    public Visitation() {
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
