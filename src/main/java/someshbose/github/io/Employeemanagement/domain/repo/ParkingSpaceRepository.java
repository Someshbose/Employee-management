package someshbose.github.io.Employeemanagement.domain.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import someshbose.github.io.Employeemanagement.domain.model.ParkingSpace;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace,Long> {

  Optional<ParkingSpace> findByEmployeeId(long id);

}
