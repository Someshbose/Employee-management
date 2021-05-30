package someshbose.github.io.Employeemanagement.domain.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    int id;

    @Embedded
    @AttributeOverride(name="address.zip", column=@Column(name="ZIP"))
    @AssociationOverrides({
            @AssociationOverride(name="primaryPhone",
                    joinColumns=@JoinColumn(name="EMERG_PHONE")),
            @AssociationOverride(name="phones",
                    joinTable=@JoinTable(name="CUST_PHONE"))})
    private ContactInfo contactInfo;
}
