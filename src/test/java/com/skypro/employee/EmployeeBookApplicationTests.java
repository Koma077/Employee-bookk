package com.skypro.employee;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeReqest;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeBookApplicationTests {

    @Mock
    private Employee employee;

    @InjectMocks
    private EmployeeService employeeService;

    private List<Employee> actualEmployee;

    @BeforeEach

    public void setUp() {
        Employee employee1 = new Employee("Alex", "Alexandrov", 1, 10000, 1);
        Employee employee2 = new Employee("Artur", "Arturov", 2, 20000, 2);
        Employee employee3 = new Employee("Max", "Maximov", 3, 30000, 3);

        actualEmployee = new ArrayList<>(List.of(employee1, employee2, employee3));

        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
    }

    @Test
    public void shouldReturnListOfEmployeesWhenCallGetEmployees() {
        List<Employee> expected = (List<Employee>) employeeService.getAllEmployees();
        assertEquals(expected, actualEmployee);
    }

    @Test
    public void shouldThrowIllegalNameExceptionWhenIllegalName() {
        EmployeeReqest badEmployee = new EmployeeReqest();
        badEmployee.setFirstName();
        badEmployee.setLastName();
        badEmployee.setDepartment(1);
        badEmployee.setSalary(10000);


        assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(badEmployee));

    }

    @Test
    public void shouldReturnNewEmployeeWhenAddEmployee() {
        final Employee actual = employee;
        EmployeeReqest employee = new EmployeeReqest();
        employee.setFirstName();
        employee.setLastName();
        employee.setDepartment(actual.getDepartment());
        employee.setSalary(actual.getSalary());


        Employee expected = employeeService.addEmployee(employee);
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnRightSum() {
        final int actual = actualEmployee.stream().mapToInt(Employee::getSalary).sum();
        final int exprcted = employeeService.getSalarySum();

        assertEquals(actual, exprcted);
    }

    @Test
    public void shouldReturnSalaryEmployeeWithMinSalary() {
        final Employee actual = actualEmployee.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
        final Employee expected = employeeService.findMinSalary();

        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnSalaryEmployeeWithMaxSalary() {
        final Employee actual = actualEmployee.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
        final Employee expected = employeeService.findMaxSalary();

        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnSalaryEmployeeWithAverageSalary() {
        final int average = actualEmployee.stream().mapToInt(Employee::getSalary).sum() / actualEmployee.size();
        final List<Employee> expected = actualEmployee.stream().filter(e -> e.getSalary() > average).collect(Collectors.toList());
        final List<Employee> actual = employeeService.findAverageSalary();

        assertEquals(expected, actual);
    }


}
