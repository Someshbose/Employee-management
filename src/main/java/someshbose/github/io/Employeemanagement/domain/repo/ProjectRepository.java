package someshbose.github.io.Employeemanagement.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.Employeemanagement.domain.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
