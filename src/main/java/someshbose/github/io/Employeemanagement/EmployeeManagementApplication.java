package someshbose.github.io.Employeemanagement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import someshbose.github.io.Employeemanagement.domain.model.Address;
import someshbose.github.io.Employeemanagement.domain.model.Department;
import someshbose.github.io.Employeemanagement.domain.model.Employee;
import someshbose.github.io.Employeemanagement.domain.model.EmployeeProject;
import someshbose.github.io.Employeemanagement.domain.model.EmployeeType;
import someshbose.github.io.Employeemanagement.domain.model.ParkingSpace;
import someshbose.github.io.Employeemanagement.domain.model.Phone;
import someshbose.github.io.Employeemanagement.domain.model.Project;
import someshbose.github.io.Employeemanagement.domain.repo.DepartmentRepository;
import someshbose.github.io.Employeemanagement.domain.repo.EmployeeProjectRepository;
import someshbose.github.io.Employeemanagement.domain.repo.EmployeeRepository;
import someshbose.github.io.Employeemanagement.domain.repo.ParkingSpaceRepository;
import someshbose.github.io.Employeemanagement.domain.repo.PhoneRepository;
import someshbose.github.io.Employeemanagement.domain.repo.ProjectRepository;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PhoneRepository phoneRepository;

//	@Autowired
//	private EmployeeProjectRepository employeeProjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = Department.builder().name("SOFTWARE").build();
		departmentRepository.save(department);
		ParkingSpace parkingSpace = ParkingSpace.builder().location("SalarPuria").lot(1).build();
		parkingSpaceRepository.save(parkingSpace);

		Project project= Project.builder().id(1).name("SPM").build();
		Project project2= Project.builder().id(2).name("OAL").build();
		projectRepository.save(project);
		projectRepository.save(project2);
		List<Project> projects = new ArrayList<>();
		projects.add(project);
		projects.add(project2);

		Address address = Address.builder().city("Jatni").state("Odisha").street("Retang Colony").zip("752050").build();

		Phone phone = Phone.builder().number("904011").type("HOME").build();
		phoneRepository.save(phone);
		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(phone);
		Employee employee = Employee.builder().id(0).name("Somesh").salary(1000L).department(department).projects(projects).parkingSpace(parkingSpace).phones(phoneList).type(
				EmployeeType.FULL_TIME_EMPLOYEE).address(address).build();
		//List<Employee> employeeList = new ArrayList<>();
		//employeeList.add(employee);
		//project.setEmployees(employeeList);
		employeeRepository.save(employee);

//		EmployeeProject employeeDepartment = EmployeeProject.builder().employee(employee).project(project).manager("Raju").build();
//		employeeProjectRepository.save(employeeDepartment);


//		ParkingSpace parkingSpace2 = ParkingSpace.builder().id(2).location("SalarPuria").lot(3).build();
//		parkingSpaceRepository.save(parkingSpace2);
//		Employee employee2 = Employee.builder().id(1).name("Pooja").salary(1200L).department(department).parkingSpace(parkingSpace2).build();
//		employeeRepository.save(employee2);
//
//		Optional<Employee> emp = employeeRepository.findByParkingSpaceId(2);
//
//		Optional<ParkingSpace> pkspace= parkingSpaceRepository.findByEmployeeId(0);
//		if(emp.isPresent() && pkspace.isPresent()){
//			System.out.println(emp.get().getId()+" "+emp.get().getName());
//			System.out.println(pkspace.get().getLocation());
//		}

		while (true){

		}
	}
}
