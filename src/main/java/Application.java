import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main (String[] args) {
// Задание 1
        String user = "postgres";
        String password = "astroclan21";
        String url = "jdbc:postgresql://localhost:5432/skypro1";
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 5);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2)
                        + " " + resultSet.getString(3)
                        + ", " + resultSet.getString(4)
                        + ", " + resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

      //  Задание 2
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            Employee employee = new Employee(
                    "Lara", "Croft",
                    "female", 30, 3);
            employeeDAO.addToTable(employee);
            System.out.println(employeeDAO.getById(4));

            System.out.println(employeeDAO.getAllEmployees());

            employeeDAO.updateEmployee(1,employee);
            System.out.println(employeeDAO.getById(1));

            employeeDAO.deleteEmployee(1);
            System.out.println(employeeDAO.getAllEmployees());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}