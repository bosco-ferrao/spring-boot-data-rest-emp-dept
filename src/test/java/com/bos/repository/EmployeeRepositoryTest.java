package com.bos.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bos.payroll.RepositoryConfiguration;
import com.bos.payroll.domain.Department;
import com.bos.payroll.domain.Employee;
import com.bos.payroll.repository.DepartmentRepository;
import com.bos.payroll.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { RepositoryConfiguration.class })
public class EmployeeRepositoryTest {

	private DepartmentRepository departmentRepository;

	@Autowired
	public void setDepartmentRepository(
			DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	private EmployeeRepository employeeRepository;

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Test
	public void testSaveEmployee() {
		Department dept = new Department();
		dept.setName("dept1");
		departmentRepository.save(dept);

		// setup Employee
		Employee employee = new Employee();
		employee.setFirstName("aa");
		employee.setLastName("bb");
		employee.setDepartment(dept);

		// check before save Employee
		assertNull(employee.getId()); // null before save
		employeeRepository.save(employee);
		assertNotNull(employee.getId()); // not null after save

		// fetch from DB
		Employee fetchedEmployee = employeeRepository.findOne(employee.getId());

		// should not be null
		assertNotNull(fetchedEmployee);

		// should equal
		assertEquals(employee.getId(), fetchedEmployee.getId());
		assertEquals(employee.getFirstName(), fetchedEmployee.getFirstName());
		assertEquals(employee.getLastName(), fetchedEmployee.getLastName());
		assertEquals(dept.getName(), fetchedEmployee.getDepartment().getName());

		// setup Employee
		employee = new Employee();
		employee.setFirstName("aa2");
		employee.setLastName("bb2");
		employee.setDepartment(dept);
		
		employeeRepository.save(employee);

		// fetch from DB
		fetchedEmployee = employeeRepository.findOne(employee.getId());

		assertEquals(employee.getId(), new Long(2));
		assertEquals(employee.getFirstName(), fetchedEmployee.getFirstName());
		assertEquals(employee.getLastName(), fetchedEmployee.getLastName());
		assertEquals(dept.getName(), fetchedEmployee.getDepartment().getName());

	}

}