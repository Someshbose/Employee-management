package someshbose.github.io.Employeemanagement.domain.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import someshbose.github.io.Employeemanagement.domain.converter.BooleanToIntegerConverter;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee {
  @Id
  private long id;

  private String name;

  private long salary;

  @Enumerated(EnumType.STRING)
  private EmployeeType type;

  @ManyToOne
  @JoinColumn(name="DEPT_ID")
  private Department department;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="PSPACE_ID")
  private ParkingSpace parkingSpace;

  @ManyToMany
  @JoinTable(name="EMP_PROJ",
      joinColumns=@JoinColumn(name="EMP_ID"),
      inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
  private Collection<Project> projects;

  @OneToMany
  @JoinTable(name="EMP_PHONE",
      joinColumns=@JoinColumn(name="EMP_ID"),
      inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
  private Collection<Phone> phones;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name="state", column=@Column(name="PROVINCE")),
          @AttributeOverride(name="zip", column=@Column(name="POSTAL_CODE"))
  })
  private Address address;

  //chapter-2
  @Convert(converter = BooleanToIntegerConverter.class,attributeName = "bonded")
  private SecurityInfo securityInfo;

  @ElementCollection
  @Convert
  private List<Boolean> securityClearances;

}
