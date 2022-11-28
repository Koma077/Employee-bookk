package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeReqest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeReqest employeeReqest){
        return this.employeeService.addEmployee(employeeReqest);
    }
    @GetMapping("/employees/salary/sum")
    public int getSalarySum(){
        return this.employeeService.getSalarySum();
    }
    @GetMapping("/employees/salary/min")
    public Employee findMinSalary(){
        return this.employeeService.findMinSalary();
    }
    @GetMapping("/employees/salary/max")
    public Employee findMaxSalary(){
        return this.employeeService.findMaxSalary();
    }
    @GetMapping("/employees/high-salary")
    public List<Employee> findAverageSalary(){
        return this.employeeService.findAverageSalary();
    }
}
