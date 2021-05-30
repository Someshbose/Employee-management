package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CompanyEmployee extends Employee {
    private int vacation;
    // ...
}
