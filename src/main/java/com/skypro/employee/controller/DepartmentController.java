package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    private final DepartmentController departmentService;

    @Autowired
    public DepartmentController(DepartmentController departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String getExistingDepartments() {
        return "Existing departments: " + departmentService.getExistingDepartments().toString();
    }

    @GetMapping("/employess")
    public Map<Integer, List<Employee>> getEmployessByDepartment() {
        return departmentService.getEmployessByDepartment();
    }

    @GetMapping("/{id}/employess")
    public Collection<Employee> getEmployeesFromDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDeparment(@PathVariable("id") int departmentId) {
        return departmentService.getSalarySumOfDeparment(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalarySumOfDeparment(@PathVariable("id") int departmentId) {
        return departmentService.getMinSalarySumOfDeparment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalarySumOfDeparment(@PathVariable("id") int departmentId){
        return departmentService.getMaxSalarySumOfDeparment(departmentId);
    }
}

