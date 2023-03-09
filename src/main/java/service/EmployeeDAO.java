package service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addToTable(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
