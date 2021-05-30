package someshbose.github.io.Employeemanagement.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.Employeemanagement.domain.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
