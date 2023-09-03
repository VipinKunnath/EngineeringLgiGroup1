package com.engineering.controller;

import com.engineering.repositories.EmployeeRepository;
import com.engineering.models.Employee;
import com.engineering.models.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeDetailsAPI {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployeeDetails() {

        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();

        return ResponseEntity.ok(employeeList);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployeeDetails(@RequestBody EmployeeVo employeeVo) {

        Employee employee = new Employee();
        employee.setName(employeeVo.getName());
        employee.setDateOfJoining(employeeVo.getDateOfJoining());
        employee.setSalary(employeeVo.getSalary());
        employee.setGemsAwarded(employeeVo.getGemsAwarded());

        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable("id") long id,
                                                          @RequestBody EmployeeVo employeeVo) throws Exception {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setName(employeeVo.getName());
            employee.get().setDateOfJoining(employeeVo.getDateOfJoining());
            employee.get().setSalary(employeeVo.getSalary());
            employee.get().setGemsAwarded(employeeVo.getGemsAwarded());

            return ResponseEntity.ok(employeeRepository.save(employee.get()));
        } else {
            throw new Exception("Employee record not found");
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeDetails(@PathVariable("id") long id) {

        employeeRepository.deleteById(id);
    }

}
