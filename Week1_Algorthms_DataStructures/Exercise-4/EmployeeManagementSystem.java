public class EmployeeManagementSystem {

    // Employee class to represent individual employees
    public static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public int getEmployeeId() { return employeeId; }
        public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        // Override toString for better representation
        @Override
        public String toString() {
            return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
        }
    }

    // EmployeeManagementSystem class to handle employee records
    private Employee[] employees;
    private int size; // Current number of employees in the array

    // Constructor
    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployeeById(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false; // Employee not found
        }

        // Shift elements to fill the gap
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear the last element
        size--;
        return true; // Employee successfully deleted
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add employees
        ems.addEmployee(new Employee(1, "John Doe", "Software Engineer", 80000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Project Manager", 90000));
        ems.addEmployee(new Employee(3, "Alice Johnson", "UX Designer", 75000));

        // Traverse employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee with ID 2:");
        Employee employee = ems.searchEmployeeById(2);
        System.out.println(employee != null ? employee : "Employee not found");

        // Delete an employee
        System.out.println("\nDeleting Employee with ID 2:");
        boolean deleted = ems.deleteEmployeeById(2);
        System.out.println(deleted ? "Employee deleted successfully" : "Employee not found");

        // Traverse employees after deletion
        System.out.println("\nEmployees after deletion:");
        ems.traverseEmployees();
    }
}
