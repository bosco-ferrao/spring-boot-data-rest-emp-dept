package com.bos.payroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.bos.payroll.domain.Department;

/**
 * @author Bosco Ferrao
 */
// tag::code[]
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
// end::code[]
