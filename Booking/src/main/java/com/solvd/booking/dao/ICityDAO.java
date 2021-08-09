package com.solvd.booking.dao;

import com.solvd.booking.places.City;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<City> {

    City getCityByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException;

    List<City> getCitiesByCountryId(int countryId) throws SQLException, ClassNotFoundException, IOException;

    void updateName(City city);
    void updatePostalCode(City city);
}
