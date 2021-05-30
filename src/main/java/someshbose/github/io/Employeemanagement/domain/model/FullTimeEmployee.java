package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends CompanyEmployee {
    private long salary;
    private long pension;
    // ...
}
