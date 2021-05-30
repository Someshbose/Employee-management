package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMP_PROJECT")
@IdClass(ProjectAssignmentId.class)
public class ProjectAssignment {
    @Id
    @ManyToOne
    @JoinColumn(name="EMP_ID")
    private Employee employee;
    @Id
    @ManyToOne
    @JoinColumn(name="PROJECT_ID")
    private Project project;
    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", updatable=false)
    private Date startDate;
    // ...
}
