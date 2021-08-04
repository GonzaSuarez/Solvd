package com.solvd.booking.dao.idao;

import com.solvd.booking.places.City;
import com.solvd.booking.travelcompany.TravelCompany;

import java.util.List;

public interface ICityDAO extends IBaseDAO<City> {

    City getCityByTravelCompanyId(int travelCompanyId);

    List<City> getCitiesByCountryId(int countryId);
}
