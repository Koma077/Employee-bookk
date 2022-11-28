package com.skypro.employee.record;

public class EmployeeReqest {
    private String firstName;
    private String lastName;
    private int department;
    private int salary;
    private double avgGrade;

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public String getFirstName(String capitalize) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(String capitalize) {
        return lastName;
    }

    public String setLastName() {
        this.lastName = lastName;
        return null;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
