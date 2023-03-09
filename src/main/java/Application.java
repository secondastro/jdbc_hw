import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee(
                "Olya", "Lukina",
                "female", 25, "1");

        employeeDAO.addToTable(employee);

        System.out.println(employeeDAO.getById(20));

        for (Employee emp : employeeDAO.getAllEmployees()) {
            System.out.println(emp);
        }

        Employee emp1 = new Employee(
                "Valera", "Kukuev", "male", 34, "4");
        emp1.setId(5);

        employeeDAO.updateEmployee(emp1);
        System.out.println(employeeDAO.getById(5));

        emp1 = new Employee(16);
        employeeDAO.deleteEmployee(emp1);
        for (Employee emp : employeeDAO.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}