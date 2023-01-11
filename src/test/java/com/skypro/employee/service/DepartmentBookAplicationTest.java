package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentBookAplicationTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    private List<Employee> actualEmployee;

    @BeforeEach

    public void setUp(){
        Employee employee1 = new Employee("Alex", "Alexandrov", 1, 10000, 1);
        Employee employee2 = new Employee("Artur", "Arturov", 2, 20000, 2);
        Employee employee3 = new Employee("Max", "Maximov", 3, 30000, 3);

        actualEmployee = new ArrayList<>(List.of(employee1,employee2,employee3));

        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
    }

    @Test
    public void shouldReturnExistingDepartments(){
        final Set<Integer> actual = actualEmployee.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        final Set<Integer> expected = departmentService.getExistingDepartments();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmployessFromDepartments(){
        final int departmentId = 1;

        final List<Employee> aqctual = actualEmployee.stream().filter(e->e.getDepartment()==departmentId).collect(Collectors.toList());
        final List<Employee> expected = departmentService.getEmployeesFromDepartment(departmentId);

        assertEquals(aqctual, expected);
    }
    @Test
    public void shouldReturnSalarySumDepartments() {
        final int departmentId = 1;

        final int actual = actualEmployee.stream().filter(e -> e.getDepartment() == departmentId).mapToInt(Employee::getSalary).sum();
        final int expected = departmentService.getSalarySumOfDeparment(departmentId);

        assertEquals(actual, expected);
    }

//    @Test
//    public void shouldReturnEmployessByDepartments(){
//    }

    @Test
    public void shouldReturnMinSalaryOfDepartments(){
        final int department = 1;

        final int actual = actualEmployee.stream().filter(e->e.getDepartment()== department).mapToInt(Employee::getSalary).min().orElse(0);
        final int expected = departmentService.getMinSalarySumOfDeparment(department);

        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnMaxSalaryOfDepartments() {
        final int department = 1;

        final int actual = actualEmployee.stream().filter(e -> e.getDepartment() == department).mapToInt(Employee::getSalary).max().orElse(0);
        final int expected = departmentService.getMinSalarySumOfDeparment(department);

        assertEquals(expected, actual);

    }








}
