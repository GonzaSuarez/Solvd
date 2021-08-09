package com.solvd.booking.dao;

import com.solvd.booking.travelcompany.TravelCompany;

public interface ITravelCompanyDAO extends IBaseDAO<TravelCompany> {

    void updateName(TravelCompany travelCompany);
    void updateEmail(TravelCompany travelCompany);
}
