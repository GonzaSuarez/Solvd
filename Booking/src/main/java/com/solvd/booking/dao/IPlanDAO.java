package com.solvd.booking.dao;

import com.solvd.booking.travelcompany.Plan;

public interface IPlanDAO extends IBaseDAO<Plan>{

    void updateName(Plan plan);
    void updateDetails(Plan plan);
    void updateMaxRoom(Plan plan);
    void updateMinRoom(Plan plan);
    void updateMonthlyPrice(Plan plan);
}
