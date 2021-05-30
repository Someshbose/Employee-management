package someshbose.github.io.Employeemanagement.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.Employeemanagement.domain.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
