package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ContractEmployee extends Employee {
    @Column(name="D_RATE")
    private int dailyRate;
    private int term;
    // ...
}
