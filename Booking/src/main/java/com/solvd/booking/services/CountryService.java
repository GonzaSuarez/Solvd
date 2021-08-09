package com.solvd.booking.services;

import com.solvd.booking.dao.mysqldao.jbdc.CityDAO;
import com.solvd.booking.dao.mysqldao.jbdc.CountryDAO;
import com.solvd.booking.dao.ICityDAO;
import com.solvd.booking.dao.ICountryDAO;
import com.solvd.booking.places.Country;

import java.io.IOException;
import java.sql.SQLException;

public class CountryService {

    private ICountryDAO countryDAO = new CountryDAO();
    private ICityDAO cityDAO = new CityDAO();

    public CountryService() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
    }

    public ICountryDAO getCountryDAO() {
        return countryDAO;
    }

    public void setCountryDAO(ICountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public ICityDAO getCityDAO() {
        return cityDAO;
    }

    public void setCityDAO(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public Country getCountry(int countryId) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        Country country = countryDAO.getItemById(countryId);
        country.addCity(cityDAO.getCitiesByCountryId(countryId));
        return country;
    }


}
