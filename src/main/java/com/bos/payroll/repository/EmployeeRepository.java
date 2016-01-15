package com.bos.payroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.bos.payroll.domain.Employee;

/**
 * @author Bosco Ferrao
 */
// tag::code[]
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
// end::code[]
