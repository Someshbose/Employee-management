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
@IdClass(ProjectId.class)
public class Project {

  @Id
  private String name;

  @ManyToMany(mappedBy="projects")
  private Collection<Employee> employees;

  @MapsId("dept")
  @ManyToOne
  @JoinColumns({
          @JoinColumn(name="DEPT_NUM",
                  referencedColumnName="NUM"),
          @JoinColumn(name="DEPT_CTY",
                  referencedColumnName="CTRY")})
  private Department dept;

  @OneToMany(mappedBy="project")
  private Collection<ProjectAssignment> assignments;
}
