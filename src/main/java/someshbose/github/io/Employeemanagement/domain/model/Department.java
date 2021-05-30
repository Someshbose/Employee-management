package someshbose.github.io.Employeemanagement.domain.model;

import java.util.Collection;
import java.util.List;
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

  @EmbeddedId private DeptId id;

  private String name;

  @OneToMany(mappedBy="department")
  private Collection<Employee> employees;

  @OneToMany(mappedBy="department")
  private List<Project> projects;

  //chapter -2
//  @ManyToMany
//  @MapKey(name="empName")
//  @Convert(converter=UpperCaseConverter.class, attributeName="key.lastName")
//  private Map<EmployeeName, Employee> employees;
  
}
