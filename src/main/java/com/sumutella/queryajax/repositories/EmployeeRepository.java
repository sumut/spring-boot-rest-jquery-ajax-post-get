package com.sumutella.queryajax.repositories;

import com.sumutella.queryajax.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

/**
 * @author sumutella
 * @time 10:48 AM
 * @since 12/7/2019, Sat
 */
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
}
