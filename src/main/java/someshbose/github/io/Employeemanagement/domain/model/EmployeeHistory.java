package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.*;

@Entity
public class EmployeeHistory {
    // ...

    @Id
    int empId;

    @MapsId
    @OneToOne
    @JoinColumn(name="EMP_ID")
    private Employee employee;
    // ...
}
