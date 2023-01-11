package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeReqest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Set<Integer> getExistingDepartments(){
        return employeeService.getAllEmployees().stream().map(Employee::getDepartment).collect(Collectors.toSet());
    }

    public List<Employee> getEmployeesFromDepartment(int departmentId){
        return employeeService.getAllEmployees().stream().filter(employee -> employee.getDepartment() == departmentId).collect(Collectors.toList());
    }

    public int getSalarySumOfDeparment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream().mapToInt(Employee::getSalary).sum();
    }

    //public Map<Integer, List<Employee>> getEmployeesByDepartments(){---??
    //}

    public int getMinSalarySumOfDeparment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream().mapToInt(Employee::getDepartment).min().orElseThrow();
    }

    public int getMaxSalarySumOfDeparment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream().mapToInt(Employee::getDepartment).max().orElseThrow();
    }
}
