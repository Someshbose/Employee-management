package someshbose.github.io.Employeemanagement.domain.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Department {
  @Id
  private long id;
  private String name;

  @OneToMany(mappedBy="department")
  private Collection<Employee> employees;

  //chapter -2
//  @ManyToMany
//  @MapKey(name="empName")
//  @Convert(converter=UpperCaseConverter.class, attributeName="key.lastName")
//  private Map<EmployeeName, Employee> employees;
  
}
