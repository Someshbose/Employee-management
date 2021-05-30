package someshbose.github.io.Employeemanagement.domain.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.*;

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
@IdClass(EmployeeId.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EMP_TYPE")
public class Employee {

  @Id
  private String country;

  @Id
  @Column(name="EMP_ID")
  private int id;

  @Column(insertable=false, updatable=false)
  private String name;

  @Column(insertable=false, updatable=false)
  private long salary;

  @Enumerated(EnumType.STRING)
  private EmployeeType type;

  @ManyToOne(optional=false)
  @JoinColumn(name="DEPT_ID", insertable=false, updatable=false)
 // @JoinTable(name = "EMP_DEPT")
  private Department department;

  @OneToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="PSPACE_ID")
  private ParkingSpace parkingSpace;

//  @ManyToMany
//  @JoinTable(name="EMP_PROJ",
//      joinColumns=@JoinColumn(name="EMP_ID"),
//      inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
//  private Collection<Project> projects;

  @ManyToMany
  @JoinTable(
          name="EMP_PROJECT",
          joinColumns={
                  @JoinColumn(name="EMP_COUNTRY", referencedColumnName="COUNTRY"),
                  @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID")},
          inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
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

  @ManyToOne
  @JoinColumns({
          @JoinColumn(name="MGR_COUNTRY", referencedColumnName="COUNTRY"),
          @JoinColumn(name="MGR_ID", referencedColumnName="EMP_ID")
  })
  private Employee manager;

  @OneToMany(mappedBy="manager")
  private Collection<Employee> directs;

  @OneToMany(orphanRemoval=true)
  private List<Evaluation> evals;

  @OneToMany(mappedBy="employee")
  private Collection<ProjectAssignment> assignments;

  @Basic(fetch=FetchType.LAZY)
  @Lob
  @Column(table="EMP_LOB")
  private byte[] photo;
  @Basic(fetch=FetchType.LAZY)
  @Lob
  @Column(table="EMP_LOB")
  private char[] comments;

}
