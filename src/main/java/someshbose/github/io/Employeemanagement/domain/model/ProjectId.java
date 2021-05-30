package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class ProjectId implements Serializable {

    @Column(name="P_NAME")
    private String name;

    @Embedded
    private DeptId dept;
    public ProjectId() {}
    public ProjectId(DeptId deptId, String name) {
        this.dept = deptId;
        this.name = name;
    }
    // ...
}
