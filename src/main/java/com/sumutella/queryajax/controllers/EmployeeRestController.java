package com.sumutella.queryajax.controllers;

import com.sumutella.queryajax.entities.Employee;
import com.sumutella.queryajax.entities.ResponseEntity;
import com.sumutella.queryajax.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sumutella
 * @time 10:52 AM
 * @since 12/7/2019, Sat
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<Employee> getEmployees(){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>();
        responseEntity.setData(employeeRepository.findAll());
        responseEntity.setStatus("Done");
        return responseEntity;
    }


    @GetMapping("/employees/{empName}")
    public ResponseEntity<Employee> showEmployee(@PathVariable String empName){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>();
        responseEntity.setData(employeeRepository.findByFirstName(empName));
        responseEntity.setStatus("done");
        return responseEntity;
    }
}
