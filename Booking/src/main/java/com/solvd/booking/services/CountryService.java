package com.solvd.booking.services;

import com.solvd.booking.dao.daoclass.CityDAO;
import com.solvd.booking.dao.daoclass.CountryDAO;
import com.solvd.booking.dao.idao.ICityDAO;
import com.solvd.booking.dao.idao.ICountryDAO;
import com.solvd.booking.places.Country;

public class CountryService {

    private ICountryDAO countryDAO = new CountryDAO();
    private ICityDAO cityDAO = new CityDAO();

    public CountryService() throws InterruptedException {
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

    public Country getCountry(int countryId) throws InterruptedException {
        Country country = countryDAO.getItemById(countryId);
        country.addCity(cityDAO.getCitiesByCountryId(countryId));
        return country;
    }


}
