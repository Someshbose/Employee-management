package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeptId implements Serializable {

    @Column(name="NUM")
    private int number;

    @Column(name="CTRY")
    private String country;
    public DeptId() {}
    public DeptId (int number, String country) {
        this.number = number;
        this.country = country;
    }
    // ...
}
