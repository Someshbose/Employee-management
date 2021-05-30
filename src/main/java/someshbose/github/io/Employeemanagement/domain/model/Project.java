package someshbose.github.io.Employeemanagement.domain.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class Project {
  @Id
 // @Column(name = "PROJ_ID")
  private long id;
  private String name;

  @ManyToMany(mappedBy="projects")
  private Collection<Employee> employees;
//  @OneToMany(mappedBy="project")
//  private Collection<EmployeeProject> employees;

}
