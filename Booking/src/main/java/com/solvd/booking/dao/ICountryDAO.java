package com.solvd.booking.dao;

import com.solvd.booking.places.Country;

public interface ICountryDAO extends IBaseDAO<Country>{

    void updateName(Country country);
}
