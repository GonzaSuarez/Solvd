package com.solvd.booking.dao;

import com.solvd.booking.travelcompany.Plane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IPlaneDAO extends IBaseDAO<Plane> {
    List<Plane> getPlanesByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException;

    void updateCapacity(Plane plane);
}
