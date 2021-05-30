package someshbose.github.io.Employeemanagement.domain.model;

//chapter-2

import javax.persistence.*;
import java.util.Map;

@Embeddable
@Access(AccessType.FIELD)
public class ContactInfo {
    @Embedded
    private Address residence;
    @ManyToOne
    @JoinColumn(name="PRI_NUM")
    private Phone primaryPhone;
    @ManyToMany @MapKey(name="type")
    @JoinTable(name="EMP_PHONES")
    private Map<String, Phone> phones;
}