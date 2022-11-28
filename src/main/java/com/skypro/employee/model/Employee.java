package com.skypro.employee.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    public final String lastName;
    private final int department;
    private final int salary;
    private final double avgGrade;

    public Employee(String firstName, String lastName, int department, int salary, double avgGrade) {
        this.avgGrade = avgGrade;
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
