package softuni.exam.instagraphlite.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String path;
    private double size;

    public Picture() {
    }

    @Column(name = "path", nullable = false, unique = true)
    public String getPath() {
        return path;
    }

    @Column(name = "size", nullable = false)
    public double getSize() {
        return size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
