package service;

import model.City;

import java.util.List;

public interface CityDAO {
    void addToTable(City city);

    City getById(int id);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}
