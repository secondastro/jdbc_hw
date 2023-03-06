package service;

import model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    void addToTable(Employee employee);

    Employee getById(int id);

    ArrayList<Employee> getAllEmployees();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
