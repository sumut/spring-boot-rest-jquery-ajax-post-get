package com.sumutella.queryajax.controllers;

import com.sumutella.queryajax.entities.Employee;
import com.sumutella.queryajax.entities.ResponseEntity;
import com.sumutella.queryajax.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;


/**
 * @author sumutella
 * @time 10:52 AM
 * @since 12/7/2019, Sat
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public ResponseEntity<Employee> getEmployees(){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>();
        responseEntity.setData(employeeRepository.findAll());
        responseEntity.setStatus("Done");
        return responseEntity;
    }


    @GetMapping("/{empName}")
    public ResponseEntity<Employee> showEmployee(@PathVariable String empName){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>();
        responseEntity.setData(employeeRepository.findByFirstName(empName));
        responseEntity.setStatus("Done");
        return responseEntity;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        ResponseEntity<Employee> response = new ResponseEntity<>();
        response.setStatus("Done");
        response.getData().add(savedEmployee);
        return response;
    }
}

