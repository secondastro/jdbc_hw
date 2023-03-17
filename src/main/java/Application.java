
import model.City;
import model.Employee;
import service.CityDAO;
import service.CityDAOImpl;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        CityDAO cityDAO = new CityDAOImpl();

        City city = new City(6, "Кисловодск");

        cityDAO.addToTable(city);

        Employee employee = new Employee(
                "Leonid", "Yackubovich",
                "male", 90, city);

        employeeDAO.addToTable(employee);

        System.out.println(cityDAO.getById(6));

        for (City c : cityDAO.getAllCities()) {
            System.out.println(c);
        }

        city = new City(6, "Чайковский");

        cityDAO.updateCity(city);

        System.out.println(cityDAO.getById(6));

        cityDAO.deleteCity(city);

        for (City c : cityDAO.getAllCities()) {
            System.out.println(c);
        }
    }
}