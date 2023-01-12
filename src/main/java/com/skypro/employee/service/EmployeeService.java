package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeReqest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeReqest employeeReqest) {
        if (employeeReqest.getFirstName() == null || employeeReqest.getLastName() == null) {
            throw new IllegalArgumentException("Error");
        }
        Employee employee = new Employee(employeeReqest.getLastName(),
                employeeReqest.getFirstName(),
                employeeReqest.getDepartment(),
                employeeReqest.getSalary(),
                employeeReqest.getAvgGrade());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(e -> e.getSalary()).sum();
    }

    public Employee findMinSalary() {
        return employees.values().stream().min(Comparator.comparing(e -> e.getSalary())).orElseThrow(IllegalArgumentException::new);
    }

    public Employee findMaxSalary() {
        return employees.values().stream().max(Comparator.comparing(e -> e.getSalary())).orElseThrow(IllegalArgumentException::new);
    }

    public List<Employee> findAverageSalary() {
        return employees.values().stream().filter(e -> e.getSalary() > 2000 && e.getAvgGrade() < 1500).collect(Collectors.toList());
    }

}

