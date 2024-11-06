package com.resultset;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create an instance of EmployeeDAO to access the database
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Example 1: Select employee by name
        String employeeName = "John Doe";  // Change this to an actual employee name in your database
        Employee employee = employeeDAO.selectEmployeeByName(employeeName);

        if (employee != null) {
            System.out.println("Employee found: " + employee.getEmpName() + ", " + employee.getEmpTitle());
        } else {
            System.out.println("Employee not found with the name: " + employeeName);
        }

        // Example 2: Select all employees and print their information
        List<Employee> allEmployees = employeeDAO.selectAllEmployees();
        if (allEmployees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nAll Employees:");
            for (Employee emp : allEmployees) {
                System.out.println(emp.getEmpId() + " | " + emp.getEmpName() + " | " + emp.getEmpTitle());
            }
        }
    }
}
