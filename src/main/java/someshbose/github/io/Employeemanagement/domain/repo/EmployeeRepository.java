package someshbose.github.io.Employeemanagement.domain.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import someshbose.github.io.Employeemanagement.domain.model.Employee;
import someshbose.github.io.Employeemanagement.domain.model.ParkingSpace;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

  //@Query("select * from employee e where e.PSPACE_ID= :id")
  Optional<Employee> findByParkingSpaceId(long id);
}
