package com.bos.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bos.payroll.domain.Department;
import com.bos.payroll.domain.Employee;
import com.bos.payroll.repository.DepartmentRepository;
import com.bos.payroll.repository.EmployeeRepository;

/**
 * @author Bosco Ferrao
 */
// tag::code[]
@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private DepartmentRepository departmentRepository;

	@Autowired
	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	public void run(String... strings) throws Exception {
		Department dept = new Department("Engineering");
		this.departmentRepository.save(dept);
		this.repository.save(new Employee("Barry", "Lamb", dept));
	}
}
// end::code[]