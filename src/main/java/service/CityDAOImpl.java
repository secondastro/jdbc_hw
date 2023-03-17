package service;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.Comparator;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void addToTable(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(City.class, id);
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities =
                (List<City>) HibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("From City")
                        .list();
        return cities.stream().
                sorted(Comparator.comparing(City::getCityId)).toList();
    }

    @Override
    public void updateCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
